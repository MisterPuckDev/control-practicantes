package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.com.rsolutionsit.controlpracticantes.common.security.principal.UserPrincipalService;

/**
 * Development security configuration.
 * <p>
 * Swagger remains public while JWT authentication
 * is completed in subsequent iterations.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Configuration
@Profile("dev")
@EnableMethodSecurity
public class SecurityConfig {

    private final UserPrincipalService userPrincipalService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(
        UserPrincipalService userPrincipalService,
        PasswordEncoder passwordEncoder) {

        this.userPrincipalService = userPrincipalService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/v1/auth/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }

    /**
     * Official AuthenticationManager used by LoginUseCase.
     */
    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration configuration)
        throws Exception {

        return configuration.getAuthenticationManager();
    }

    /**
     * Authentication provider backed by UserPrincipalService.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider =
            new DaoAuthenticationProvider();

        provider.setUserDetailsService(userPrincipalService);
        provider.setPasswordEncoder(passwordEncoder);

        return provider;
    }
}
