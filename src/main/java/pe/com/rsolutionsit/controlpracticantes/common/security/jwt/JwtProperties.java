package pe.com.rsolutionsit.controlpracticantes.common.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Propiedades de configuración para JWT.
 *
 * Se cargarán desde application.yml.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "security.jwt")
public record JwtProperties(

    String secret,

    long expiration

) {
}
