package pe.com.rsolutionsit.controlpracticantes.common.security.filter;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pe.com.rsolutionsit.controlpracticantes.common.constants.TraceConstants;
import pe.com.rsolutionsit.controlpracticantes.common.security.jwt.JwtClaims;
import pe.com.rsolutionsit.controlpracticantes.common.security.jwt.JwtService;
import pe.com.rsolutionsit.controlpracticantes.common.security.jwt.JwtTokenType;
import pe.com.rsolutionsit.controlpracticantes.common.security.service.CustomUserDetailsService;

import java.io.IOException;
import java.util.Set;

/**
 * Authenticates requests using Bearer JWT tokens.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /**
     * Logger.
     */
    private static final Logger LOGGER =
        LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    /**
     * Public endpoints excluded from authentication.
     */
    private static final Set<String> PUBLIC_PATHS = Set.of(
        "/api/v1/auth/login",
        "/v3/api-docs",
        "/swagger-ui",
        "/swagger-ui.html");

    /**
     * JWT service.
     */
    private final JwtService jwtService;

    /**
     * User details service.
     */
    private final CustomUserDetailsService userDetailsService;

    /**
     * Creates the authentication filter.
     *
     * @param jwtService         JWT service.
     * @param userDetailsService user details service.
     */
    public JwtAuthenticationFilter(
        JwtService jwtService,
        CustomUserDetailsService userDetailsService) {

        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Authenticates the request when a valid Bearer token is present.
     *
     * @param request     current HTTP request.
     * @param response    current HTTP response.
     * @param filterChain remaining filter chain.
     * @throws ServletException if servlet processing fails.
     * @throws IOException      if request processing fails.
     */
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

        if (shouldSkipAuthentication(request)) {

            filterChain.doFilter(request, response);
            return;

        }

        String token = extractBearerToken(request);

        if (token == null) {

            filterChain.doFilter(request, response);
            return;

        }

        try {

            JwtClaims claims = jwtService.validateToken(token);

            if (claims.tokenType() != JwtTokenType.ACCESS) {
                throw new JwtException(
                    "Refresh token cannot access protected resources.");
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails =
                    userDetailsService.loadUserByUsername(claims.username());

                UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());

                authentication.setDetails(
                    new WebAuthenticationDetailsSource()
                        .buildDetails(request));

                SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
            }

        } catch (JwtException exception) {

            LOGGER.warn(
                "JWT validation failed. reason={} traceId={}",
                exception.getMessage(),
                MDC.get(TraceConstants.TRACE_ID));

            SecurityContextHolder.clearContext();

        }

        filterChain.doFilter(request, response);
    }

    /**
     * Determines whether authentication should be skipped.
     *
     * @param request current HTTP request.
     * @return {@code true} if authentication should be skipped.
     */
    private boolean shouldSkipAuthentication(HttpServletRequest request) {

        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        String path = request.getServletPath();

        return PUBLIC_PATHS.stream().anyMatch(path::startsWith);
    }

    /**
     * Extracts the Bearer token from the Authorization header.
     *
     * @param request current HTTP request.
     * @return JWT token or {@code null}.
     */
    private String extractBearerToken(HttpServletRequest request) {

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null || !header.startsWith("Bearer ")) {
            return null;
        }

        return header.substring(7).trim();
    }

}
