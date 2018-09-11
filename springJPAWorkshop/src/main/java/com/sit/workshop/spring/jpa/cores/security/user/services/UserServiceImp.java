package com.sit.workshop.spring.jpa.cores.security.user.services;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.OperatorEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.UserEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.UserGroupEntity;
import com.sit.workshop.spring.jpa.cores.security.entities.UserOperatorEntity;
import com.sit.workshop.spring.jpa.cores.security.interfaces.GroupDao;
import com.sit.workshop.spring.jpa.cores.security.interfaces.UserDao;
import com.sit.workshop.spring.jpa.cores.security.user.domains.Group;
import com.sit.workshop.spring.jpa.cores.security.user.domains.Operator;
import com.sit.workshop.spring.jpa.cores.security.user.domains.User;
import com.sit.workshop.spring.jpa.cores.security.user.interfaces.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	@Qualifier("operatorDaoImp")
	private CommonDao<OperatorEntity> operatorDao;
	
	@Override
	public User getUserById(Long id) throws Exception {
		User user = new User();
		UserEntity userEntity = userDao.findById(id);
		if (userEntity != null) {
			BeanUtils.copyProperties(user, userEntity);
			
			// Operator
						List<UserOperatorEntity> userOperatorList = userEntity.getUserOperators();
						if (userOperatorList != null) {
							for (UserOperatorEntity userOperator : userOperatorList) {
								// Create Operator Object
								Operator operator = new Operator();
								BeanUtils.copyProperties(operator, userOperator.getOperator());

								// Add operator to user
								user.addOperators(operator);
							}
						}

						// Group
						List<UserGroupEntity> userGroupList = userEntity.getUserGroups();
						if (userGroupList != null) {
							for (UserGroupEntity userGroup : userGroupList) {
								// Create Group Object
								Group group = new Group();
								BeanUtils.copyProperties(group, userGroup.getGroup());

								// Add group to user
								user.addGroup(group);
							}
						}
		}
		return user;
	}

	@Override
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
