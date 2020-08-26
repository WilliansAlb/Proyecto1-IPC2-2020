CREATE SCHEMA IF NOT EXISTS Intelaf;

USE Intelaf;

CREATE TABLE IF NOT EXISTS Tienda(
	codigo_tienda VARCHAR(15) NOT NULL,
	nombre VARCHAR(45) NOT NULL,
	direccion VARCHAR(45) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	telefono2 VARCHAR(15),
	email VARCHAR(35),
	horario VARCHAR(25),
	PRIMARY KEY(codigo_tienda)
);

CREATE TABLE IF NOT EXISTS Producto(
	codigo_producto VARCHAR(15) NOT NULL,
	nombre VARCHAR(35) NOT NULL,
	fabricante VARCHAR(35) NOT NULL,
	precio DECIMAL(14,8) NOT NULL,
	descripcion VARCHAR(55),
	garantia INT,
	PRIMARY KEY(codigo_producto)
);

CREATE TABLE IF NOT EXISTS Cliente(
	nit VARCHAR(8) NOT NULL,
	nombre VARCHAR(35) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	credito DECIMAL(14,8) NOT NULL,
	dpi VARCHAR(13),
	email VARCHAR(35),
	direccion VARCHAR(35),
	PRIMARY KEY(nit)
);

CREATE TABLE IF NOT EXISTS Pedido(
	codigo_pedido INT NOT NULL,
	codigo_tienda1 VARCHAR(15) NOT NULL,
	codigo_tienda2 VARCHAR(15) NOT NULL,
	fecha DATE NOT NULL,
	nit VARCHAR(8) NOT NULL,
	anticipo DECIMAL(14,8) NOT NULL,
	entregado TINYINT(1) DEFAULT 0,
	egresado TINYINT(1) DEFAULT 0,
	ingresado TINYINT(1) DEFAULT 0,
	atrasado TINYINT(1) DEFAULT 0,
	fecha_ingreso DATE,
	PRIMARY KEY (codigo_pedido),
	FOREIGN KEY (codigo_tienda1) REFERENCES Tienda(codigo_tienda) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (codigo_tienda2) REFERENCES Tienda(codigo_tienda) ON DELETE NO ACTION ON UPDATE CASCADE 
);

CREATE TABLE IF NOT EXISTS Solicitado(
	codigo_solicitado INT NOT NULL AUTO_INCREMENT,
	codigo_producto VARCHAR(15) NOT NULL,
	codigo_pedido INT NOT NULL,
	cantidad INT NOT NULL,
	total DECIMAL(14,8),
	PRIMARY KEY (codigo_solicitado),
	FOREIGN KEY (codigo_producto) REFERENCES Producto(codigo_producto) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (codigo_pedido) REFERENCES Pedido(codigo_pedido) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Tiempo(
	id_tiempo INT NOT NULL AUTO_INCREMENT,
	codigo_tienda1 VARCHAR(15) NOT NULL,
	codigo_tienda2 VARCHAR(15) NOT NULL,
	dias INT NOT NULL,
	PRIMARY KEY (id_tiempo),
	FOREIGN KEY (codigo_tienda1) REFERENCES Tienda(codigo_tienda) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (codigo_tienda2) REFERENCES Tienda(codigo_tienda) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Existencia(
	codigo_existencia INT NOT NULL AUTO_INCREMENT,
	codigo_producto VARCHAR(15) NOT NULL, 
	codigo_tienda VARCHAR(15) NOT NULL,
	cantidad INT NOT NULL,
	total DECIMAL(14,8),
	PRIMARY KEY (codigo_existencia),
	FOREIGN KEY (codigo_producto) REFERENCES Producto(codigo_producto) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (codigo_tienda) REFERENCES Tienda(codigo_tienda) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Factura(
	codigo_factura INT NOT NULL AUTO_INCREMENT,
	codigo_tienda VARCHAR(15) NOT NULL,
	nit VARCHAR(8) NOT NULL,
	fecha DATE NOT NULL,
	total DECIMAL(14,8),
	pago_credito DECIMAL(14,8),
	PRIMARY KEY (codigo_factura),
	FOREIGN KEY (codigo_tienda) REFERENCES Tienda(codigo_tienda) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (nit) REFERENCES Cliente(nit) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Venta(
	codigo_venta INT NOT NULL AUTO_INCREMENT,
	codigo_factura INT NOT NULL,
	codigo_producto VARCHAR(15) NOT NULL,
	cantidad INT NOT NULL,
	total DECIMAL(14,8),
	PRIMARY KEY (codigo_venta),
	FOREIGN KEY (codigo_factura) REFERENCES Factura(codigo_factura) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (codigo_producto) REFERENCES Producto(codigo_producto) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Empleado(
	codigo_empleado VARCHAR(10) NOT NULL,
	nombre VARCHAR(35) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	dpi VARCHAR(13) NOT NULL DEFAULT '--',
	nit VARCHAR(8),
	email VARCHAR(25) NOT NULL DEFAULT '--',
	direccion VARCHAR(45) NOT NULL DEFAULT '--',
	PRIMARY KEY (codigo_empleado)
);
