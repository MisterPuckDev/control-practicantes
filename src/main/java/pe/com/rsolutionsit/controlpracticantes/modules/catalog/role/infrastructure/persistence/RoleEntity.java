package pe.com.rsolutionsit.controlpracticantes.modules.catalog.role.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import pe.com.rsolutionsit.controlpracticantes.common.persistence.BaseEntity;
import pe.com.rsolutionsit.controlpracticantes.common.security.authorization.RoleCode;

/**
 * Persistent role entity.
 *
 * @author MisterPuckDev
 * @since 0.2.0
 */
@Entity
@Table(name = "roles")
@SQLDelete(sql = """
    UPDATE roles
    SET deleted_at=CURRENT_TIMESTAMP
    WHERE id=?
    """)
@SQLRestriction("deleted_at IS NULL")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 30)
    private RoleCode code;

    @Column(nullable = false, length = 100)
    private String name;

    public RoleEntity() {
    }

    public RoleCode getCode() {
        return code;
    }

    public void setCode(RoleCode code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
