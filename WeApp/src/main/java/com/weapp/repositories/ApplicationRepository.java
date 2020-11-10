package com.weapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weapp.domain.Application;
import com.weapp.domain.User;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	
	Optional<Application> findById(int id); 
	
	// select * from application where name = :name
	List<Application> findByNameIgnoreCase(String name); 
	
	// select * from application where organization = :organization
	List<Application> findByOrganization(String organization); 
	
	List<Application> findByUser(User user);
	
	List<Application> findByVersion(String version);
	
	List<Application> findByApproved(Boolean approved);
	
	List<Application> findByCategory(String category);

	List<Application> findByPlatform(String platform);
	
	List<Application> findAll(); 
	
	List<Application> findByOrderByNameAsc(); 
	
}
