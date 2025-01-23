-- Creación de la base de datos
CREATE DATABASE bdtecnologia;
USE bdtecnologia;

-- Tabla: categoria
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `descat` varchar(50) NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla: empleado
CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `nomemp` varchar(50) NOT NULL,
  `apeemp` varchar(50) NOT NULL,
  `dniemp` varchar(8) NOT NULL,
  `telemp` varchar(15) NOT NULL,
  `coremp` varchar(50) NOT NULL,
  PRIMARY KEY (`idempleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla: proveedor
CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL AUTO_INCREMENT,
  `razsocial` varchar(15) NOT NULL,
  `ruc` varchar(15) NOT NULL,
  `telefonopro` varchar(15) NOT NULL,
  `correopro` varchar(30) NOT NULL,
  `contacto` varchar(50) NOT NULL,
  `telefonocon` varchar(15) NOT NULL,
  `correocon` varchar(30) NOT NULL,
  PRIMARY KEY (`idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla: producto
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nompro` varchar(50) NOT NULL,
  `despro` varchar(100) DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `idcategoria` int(11) NOT NULL,
  `idproveedor` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `idcategoria` (`idcategoria`),
  KEY `idproveedor` (`idproveedor`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla: pedido
CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `idempleado` int(11) NOT NULL,
  `idproveedor` int(11) NOT NULL,
  `estado` varchar(15) NOT NULL DEFAULT 'Pendiente',
  `total` double DEFAULT 0,
  PRIMARY KEY (`idpedido`),
  KEY `idempleado` (`idempleado`),
  KEY `idproveedor` (`idproveedor`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla: pedido_producto
CREATE TABLE `pedido_producto` (
  `idpedido` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_unitario` double NOT NULL,
  PRIMARY KEY (`idpedido`, `idproducto`),
  KEY `idproducto` (`idproducto`),
  CONSTRAINT `pedido_producto_ibfk_1` FOREIGN KEY (`idpedido`) REFERENCES `pedido` (`idpedido`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pedido_producto_ibfk_2` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;




-- Insertar datos en la tabla categoria
INSERT INTO `categoria` (`idcategoria`, `descat`) VALUES
(1, 'Laptops'),
(2, 'Smartphones'),
(3, 'Accesorios'),
(4, 'Componentes'),
(5, 'Redes');

-- Insertar datos en la tabla empleado
INSERT INTO `empleado` (`idempleado`, `nomemp`, `apeemp`, `dniemp`, `telemp`, `coremp`) VALUES
(1, 'Juan', 'Perez', '12345678', '987654321', 'juan.perez@example.com'),
(2, 'Maria', 'Lopez', '23456789', '987654322', 'maria.lopez@example.com'),
(3, 'Carlos', 'Gomez', '34567890', '987654323', 'carlos.gomez@example.com'),
(4, 'Ana', 'Martinez', '45678901', '987654324', 'ana.martinez@example.com'),
(5, 'Luis', 'Ramirez', '56789012', '987654325', 'luis.ramirez@example.com');

-- Insertar datos en la tabla proveedor
INSERT INTO `proveedor` (`idproveedor`, `razsocial`, `ruc`, `telefonopro`, `correopro`, `contacto`, `telefonocon`, `correocon`) VALUES
(1, 'Proveedor A', '11111111111', '987654111', 'contactoA@example.com', 'Juan A', '987654211', 'juanA@example.com'),
(2, 'Proveedor B', '22222222222', '987654112', 'contactoB@example.com', 'Maria B', '987654212', 'mariaB@example.com'),
(3, 'Proveedor C', '33333333333', '987654113', 'contactoC@example.com', 'Carlos C', '987654213', 'carlosC@example.com'),
(4, 'Proveedor D', '44444444444', '987654114', 'contactoD@example.com', 'Ana D', '987654214', 'anaD@example.com'),
(5, 'Proveedor E', '55555555555', '987654115', 'contactoE@example.com', 'Luis E', '987654215', 'luisE@example.com');

-- Insertar datos en la tabla producto
INSERT INTO `producto` (`idproducto`, `nompro`, `despro`, `cantidad`, `precio`, `idcategoria`, `idproveedor`) VALUES
(1, 'Laptop Dell', 'Laptop de alto rendimiento', 10, 1500, 1, 1),
(2, 'iPhone 14', 'Smartphone de última generación', 20, 1200, 2, 2),
(3, 'Teclado Mecánico', 'Teclado con iluminación RGB', 50, 80, 3, 3),
(4, 'Disco SSD 1TB', 'Unidad de almacenamiento sólida', 15, 100, 4, 1),
(5, 'Router WiFi 6', 'Router de alta velocidad', 30, 200, 5, 2);

-- Insertar datos en la tabla pedido
INSERT INTO `pedido` (`idpedido`, `fecha`, `idempleado`, `idproveedor`, `estado`, `total`) VALUES
(1, '2024-12-13', 1, 1, 'Pendiente', 1000),
(2, '2024-12-14', 2, 2, 'Completado', 2000),
(3, '2024-12-15', 3, 3, 'Cancelado', 1500),
(4, '2024-12-16', 4, 4, 'Pendiente', 500),
(5, '2024-12-17', 5, 5, 'En Proceso', 1200);

-- Insertar datos en la tabla pedido_producto
INSERT INTO `pedido_producto` (`idpedido`, `idproducto`, `cantidad`, `precio_unitario`) VALUES
(1, 1, 2, 1500),
(1, 4, 1, 100),
(2, 2, 3, 1200),
(3, 3, 5, 80),
(4, 5, 1, 200);