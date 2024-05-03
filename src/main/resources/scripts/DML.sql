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
INSERT INTO tbl_ofertas (descuento, fecha_vencimiento, estado) VALUES (10.50, TO_DATE('15-05-2024', 'DD-MM-YYYY'), 'activo');
INSERT INTO tbl_ofertas (descuento, fecha_vencimiento, estado) VALUES (20.00, TO_DATE('30-06-2024', 'DD-MM-YYYY'), 'inactivo');
INSERT INTO tbl_ofertas (descuento, fecha_vencimiento, estado) VALUES (15.75, TO_DATE('10-07-2024', 'DD-MM-YYYY'), 'activo');

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
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Estados Unidos');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Reino Unido');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Costa Rica');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Guatemala');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'El Salvador');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Honduras');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Nicaragua');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES (NULL, 3, 'Belice');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Estados Unidos' AND id_tipo_lugar = 3), 1, 'Nueva York');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Estados Unidos' AND id_tipo_lugar = 3), 1, 'Los Ángeles');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Estados Unidos' AND id_tipo_lugar = 3), 1, 'Chicago');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Reino Unido' AND id_tipo_lugar = 3), 1, 'Londres');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Reino Unido' AND id_tipo_lugar = 3), 1, 'Manchester');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Reino Unido' AND id_tipo_lugar = 3), 1, 'Edimburgo');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Costa Rica' AND id_tipo_lugar = 3), 1, 'San José');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Costa Rica' AND id_tipo_lugar = 3), 1, 'Heredia');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Costa Rica' AND id_tipo_lugar = 3), 1, 'Alajuela');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Guatemala' AND id_tipo_lugar = 3), 1, 'Ciudad de Guatemala');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Guatemala' AND id_tipo_lugar = 3), 1, 'Quetzaltenango');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Guatemala' AND id_tipo_lugar = 3), 1, 'Escuintla');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'El Salvador' AND id_tipo_lugar = 3), 1, 'San Salvador');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'El Salvador' AND id_tipo_lugar = 3), 1, 'Santa Ana');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'El Salvador' AND id_tipo_lugar = 3), 1, 'San Miguel');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Honduras' AND id_tipo_lugar = 3), 1, 'Tegucigalpa');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Honduras' AND id_tipo_lugar = 3), 1, 'San Pedro Sula');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Honduras' AND id_tipo_lugar = 3), 1, 'La Ceiba');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Nicaragua' AND id_tipo_lugar = 3), 1, 'Managua');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Nicaragua' AND id_tipo_lugar = 3), 1, 'León');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Nicaragua' AND id_tipo_lugar = 3), 1, 'Granada');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Belice' AND id_tipo_lugar = 3), 1, 'Belmopan');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Belice' AND id_tipo_lugar = 3), 1, 'San Ignacio');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Belice' AND id_tipo_lugar = 3), 1, 'Dangriga');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Estados Unidos' AND id_tipo_lugar = 3), 4, 'California');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Estados Unidos' AND id_tipo_lugar = 3), 4, 'Nueva York');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Estados Unidos' AND id_tipo_lugar = 3), 4, 'Texas');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Reino Unido' AND id_tipo_lugar = 3), 4, 'Inglaterra');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Reino Unido' AND id_tipo_lugar = 3), 4, 'Escocia');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Reino Unido' AND id_tipo_lugar = 3), 4, 'Gales');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Costa Rica' AND id_tipo_lugar = 3), 4, 'San José');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Costa Rica' AND id_tipo_lugar = 3), 4, 'Alajuela');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Costa Rica' AND id_tipo_lugar = 3), 4, 'Guanacaste');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Guatemala' AND id_tipo_lugar = 3), 4, 'Guatemala');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Guatemala' AND id_tipo_lugar = 3), 4, 'Quetzaltenango');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Guatemala' AND id_tipo_lugar = 3), 4, 'Peten');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'El Salvador' AND id_tipo_lugar = 3), 2, 'San Salvador');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'El Salvador' AND id_tipo_lugar = 3), 2, 'Santa Ana');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'El Salvador' AND id_tipo_lugar = 3), 2, 'La Libertad');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Honduras' AND id_tipo_lugar = 3), 2, 'Francisco Morazán');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Honduras' AND id_tipo_lugar = 3), 2, 'Cortés');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Honduras' AND id_tipo_lugar = 3), 4, 'Atlántida');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Nicaragua' AND id_tipo_lugar = 3), 4, 'Managua');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Nicaragua' AND id_tipo_lugar = 3), 4, 'León');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Nicaragua' AND id_tipo_lugar = 3), 4, 'Chinandega');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Belice' AND id_tipo_lugar = 3), 4, 'Belice');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Belice' AND id_tipo_lugar = 3), 4, 'Cayo');
INSERT INTO tbl_lugares (id_lugar_padre, id_tipo_lugar, nombre_lugar) VALUES ((SELECT id_lugar FROM tbl_lugares WHERE nombre_lugar = 'Belice' AND id_tipo_lugar = 3), 4, 'Orange Walk');

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


COMMIT;