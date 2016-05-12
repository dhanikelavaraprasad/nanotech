package com.cyb.tms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyb.tms.dao.TmsUsersDAO;
import com.cyb.tms.entity.TmsUsers;
import com.cyb.tms.utils.HibernateUtil;

@Repository
public class TmsUsersDAOImpl implements TmsUsersDAO {

private static final String USER_NAME = "username";
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public TmsUsers findByUsername(String username) {
		return hibernateUtil.findByUsername(USER_NAME, username, TmsUsers.class);
	}

}
