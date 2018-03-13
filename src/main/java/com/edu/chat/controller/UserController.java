package com.edu.chat.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Stepan Ferubko
 */
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getFirstUser() {
        return "John";
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllUsers() {
        return "John";
    }
}
