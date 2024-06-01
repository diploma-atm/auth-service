package kz.diploma.auth.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "kz.diploma.auth.service.repository")
@EnableTransactionManagement
public class JpaConfiguration {
}