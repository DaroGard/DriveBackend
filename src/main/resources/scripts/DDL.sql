CREATE TABLE tbl_estados_archivo (
    id_estado   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    tipo_estado VARCHAR2(50) NOT NULL
);

CREATE TABLE tbl_genero (
    id_genero   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    tipo_genero VARCHAR2(1) NOT NULL
);

CREATE TABLE tbl_ofertas (
    id_oferta          INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descuento          NUMBER(10,2) NOT NULL,
    fecha_vencimiento  DATE NOT NULL,
    estado             VARCHAR2(5) NOT NULL
);

CREATE TABLE tbl_permisos (
    id_permiso       INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nombre_permiso   VARCHAR2(50)
);

CREATE TABLE tbl_tipos_archivos ( 
    id_tipo_archivo INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    tipo_archivo    VARCHAR2(50) NOT NULL
);

CREATE TABLE tbl_tipos_lugares (
    id_tipo_lugar INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    tipo_lugar   VARCHAR2(50) NOT NULL
);

CREATE TABLE tbl_preferencias (
    id_preferencia INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    preferencia    VARCHAR2(50)
);

CREATE TABLE tbl_estados_carpeta (
    id_estado  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    estado     VARCHAR2(5) NOT NULL
);

CREATE TABLE tbl_metodos_pago (
    id_metodo_pago INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    metodo_pago    VARCHAR2(50)
);

CREATE TABLE tbl_grupos (
    id_grupo INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nombre_grupo VARCHAR2(50),
    descripcion  VARCHAR2(250),
    fecha_creacion DATE NOT NULL
);

CREATE TABLE tbl_etiquetas (
    id_etiqueta     INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nombre_etiqueta VARCHAR2(50) NOT NULL,
    color           VARCHAR2(20),
    CONSTRAINT tbl_etiquetas_un UNIQUE (nombre_etiqueta)
);

CREATE TABLE tbl_configuracion_aplicacion (
    id_configuracion    INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nombre              VARCHAR2(50) NOT NULL,
    valor               VARCHAR2(100) NOT NULL
);

CREATE TABLE tbl_eventos_sincronizacion (
    id_evento           INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    tipo_evento         VARCHAR2(50) NOT NULL,
    fecha               TIMESTAMP NOT NULL,
    resultado           VARCHAR2(100),
    CONSTRAINT ck_tipo_evento CHECK (tipo_evento IN ('INICIO', 'FIN', 'ERROR'))
);

CREATE TABLE tbl_planes (
    id_plan                   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_oferta                 INTEGER NOT NULL,
    nombre_plan               VARCHAR2(50) NOT NULL,
    almacenamiento            INTEGER NOT NULL,
    precio                    NUMBER(10,2) NOT NULL,
    descripcion               VARCHAR2(250),
    CONSTRAINT tbl_planes_ofertas_fk FOREIGN KEY (id_oferta)
        REFERENCES tbl_ofertas (id_oferta)
);

CREATE TABLE tbl_lugares (
    id_lugar       INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_lugar_padre INTEGER,
    id_tipo_lugar  INTEGER NOT NULL,
    nombre_lugar   VARCHAR2(50) NOT NULL,
    CONSTRAINT tbl_lugares_lugares_fk FOREIGN KEY (id_lugar_padre)
        REFERENCES tbl_lugares (id_lugar),
    CONSTRAINT tbl_lugares_tipos_lugares_fk FOREIGN KEY (id_tipo_lugar)
        REFERENCES tbl_tipos_lugares (id_tipo_lugar)
);

CREATE TABLE tbl_usuarios (
    id_usuario        INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_genero         INTEGER,
    id_lugar          INTEGER,
    id_preferencia    INTEGER,
    nombre            VARCHAR2(50) NOT NULL,
    apellido          VARCHAR2(50) NOT NULL,
    correo            VARCHAR2(100) NOT NULL,
    contrasena        VARCHAR2(30) NOT NULL,
    telefono          VARCHAR2(20),
    imagen            VARCHAR2(100),
    CONSTRAINT tbl_usuarios_genero_fk FOREIGN KEY (id_genero)
        REFERENCES tbl_genero (id_genero),
    CONSTRAINT tbl_usuarios_lugar_fk FOREIGN KEY (id_lugar)
        REFERENCES tbl_lugares (id_lugar),
    CONSTRAINT tbl_usuarios_preferencia_fk FOREIGN KEY (id_preferencia)
        REFERENCES tbl_preferencias (id_preferencia),
    CONSTRAINT tbl_usuarios_un UNIQUE (correo)
);

