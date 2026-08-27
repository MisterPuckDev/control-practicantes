CREATE TABLE users
(

    id         UUID PRIMARY KEY,

    username   VARCHAR(50)  NOT NULL UNIQUE,

    full_name  VARCHAR(120) NOT NULL,

    email      VARCHAR(150) NOT NULL UNIQUE,

    password   VARCHAR(255) NOT NULL,

    role_id    UUID         NOT NULL,

    active     BOOLEAN      NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    deleted_at TIMESTAMP,

    created_by UUID,

    updated_by UUID,

    deleted_by UUID,

    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
            REFERENCES roles (id)

);

CREATE INDEX idx_users_username_active
    ON users (username)
    WHERE deleted_at IS NULL;
