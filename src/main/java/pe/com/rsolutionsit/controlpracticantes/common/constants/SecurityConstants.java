package pe.com.rsolutionsit.controlpracticantes.common.constants;

/**
 * Constantes utilizadas por el módulo de seguridad.
 *
 * Centraliza nombres de cabeceras, prefijos y otros valores
 * relacionados con autenticación.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
public final class SecurityConstants {

    private SecurityConstants() {
    }

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";
}
