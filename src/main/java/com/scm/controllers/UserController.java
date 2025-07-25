package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.services.UserService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/user")
public class UserController {

    // 
    // @Autowired
    // private UserService userService;

    // user dashbaord page

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String userDashboard() {
    return "user/dashboard";
}

    @RequestMapping(value = "/profile")
    public String userProfile(Model model, Authentication authentication) {

        return "user/profile";
    }
}
