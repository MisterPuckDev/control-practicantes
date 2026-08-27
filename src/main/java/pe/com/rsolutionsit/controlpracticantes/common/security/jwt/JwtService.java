package pe.com.rsolutionsit.controlpracticantes.common.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import pe.com.rsolutionsit.controlpracticantes.common.security.principal.UserPrincipal;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

/**
 * JWT service.
 * <p>
 * Handles token generation and validation.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Service
public class JwtService {

    private final JwtProperties properties;

    private final SecretKey secretKey;

    public JwtService(JwtProperties properties) {

        this.properties = properties;

        this.secretKey = Keys.hmacShaKeyFor(
            properties.getSecret()
                .getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserPrincipal principal) {

        Instant now = Instant.now();

        return Jwts.builder()

            .subject(principal.getUsername())

            .claim("userId", principal.getId().toString())

            .claim("role", principal.getDomainUser().roleCode().name())

            .issuedAt(Date.from(now))

            .expiration(Date.from(
                now.plusMillis(properties.getExpiration())))

            .signWith(secretKey)

            .compact();
    }

    public String extractUsername(String token) {

        return extractClaims(token).getSubject();
    }

    public UUID extractUserId(String token) {

        return UUID.fromString(

            extractClaims(token)

                .get("userId", String.class)

        );
    }

    public boolean isTokenValid(String token, UserPrincipal principal) {

        return extractUsername(token)

            .equals(principal.getUsername())

            && !extractClaims(token)

            .getExpiration()

            .before(new Date());
    }

    private Claims extractClaims(String token) {

        return Jwts.parser()

            .verifyWith(secretKey)

            .build()

            .parseSignedClaims(token)

            .getPayload();
    }
}
