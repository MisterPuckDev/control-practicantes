package pe.com.rsolutionsit.controlpracticantes.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * Registers the application's shared clock.
 *
 * <p>Centralizing time access makes the application deterministic during
 * testing and avoids direct dependencies on system time.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Configuration
public class ClockConfig {

    /**
     * Returns the system clock used across the application.
     *
     * @return shared system clock.
     */
    @Bean
    public Clock systemClock() {

        return Clock.systemDefaultZone();
    }
}
