package com.cyb.tms.service;

import java.util.List;

import com.cyb.tms.entity.TmsUsers;

public interface TmsUserService {
	
	public long createUser(TmsUsers tmsUser);
    public TmsUsers updateUser(TmsUsers tmsUser);
    public void deleteUser(long id);
    public List<TmsUsers> getAllUsers();
    public TmsUsers getUser(long id);
	public boolean isUserExist(TmsUsers tmsUser);

}
