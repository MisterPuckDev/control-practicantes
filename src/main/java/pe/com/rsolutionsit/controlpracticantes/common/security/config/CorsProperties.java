package pe.com.rsolutionsit.controlpracticantes.common.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the allowed CORS origins for each environment.
 *
 * <p>Origins are loaded from application configuration files, avoiding the
 * use of wildcard origins in production.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "security.cors")
public class CorsProperties {

    /**
     * Allowed origins.
     */
    private List<String> allowedOrigins = new ArrayList<>();

    /**
     * Returns allowed origins.
     *
     * @return list of origins.
     */
    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    /**
     * Updates allowed origins.
     *
     * @param allowedOrigins allowed origins.
     */
    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }
}
