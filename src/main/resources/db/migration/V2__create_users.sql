CREATE TABLE control_practicantes.users(

                                           id UUID PRIMARY KEY,

                                           username VARCHAR(50) UNIQUE NOT NULL,

                                           full_name VARCHAR(120) NOT NULL,

                                           email VARCHAR(150) UNIQUE NOT NULL,

                                           password VARCHAR(255) NOT NULL,

                                           role_id UUID NOT NULL,

                                           active BOOLEAN NOT NULL DEFAULT TRUE,

                                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                           updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                           deleted_at TIMESTAMP,

                                           CONSTRAINT fk_user_role
                                               FOREIGN KEY(role_id)
                                                   REFERENCES control_practicantes.roles(id)

);
