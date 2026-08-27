package pe.com.rsolutionsit.controlpracticantes.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
            .info(new Info()
                .title("Intern Hours Control System API")
                .version("0.2.0")
                .description("""
                    Enterprise API built with Java 21,
                    Spring Boot and Hexagonal Architecture.
                    """)
                .contact(new Contact()
                    .name("MisterPuckDev")
                    .email("sosa.sandoval.raul@gmail.com"))
                .license(new License()
                    .name("Private License")));

    }
}
