CREATE TABLE control_practicantes.roles(

                                           id UUID PRIMARY KEY,

                                           code VARCHAR(30) UNIQUE NOT NULL,

                                           name VARCHAR(100) NOT NULL,

                                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                           updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                           deleted_at TIMESTAMP

);
