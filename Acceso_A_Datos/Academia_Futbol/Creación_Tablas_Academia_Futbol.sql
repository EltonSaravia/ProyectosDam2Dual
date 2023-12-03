-- Creación de tablas Entidades 
CREATE TABLE Jugador (
    id_jugador INTEGER PRIMARY KEY,
    nombre TEXT,
    categoria TEXT,
    edad INTEGER,
    dorsal INTEGER,
    posicion TEXT,
    partidos_jugados INTEGER,
    min_acumulados INTEGER,
    amarillas INTEGER,
    rojas INTEGER,
    lesionado BOOLEAN,
    partidos_sancionado INTEGER
     FOREIGN KEY (categoria) REFERENCES Equipo(categoria);
);

CREATE TABLE Directivo (
    id_directivo INTEGER PRIMARY KEY,
    cargo TEXT
);

CREATE TABLE Equipo (
    cod_equipo INTEGER PRIMARY KEY,
    estadio TEXT,
    entrenador TEXT,
categoria TEXT,
    FOREIGN KEY (entrenador) REFERENCES Entrenador(nombre)
);

CREATE TABLE Entrenador (
    id_entrenador INTEGER PRIMARY KEY,
    nombre TEXT,
	apellidos TEXT,
    partidos INTEGER,
    meses_exp INTEGER
);

CREATE TABLE Partidos (
    id_partido INTEGER PRIMARY KEY,
    equipo_local TEXT,
    equipo_visitante TEXT
);

CREATE TABLE Gol (
    id_gol INTEGER PRIMARY KEY,
    jugador TEXT,
    dorsal INTEGER,
    equipo TEXT,
    partido INTEGER,
    min INTEGER,
    FOREIGN KEY (jugador) REFERENCES Jugador(nombre),
    FOREIGN KEY (dorsal) REFERENCES Jugador(dorsal),
    FOREIGN KEY (equipo) REFERENCES Equipo(nombre),
    FOREIGN KEY (partido) REFERENCES Partidos(id_partido)
);

CREATE TABLE Lesion (
    id_lesion INTEGER PRIMARY KEY,
    fecha_inicio DATE,
    fecha_fin DATE,
    jugador TEXT,
    FOREIGN KEY (jugador) REFERENCES Jugador(nombre)
);

CREATE TABLE Tarjeta (
    id_tarjeta INTEGER PRIMARY KEY,
    roja BOOLEAN,
    amarilla BOOLEAN,
    jugador TEXT,
    FOREIGN KEY (jugador) REFERENCES Jugador(nombre)
);

-- Creación de relaciones
CREATE TABLE Trabaja (
    id_directivo INTEGER,
    id_equipo INTEGER,
    PRIMARY KEY (id_directivo, id_equipo),
    FOREIGN KEY (id_directivo) REFERENCES Directivo(id_directivo),
    FOREIGN KEY (id_equipo) REFERENCES Equipo(cod_equipo)
);

CREATE TABLE Compite (
    id_partido INTEGER,
    id_equipo INTEGER,
    fecha DATE,
    hora DATETIME,
    PRIMARY KEY (id_partido, id_equipo),
    FOREIGN KEY (id_partido) REFERENCES Partidos(id_partido),
    FOREIGN KEY (id_equipo) REFERENCES Equipo(cod_equipo)
);

CREATE TABLE Prepara (
    id_equipo INTEGER,
    id_entrenador INTEGER,
    fecha DATE,
    PRIMARY KEY (id_equipo),
    FOREIGN KEY (id_equipo) REFERENCES Equipo(cod_equipo),
    FOREIGN KEY (id_entrenador) REFERENCES Entrenador(id_entrenador)
);

CREATE TABLE Pertenece (
    id_jugador INTEGER,
    id_equipo INTEGER,
    PRIMARY KEY (id_jugador, id_equipo),
    FOREIGN KEY (id_jugador) REFERENCES Jugador(id_jugador),
    FOREIGN KEY (id_equipo) REFERENCES Equipo(cod_equipo)
);

CREATE TABLE Produce (
    id_partido INTEGER,
    id_gol INTEGER,
    fecha DATE,
    PRIMARY KEY (id_partido, id_gol),
    FOREIGN KEY (id_partido) REFERENCES Partidos(id_partido),
    FOREIGN KEY (id_gol) REFERENCES Gol(id_gol)
);

CREATE TABLE OcurrenLesiones (
    id_partido INTEGER,
    id_lesion INTEGER,
    fecha DATE,
    PRIMARY KEY (id_partido, id_lesion),
    FOREIGN KEY (id_partido) REFERENCES Partidos(id_partido),
    FOREIGN KEY (id_lesion) REFERENCES Lesion(id_lesion)
);

CREATE TABLE OcurrenTarjetas (
    id_partido INTEGER,
    id_tarjeta INTEGER,
    fecha DATE,
    PRIMARY KEY (id_partido, id_tarjeta),
    FOREIGN KEY (id_partido) REFERENCES Partidos(id_partido),
    FOREIGN KEY (id_tarjeta) REFERENCES Tarjeta(id_tarjeta)
);
