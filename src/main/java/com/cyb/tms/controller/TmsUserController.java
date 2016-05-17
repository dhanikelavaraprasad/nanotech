package com.cyb.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.tms.entity.TmsUsers;
import com.cyb.tms.service.TmsUserService;
import com.cyb.tms.util.URIConstants;

@RestController
public class TmsUserController {
	
	@Autowired
	TmsUserService tmsUserService;
	
	@RequestMapping(value = URIConstants.CREATE_USER, method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody TmsUsers tmsUser) {
		
		System.out.println("Creating User " + tmsUser.getUserName());
		 
		if (tmsUserService.isUserExist(tmsUser)) {
            System.out.println("A User with name " + tmsUser.getUserName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
		tmsUserService.createUser(tmsUser);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	 @RequestMapping(value = URIConstants.GET_ALL_USERS, method = RequestMethod.GET)
	    public ResponseEntity<List<TmsUsers>> listAllUsers() {
	        List<TmsUsers> users = tmsUserService.getAllUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<TmsUsers>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<TmsUsers>>(users, HttpStatus.OK);
	    }

}
