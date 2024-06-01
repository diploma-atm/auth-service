package kz.diploma.auth.service.model.auth_params;

import kz.diploma.auth.service.model.dto.AuthResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class OutputAuthParams {
    private final Map<String, String> headers = new HashMap<>();
    private AuthResponseDTO response;

}
