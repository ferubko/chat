package com.edu.leagua.team.common;

/**
 * Created by stepanferubko
 */
public abstract class ErrorCodes {
    public static final String ENTITY_NOT_FOUND = "ENTITY_NOT_FOUND";
    public static final String UNEXPECTED_ERROR = "UNEXPECTED_ERROR";

    public static String generateErrorId(String source) {
        long time = System.currentTimeMillis();
        return source + time;
    }
}