CREATE TABLE tbl_facturacion_planes (
    id_facturacion    INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_tarjeta        INTEGER NOT NULL,
    id_plan           INTEGER NOT NULL,
    fecha             DATE,
    CONSTRAINT tbl_facturacion_planes_planes_fk FOREIGN KEY (id_plan)
        REFERENCES tbl_planes (id_plan),
    CONSTRAINT tbl_facturacion_planes_tarjetas_fk FOREIGN KEY (id_tarjeta)
        REFERENCES tbl_tarjetas (id_tarjeta)
);

CREATE TABLE tbl_tarjetas (
    id_tarjeta                INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_metodo_pago            INTEGER NOT NULL,
    id_usuario                INTEGER NOT NULL,
    numero_tarjeta            VARCHAR2(16) NOT NULL,
    fecha_vencimiento         DATE NOT NULL,
    codigo_postal             VARCHAR2(3) NOT NULL,
    codigo_seguridad          VARCHAR2(3) NOT NULL,
    CONSTRAINT tbl_tarjetas_usuarios_fk FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario)
);

CREATE TABLE tbl_archivos (
    id_archivo            INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario            INTEGER NOT NULL,
    id_tipo_archivo       INTEGER NOT NULL,
    id_estado             INTEGER NOT NULL,
    id_carpeta            INTEGER,
    tamano                INTEGER NOT NULL,
    nombre                VARCHAR2(50) NOT NULL,
    fecha_creacion        DATE NOT NULL,
    fecha_utilizacion     DATE NOT NULL,
    descripcion           VARCHAR2(200),
    CONSTRAINT tbl_archivos_usuarios_fk FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT tbl_archivos_tipos_fk FOREIGN KEY (id_tipo_archivo)
        REFERENCES tbl_tipos_archivos (id_tipo_archivo),
    CONSTRAINT tbl_archivos_estados_fk FOREIGN KEY (id_estado)
        REFERENCES tbl_estados_archivo (id_estado)
);

CREATE TABLE tbl_compartidos (
    id_compartido               INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_archivo                  INTEGER NOT NULL,
    id_permiso                  INTEGER NOT NULL,
    id_usuario_propietario      INTEGER NOT NULL,
    id_usuario_compartido       INTEGER NOT NULL,
    fecha_compartido            DATE NOT NULL,
    ultima_modificacion         DATE,
    CONSTRAINT tbl_compartidos_archivos_fk FOREIGN KEY (id_archivo)
        REFERENCES tbl_archivos (id_archivo),
    CONSTRAINT tbl_compartidos_permisos_fk FOREIGN KEY (id_permiso)
        REFERENCES tbl_permisos (id_permiso),
    CONSTRAINT tbl_compartidos_usuarios_fk1 FOREIGN KEY (id_usuario_propietario)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT tbl_compartidos_usuarios_fk2 FOREIGN KEY (id_usuario_compartido)
        REFERENCES tbl_usuarios (id_usuario)
);

CREATE TABLE tbl_computadoras (
    id_computadora        INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario            INTEGER NOT NULL,
    nombre_computadora    VARCHAR2(50),
    CONSTRAINT fk_usuario_computadora FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario)
);

CREATE TABLE tbl_carpetas (
    id_carpeta        INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_carpeta_padre  INTEGER,
    id_estado         INTEGER NOT NULL,
    nombre_carpeta    VARCHAR2(50),
    CONSTRAINT fk_estado_carpetas FOREIGN KEY (id_estado)
        REFERENCES tbl_estados_carpeta (id_estado),
    CONSTRAINT fk_carpeta_padre FOREIGN KEY (id_carpeta_padre)
        REFERENCES tbl_carpetas (id_carpeta)
);

CREATE TABLE tbl_favoritos (
    id_favorito     INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario      INTEGER NOT NULL,
    id_archivo      INTEGER NOT NULL,
    fecha_agregado  DATE NOT NULL,
    CONSTRAINT fk_usuario_favoritos FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT fk_archivo_favoritos FOREIGN KEY (id_archivo)
        REFERENCES tbl_archivos (id_archivo)
);

