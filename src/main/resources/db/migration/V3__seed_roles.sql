INSERT INTO control_practicantes.roles (
    id,
    code,
    description
)
VALUES
    (gen_random_uuid(),'ADMIN','Administrador del sistema'),
    (gen_random_uuid(),'RRHH','Recursos Humanos'),
    (gen_random_uuid(),'SUPERVISOR','Supervisor'),
    (gen_random_uuid(),'PRACTICANTE','Practicante');
