package kz.diploma.auth.service.chain.engine;

import kz.diploma.auth.service.chain.basic.AbstractChainStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;

public interface AuthAbstractChainStep extends AbstractChainStep<InputAuthParams, OutputAuthParams> {
}