CREATE TABLE tbl_usuarios_grupo (
    id_administrador  INTEGER NOT NULL,
    id_usuario        INTEGER NOT NULL,
    id_archivo        INTEGER NOT NULL,
    id_grupo          INTEGER NOT NULL,
    CONSTRAINT fk_administrador FOREIGN KEY (id_administrador)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT fk_archivo FOREIGN KEY (id_archivo)
        REFERENCES tbl_archivos (id_archivo),
    CONSTRAINT fk_grupo FOREIGN KEY (id_grupo)
        REFERENCES tbl_grupos (id_grupo)
);

CREATE TABLE tbl_actividades_usuario (
    id_actividad    INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario      INTEGER NOT NULL,
    tipo_actividad  VARCHAR2(50) NOT NULL,
    id_archivo      INTEGER,
    id_carpeta      INTEGER,
    fecha           DATE NOT NULL,
    CONSTRAINT tbl_actividades_usuario_usuarios_fk FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT tbl_actividades_usuario_archivos_fk FOREIGN KEY (id_archivo)
        REFERENCES tbl_archivos (id_archivo),
    CONSTRAINT tbl_actividades_usuario_carpetas_fk FOREIGN KEY (id_carpeta)
        REFERENCES tbl_carpetas (id_carpeta)
);

CREATE TABLE tbl_comentarios (
    id_comentario   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario      INTEGER NOT NULL,
    id_archivo      INTEGER,
    id_carpeta      INTEGER,
    texto_comentario VARCHAR2(500) NOT NULL,
    fecha           DATE NOT NULL,
    CONSTRAINT tbl_comentarios_usuarios_fk FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT tbl_comentarios_archivos_fk FOREIGN KEY (id_archivo)
        REFERENCES tbl_archivos (id_archivo),
    CONSTRAINT tbl_comentarios_carpetas_fk FOREIGN KEY (id_carpeta)
        REFERENCES tbl_carpetas (id_carpeta)
);

CREATE TABLE tbl_notificaciones (
    id_notificacion INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario_destino INTEGER NOT NULL,
    mensaje         VARCHAR2(500) NOT NULL,
    fecha           DATE NOT NULL,
    leido           BOOLEAN DEFAULT FALSE,
    CONSTRAINT tbl_notificaciones_usuarios_fk FOREIGN KEY (id_usuario_destino)
        REFERENCES tbl_usuarios (id_usuario)
);

CREATE TABLE tbl_versiones_archivos (
    id_version          INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_archivo          INTEGER NOT NULL,
    nombre_archivo      VARCHAR2(100) NOT NULL,
    ruta_archivo        VARCHAR2(200) NOT NULL,
    fecha_creacion      DATE NOT NULL,
    id_usuario_creador  INTEGER NOT NULL,
    CONSTRAINT tbl_versiones_archivos_archivos_fk FOREIGN KEY (id_archivo)
        REFERENCES tbl_archivos (id_archivo),
    CONSTRAINT tbl_versiones_archivos_usuarios_fk FOREIGN KEY (id_usuario_creador)
        REFERENCES tbl_usuarios (id_usuario)
);

CREATE TABLE tbl_recuperacion_contrasena (
    id_solicitud    INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario      INTEGER NOT NULL,
    token           VARCHAR2(100) NOT NULL,
    fecha_solicitud DATE NOT NULL,
    utilizado       BOOLEAN DEFAULT FALSE,
    CONSTRAINT tbl_recuperacion_contrasena_usuarios_fk FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario)
);

CREATE TABLE tbl_archivos_eliminados (
    id_archivo_eliminado INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario           INTEGER NOT NULL,
    id_archivo           INTEGER NOT NULL,
    fecha_eliminacion    DATE NOT NULL,
    CONSTRAINT fk_usuario_archivo_eliminado FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT fk_archivo_archivo_eliminado FOREIGN KEY (id_archivo)
        REFERENCES tbl_archivos (id_archivo)
);

CREATE TABLE tbl_actividades_usuario (
    id_actividad    INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario      INTEGER NOT NULL,
    tipo_actividad  VARCHAR2(50) NOT NULL,
    id_archivo      INTEGER,
    id_carpeta      INTEGER,
    fecha           DATE NOT NULL,
    CONSTRAINT fk_usuario_actividad FOREIGN KEY (id_usuario)
        REFERENCES tbl_usuarios (id_usuario),
    CONSTRAINT fk_archivo_actividad FOREIGN KEY (id_archivo)
        REFERENCES tbl_archivos (id_archivo),
    CONSTRAINT fk_carpeta_actividad FOREIGN KEY (id_carpeta)
        REFERENCES tbl_carpetas (id_carpeta)
);