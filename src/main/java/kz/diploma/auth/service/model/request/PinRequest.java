package kz.diploma.auth.service.model.request;

import lombok.Data;

@Data
public class PinRequest {
    private String pan;
    private String pin;
}
