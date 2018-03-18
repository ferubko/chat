package com.edu.leagua.team.tools;

import org.springframework.web.client.ResourceAccessException;

import java.util.function.Supplier;

/**
 * Created by stepanferubko
 */
public class ExponentialBackOffExec {
//    private final static Logger LOG = java.util.logging.Logger.getLogger(ExponentialBackOffExec.class.getName());
//    private final static Logger LOG = Logger(ExponentialBackOffExec.class);

    public static final int DEF_ATTEMPTS_COUNT = 6;
    private final static int MAX_TIMEOUT = 300;
    private final static int[] TIMEOUTS = {1, 5, 10, 60, 60, 60, 180, MAX_TIMEOUT};

    public static <T> T executeRestTemplate(Supplier<T> action, int attempts) {
        for (int i = 0; i < attempts - 1; i++) {
            try {
                return action.get();
            } catch (ResourceAccessException ex) {
                int timeout = i < TIMEOUTS.length ? TIMEOUTS[i] : MAX_TIMEOUT;
//                LOG.warn("RestTemplate action was failed with attempt={} error=[{}] next attempt after {} sec.", i + 1, ex.getMessage(), timeout);
                sleep(timeout);
            }
        }
        return action.get();
    }

    private static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
