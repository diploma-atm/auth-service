package kz.diploma.auth.service.chain.step;


import kz.diploma.auth.service.chain.engine.AuthAbstractChainStep;
import kz.diploma.auth.service.model.auth_params.InputAuthParams;
import kz.diploma.auth.service.model.auth_params.OutputAuthParams;
import kz.diploma.auth.service.model.dto.AuthResponseDTO;
import kz.diploma.auth.service.model.enums.Roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FinishStep implements AuthAbstractChainStep {
    @Override
    public OutputAuthParams execute(InputAuthParams in) {
        log.info("FinishStep");
        String fio;
        if (in.getRole() == Roles.ADMIN) {
            fio = new StringBuilder()
                    .append(in.getAdmin().surname)
                    .append(" ")
                    .append(in.getAdmin().name)
                    .toString();

            if(in.getAdmin().lastName != null){
                fio += " " + in.getAdmin().lastName;
            }
        } else {
            fio = new StringBuilder()
                    .append(in.getClient().surname)
                    .append(" ")
                    .append(in.getClient().name)
                    .append(" ")
                    .toString();
            if(in.getClient().lastName != null){
                fio += " " + in.getClient().lastName;
            }
        }

        var builder = OutputAuthParams.builder()
                .response(AuthResponseDTO.builder()
                        .role(in.getRole())
                .fio(fio)
                .authToken(in.getAuthEntity().apiKey)
                .phoneNumber(in.getPhoneNumber())
                .build());

        var output = builder.build();
        output.getHeaders().put("Authorization", in.getAuthEntity().apiKey);

        return output;
    }
}
