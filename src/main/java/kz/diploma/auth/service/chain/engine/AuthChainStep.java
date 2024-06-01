package kz.diploma.auth.service.chain.engine;

import kz.diploma.auth.service.chain.basic.AbstractChainStep;
import kz.diploma.auth.service.chain.basic.BaseChainStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;

public abstract class AuthChainStep extends BaseChainStep<InputAuthParams, OutputAuthParams> {
    protected AuthChainStep(AbstractChainStep<InputAuthParams, OutputAuthParams> next) {
        super(next);
    }
}
