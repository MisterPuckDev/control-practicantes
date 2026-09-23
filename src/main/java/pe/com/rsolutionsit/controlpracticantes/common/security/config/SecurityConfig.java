package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import pe.com.rsolutionsit.controlpracticantes.common.logging.RequestLoggingFilter;
import pe.com.rsolutionsit.controlpracticantes.common.security.filter.JwtAuthenticationFilter;
import pe.com.rsolutionsit.controlpracticantes.common.security.filter.RequestTraceFilter;
import pe.com.rsolutionsit.controlpracticantes.common.security.ratelimit.filter.RateLimitFilter;

import java.util.List;

/**
 * Configures Spring Security.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final RequestTraceFilter requestTraceFilter;
    private final RateLimitFilter rateLimitFilter;
    private final CorsProperties corsProperties;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
    private final JwtAccessDeniedHandler accessDeniedHandler;
    private final RequestLoggingFilter  requestLoggingFilter;

    /**
     * Creates the security configuration.
     *
     * @param jwtAuthenticationFilter  JWT authentication filter.
     * @param requestTraceFilter       request trace filter.
     * @param rateLimitFilter          rate limit filter.
     * @param corsProperties           CORS configuration.
     * @param authenticationEntryPoint unauthorized request handler.
     * @param accessDeniedHandler      forbidden request handler.
     * @param requestLoggingFilter     logging filter
     */
    public SecurityConfig(
        JwtAuthenticationFilter jwtAuthenticationFilter,
        RequestTraceFilter requestTraceFilter,
        RateLimitFilter rateLimitFilter,
        CorsProperties corsProperties,
        JwtAuthenticationEntryPoint authenticationEntryPoint,
        JwtAccessDeniedHandler accessDeniedHandler,
        RequestLoggingFilter requestLoggingFilter) {

        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.requestTraceFilter = requestTraceFilter;
        this.rateLimitFilter = rateLimitFilter;
        this.corsProperties = corsProperties;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.accessDeniedHandler = accessDeniedHandler;
        this.requestLoggingFilter = requestLoggingFilter;
    }

    /**
     * Configures the application's HTTP security filter chain.
     *
     * @param http Spring Security builder.
     * @return configured filter chain.
     * @throws Exception if configuration fails.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {

        http

            .csrf(csrf -> csrf.disable())

            .cors(cors -> cors.configurationSource(corsConfigurationSource()))

            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler))

            .headers(headers -> headers

                .cacheControl(Customizer.withDefaults())

                .contentTypeOptions(Customizer.withDefaults())

                .frameOptions(frame -> frame.deny())

                .contentSecurityPolicy(csp -> csp.policyDirectives(
                    "default-src 'none'; frame-ancestors 'none'; base-uri 'none';"))

                .httpStrictTransportSecurity(hsts -> hsts
                    .includeSubDomains(true)
                    .maxAgeInSeconds(31536000))

                .referrerPolicy(referrer -> referrer.policy(
                    org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy
                        .STRICT_ORIGIN_WHEN_CROSS_ORIGIN))

                .permissionsPolicy(policy -> policy.policy(
                    "camera=(), microphone=(), geolocation=()")))

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                .requestMatchers(
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html").permitAll()

                .requestMatchers(HttpMethod.POST,
                    "/api/v1/auth/login").permitAll()

                .anyRequest().authenticated())

            .addFilterBefore(
                requestTraceFilter,
                UsernamePasswordAuthenticationFilter.class)

            .addFilterAfter(
                rateLimitFilter,
                RequestTraceFilter.class)

            .addFilterAfter(
                jwtAuthenticationFilter,
                RateLimitFilter.class)

            .addFilterAfter(
                requestLoggingFilter,
                JwtAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Creates the application's CORS configuration.
     *
     * @return configured CORS source.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(corsProperties.getAllowedOrigins());

        configuration.setAllowedMethods(List.of(
            "GET", "POST", "PUT", "PATCH", "DELETE"));

        configuration.setAllowedHeaders(List.of(
            "Authorization",
            "Content-Type",
            "Accept",
            "X-Requested-With"));

        configuration.setExposedHeaders(List.of(
            "X-RateLimit-Remaining",
            "Retry-After"));

        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
