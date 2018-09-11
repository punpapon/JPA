package com.sit.workshop.spring.jpa.cores.security.user.interfaces;

import com.sit.workshop.spring.jpa.cores.security.user.domains.User;

public interface UserService {
	
	User getUserById(Long id) throws Exception;

	User addUser(User user) throws Exception;

	User updateUser(User user) throws Exception;

	void deleteUser(User user) throws Exception;
	
}
