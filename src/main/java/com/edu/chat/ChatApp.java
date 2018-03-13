package com.edu.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stepan Ferubko
 */
@SpringBootApplication
public class ChatApp {
    public static void main(String[] args) {
        //SpringApplication.run(ChatApp.class, args);
//for heroku only
        SpringApplication application = new SpringApplication(ChatApp.class);
        Map<String, Object> map = new HashMap<>();
        map.put("server.port", System.getenv("PORT"));
        application.setDefaultProperties(map);
        application.run(args);
    }
}
