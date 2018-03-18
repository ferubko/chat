package com.edu.leagua.team.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stepan Ferubko
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TeamController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getFirstTeam() {
        return "John";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllTeams() {
        return "John";
    }
}
