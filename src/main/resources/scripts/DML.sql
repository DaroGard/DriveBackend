-- Inserciones en tbl_permisos
INSERT INTO tbl_permisos (nombre_permiso) VALUES ('lectura');
INSERT INTO tbl_permisos (nombre_permiso) VALUES ('escritura');
INSERT INTO tbl_permisos (nombre_permiso) VALUES ('comentario');

-- Inserciones en tbl_tipos_archivos
INSERT INTO tbl_tipos_archivos (tipo_archivo) VALUES ('.pdf');
INSERT INTO tbl_tipos_archivos (tipo_archivo) VALUES ('.png');
INSERT INTO tbl_tipos_archivos (tipo_archivo) VALUES ('.docx');
INSERT INTO tbl_tipos_archivos (tipo_archivo) VALUES ('.jpeg');
INSERT INTO tbl_tipos_archivos (tipo_archivo) VALUES ('.xlsx');
INSERT INTO tbl_tipos_archivos (tipo_archivo) VALUES ('.mp3');
INSERT INTO tbl_tipos_archivos (tipo_archivo) VALUES ('.mp4');
INSERT INTO tbl_tipos_archivos (tipo_archivo) VALUES ('.txt');

-- Inserciones en tbl_estados_archivo
INSERT INTO tbl_estados_archivo (tipo_estado) VALUES ('activo');
INSERT INTO tbl_estados_archivo (tipo_estado) VALUES ('en papelera');

-- Inserciones en tbl_estados_carpeta
INSERT INTO tbl_estados_carpeta (estado) VALUES ('activo');
INSERT INTO tbl_estados_carpeta (estado) VALUES ('en papelera');
INSERT INTO tbl_estados_carpeta (estado) VALUES ('destacado');

-- Inserciones en tbl_genero
INSERT INTO tbl_genero (tipo_genero) VALUES ('F');
INSERT INTO tbl_genero (tipo_genero) VALUES ('M');

-- Inserciones en tbl_tipos_lugares
INSERT INTO tbl_tipos_lugares (tipo_lugar) VALUES ('ciudad');
INSERT INTO tbl_tipos_lugares (tipo_lugar) VALUES ('departamento');
INSERT INTO tbl_tipos_lugares (tipo_lugar) VALUES ('pais');
INSERT INTO tbl_tipos_lugares (tipo_lugar) VALUES ('estado');

-- Inserts en tbl_ofertas
INSERT INTO tbl_ofertas (descuento, fecha_vencimiento, estado) VALUES (10.50, '2024-05-15', 'activo');
INSERT INTO tbl_ofertas (descuento, fecha_vencimiento, estado) VALUES (20.00, '2024-06-30', 'inactivo');
INSERT INTO tbl_ofertas (descuento, fecha_vencimiento, estado) VALUES (15.75, '2024-07-10', 'activo');

-- Inserts en tbl_preferencias
INSERT INTO tbl_preferencias (preferencia) VALUES ('Publico');
INSERT INTO tbl_preferencias (preferencia) VALUES ('Privado');
INSERT INTO tbl_preferencias (preferencia) VALUES ('Solo Amigos');

-- Inserts en tbl_metodos_pago
INSERT INTO tbl_metodos_pago (metodo_pago) VALUES ('Tarjeta de crédito');
INSERT INTO tbl_metodos_pago (metodo_pago) VALUES ('Tarjeta de débito');
INSERT INTO tbl_metodos_pago (metodo_pago) VALUES ('PayPal');

-- Inserts en tbl_planes
INSERT INTO tbl_planes (id_oferta, nombre_plan, almacenamiento, precio, descripcion) VALUES (1, 'Plan Básico', 10, 5.99, 'Plan con almacenamiento básico');
INSERT INTO tbl_planes (id_oferta, nombre_plan, almacenamiento, precio, descripcion) VALUES (2, 'Plan Estándar', 50, 9.99, 'Plan con almacenamiento estándar');
INSERT INTO tbl_planes (id_oferta, nombre_plan, almacenamiento, precio, descripcion) VALUES (3, 'Plan Premium', 100, 14.99, 'Plan con almacenamiento premium');


-- Inserts en tbl_lugares
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 1, 'Ciudad de México');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (1, 2, 'Cuauhtémoc');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (1, 2, 'Miguel Hidalgo');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Estados Unidos');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (5, 4, 'California');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (5, 4, 'Nueva York');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 1, 'Madrid');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (7, 2, 'Centro');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (7, 2, 'Salamanca');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Reino Unido');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (10, 4, 'Inglaterra');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (10, 4, 'Escocia');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 1, 'Tokio');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (13, 2, 'Shinjuku');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (13, 2, 'Shibuya');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Costa Rica');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (17, 4, 'San José');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (17, 4, 'Heredia');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Guatemala');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (21, 4, 'Guatemala');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (21, 4, 'Quetzaltenango');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'El Salvador');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (24, 4, 'San Salvador');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (24, 4, 'Santa Ana');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Honduras');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (27, 4, 'Tegucigalpa');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (27, 4, 'San Pedro Sula');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Nicaragua');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (31, 4, 'Managua');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (31, 4, 'León');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Belice');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (35, 4, 'Belmopan');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (35, 4, 'San Ignacio');

-- Inserts en tbl_etiquetas
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Trabajo', 'Azul');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Personal', 'Verde');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Urgente', 'Rojo');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Proyecto A', 'Naranja');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Proyecto B', 'Morado');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Personal', 'Amarillo');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Trabajo Remoto', 'Gris');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Importante', 'Rojo');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Tareas Pendientes', 'Verde');
INSERT INTO tbl_etiquetas (nombre_etiqueta, color) VALUES ('Reuniones', 'Azul');

-- Inserts en tbl_configuracion_aplicacion
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('MaxIntentos', '5');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('FormatoFecha', 'dd-MM-yyyy');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('SimboloMoneda', '€');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('Idioma', 'es_ES');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('MostrarNotificaciones', 'true');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('ModoOscuro', 'false');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('ZonaHoraria', 'UTC');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('TamañoFuentePredeterminado', '14');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('ActivarRegistro', 'true');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('PermitirAccesoInvitados', 'false');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('NotificacionesCorreoElectronico', 'true');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('FormatoHora', 'HH:mm:ss');
INSERT INTO tbl_configuracion_aplicacion (nombre, valor) VALUES ('ConfiguracionRegional', 'es_ES');
