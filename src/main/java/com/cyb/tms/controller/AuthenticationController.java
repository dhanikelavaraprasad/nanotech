package com.cyb.tms.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.tms.security.TokenUtils;
import com.cyb.tms.security.json.AuthenticationRequest;
import com.cyb.tms.security.json.AuthenticationResponse;
import com.cyb.tms.security.model.CybUsers;





@RestController
@RequestMapping("${tms.route.authentication}")
public class AuthenticationController {
	
	  private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class.getName());

	  @Value("${tms.token.header}")
	  private String tokenHeader;

	  @Autowired
	  private AuthenticationManager authenticationManager;

	  @Autowired
	  private TokenUtils tokenUtils;

	  @Autowired
	  private UserDetailsService userDetailsService;

	  @RequestMapping(method = RequestMethod.POST)
	  public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException {
		  logger.info("tms.route.authentication-start");
		try {
			// Perform the authentication
			Authentication authentication = this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(),
							authenticationRequest.getPassword()
							)
					);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			// Reload password post-authentication so we can generate token
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			String token = this.tokenUtils.generateToken(userDetails);
			// Return the token
			return ResponseEntity.ok(new AuthenticationResponse(token));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	  }

	  @RequestMapping(value = "${tms.route.authentication.refresh}", method = RequestMethod.GET)
	  public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
		  logger.info("route.authentication.refresh-start");
	    String token = request.getHeader(tokenHeader);
	    String username = this.tokenUtils.getUsernameFromToken(token);
	    CybUsers user = (CybUsers) this.userDetailsService.loadUserByUsername(username);
	    //if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
	      String refreshedToken = this.tokenUtils.refreshToken(token);
	      return ResponseEntity.ok(new AuthenticationResponse(refreshedToken));
	   // } else {
	   //   return ResponseEntity.badRequest().body(null);
	   // }
	  }
}
