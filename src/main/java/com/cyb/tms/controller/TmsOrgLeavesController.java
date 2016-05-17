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

import com.cyb.tms.entity.TmsOrgLeaves;
import com.cyb.tms.service.TmsOrgLeavesService;
import com.cyb.tms.util.URIConstants;

@RestController
@RequestMapping(URIConstants.LEAVE)
public class TmsOrgLeavesController {
	
	@Autowired
	TmsOrgLeavesService leaveService;
	
	@RequestMapping(value = URIConstants.CREATE_LEAVE, method = RequestMethod.POST)
    public ResponseEntity<?> createLeave(@RequestBody TmsOrgLeaves leave) {
		
		System.out.println("Creating User " + leave.getDescription());
		 
		/*if (leaveService.isUserExist(leaves)) {
            System.out.println("Leave for the date  " + leaves.getDate() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
 
		leaveService.createLeave(leave);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	 @RequestMapping(value = URIConstants.GET_ALL_LEAVES, method = RequestMethod.GET)
	    public ResponseEntity<List<TmsOrgLeaves>> listAllLeaves() {
	        List<TmsOrgLeaves> leave = leaveService.getAllLeaves();
	        if(leave.isEmpty()){
	            return new ResponseEntity<List<TmsOrgLeaves>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<TmsOrgLeaves>>(leave, HttpStatus.OK);
	    }

}
