package pe.com.rsolutionsit.controlpracticantes.modules.user.infrastructure.persistence;

import jakarta.persistence.*;
import pe.com.rsolutionsit.controlpracticantes.common.persistence.BaseEntity;

/**
 * Entidad persistente del usuario.
 * <p>
 * Se encarga únicamente de la representación en la base de datos.
 */

@Entity
@Table(name = "usuarios")
public class UsuarioEntity extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 120)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleCode roleCode;

    @Column(nullable = false)
    private boolean active;

    public UsuarioEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleCode getRole() {
        return roleCode;
    }

    public void setRole(RoleCode roleCode) {
        this.roleCode = roleCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
