package com.cyb.tms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/protected")
public class MethodProtectedRestController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getProtectedGreeting() {
        return ResponseEntity.ok("Greetings from admin protected method!");
    }

}
