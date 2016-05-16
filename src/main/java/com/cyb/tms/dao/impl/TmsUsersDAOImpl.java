package com.cyb.tms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.cyb.tms.dao.TmsUsersDAO;
import com.cyb.tms.entity.TmsUsers;
import com.cyb.tms.util.HibernateUtil;

@Repository
public class TmsUsersDAOImpl implements TmsUsersDAO {

private static final String USER_NAME = "userName";
	
	@Autowired
    private HibernateUtil hibernateUtil;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public TmsUsers findByUsername(String username) {
		return hibernateUtil.findByUsername(USER_NAME, username, TmsUsers.class);
	}

	@Override
	public long createUser(TmsUsers user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return (Long) hibernateUtil.create(user);
	}

	@Override
	public TmsUsers updateUser(TmsUsers tmsUser) {
		return hibernateUtil.update(tmsUser);
	}

	@Override
	public void deleteUser(long id) {
		TmsUsers user = new TmsUsers();
		user.setId(id);
        hibernateUtil.delete(user);
	}

	@Override
	public List<TmsUsers> getAllUsers() {
		return hibernateUtil.fetchAll(TmsUsers.class);
	}

	@Override
	public TmsUsers getUser(long id) {
		return hibernateUtil.fetchById(id, TmsUsers.class);
	}


}
