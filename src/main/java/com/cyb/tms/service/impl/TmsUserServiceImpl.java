package com.cyb.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyb.tms.dao.TmsUsersDAO;
import com.cyb.tms.entity.TmsUsers;
import com.cyb.tms.service.TmsUserService;

@Service
@Transactional
public class TmsUserServiceImpl implements TmsUserService {
	
	@Autowired
	TmsUsersDAO tmsUsersDao;

	@Override
	public long createUser(TmsUsers tmsUser) {
		return (Long) tmsUsersDao.createUser(tmsUser);
	}

	@Override
	public TmsUsers updateUser(TmsUsers tmsUser) {
		return tmsUsersDao.updateUser(tmsUser);
	}

	@Override
	public void deleteUser(long id) {
		tmsUsersDao.deleteUser(id);
	}

	@Override
	public List<TmsUsers> getAllUsers() {
		return tmsUsersDao.getAllUsers();
	}

	@Override
	public TmsUsers getUser(long id) {
		return tmsUsersDao.getUser(id);
	}

	@Override
	public boolean isUserExist(TmsUsers tmsUser) {
		return tmsUsersDao.findByUsername(tmsUser.getUserName())!=null;
	}

}
