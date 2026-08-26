package pe.com.rsolutionsit.controlpracticantes.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * Configuración del reloj del sistema.
 *
 * Centraliza la obtención de la hora para facilitar las pruebas
 * y evitar el uso directo de LocalDateTime.now().
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Configuration
public class ClockConfig {

    /**
     * Expone un Clock del sistema como Bean de Spring.
     *
     * @return reloj del sistema.
     */
    @Bean
    public Clock systemClock() {
        return Clock.systemDefaultZone();
    }
}