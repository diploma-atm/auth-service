package kz.diploma.auth.service.generator;

import com.thoughtworks.xstream.core.util.Base64Encoder;
import kz.diploma.auth.service.properties.SecretKeyConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

@Component
@RequiredArgsConstructor
public class CryptoGenerator {
    private final SecretKeyConfigProperties secretKeyConfig;

    public String generateHmacSHA256Signature(String data) throws GeneralSecurityException {
        byte[] hmacData;

        SecretKeySpec secretKey = new SecretKeySpec(secretKeyConfig.getValue().getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        hmacData = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return new Base64Encoder().encode(hmacData);
    }
}
