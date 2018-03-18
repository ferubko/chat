package com.edu.leagua.team.common;

import com.edu.leagua.team.exceptions.InternalServiceInvocationException;
import com.edu.leagua.team.tools.ExponentialBackOffExec;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by stepanferubko
 */
public abstract class AbstractClient {
    public static final String FOOTBALL_DATA = "http://api.football-data.org/v1";

    protected final RestTemplate restTemplate;
    protected final int attemptsCount;

    protected AbstractClient(int attemptsCount) {
        this.restTemplate = new RestTemplate();
        this.attemptsCount = attemptsCount;
    }

    protected AbstractClient() {
        this.restTemplate = new RestTemplate();
        this.attemptsCount = ExponentialBackOffExec.DEF_ATTEMPTS_COUNT;
    }

    protected <T extends AbstractResponse> T getResponse(Supplier<T> action) throws InternalServiceInvocationException {
        return getResponse(action, attemptsCount);
    }

    protected <T extends AbstractResponse> T getResponse(Supplier<T> action, int attempts) throws InternalServiceInvocationException {
        T response = ExponentialBackOffExec.executeRestTemplate(action, attempts);
        if (response.isError()) {
            throw new InternalServiceInvocationException(response);
        }
        return response;
    }

    protected String endpoint(String... parts) {
        return Arrays.stream(parts).collect(Collectors.joining());
    }
}
