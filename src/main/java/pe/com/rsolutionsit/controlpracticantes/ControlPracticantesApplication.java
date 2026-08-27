package pe.com.rsolutionsit.controlpracticantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pe.com.rsolutionsit.controlpracticantes.common.security.jwt.JwtProperties;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "securityAuditor")
@EnableConfigurationProperties(JwtProperties.class)
public class ControlPracticantesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlPracticantesApplication.class, args);
    }

}
