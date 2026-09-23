package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Password encoder configuration.
 *
 * <p>Provides the official {@link PasswordEncoder} used across the entire
 * application.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Configuration
public class PasswordConfig {

    /**
     * Creates the BCrypt password encoder.
     *
     * @return BCrypt password encoder with strength 13.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(13);
    }
}
