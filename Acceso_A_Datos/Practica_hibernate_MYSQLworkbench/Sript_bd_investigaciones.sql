
USE investigaciones;
CREATE TABLE EDUCACION (
    ED_ID INT PRIMARY KEY,
    UNI_ID INT,
    ED_GRADO VARCHAR(255),
    ED_CAMPO VARCHAR(255),
    ED_DESCRIPCION TEXT,
    INV_ID INT,
    FOREIGN KEY (INV_ID) REFERENCES INVESTIGADOR(INV_ID)
);


CREATE TABLE INVESTIGADOR (
    INV_ID INT PRIMARY KEY,
    INV_NOMBRE VARCHAR(255),
    INV_EXTENSION INT,
	INV_EMAIL INT,
	INV_SNI INT,
	INV_PRODEP INT,
	INV_CATEGORIA INT,
	INV_CUBICULO INT,
    INV_DESCRIPCION TEXT

    
);

-- Creación de la tabla TESIS_REDACTADAS
CREATE TABLE TESIS_REDACTADAS (
    TESIS_ID INT PRIMARY KEY,
    TESIS_NOMBRE VARCHAR(255),
    TESIS_DESCRIPCION TEXT,
    INV_ID INT,
    FOREIGN KEY (INV_ID) REFERENCES INVESTIGADOR(INV_ID)
    -- Aquí podrían ir más atributos según la necesidad
);

-- Creación de la tabla EXPERIENCIA_LABORAL
CREATE TABLE EXPERIENCIA_LABORAL (
    EL_ID INT PRIMARY KEY,
    EL_INSTITUTO VARCHAR(255),
    EL_PERIODO VARCHAR(255),
    EL_DESCRIPCION TEXT,
    INV_ID INT,
    FOREIGN KEY (INV_ID) REFERENCES INVESTIGADOR(INV_ID)
    
);

-- Creación de la tabla TRABAJOS_GRADO_DIRIGIDOS
CREATE TABLE TRABAJOS_GRADO_DIRIGIDOS (
    TG_ID INT PRIMARY KEY,
    TG_NOMBRE VARCHAR(255),
    TG_ALUMNO VARCHAR(255),
	TG_NIVEL VARCHAR(255),
	TG_TIPO VARCHAR(255),
    INV_ID INT,
    FOREIGN KEY (INV_ID) REFERENCES INVESTIGADOR(INV_ID)
    
);
