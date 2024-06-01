package kz.diploma.auth.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "secret-key")
public class SecretKeyConfigProperties {
    public String value;
}
