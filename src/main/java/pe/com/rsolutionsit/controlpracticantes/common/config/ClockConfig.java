package pe.com.rsolutionsit.controlpracticantes.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * System clock configuration.
 * <p>
 * Centralizes time access for testing purposes.
 *
 * @author MisterPuckDev
 * @since 1.0.0
 */
@Configuration
public class ClockConfig {

    @Bean
    public Clock systemClock() {
        return Clock.systemDefaultZone();
    }
}
