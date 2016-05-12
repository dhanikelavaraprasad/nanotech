package com.cyb.tms.security.factory;

import org.springframework.security.core.authority.AuthorityUtils;

import com.cyb.tms.entity.TmsUsers;
import com.cyb.tms.security.model.CybUsers;

public class TmsUserFactory {
	
	public static CybUsers create(TmsUsers user) {
	    return new CybUsers(
	      user.getId(),
	      user.getUserName(),
	      user.getPassword(),
	      user.getEmail(),
	      AuthorityUtils.commaSeparatedStringToAuthorityList(user.getUserRole())
	    );
	  }

}
