package kz.diploma.auth.service;

import kz.diploma.auth.service.properties.SecretKeyConfigProperties;
import kz.diploma.library.shared.model.ModelsAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import({ModelsAutoConfiguration.class})
@EnableConfigurationProperties(value = SecretKeyConfigProperties.class)
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
