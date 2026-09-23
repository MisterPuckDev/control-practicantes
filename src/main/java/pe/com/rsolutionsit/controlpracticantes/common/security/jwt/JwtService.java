package pe.com.rsolutionsit.controlpracticantes.common.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.common.security.principal.UserPrincipal;
import pe.com.rsolutionsit.controlpracticantes.common.time.ClockProvider;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

/**
 * Handles JWT generation and validation.
 *
 * <p>This service is the only class aware of the JJWT library.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Service
public class JwtService {

    /**
     * Allowed clock skew.
     */
    private static final long CLOCK_SKEW_SECONDS = 30;

    /**
     * JWT configuration.
     */
    private final JwtProperties properties;

    /**
     * Centralized time provider.
     */
    private final ClockProvider clockProvider;

    /**
     * HMAC signing key.
     */
    private final SecretKey secretKey;

    /**
     * Creates the JWT service.
     *
     * @param properties    JWT configuration.
     * @param clockProvider centralized clock.
     */
    public JwtService(
        JwtProperties properties,
        ClockProvider clockProvider) {

        this.properties = properties;
        this.clockProvider = clockProvider;

        this.secretKey = Keys.hmacShaKeyFor(
            properties.getSecret()
                .getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Generates an access token.
     *
     * @param principal authenticated user.
     * @return signed access token.
     */
    public String generateAccessToken(UserPrincipal principal) {

        return generateToken(
            principal,
            JwtTokenType.ACCESS,
            properties.getExpiration());
    }

    /**
     * Generates a refresh token.
     *
     * @param principal authenticated user.
     * @return signed refresh token.
     */
    public String generateRefreshToken(UserPrincipal principal) {

        return generateToken(
            principal,
            JwtTokenType.REFRESH,
            properties.getRefreshExpiration());
    }

    /**
     * Validates a JWT.
     *
     * @param token signed JWT.
     * @return validated immutable claims.
     */
    public JwtClaims validateToken(String token) {

        Claims claims = parseClaims(token);

        validateStandardClaims(claims);

        return new JwtClaims(

            UUID.fromString(claims.get("userId", String.class)),

            claims.getSubject(),

            claims.get("role", String.class),

            JwtTokenType.valueOf(
                claims.get("tokenType", String.class)),

            claims.getIssuedAt().toInstant(),

            claims.getExpiration().toInstant(),

            claims.getId());

    }

    /**
     * Generates a signed JWT.
     */
    private String generateToken(
        UserPrincipal principal,
        JwtTokenType tokenType,
        long expiration) {

        Instant now = clockProvider.nowUtc().toInstant(java.time.ZoneOffset.UTC);

        return Jwts.builder()

            .id(UUID.randomUUID().toString())

            .issuer(properties.getIssuer())

            .audience().add(properties.getAudience()).and()

            .subject(principal.getUsername())

            .claim("userId", principal.getId().toString())

            .claim("role", principal.getDomainUser().roleCode().name())

            .claim("tokenType", tokenType.name())

            .issuedAt(Date.from(now))

            .expiration(Date.from(now.plusMillis(expiration)))

            .signWith(secretKey)

            .compact();

    }

    /**
     * Parses JWT claims.
     */
    private Claims parseClaims(String token) {

        return Jwts.parser()

            .verifyWith(secretKey)

            .clockSkewSeconds(CLOCK_SKEW_SECONDS)

            .build()

            .parseSignedClaims(token)

            .getPayload();

    }

    /**
     * Validates issuer, audience and subject.
     */
    private void validateStandardClaims(Claims claims) {

        if (!properties.getIssuer().equals(claims.getIssuer())) {
            throw new JwtException("Invalid issuer.");
        }

        if (!claims.getAudience().contains(properties.getAudience())) {
            throw new JwtException("Invalid audience.");
        }

        if (claims.getSubject() == null || claims.getSubject().isBlank()) {
            throw new JwtException("Missing subject.");
        }
    }

}
