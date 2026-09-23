package pe.com.rsolutionsit.controlpracticantes.common.config.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import pe.com.rsolutionsit.controlpracticantes.common.security.config.CorsProperties;
import pe.com.rsolutionsit.controlpracticantes.common.security.jwt.JwtProperties;
import pe.com.rsolutionsit.controlpracticantes.common.security.ratelimit.config.RateLimitProperties;

/**
 * Registers every typed configuration class used by the application.
 *
 * <p>Each module owns its own configuration class while registration remains
 * centralized.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties({
    ApplicationProperties.class,
    DatabaseProperties.class,
    ManagementProperties.class,
    JwtProperties.class,
    CorsProperties.class,
    RateLimitProperties.class
})
public class ConfigurationPropertiesRegistrar {
}
