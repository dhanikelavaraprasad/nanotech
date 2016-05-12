package com.cyb.tms.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;


public class AuthenticationTokenFilter extends
		UsernamePasswordAuthenticationFilter {

	
	 @Value("${tms.token.header}") 
	 private String tokenHeader;
	 

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private EntryPointUnauthorizedHandler restAuthenticationEntryPoint;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String authToken = httpRequest.getHeader(tokenHeader);
		String username = this.tokenUtils.getUsernameFromToken(authToken);


		if (username != null
				&& SecurityContextHolder.getContext().getAuthentication() == null) {
			try {
				UserDetails userDetails = this.userDetailsService
						.loadUserByUsername(username);
				if (this.tokenUtils.validateToken(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication
							.setDetails(new WebAuthenticationDetailsSource()
									.buildDetails(httpRequest));
					SecurityContextHolder.getContext().setAuthentication(
							authentication);
				}
				
				chain.doFilter(request, response);
			} catch (AuthenticationException authenticationException) {
				SecurityContextHolder.clearContext();
				restAuthenticationEntryPoint.commence(httpRequest, httpResponse,
				 authenticationException);
			}
		} else {
			restAuthenticationEntryPoint.commence(httpRequest, httpResponse,
					 null);
			
		}

	}

}
