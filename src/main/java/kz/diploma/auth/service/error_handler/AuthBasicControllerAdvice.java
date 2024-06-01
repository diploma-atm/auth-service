package kz.diploma.auth.service.error_handler;

import kz.diploma.auth.service.exception.BaseAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AuthBasicControllerAdvice {

    @ExceptionHandler(BaseAuthException.class)
    protected ResponseEntity<ErrorResponse> handleBaseAuthException(BaseAuthException e) {
        log.warn("Exception: {}", e.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(), e.getDescription());

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(e.getErrorCode()));
    }
}
