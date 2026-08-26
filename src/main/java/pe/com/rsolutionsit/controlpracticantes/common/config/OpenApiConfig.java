package pe.com.rsolutionsit.controlpracticantes.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de OpenAPI para la documentación de la API.
 *
 * Centraliza la información general del proyecto que será mostrada
 * en Swagger UI.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Configuration
public class OpenApiConfig {

    /**
     * Configura la información principal de la API.
     *
     * @return configuración personalizada de OpenAPI.
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Sistema Control de Practicantes")
                        .version("1.0.0")
                        .description("API empresarial para la gestión de horas de practicantes.")
                        .contact(new Contact()
                                .name("MisterPuckDev")));
    }
}