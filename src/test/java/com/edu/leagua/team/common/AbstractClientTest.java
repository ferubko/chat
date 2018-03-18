package com.edu.leagua.team.common;

import com.edu.leagua.team.exceptions.InternalServiceInvocationException;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

/**
 * Created by stepanferubko
 */
public class AbstractClientTest {
    private AbstractClient abstractClient;

    @Before
    public void setUp() throws Exception {
        abstractClient = new AbstractClient(1) {
        };
    }

    @Test(timeout = 1000)
    public void getResponse() throws Exception {
        IntResponse resp = abstractClient.getResponse(() -> new IntResponse(134));

        assertThat(resp).isNotNull();
        assertThat(resp.value).isEqualTo(134);
        assertThat(resp.isError()).isFalse();
        assertThat(resp.getErrorMessage()).isNull();
        assertThat(resp.getErrorCode()).isNull();
    }

    @Test(timeout = 1000)
    public void getResponse_InternalServiceInvocationException1() throws Exception {
        Throwable th = catchThrowable(() -> abstractClient.getResponse(() -> new IntResponse(true, "CODE1", "Some err msg 1")));

        assertThat(th).isExactlyInstanceOf(InternalServiceInvocationException.class).hasMessage("code='CODE1' message='Some err msg 1'");
        assertThat(((InternalServiceInvocationException) th).getErrorCode()).isEqualTo("CODE1");
        assertThat(((InternalServiceInvocationException) th).getErrorMessage()).isEqualTo("Some err msg 1");
    }

    @Test(timeout = 1000)
    public void getResponse_InternalServiceInvocationException1_2_attempts() throws Exception {
        Throwable th = catchThrowable(() -> abstractClient.getResponse(() -> new IntResponse(true, "CODE1", "Some err msg 1"), 5));

        assertThat(th).isExactlyInstanceOf(InternalServiceInvocationException.class).hasMessage("code='CODE1' message='Some err msg 1'");
        assertThat(((InternalServiceInvocationException) th).getErrorCode()).isEqualTo("CODE1");
        assertThat(((InternalServiceInvocationException) th).getErrorMessage()).isEqualTo("Some err msg 1");
    }

    @Test(timeout = 1000)
    public void getResponse_InternalServiceInvocationException2() throws Exception {
        Throwable th = catchThrowable(() -> abstractClient.getResponse(() -> new IntResponse(true, null, null)));

        assertThat(th).isExactlyInstanceOf(InternalServiceInvocationException.class).hasMessage("code='null' message='null'");
        assertThat(((InternalServiceInvocationException) th).getErrorCode()).isEqualTo(ErrorCodes.UNEXPECTED_ERROR);
        assertThat(((InternalServiceInvocationException) th).getErrorMessage()).isNull();
    }

    @Test(timeout = 1000)
    public void getResponse_InternalServiceInvocationException3() throws Exception {
        Throwable th = catchThrowable(() -> abstractClient.getResponse(() -> new IntResponse(true, "CODE2", null)));

        assertThat(th).isExactlyInstanceOf(InternalServiceInvocationException.class).hasMessage("code='CODE2' message='null'");
        assertThat(((InternalServiceInvocationException) th).getErrorCode()).isEqualTo("CODE2");
        assertThat(((InternalServiceInvocationException) th).getErrorMessage()).isNull();
    }

    @Test(timeout = 1000)
    public void getResponse_RuntimeException() throws Exception {
        Supplier<AbstractResponse> act = mock(Supplier.class);
        when(act.get()).thenThrow(new RuntimeException("Exception for tests purposes"));

        Throwable th = catchThrowable(() -> abstractClient.getResponse(act));

        assertThat(th).isExactlyInstanceOf(RuntimeException.class).hasMessage("Exception for tests purposes");
        verify(act, times(1)).get();
    }

    @Test(timeout = 1000)
    public void getResponse_RuntimeException_10_attempts() throws Exception {
        Supplier<AbstractResponse> act = mock(Supplier.class);
        when(act.get()).thenThrow(new RuntimeException("Exception for tests purposes"));

        Throwable th = catchThrowable(() -> abstractClient.getResponse(act, 10));

        assertThat(th).isExactlyInstanceOf(RuntimeException.class).hasMessage("Exception for tests purposes");
        verify(act, times(1)).get();
    }

    private class IntResponse extends AbstractResponse {
        Integer value;

        public IntResponse(Integer value) {
            this.value = value;
        }

        public IntResponse(boolean error, String errorCode, String errorMessage) {
            this.error = error;
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }
    }
}