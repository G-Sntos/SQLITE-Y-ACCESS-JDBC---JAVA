# SQLITE-Y-ACCESS-JDBC---JAVA


Ejercicio 1.- SQLITE
REALIZA UN PROGRAMA EN JAVA QUE CONECTE CON UNA BASE DE DATOS SQLITE
MEDIANTE UN CONECTOR JDBC. LA BASE DE DATOS SERÁ LA SIGUIENTE

TABLE libro(
ISBN INT(10) PRIMARY KEY,
titulo CHAR(30) NOT NULL,
autor CHAR(30),
númejemplares INT(2),
anyopublicacion INT(10),
editorial CHAR(30),
numpag INT(4));
TABLE socio(
numsocio INT(5) PRIMARY KEY,
nombre CHAR(15) NOT NULL,
apellidos CHAR(15) NOT NULL,
telefono CHAR(10),
edad INT(5),
falta DATE);
TABLE prestamo(
libro INT(10) NOT NULL,
socio INT(5) NOT NULL,
fprestamo DATE NOT NULL,
fdevolucion DATE,
PRIMARY KEY (libro,socio,fprestamo),
FOREIGN KEY (libro) REFERENCES libro,
FOREIGN KEY (socio) REFERENCES socio);

Y EL PROGRAMA JAVA TENDRA UN MENÚ CON LA OPCIÓN “INSERTAR DATOS” DONDE
NOS PERMITIRÁ HACER INSERCIONES DE DATOS EN LAS 3 TABLAS.-

- INSERTAR LIBRO.
- INSERTAR SOCIO.
- INSERTAR PRESTAMO.
OTRA OPCIÓN DEL MENÚ “LISTADO DATOS” DONDE NOS FACILITARÁ INFORMACIÓN
SOBRE.-
- LISTADO DE LIBROS.
- LISTADO DE SOCIOS.
- LISTADO DE PRÉSTAMOS.
Y OTRA OPCIÓN DEL MENÚ “ELIMINACIÓN DATOS” DONDE PODREMOS.-
- ELIMINAR LIBRO
- ELIMINAR SOCIO
TENDREMOS QUE HACER ADEMÁS UNA GESTIÓN DE ERRORES AL INTRODUCIR DATOS,
OSEA EVITAR QUE SALGAN EXCEPCIONES.
Ejercicio 2.- ACCESS
REALIZA UN PROGRAMA EN JAVA QUE CONECTE CON UNA BASE DE DATOS ACCESS Y
REALICE LA MISMA ACTIVIDAD DEL EJERCICIO 1. CREAREMOS LAS TABLAS EN ACCESS Y
CON EL PROGRAMA JAVA GESTIONAREMOS DICHA BASE DE DATOS.
EN LAS CORRECCIONES EL CONECTOR DE ACCESS SE LLAMARÁ “BBDD-ACCESS”
NOTA.-
- MODO CONSOLA MÁXIMA NOTA UN 8.
- INTERFAZ GRÁFICA PUNTUA SOBRE 10
