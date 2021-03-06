/*
 * Thanks to spring.io's doc on Testing the Web Layer
 *  https://spring.io/guides/gs/testing-web/ 
 */
package com.weapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.weapp.web.ApplicationAdminController;
import com.weapp.web.ApplicationUserController;
import com.weapp.web.UserViewController;
import com.weapp.web.LoginController;

/**
 * The Class WeAppApplicationTests.
 * @SpringBootTest tells Spring Boot to look for a main configuration class
 */
@SpringBootTest
class WeAppApplicationTests {
	
	/** The login controller. */
	@Autowired
	private LoginController loginController;
	
	/** The application user controller. */
	@Autowired
	private ApplicationUserController applicationUserController;
	
	/** The application admin controller. */
	@Autowired
	private ApplicationAdminController applicationAdminController;
	
	/** The dashboard controller. */
	@Autowired
	private UserViewController dashboardController;

	/**
	 * Context loads.
	 */
	@Test
	void contextLoads() {
		assertThat(loginController).isNotNull();
		assertThat(applicationUserController).isNotNull();
		assertThat(applicationAdminController).isNotNull();
		assertThat(dashboardController).isNotNull();
	}

}
