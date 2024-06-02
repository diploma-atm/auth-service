package kz.diploma.auth.service.model.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String phoneNumber;
    private String password;
}
