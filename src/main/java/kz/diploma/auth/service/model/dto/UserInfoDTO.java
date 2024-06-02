package kz.diploma.auth.service.model.dto;

import kz.diploma.auth.service.model.enums.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoDTO {
    private Roles role;
}
