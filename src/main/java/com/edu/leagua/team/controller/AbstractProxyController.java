package com.edu.leagua.team.controller;

import com.edu.leagua.team.common.AbstractResponse;
import com.edu.leagua.team.common.ErrorCodes;
import com.edu.leagua.team.common.FaultResponseFactory;
import com.edu.leagua.team.exceptions.InternalServiceInvocationException;

import java.util.function.Supplier;

/**
 * Created by stepanferubko
 */
public abstract class AbstractProxyController {
    //    todo add logger
    protected <T extends AbstractResponse> T callRemote(RemoteClientFunction<T> function, Supplier<T> errorWrapper) {
        try {
            return function.call();
        } catch (InternalServiceInvocationException e) {

            T err = errorWrapper.get();
            return FaultResponseFactory.errorResponse(err, e);
        } catch (Throwable th) {
            T err = errorWrapper.get();
            return FaultResponseFactory.errorResponse(err, ErrorCodes.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    public interface RemoteClientFunction<R> {
        R call() throws InternalServiceInvocationException;
    }

}
