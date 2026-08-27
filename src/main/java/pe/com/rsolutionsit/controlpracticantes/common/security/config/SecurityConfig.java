package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Development security configuration.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Configuration
@Profile("dev")
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {

        http

            .csrf(csrf -> csrf.disable())

            .httpBasic(httpBasic -> httpBasic.disable())

            .formLogin(form -> form.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(

                    "/swagger-ui/**",

                    "/v3/api-docs/**",

                    "/swagger-ui.html"

                ).permitAll()

                .anyRequest().permitAll());

        return http.build();

    }

}
