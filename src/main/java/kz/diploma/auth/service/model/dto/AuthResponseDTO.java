package kz.diploma.auth.service.model.dto;

import kz.diploma.auth.service.model.enums.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDTO {
    private Roles role;
    private String fio;
    private String phoneNumber;
    private String authToken;
}
