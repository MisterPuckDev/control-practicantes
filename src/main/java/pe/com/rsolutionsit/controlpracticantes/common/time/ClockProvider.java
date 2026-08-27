package pe.com.rsolutionsit.controlpracticantes.common.time;

import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Centralized time provider.
 * <p>
 * Avoids direct calls to LocalDateTime.now()
 * and makes testing deterministic.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Component
public class ClockProvider {

    private final Clock clock;

    public ClockProvider(Clock clock) {
        this.clock = clock;
    }

    /**
     * Returns current local date-time.
     */
    public LocalDateTime now() {
        return LocalDateTime.now(clock);
    }

    /**
     * Returns current UTC date-time.
     */
    public LocalDateTime nowUtc() {
        return LocalDateTime.now(clock.withZone(ZoneOffset.UTC));
    }
}
