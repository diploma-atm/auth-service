package kz.diploma.auth.service.chain.step;

import kz.diploma.auth.service.chain.engine.AuthConditionalChainStep;
import kz.diploma.auth.service.chain.step.check.CheckPasswordStep;
import kz.diploma.auth.service.chain.step.ex.AuthenticateExStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;
import kz.diploma.auth.service.model.enums.Roles;
import kz.diploma.auth.service.service.user.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FetchUserStep extends AuthConditionalChainStep {
    private final LoginService loginService;

    protected FetchUserStep(CheckPasswordStep chainA,
                            AuthenticateExStep chainB,
                            LoginService loginService) {
        super(chainA, chainB);
        this.loginService = loginService;
    }

    @Override
    public OutputAuthParams execute(InputAuthParams inputAuthParams) {
        log.info("Fetching user");

        if(inputAuthParams.getLogin().length() < 12){
            var admin = loginService.findAdmin(inputAuthParams.getLogin()).orElse(null);
            inputAuthParams.setAdmin(admin);
            if(admin != null){
                inputAuthParams.setRole(Roles.ADMIN);
            }
        } else {
            var product = loginService.findProduct(inputAuthParams.getLogin()).orElse(null);
            inputAuthParams.setProduct(product);
            if(product != null){
                inputAuthParams.setRole(Roles.CLIENT);
            }
        }

        return super.execute(inputAuthParams);
    }

    @Override
    protected boolean branch(InputAuthParams inputAuthParams) {
        if(inputAuthParams.getRole() == Roles.ADMIN){
            return inputAuthParams.getAdmin() != null;
        } else {
            return inputAuthParams.getProduct() != null;
        }
    }
}
