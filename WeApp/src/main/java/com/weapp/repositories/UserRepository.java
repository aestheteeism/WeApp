/*
 * Thanks to spring.io documentation on Query Creation
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 * 
 * Thanks to Baeldung for the guide on use of @Repository
 * https://www.baeldung.com/spring-component-repository-service
 */
package com.weapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weapp.domain.User;

/**
 * This is the repository class for User objects
 * All method names are compliant with Spring Data naming conventions
 * so that this class can extends Spring Data JPA 
 * See: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 * for more details
 * 
 * @Repository tell Spring that this is the repository - persistence layer (database repository) 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	/**
	 * Retrieve User from the data store by username .
	 *
	 * @param username the username to search for
	 * @return the user if found
	 */
	// @Query("SELECT u FROM User u WHERE u.name = :name")
	User findByUsername(String username);
	
	/**
	 * Retrieve a list of Users from the data store by name.
	 *
	 * @param name the name to search for
	 * @return the list of users if found
	 */
	List<User> findByName(String name);
}