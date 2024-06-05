package kz.diploma.auth.service.chain.step.check;

import kz.diploma.auth.service.chain.engine.AuthConditionalChainStep;
import kz.diploma.auth.service.chain.step.CloseSessionStep;
import kz.diploma.auth.service.chain.step.ex.AuthenticateExStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.enums.Roles;
import org.springframework.stereotype.Component;

@Component
public class CheckUserStatusStep extends AuthConditionalChainStep {
    protected CheckUserStatusStep(CloseSessionStep chainA, AuthenticateExStep chainB) {
        super(chainA, chainB);
    }

    @Override
    protected boolean branch(InputAuthParams inputAuthParams) {
        return inputAuthParams.getRole() == Roles.ADMIN || !inputAuthParams.getProduct().isBlocked;
    }
}
