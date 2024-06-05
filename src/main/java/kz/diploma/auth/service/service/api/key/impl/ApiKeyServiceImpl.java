package kz.diploma.auth.service.service.api.key.impl;

import kz.diploma.auth.service.repository.AuthSessionRepository;
import kz.diploma.auth.service.service.api.key.ApiKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService {
    private final AuthSessionRepository authSessionRepository;

    @Override
    public void closeSessions(String login) {
        authSessionRepository.closeByLogin(login);
    }
}
