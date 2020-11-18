package com.weapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.weapp.domain.Application;
import com.weapp.repositories.ApplicationRepository;
import com.weapp.service.ApplicationService;

/**
 * The Class UserViewController.
 */
@Controller
public class UserViewController {


	/** The app service. */
	@Autowired
	private ApplicationService appService;

	/**
	 * Root view.
	 *
	 * @param model the model
	 * @param keyword the keyword
	 * @param sortBy the sort by
	 * @return the string
	 */
	@GetMapping("/")
	public String rootView (ModelMap model, @Param("keyword") String keyword, @Param("sortBy") String sortBy) {
		List<Application> applications = new ArrayList<>(); 
		List<String> categories = appService.findDistinctCategory(); 
		List<String> platforms = appService.findDistinctPlatform(); 
		model.put("categories", categories); 
		model.put("platforms", platforms);
		if(keyword != null) {
			applications = appService.findByKeyword(keyword); 
			model.addAttribute("applications", applications);
			model.addAttribute("keyword", keyword);
		} else if(sortBy != null) {
			if(sortBy.equals("name")) {
				applications = appService.findByOrderByNameAsc();
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			} 
			if(sortBy.equals("price")) {
				applications = appService.findByOrderByPriceDesc();
				model.addAttribute("applications", applications);
				model.addAttribute("sortByValue", sortBy);
			}
			if(sortBy.equals("")) {
				applications = appService.findByApproved(true);
				model.addAttribute("applications", applications);
			}
		} 		
		else {
			applications = appService.findByApproved(true);
			model.put("applications", applications);
		}

		return "index"; 
	}

	/**
	 * Filterd by category.
	 *
	 * @param model the model
	 * @param category the category
	 * @return the string
	 */
	@GetMapping("/c/{category}")
	public String filterdByCategory(ModelMap model, @PathVariable String category) {
		List<Application> applications = appService.findByCategory(category); 
		List<String> categories = appService.findDistinctCategory(); 
		List<String> platforms = appService.findDistinctPlatform(); 
		model.put("categories", categories); 
		model.put("platforms", platforms); 
		model.put("applications", applications);
		return "index"; 
	}

	/**
	 * Filterd by platform.
	 *
	 * @param model the model
	 * @param platform the platform
	 * @return the string
	 */
	@GetMapping("/p/{platform}")
	public String filterdByPlatform(ModelMap model, @PathVariable String platform) {
		List<Application> applications = appService.findByPlatform(platform);
		List<String> categories = appService.findDistinctCategory(); 
		List<String> platforms = appService.findDistinctPlatform(); 
		model.put("categories", categories); 
		model.put("platforms", platforms);
		model.put("applications", applications);
		return "index"; 
	}


	/**
	 * Dashboard.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
	public String dashboard(ModelMap model) {
		List<Application> applications = appService.findAll(); 
		model.put("applications", applications);

		return "dashboard"; 
	}
}
