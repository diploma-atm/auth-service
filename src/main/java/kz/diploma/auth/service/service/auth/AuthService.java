package kz.diploma.auth.service.service.auth;

public interface AuthService {
    boolean checkSession(String token);

    void logout(String token);
}
