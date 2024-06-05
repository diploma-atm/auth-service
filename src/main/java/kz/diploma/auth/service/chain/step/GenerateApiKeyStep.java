package kz.diploma.auth.service.chain.step;

import kz.diploma.auth.service.chain.engine.AuthChainStep;
import kz.diploma.auth.service.generator.ApiKeyGenerator;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;
import kz.diploma.auth.service.repository.AuthSessionRepository;
import kz.diploma.library.shared.model.entity.auth.AuthEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenerateApiKeyStep extends AuthChainStep {
    private final ApiKeyGenerator apiKeyGenerator;
    private final AuthSessionRepository authSessionRepository;

    protected GenerateApiKeyStep(FinishStep next, ApiKeyGenerator apiKeyGenerator, AuthSessionRepository authSessionRepository) {
        super(next);
        this.apiKeyGenerator = apiKeyGenerator;
        this.authSessionRepository = authSessionRepository;
    }

    @Override
    public OutputAuthParams execute(InputAuthParams inputAuthParams) {
        log.info("GenerateApiKeyStep");
        AuthEntity authEntity = apiKeyGenerator.generateNewKey(inputAuthParams.getLogin());

        authEntity = authSessionRepository.save(authEntity);
        inputAuthParams.setAuthEntity(authEntity);

        return super.execute(inputAuthParams);
    }
}
