package kz.diploma.auth.service.exception;

public abstract class BaseAuthException extends RuntimeException{

    public abstract int getErrorCode();

    public abstract String getDescription();

}
