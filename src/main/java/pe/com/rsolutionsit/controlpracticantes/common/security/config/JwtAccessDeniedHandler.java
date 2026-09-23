package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import pe.com.rsolutionsit.controlpracticantes.common.response.ApiErrorResponse;

import java.io.IOException;

/**
 * Handles forbidden requests.
 *
 * <p>This handler is executed when an authenticated user attempts to access
 * a resource without having the required permissions.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * JSON serializer.
     */
    private final ObjectMapper objectMapper;

    /**
     * Creates the access denied handler.
     *
     * @param objectMapper JSON serializer.
     */
    public JwtAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Returns a standardized HTTP 403 response.
     *
     * @param request               current HTTP request.
     * @param response              current HTTP response.
     * @param accessDeniedException permission failure.
     * @throws IOException      if writing the response fails.
     * @throws ServletException if servlet processing fails.
     */
    @Override
    public void handle(
        HttpServletRequest request,
        HttpServletResponse response,
        AccessDeniedException accessDeniedException)
        throws IOException, ServletException {

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        objectMapper.writeValue(
            response.getWriter(),
            ApiErrorResponse.of(
                HttpStatus.FORBIDDEN.value(),
                "FORBIDDEN",
                "Access denied."));
    }
}
