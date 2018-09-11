package com.sit.workshop.spring.jpa.cores.security.interfaces;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.UserEntity;

public interface UserDao extends CommonDao<UserEntity> {
	void deleteUserOperatorByUser(UserEntity user);
	void deleteUserGroupByUser(UserEntity user);
	void addUserOperatorByUser(UserEntity user);
	void addUserGroupByUser(UserEntity user);
}
