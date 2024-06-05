package kz.diploma.auth.service.model.auth_params;

import kz.diploma.auth.service.model.enums.Roles;
import kz.diploma.library.shared.model.entity.AdminEntity;
import kz.diploma.library.shared.model.entity.ProductEntity;
import kz.diploma.library.shared.model.entity.auth.AuthEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputAuthParams {
    private String login;
    private String password;
    private Roles role;
    private AdminEntity admin;
    private ProductEntity product;
    private AuthEntity authEntity;
}