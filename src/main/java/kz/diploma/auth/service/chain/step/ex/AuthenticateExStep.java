package kz.diploma.auth.service.chain.step.ex;

import kz.diploma.auth.service.chain.engine.AuthAbstractChainStep;
import kz.diploma.auth.service.exception.AuthenticationException;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateExStep implements AuthAbstractChainStep {

    @Override
    public OutputAuthParams execute(InputAuthParams inputAuthParams) {
        throw new AuthenticationException();
    }
}
