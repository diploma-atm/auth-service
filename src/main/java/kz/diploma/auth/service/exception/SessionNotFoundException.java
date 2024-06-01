package kz.diploma.auth.service.exception;

import org.springframework.http.HttpStatus;

public class SessionNotFoundException extends BaseAuthException {
    private static final Integer ERROR_CODE = HttpStatus.NOT_FOUND.value();
    private final String token;

    public SessionNotFoundException(String token) {
        this.token = token;
    }

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }

    @Override
    public String getDescription() {
        return "[SessionNotFound] apiKey not found for token %s".formatted(token);
    }
}