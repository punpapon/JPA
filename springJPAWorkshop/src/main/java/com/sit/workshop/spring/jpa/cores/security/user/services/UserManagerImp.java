package com.sit.workshop.spring.jpa.cores.security.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sit.workshop.spring.jpa.cores.security.user.domains.User;
import com.sit.workshop.spring.jpa.cores.security.user.interfaces.UserManager;
import com.sit.workshop.spring.jpa.cores.security.user.interfaces.UserService;

@Component
@Transactional
public class UserManagerImp implements UserManager{

	@Autowired
	private UserService userService;
	
	@Override
	public User getUserById(Long id) throws Exception {
		return userService.getUserById(id);
	}

	@Override
	public User addUser(User group) throws Exception {
		return userService.addUser(group);
	}

	@Override
	public User updateUser(User group) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User group) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
