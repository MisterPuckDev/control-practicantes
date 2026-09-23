package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import pe.com.rsolutionsit.controlpracticantes.common.response.ApiErrorResponse;

import java.io.IOException;

/**
 * Handles unauthorized requests.
 *
 * <p>This entry point is invoked whenever an unauthenticated client attempts
 * to access a protected resource. It returns a standardized JSON response
 * instead of the default Spring Security HTML response.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * JSON serializer.
     */
    private final ObjectMapper objectMapper;

    /**
     * Creates the authentication entry point.
     *
     * @param objectMapper JSON serializer.
     */
    public JwtAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Returns a standardized HTTP 401 response.
     *
     * @param request       current HTTP request.
     * @param response      current HTTP response.
     * @param authException authentication failure.
     * @throws IOException      if writing the response fails.
     * @throws ServletException if servlet processing fails.
     */
    @Override
    public void commence(
        HttpServletRequest request,
        HttpServletResponse response,
        AuthenticationException authException)
        throws IOException, ServletException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        objectMapper.writeValue(
            response.getWriter(),
            ApiErrorResponse.of(
                HttpStatus.UNAUTHORIZED.value(),
                "UNAUTHORIZED",
                "Authentication is required."));
    }
}
