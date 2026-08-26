package pe.com.rsolutionsit.controlpracticantes.common.security.authorization;

/**
 * Define los roles oficiales del sistema.
 *
 * Estos roles serán utilizados por Spring Security
 * para controlar el acceso a los recursos protegidos.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */

public enum Role {

    ADMIN,

    RRHH,

    SUPERVISOR,

    PRACTICANTE

}
