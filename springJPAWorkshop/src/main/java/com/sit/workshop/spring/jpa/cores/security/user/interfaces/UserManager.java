package com.sit.workshop.spring.jpa.cores.security.user.interfaces;

import com.sit.workshop.spring.jpa.cores.security.user.domains.User;

public interface UserManager {

	User getUserById(Long id) throws Exception;

	User addUser(User group) throws Exception;

	User updateUser(User group) throws Exception;

	void deleteUser(User group) throws Exception;
	
}
