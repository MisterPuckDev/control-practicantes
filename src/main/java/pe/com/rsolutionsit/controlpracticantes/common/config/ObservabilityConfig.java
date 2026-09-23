package pe.com.rsolutionsit.controlpracticantes.common.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

/**
 * Observability configuration.
 *
 * <p>Registers common application tags used by Micrometer metrics.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Configuration
public class ObservabilityConfig {

    /**
     * Metrics registry.
     */
    private final MeterRegistry meterRegistry;

    /**
     * Creates the observability configuration.
     *
     * @param meterRegistry metrics registry.
     */
    public ObservabilityConfig(MeterRegistry meterRegistry) {

        this.meterRegistry = meterRegistry;
    }

    /**
     * Registers common metric tags.
     */
    @PostConstruct
    public void configureMetrics() {

        meterRegistry.config()

            .commonTags(

                "application",

                "intern-hours-control-system");

    }
}
