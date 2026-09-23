package pe.com.rsolutionsit.controlpracticantes.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the application's JSON serialization.
 *
 * <p>This configuration guarantees a single ObjectMapper across the entire
 * application, ensuring consistent serialization for controllers, filters,
 * security handlers and exception handlers.
 *
 * <p>Main behaviors:
 * <p>
 * * ISO-8601 date serialization.
 * * Java Time support.
 * * No timestamp serialization.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@Configuration
public class JacksonConfig {

    /**
     * Creates the application's shared ObjectMapper.
     *
     * @return configured ObjectMapper.
     */
    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mapper.disable(
            SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS);

        return mapper;
    }
}
