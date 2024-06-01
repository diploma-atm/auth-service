package kz.diploma.auth.service.chain.step;

import kz.diploma.auth.service.chain.engine.AuthConditionalChainStep;
import kz.diploma.auth.service.chain.step.ex.AuthenticateExStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ValidateUserStep extends AuthConditionalChainStep {

    protected ValidateUserStep(FetchUserStep chainA, AuthenticateExStep chainB) {
        super(chainA, chainB);
    }

    @Override
    protected boolean branch(InputAuthParams inputAuthParams) {
        return StringUtils.isNotEmpty(inputAuthParams.getPhoneNumber()) && StringUtils.isNotEmpty(inputAuthParams.getPassword());
    }
}
