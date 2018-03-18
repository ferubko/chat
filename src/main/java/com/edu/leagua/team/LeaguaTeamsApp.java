package com.edu.leagua.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Stepan Ferubko
 */
@SpringBootApplication
public class LeaguaTeamsApp {
    public static void main(String[] args) {
        //SpringApplication.run(ChatApp.class, args);
//for heroku only
        SpringApplication application = new SpringApplication(LeaguaTeamsApp.class);
//        Map<String, Object> map = new HashMap<>();
//        map.put("server.port", System.getenv("PORT"));
//        application.setDefaultProperties(map);
        application.run(args);
    }
}
