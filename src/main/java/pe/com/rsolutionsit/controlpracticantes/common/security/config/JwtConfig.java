package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

/**
 * Configures JWT authentication infrastructure.
 *
 * <p>This class exposes the {@link AuthenticationManager} used during user
 * authentication and keeps JWT-specific configuration isolated from the
 * security filter chain.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Configuration
public class JwtConfig {

    /**
     * Creates the application's authentication manager.
     *
     * @param configuration Spring authentication configuration.
     * @return configured authentication manager.
     * @throws Exception if the authentication manager cannot be created.
     */
    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration configuration)
        throws Exception {

        return configuration.getAuthenticationManager();
    }
}
