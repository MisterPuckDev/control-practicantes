package pe.com.rsolutionsit.controlpracticantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Application entry point.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "securityAuditor")
public class ControlPracticantesApplication {

    /**
     * Starts the application.
     *
     * @param args startup arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ControlPracticantesApplication.class, args);
    }
}
