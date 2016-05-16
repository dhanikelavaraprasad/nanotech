package com.cyb.tms.security.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cyb.tms.security.service.SecurityService;


public class SecurityServiceImpl implements SecurityService {

	@Override
	public Boolean hasProtectedAccess() {
		return (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
	}

}
