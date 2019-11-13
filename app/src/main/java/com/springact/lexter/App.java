package com.spring.lexter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.modelmapper.ModelMapper;
/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
    }
    
    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}




// Spring Resource Files
// @Transactional (Default Value? true? false?)
// Spring Security Add User
// Users to Authenticate
// DTO, DAO
// Mappers
// Validation, Data Binding
// Tasks, Scheduling
// Log-in Page, Spring Security, AngularJS