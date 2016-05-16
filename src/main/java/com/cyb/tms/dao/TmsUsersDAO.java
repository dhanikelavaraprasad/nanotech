package com.cyb.tms.dao;

import java.util.List;

import com.cyb.tms.entity.TmsUsers;

public interface TmsUsersDAO {
	
	public TmsUsers findByUsername(String username);
	public long createUser(TmsUsers user);
    public TmsUsers updateUser(TmsUsers tmsUser);
    public void deleteUser(long id);
    public List<TmsUsers> getAllUsers();
    public TmsUsers getUser(long id);	
	//public List<TmsUsers> getAllUsers(String user);
	
}
