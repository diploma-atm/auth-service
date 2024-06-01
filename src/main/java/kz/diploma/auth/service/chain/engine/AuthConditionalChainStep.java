package kz.diploma.auth.service.chain.engine;

import kz.diploma.auth.service.chain.basic.AbstractChainStep;
import kz.diploma.auth.service.chain.basic.ConditionalChainStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;

public abstract class AuthConditionalChainStep extends ConditionalChainStep<InputAuthParams, OutputAuthParams> {

    protected AuthConditionalChainStep(AbstractChainStep<InputAuthParams, OutputAuthParams> chainA, AbstractChainStep<InputAuthParams, OutputAuthParams> chainB) {
        super(chainA, chainB);
    }
}
