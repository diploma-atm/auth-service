package kz.diploma.auth.service.model.auth_params;

import kz.diploma.auth.service.model.enums.Roles;
import kz.diploma.library.shared.model.entity.AdminEntity;
import kz.diploma.library.shared.model.entity.ClientEntity;
import kz.diploma.library.shared.model.entity.auth.AuthEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputAuthParams {
    private String phoneNumber;
    private String password;
    private Roles role;
    private AdminEntity admin;
    private ClientEntity client;
    private AuthEntity authEntity;
}