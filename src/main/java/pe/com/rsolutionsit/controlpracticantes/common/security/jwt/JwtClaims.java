package pe.com.rsolutionsit.controlpracticantes.common.security.jwt;

import java.time.Instant;
import java.util.UUID;

/**
 * Immutable representation of validated JWT claims.
 *
 * <p>This object isolates the rest of the application from the underlying
 * JWT library. The token is parsed only once inside {@link JwtService} and
 * converted into this record.
 *
 * @param userId    authenticated user identifier.
 * @param username  authenticated username.
 * @param role      assigned role.
 * @param tokenType token type.
 * @param issuedAt  token creation time.
 * @param expiresAt token expiration time.
 * @param tokenId   unique JWT identifier.
 * @author Raul Sosa
 * @since 1.0.0
 */
public record JwtClaims(

    UUID userId,

    String username,

    String role,

    JwtTokenType tokenType,

    Instant issuedAt,

    Instant expiresAt,

    String tokenId
) {
}
