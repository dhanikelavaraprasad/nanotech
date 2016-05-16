package com.cyb.tms.util;

public class URIConstants {
	
	public static final String GET_USER = "api/user/{id}";
	public static final String GET_ALL_USER = "api/user/list";
	public static final String CREATE_USER = "api/user/create";
	public static final String DELETE_USER = "api/user/delete/{id}";
	public static final String EDIT_USER = "api/user/edit/{id}";

	public static final String TOKEN_HEADER = "X-Auth-Token";
	public static final String TOKEN_SECRET = "eHTRcUpaSWfGgTIJsC4rM6lPMm8es87pYPrELJUwoNqMXN7zWIzGQGq1hgdPCM5u";
	public static final Long TOKEN_EXPIRE = (long) 86400;
	public static final String ROUTE_AUTH = "api/auth";
	public static final String ROUTE_AUTH_REFRESH = "/refresh";
	
	
}
