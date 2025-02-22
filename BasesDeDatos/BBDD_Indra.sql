-- Creación de la tabla USUARIO para almacenar la información de los usuarios del sistema.
CREATE TABLE USUARIO (
    ID NUMBER(8) GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Identificador único autoincremental para cada usuario.
    NOMBRE VARCHAR2(30) NOT NULL, -- Nombre del usuario (obligatorio).
    AP1 VARCHAR2(30) NOT NULL, -- Primer apellido del usuario (obligatorio).
    AP2 VARCHAR2(30) NOT NULL, -- Segundo apellido del usuario (obligatorio).
    CORREO VARCHAR2(50) NOT NULL, -- Correo electrónico del usuario (obligatorio).
    CONTRASEÑA VARCHAR2(32) NOT NULL -- Contraseña del usuario (obligatorio, longitud máxima de 32 caracteres).
);

-- Creación de la tabla TLF_USUARIO para almacenar los números de teléfono asociados a cada usuario.
CREATE TABLE TLF_USUARIO (
    ID_USUARIO NUMBER(8), -- Clave foránea que referencia al ID del usuario en la tabla USUARIO.
    TLF NUMBER(9), -- Número de teléfono del usuario (hasta 9 dígitos).
    PRIMARY KEY (ID_USUARIO, TLF), -- Clave primaria compuesta por ID_USUARIO y TLF para evitar duplicados.
    FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID) -- Relación con la tabla USUARIO.
);

-- Creación de la tabla UBICACION para almacenar las ubicaciones de los eventos.
CREATE TABLE UBICACION (
    ID NUMBER(8) GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Identificador único autoincremental para cada ubicación.
    PAIS VARCHAR2(30) NOT NULL, -- País de la ubicación (obligatorio).
    CIUDAD VARCHAR2(30) NOT NULL, -- Ciudad de la ubicación (obligatorio).
    LOCALIDAD VARCHAR2(30) NOT NULL, -- Localidad de la ubicación (obligatorio).
    CALLE VARCHAR2(30) NOT NULL, -- Calle de la ubicación (obligatorio).
    LETRA VARCHAR2(30), -- Letra del edificio o local (opcional).
    CP NUMBER(8) NOT NULL, -- Código postal de la ubicación (obligatorio).
    NUMERO NUMBER(8) -- Número del edificio o local (opcional).
);

-- Creación de la tabla CATEGORIA para almacenar las categorías de los eventos.
CREATE TABLE CATEGORIA (
    ID NUMBER(8) GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Identificador único autoincremental para cada categoría.
    NOMBRE VARCHAR2(30), -- Nombre de la categoría.
    DESCRIPCION VARCHAR2(255) -- Descripción de la categoría.
);

-- Creación de la tabla ORGANIZADOR para almacenar la información de los organizadores de eventos.
CREATE TABLE ORGANIZADOR (
    ID NUMBER(8) GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Identificador único autoincremental para cada organizador.
    RAZON_SOCIAL VARCHAR2(30) -- Razón social del organizador.
);

-- Creación de la tabla TLF_ORGANIZADOR para almacenar los números de teléfono asociados a cada organizador.
CREATE TABLE TLF_ORGANIZADOR (
    ID_ORGANIZADOR NUMBER(8), -- Clave foránea que referencia al ID del organizador en la tabla ORGANIZADOR.
    TLF NUMBER(8), -- Número de teléfono del organizador (hasta 8 dígitos).
    PRIMARY KEY (ID_ORGANIZADOR, TLF), -- Clave primaria compuesta por ID_ORGANIZADOR y TLF para evitar duplicados.
    FOREIGN KEY (ID_ORGANIZADOR) REFERENCES ORGANIZADOR(ID) -- Relación con la tabla ORGANIZADOR.
);

-- Creación de la tabla EVENTO para almacenar la información de los eventos.
CREATE TABLE EVENTO (
    ID NUMBER(8) GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Identificador único autoincremental para cada evento.
    ID_UBICACION NUMBER(8), -- Clave foránea que referencia a la ubicación del evento en la tabla UBICACION.
    NOMBRE VARCHAR2(30) NOT NULL, -- Nombre del evento (obligatorio).
    FECHA DATE NOT NULL, -- Fecha del evento (obligatorio).
    HORA_COMIENZO VARCHAR2(30) NOT NULL, -- Hora de inicio del evento (obligatorio).
    DURACION NUMBER(8), -- Duración del evento en horas (opcional).
    ESTADO BOOLEAN NOT NULL, -- Estado del evento (activo/inactivo, obligatorio).
    MODALIDAD VARCHAR2(1) CHECK (MODALIDAD IN ('O', 'P', 'A')) NOT NULL, -- Modalidad del evento (O: Online, P: Presencial, A: Ambos, obligatorio).
    TIPO VARCHAR2(1) CHECK (TIPO IN ('C', 'T', 'A')) NOT NULL, -- Tipo de evento (C: Conferencia, T: Taller, A: Actividad, obligatorio).
    ID_ORGANIZADOR NUMBER(8) NOT NULL, -- Clave foránea que referencia al organizador del evento en la tabla ORGANIZADOR.
    ID_CATEGORIA NUMBER(8) NOT NULL, -- Clave foránea que referencia a la categoría del evento en la tabla CATEGORIA.
    FOREIGN KEY (ID_UBICACION) REFERENCES UBICACION(ID), -- Relación con la tabla UBICACION.
    FOREIGN KEY (ID_ORGANIZADOR) REFERENCES ORGANIZADOR(ID), -- Relación con la tabla ORGANIZADOR.
    FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID) -- Relación con la tabla CATEGORIA.
);

-- Creación de la tabla INSCRIPCION para almacenar las inscripciones de usuarios a eventos.
CREATE TABLE INSCRIPCION (
    ID_USUARIO NUMBER(8), -- Clave foránea que referencia al ID del usuario en la tabla USUARIO.
    ID_EVENTO NUMBER(8), -- Clave foránea que referencia al ID del evento en la tabla EVENTO.
    FECHA_INSCRIPCION DATE NOT NULL, -- Fecha en la que el usuario se inscribió al evento (obligatorio).
    PRIMARY KEY (ID_USUARIO, ID_EVENTO), -- Clave primaria compuesta por ID_USUARIO y ID_EVENTO para evitar duplicados.
    FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID), -- Relación con la tabla USUARIO.
    FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO(ID) -- Relación con la tabla EVENTO.
);