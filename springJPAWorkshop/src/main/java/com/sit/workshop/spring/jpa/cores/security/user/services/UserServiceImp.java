package com.sit.workshop.spring.jpa.cores.security.user.services;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.GroupEntity;
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
		
		User user = null;
		UserEntity userEntity = userDao.findById(id);
		if (userEntity != null) {
			user = new User();
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
		if (user == null) {
			throw new Exception("No object");
		}

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userEntity, user);

		// Salt and Password
		String password = user.getPassword();
		String salt = "XXXXX";
		String passwordEncry = "XXXXXX";
		userEntity.setPass(passwordEncry);
		userEntity.setSalt(salt);
		userEntity.setPasswordDate(Calendar.getInstance().getTime());
		userEntity.setLockStatus('1');
		

		List<Operator> operators = user.getOperators();
		if (operators != null && !operators.isEmpty()) {
			// Insert new UserOperator data
			for (Operator operator : operators) {
				OperatorEntity operatorEntity = operatorDao.findById(operator.getOperatorId());

				UserOperatorEntity userOperator = new UserOperatorEntity();
				userOperator.setUser(userEntity);
				userOperator.setOperator(operatorEntity);
				userEntity.addUserOperator(userOperator);
			}
		}

		List<Group> groups = user.getGroups();
		if (groups != null && !groups.isEmpty()) {
			// Insert new UserGroup data
			for (Group group : groups) {
				GroupEntity groupEntity = groupDao.findById(group.getGroupId());

				UserGroupEntity userGroup = new UserGroupEntity();
				userGroup.setUser(userEntity);
				userGroup.setGroup(groupEntity);
				userEntity.addUserGroup(userGroup);
			}
		}

		// Insert User
		userEntity = userDao.add(userEntity);
		BeanUtils.copyProperties(user, userEntity);

		return user;
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
