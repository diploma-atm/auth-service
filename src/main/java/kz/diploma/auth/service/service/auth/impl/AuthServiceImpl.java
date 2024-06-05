package kz.diploma.auth.service.service.auth.impl;

import kz.diploma.auth.service.exception.AuthenticationException;
import kz.diploma.auth.service.exception.SessionNotFoundException;
import kz.diploma.auth.service.model.dto.UserInfoDTO;
import kz.diploma.auth.service.model.enums.Roles;
import kz.diploma.auth.service.repository.AuthSessionRepository;
import kz.diploma.auth.service.service.auth.AuthService;
import kz.diploma.auth.service.service.user.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthSessionRepository repository;
    private final LoginService loginService;

    @Override
    public UserInfoDTO checkSession(String token) {
        var opt = repository.findByApiKey(token);

        if(opt.isEmpty()){
            throw new SessionNotFoundException(token);
        }

        var apiKey = opt.get();
        if(LocalDateTime.now().isAfter(apiKey.expiryDate) || apiKey.terminatedDate != null){
            throw new AuthenticationException("Expired session");
        }

        var admin = loginService.findAdmin(apiKey.login);

        Roles role;
        if(admin.isPresent()){
            role = Roles.ADMIN;
        } else{
            role = Roles.CLIENT;
        }

        return UserInfoDTO.builder()
                .role(role)
                .build();
    }

    @Override
    public void logout(String token) {
        repository.closeByToken(token);
    }
}
