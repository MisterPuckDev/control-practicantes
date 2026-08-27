CREATE TABLE roles
(

    id         UUID PRIMARY KEY,

    code       VARCHAR(30)  NOT NULL UNIQUE,

    name       VARCHAR(100) NOT NULL,

    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    deleted_at TIMESTAMP,

    created_by UUID,

    updated_by UUID,

    deleted_by UUID

);
