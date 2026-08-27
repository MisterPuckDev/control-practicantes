package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger security configuration.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Configuration
public class OpenApiSecurityConfig {

    @Bean
    public OpenAPI openApiSecurity() {

        return new OpenAPI()

            .components(

                new Components()

                    .addSecuritySchemes(

                        "BearerAuth",

                        new SecurityScheme()

                            .type(SecurityScheme.Type.HTTP)

                            .scheme("bearer")

                            .bearerFormat("JWT")

                    )

            );

    }

}
