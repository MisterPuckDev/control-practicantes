package pe.com.rsolutionsit.controlpracticantes.common.security.password;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuración del codificador de contraseñas.
 *
 * Expone un PasswordEncoder basado en BCrypt para toda la aplicación.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Configuration
public class PasswordConfig {

    /**
     * Crea el codificador oficial del sistema.
     *
     * @return instancia de BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
