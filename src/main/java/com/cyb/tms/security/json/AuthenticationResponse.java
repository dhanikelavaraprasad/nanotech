package com.cyb.tms.security.json;

import com.cyb.tms.security.model.ModelBase;

public class AuthenticationResponse extends ModelBase {


	private static final long serialVersionUID = -8899688124401146318L;
	
	private String token;
	
	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
