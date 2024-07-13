CREATE TABLE topico (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL ,
    documento VARCHAR(20) NOT NULL ,
    telefono varchar(20) not null
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(2000) NOT NULL,
    status VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

);