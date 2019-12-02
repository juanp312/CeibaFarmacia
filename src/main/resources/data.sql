create table MEDICAMENTO
(
    ID INTEGER not null AUTO_INCREMENT,
    NOMBRE VARCHAR(255) not null,
    CODIGO VARCHAR(255) not null,
    DISPONIBILIDAD BOOLEAN not null,
    primary key(ID)
);


INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (10000, 'aaaNombre', 'aaaCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (10001, 'aaaNombre', 'aaaCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (10002, 'aaaNombre', 'aaaCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (10003, 'aaaNombre', 'aaaCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (10004, 'aaaNombre', 'aaaCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (10005, 'aaaNombre', 'aaaCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (10006, 'aaaNombre', 'aaaCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (10007, 'aaaNombre', 'aaaCodigo', true);

INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (20000, 'bbbNombre', 'bbbCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (20001, 'bbbNombre', 'bbbCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (20002, 'bbbNombre', 'bbbCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (20003, 'bbbNombre', 'bbbCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (20004, 'bbbNombre', 'bbbCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (20005, 'bbbNombre', 'bbbCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (20006, 'bbbNombre', 'bbbCodigo', true);
INSERT INTO MEDICAMENTO (ID, NOMBRE, CODIGO, DISPONIBILIDAD ) VALUES (20007, 'bbbNombre', 'bbbCodigo', true);


CREATE TABLE COMPRA
(
    ID INTEGER not null AUTO_INCREMENT,
    CODIGO_MEDICAMENTO VARCHAR(255) not null,
    NUMERO_IDENTIDAD INTEGER not null,
    MEDIO_PAGO VARCHAR(255) not null,
    RECETA BOOLEAN not null,
    CANTIDAD INTEGER not null,
    primary key (ID)
);

CREATE TABLE USUARIO
(
    NUMERO_IDENTIDAD INTEGER not null AUTO_INCREMENT,
    NOMBRE VARCHAR(255) not null,
    EDAD INTEGER not null,
    primary key (NUMERO_IDENTIDAD)
);

INSERT INTO USUARIO (NUMERO_IDENTIDAD, NOMBRE, EDAD ) VALUES (2, 'JUAN', 20);