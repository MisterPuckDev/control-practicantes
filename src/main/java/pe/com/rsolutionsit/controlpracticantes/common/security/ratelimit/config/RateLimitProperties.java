package pe.com.rsolutionsit.controlpracticantes.common.security.ratelimit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * Configuration properties used by the Rate Limiting module.
 *
 * <p>This class centralizes the configuration values that define how many
 * requests are allowed during a refill period. The values are loaded from
 * the application configuration file and can be overridden per environment.
 *
 * <p>Example:
 *
 * <pre>
 * security:
 *   rate-limit:
 *     capacity: 60
 *     refill-tokens: 60
 *     refill-duration: 1m
 * </pre>
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "security.rate-limit")
public class RateLimitProperties {

    /**
     * Maximum number of tokens that a bucket can hold.
     */
    private long capacity = 60;

    /**
     * Number of tokens added during each refill period.
     */
    private long refillTokens = 60;

    /**
     * Duration of the refill period.
     */
    private Duration refillDuration = Duration.ofMinutes(1);

    /**
     * Returns the bucket capacity.
     *
     * @return maximum number of tokens.
     */
    public long getCapacity() {
        return capacity;
    }

    /**
     * Updates the bucket capacity.
     *
     * @param capacity new maximum number of tokens.
     */
    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    /**
     * Returns the number of tokens restored during each refill.
     *
     * @return refill token count.
     */
    public long getRefillTokens() {
        return refillTokens;
    }

    /**
     * Updates the refill token amount.
     *
     * @param refillTokens number of tokens restored during each refill.
     */
    public void setRefillTokens(long refillTokens) {
        this.refillTokens = refillTokens;
    }

    /**
     * Returns the duration between bucket refills.
     *
     * @return refill duration.
     */
    public Duration getRefillDuration() {
        return refillDuration;
    }

    /**
     * Updates the refill duration.
     *
     * @param refillDuration new refill period.
     */
    public void setRefillDuration(Duration refillDuration) {
        this.refillDuration = refillDuration;
    }
}
