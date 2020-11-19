/*
 * 
 */
package com.weapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.weapp.domain.User;
import com.weapp.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
	/** The user service. */
	@Autowired
	private UserService userService; 
	
	/**
	 * Login.
	 *
	 * @return the string
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	/**
	 * Register.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.put("user", new User());
		return "register"; 
	}
	
	/**
	 * Register post.
	 *
	 * @param user the user
	 * @return the string
	 */
	@PostMapping("/register")
	public String registerPost(@ModelAttribute User user) {
		User savedUser = userService.save(user); 
		return "redirect:/login"; 
	}
}
