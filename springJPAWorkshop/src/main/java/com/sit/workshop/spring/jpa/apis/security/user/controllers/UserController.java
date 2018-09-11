package com.sit.workshop.spring.jpa.apis.security.user.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.workshop.spring.jpa.cores.security.user.domains.User;
import com.sit.workshop.spring.jpa.cores.security.user.interfaces.UserManager;

@RestController
@RequestMapping("api/security/user")
public class UserController {
	
	@Autowired 
	private UserManager userManager;
	
	
	@GetMapping
	public ResponseEntity test() {
		return ResponseEntity.ok("Hello world!");		
	}
	
	@PostMapping
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
		if (errors.hasErrors()) {
			ResponseEntity response = ResponseEntity.badRequest().body("Had Errors.");
			return response;			
		}
				
		ResponseEntity response = null;
		try {
			user = userManager.addUser(user);
			response = ResponseEntity.ok(user);
			
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			e.printStackTrace();	
		}
		
		return response;
	}
	
	@GetMapping("{id}")
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public ResponseEntity getUserById(@Valid @PathVariable int id) {
		
		ResponseEntity response = null;
		try {
			User user = userManager.getUserById(new Long(id));
			response = ResponseEntity.ok(user);
			
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			e.printStackTrace();
		} 	
		
		return response;
	}
}
