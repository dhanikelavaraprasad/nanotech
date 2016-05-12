package com.cyb.tms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyb.tms.dao.TmsUsersDAO;
import com.cyb.tms.entity.TmsUsers;
import com.cyb.tms.security.factory.TmsUserFactory;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private TmsUsersDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TmsUsers user = this.userDAO.findByUsername(username);

	    if (user == null) {
	      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	    } else {
	      return TmsUserFactory.create(user);
	    }
	}

	

}
