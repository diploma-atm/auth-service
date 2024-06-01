package kz.diploma.auth.service.model.request;

import kz.diploma.auth.service.model.enums.Roles;
import lombok.Data;

@Data
public class AuthRequest {
    private String phoneNumber;
    private String password;
    private Roles role;
}
