CREATE TABLE usuarios (
    id BIGSERIAL NOT NULL,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(300) NOT NULL,
    activo BOOLEAN DEFAULT true,

    PRIMARY KEY (id)
);