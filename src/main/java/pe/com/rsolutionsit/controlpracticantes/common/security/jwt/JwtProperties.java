package pe.com.rsolutionsit.controlpracticantes.common.security.jwt;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * JWT configuration loaded from application configuration files.
 *
 * <p>This class centralizes every configurable value required by the JWT
 * module and validates them during application startup.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    /**
     * HMAC secret.
     */
    private String secret;

    /**
     * Access token expiration in milliseconds.
     */
    private long expiration;

    /**
     * Refresh token expiration in milliseconds.
     */
    private long refreshExpiration;

    /**
     * Expected issuer.
     */
    private String issuer;

    /**
     * Expected audience.
     */
    private String audience;

    /**
     * Validates configuration during startup.
     */
    @PostConstruct
    public void validate() {

        if (secret == null || secret.length() < 32) {
            throw new IllegalStateException(
                "JWT secret must contain at least 32 characters.");
        }

        if (expiration <= 0) {
            throw new IllegalStateException(
                "JWT expiration must be greater than zero.");
        }

        if (refreshExpiration <= expiration) {
            throw new IllegalStateException(
                "Refresh expiration must be greater than access expiration.");
        }
    }

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

    public long getRefreshExpiration() {
        return refreshExpiration;
    }

    public void setRefreshExpiration(long refreshExpiration) {
        this.refreshExpiration = refreshExpiration;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
