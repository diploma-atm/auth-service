package kz.diploma.auth.service.chain.step;

import kz.diploma.auth.service.chain.engine.AuthChainStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;
import kz.diploma.auth.service.service.api.key.ApiKeyService;
import org.springframework.stereotype.Component;

@Component
public class CloseSessionStep extends AuthChainStep {
    private final ApiKeyService apiKeyService;

    protected CloseSessionStep(GenerateApiKeyStep next, ApiKeyService apiKeyService) {
        super(next);
        this.apiKeyService = apiKeyService;
    }

    @Override
    public OutputAuthParams execute(InputAuthParams inputAuthParams) {
        apiKeyService.closeSessions(inputAuthParams.getPhoneNumber());
        return super.execute(inputAuthParams);
    }
}
