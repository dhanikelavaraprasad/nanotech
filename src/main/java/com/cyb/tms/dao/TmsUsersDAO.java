package com.cyb.tms.dao;

import com.cyb.tms.entity.TmsUsers;

public interface TmsUsersDAO {
	
	public TmsUsers findByUsername(String username);
	
}
