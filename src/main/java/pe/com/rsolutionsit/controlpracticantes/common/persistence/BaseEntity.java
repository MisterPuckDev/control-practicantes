package pe.com.rsolutionsit.controlpracticantes.common.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base class for every persistent entity.
 *
 * <p>This class centralizes:
 * <p>
 * * UUID identifiers.
 * * Creation audit.
 * * Update audit.
 * * Soft delete metadata.
 *
 * @author Raul Sosa
 * @since 1.0.0
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    protected UUID id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    protected LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    protected UUID createdBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected UUID updatedBy;

    @Column(name = "deleted_at")
    protected LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    protected UUID deletedBy;

    /**
     * Returns the entity identifier.
     *
     * @return entity identifier.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Returns the creation timestamp.
     *
     * @return creation timestamp.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Returns the last update timestamp.
     *
     * @return last update timestamp.
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Returns the creation user.
     *
     * @return creator identifier.
     */
    public UUID getCreatedBy() {
        return createdBy;
    }

    /**
     * Returns the last update user.
     *
     * @return updater identifier.
     */
    public UUID getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Returns the deletion timestamp.
     *
     * @return deletion timestamp.
     */
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    /**
     * Returns the deletion user.
     *
     * @return deletion user.
     */
    public UUID getDeletedBy() {
        return deletedBy;
    }

    /**
     * Marks the entity as logically deleted.
     *
     * @param userId user performing the deletion.
     */
    public void markAsDeleted(UUID userId) {

        this.deletedAt = LocalDateTime.now();

        this.deletedBy = userId;
    }

    /**
     * Returns whether the entity is logically deleted.
     *
     * @return {@code true} if deleted.
     */
    public boolean isDeleted() {

        return deletedAt != null;
    }
}
