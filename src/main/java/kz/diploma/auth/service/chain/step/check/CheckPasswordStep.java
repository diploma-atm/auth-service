package kz.diploma.auth.service.chain.step.check;

import kz.diploma.auth.service.chain.engine.AuthConditionalChainStep;
import kz.diploma.auth.service.chain.step.ex.AuthenticateExStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CheckPasswordStep extends AuthConditionalChainStep {
    private static final Logger log = LoggerFactory.getLogger(CheckPasswordStep.class);

    protected CheckPasswordStep(CheckUserStatusStep chainA, AuthenticateExStep chainB) {
        super(chainA, chainB);
    }

    @Override
    protected boolean branch(InputAuthParams inputAuthParams) {
        log.info("Checking if password is valid " + inputAuthParams.getPassword() + "\t" + inputAuthParams.getClient().password);
        return inputAuthParams.getClient().password.equalsIgnoreCase(inputAuthParams.getPassword());
    }
}
