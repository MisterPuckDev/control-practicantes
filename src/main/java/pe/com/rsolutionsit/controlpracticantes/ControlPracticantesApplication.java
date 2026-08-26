package pe.com.rsolutionsit.controlpracticantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ControlPracticantesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlPracticantesApplication.class, args);
    }

}
