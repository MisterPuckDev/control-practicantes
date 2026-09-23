package pe.com.rsolutionsit.controlpracticantes.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI configuration.
 *
 * <p>Centralizes API documentation, JWT security definition and
 * environment-specific servers.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Configuration
public class OpenApiConfig {

    /**
     * Security scheme name.
     */
    private static final String SECURITY_SCHEME = "BearerAuth";

    /**
     * Creates the OpenAPI definition.
     *
     * @return configured OpenAPI.
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

            .info(new Info()

                .title("Intern Hours Control System API")

                .version("1.0.0")

                .description("""
                    Enterprise REST API built with Java 21,
                    Spring Boot 4 and Hexagonal Architecture.

                    Features:
                    - JWT Authentication
                    - Rate Limiting
                    - Audit Logging
                    - Soft Delete
                    - UUID identifiers
                    - Trace ID propagation
                    """)

                .contact(new Contact()

                    .name("Raul Sosa")

                    .email("sosa.sandoval.raul@gmail.com"))

                .license(new License()

                    .name("Private License")))

            .servers(List.of(

                new Server()

                    .url("http://localhost:8080/api")

                    .description("Development"),

                new Server()

                    .url("https://api.company.com/api")

                    .description("Production")))

            .addSecurityItem(

                new SecurityRequirement()

                    .addList(SECURITY_SCHEME))

            .components(new Components()

                .addSecuritySchemes(

                    SECURITY_SCHEME,

                    new SecurityScheme()

                        .type(SecurityScheme.Type.HTTP)

                        .scheme("bearer")

                        .bearerFormat("JWT")));

    }
}
