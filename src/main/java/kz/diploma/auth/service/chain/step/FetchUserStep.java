package kz.diploma.auth.service.chain.step;

import kz.diploma.auth.service.chain.engine.AuthConditionalChainStep;
import kz.diploma.auth.service.chain.step.check.CheckPasswordStep;
import kz.diploma.auth.service.chain.step.ex.AuthenticateExStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;
import kz.diploma.auth.service.model.enums.Roles;
import kz.diploma.auth.service.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FetchUserStep extends AuthConditionalChainStep {
    private final UserService userService;

    protected FetchUserStep(CheckPasswordStep chainA,
                            AuthenticateExStep chainB,
                            UserService userService) {
        super(chainA, chainB);
        this.userService = userService;
    }

    @Override
    public OutputAuthParams execute(InputAuthParams inputAuthParams) {
        log.info("Fetching user");

        var admin = userService.findAdmin(inputAuthParams.getPhoneNumber()).orElse(null);
        inputAuthParams.setAdmin(admin);

        var client = userService.findClient(inputAuthParams.getPhoneNumber()).orElse(null);
        inputAuthParams.setClient(client);

        if(admin != null){
            inputAuthParams.setRole(Roles.ADMIN);
        } else{
            inputAuthParams.setRole(Roles.CLIENT);
        }

        return super.execute(inputAuthParams);
    }

    @Override
    protected boolean branch(InputAuthParams inputAuthParams) {
        if(inputAuthParams.getRole() == Roles.ADMIN){
            return inputAuthParams.getAdmin() != null;
        } else {
            return inputAuthParams.getClient() != null;
        }
    }
}
