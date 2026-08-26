package pe.com.rsolutionsit.controlpracticantes.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de seguridad para el entorno de desarrollo.
 *
 * Durante esta etapa todos los endpoints permanecen abiertos,
 * mientras que Swagger puede consultarse libremente.
 *
 * Esta configuración será reemplazada progresivamente por JWT.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Configuration
@Profile("dev")
public class SecurityConfig {

    /**
     * Configuración temporal del filtro de seguridad.
     *
     * @param http configuración HTTP de Spring Security.
     * @return cadena de filtros configurada.
     * @throws Exception cuando ocurre un error durante la configuración.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html",
                                "/actuator/**"
                        ).permitAll()

                        .anyRequest().permitAll()
                )

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}