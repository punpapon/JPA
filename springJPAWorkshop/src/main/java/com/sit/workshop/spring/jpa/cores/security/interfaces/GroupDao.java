package com.sit.workshop.spring.jpa.cores.security.interfaces;

import com.sit.commons.CommonDao;
import com.sit.workshop.spring.jpa.cores.security.entities.GroupEntity;

public interface GroupDao extends CommonDao<GroupEntity>{
	void deleteGroupOperatorByGroup(GroupEntity group);
	void deleteGroupUserByGroup(GroupEntity group);
	void addGroupOperatorByGroup(GroupEntity group);
	void addUserGroupByGroup(GroupEntity group);
}
