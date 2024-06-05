package kz.diploma.auth.service.generator;

import kz.diploma.library.shared.model.entity.auth.AuthEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ApiKeyGenerator {

    private final CryptoGenerator generator;

    public AuthEntity generateNewKey(String login) {
        AuthEntity key = null;

        try {
            key = new AuthEntity();
            key.startDate = LocalDateTime.now();
            key.apiKey = generator.generateHmacSHA256Signature(UUID.randomUUID().toString());
            key.login = login;
            key.expiryDate = LocalDateTime.now().plusHours(25L);
        } catch (GeneralSecurityException ex) {
            ex.printStackTrace();
        }

        return key;
    }

}
