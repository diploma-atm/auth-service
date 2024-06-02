package kz.diploma.auth.service.service.auth;

import kz.diploma.auth.service.model.dto.UserInfoDTO;

public interface AuthService {
    UserInfoDTO checkSession(String token);

    void logout(String token);
}
