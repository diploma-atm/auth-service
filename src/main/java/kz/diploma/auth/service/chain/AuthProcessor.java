package kz.diploma.auth.service.chain;

import kz.diploma.auth.service.chain.step.ValidateUserStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;
import kz.diploma.auth.service.model.enums.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AuthProcessor {
    private final ValidateUserStep requestChain;

    @Transactional(rollbackFor = Exception.class)
    public OutputAuthParams execute(String phoneNumber, String password, Roles role) {
        return requestChain.execute(InputAuthParams.builder()
                .phoneNumber(phoneNumber)
                .password(password)
                .role(role)
                .build());
    }
}
