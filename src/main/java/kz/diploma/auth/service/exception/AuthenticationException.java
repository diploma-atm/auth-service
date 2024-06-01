package kz.diploma.auth.service.exception;

import org.apache.http.HttpStatus;

public class AuthenticationException extends BaseAuthException {
    private final String desc;

    public AuthenticationException() {
        this.desc = "Authentication Failed";
    }

    public AuthenticationException(String desc) {
        this.desc = desc;
    }

    @Override
    public int getErrorCode() {
        return HttpStatus.SC_UNAUTHORIZED;
    }

    @Override
    public String getDescription() {
        return this.desc;
    }
}
