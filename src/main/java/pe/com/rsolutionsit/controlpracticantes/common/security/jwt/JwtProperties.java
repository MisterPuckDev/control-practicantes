package pe.com.rsolutionsit.controlpracticantes.common.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * JWT configuration properties loaded from application.yml.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    private String secret;

    private long expiration;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
}
