CREATE DATABASE IF NOT EXISTS proyectodsa2;
USE proyectodsa2;

-- Insertar datos de ejemplo en clientes
INSERT INTO clientes (nombre_cliente, direccion, username, password, email, telefono, estado) VALUES
('Juan Perez', 'Calle Falsa 123', 'jperez', 'password123', 'juan.perez@example.com', '1234567890', '1'),
('Maria Lopez', 'Avenida Siempre Viva 456', 'mlopez', 'password456', 'maria.lopez@example.com', '0987654321', '1'),
('Carlos Sanchez', 'Calle Larga 789', 'csanchez', 'password789', 'carlos.sanchez@example.com', '9876543210', '1'),
('Ana Gonzalez', 'Avenida Principal 101', 'agonzalez', 'password101', 'ana.gonzalez@example.com', '4567890123', '1'),
('Luis Ramirez', 'Calle Secundaria 202', 'lramirez', 'password202', 'luis.ramirez@example.com', '6789012345', '1'),
('Carmen Diaz', 'Avenida Central 303', 'cdiaz', 'password303', 'carmen.diaz@example.com', '7890123456', '1'),
('Jorge Torres', 'Calle Nueva 404', 'jtorres', 'password404', 'jorge.torres@example.com', '8901234567', '1'),
('Gloria Martinez', 'Avenida Antigua 505', 'gmartinez', 'password505', 'gloria.martinez@example.com', '9012345678', '1'),
('Ricardo Herrera', 'Calle Vieja 606', 'rherrera', 'password606', 'ricardo.herrera@example.com', '0123456789', '1'),
('Marta Vargas', 'Avenida Lejana 707', 'mvargas', 'password707', 'marta.vargas@example.com', '2345678901', '1');

-- Insertar datos de ejemplo en productos
INSERT INTO productos (nombre_producto, descripcion, precio, stock, estado) VALUES
('Cemento Portland', 'Bolsa de cemento Portland 50kg', 15.00, 200, '1'),
('Arena Fina', 'Saco de arena fina 40kg', 5.00, 150, '1'),
('Ladrillo King Kong', 'Ladrillo tipo King Kong', 0.50, 1000, '1'),
('Malla Electrosoldada', 'Malla de acero electrosoldada 6mm', 25.00, 80, '1'),
('Hierro Corrugado', 'Barra de hierro corrugado 12mm', 10.00, 300, '1'),
('Piedra Chancada', 'Saco de piedra chancada 40kg', 8.00, 120, '1'),
('Cal Hidratada', 'Bolsa de cal hidratada 25kg', 7.00, 100, '1'),
('Yeso en Polvo', 'Saco de yeso en polvo 25kg', 6.00, 110, '1'),
('Bloque de Concreto', 'Bloque de concreto 15x20x40cm', 2.00, 500, '1'),
('Pintura Látex', 'Galón de pintura látex blanca', 20.00, 50, '1');

-- Insertar datos de ejemplo en pedidos
INSERT INTO pedidos (cliente_id, fecha, total, estado) VALUES
(1, '2024-08-01', 150.00, '1'),
(2, '2024-08-02', 50.00, '1'),
(3, '2024-08-03', 300.00, '1'),
(4, '2024-08-04', 75.00, '1'),
(5, '2024-08-05', 40.00, '1'),
(6, '2024-08-06', 100.00, '1'),
(7, '2024-08-07', 80.00, '1'),
(8, '2024-08-08', 60.00, '1'),
(9, '2024-08-09', 250.00, '1'),
(10, '2024-08-10', 200.00, '1');

-- Insertar datos de ejemplo en detalle_pedidos
INSERT INTO detalle_pedidos (pedido_id, producto_id, cantidad, precio_unitario, estado) VALUES
(1, 1, 10, 15.00, '1'),
(1, 3, 100, 0.50, '1'),
(2, 2, 10, 5.00, '1'),
(3, 4, 8, 25.00, '1'),
(3, 5, 20, 10.00, '1'),
(4, 6, 5, 8.00, '1'),
(5, 7, 10, 7.00, '1'),
(6, 8, 15, 6.00, '1'),
(7, 9, 50, 2.00, '1'),
(8, 10, 3, 20.00, '1'),
(9, 1, 20, 15.00, '1'),
(9, 3, 200, 0.50, '1'),
(10, 4, 10, 25.00, '1'),
(10, 6, 10, 8.00, '1');

-- Insertar datos de ejemplo en proveedores
INSERT INTO proveedores (nombre_proveedor, direccion, telefono, email, estado) VALUES
('Proveedor Uno', 'Calle Principal 123', '123456789', 'proveedor1@example.com', '1'),
('Proveedor Dos', 'Avenida Secundaria 456', '987654321', 'proveedor2@example.com', '1'),
('Proveedor Tres', 'Calle Tercera 789', '456789012', 'proveedor3@example.com', '1'),
('Proveedor Cuatro', 'Avenida Cuarta 101', '789012345', 'proveedor4@example.com', '1'),
('Proveedor Cinco', 'Calle Quinta 202', '234567890', 'proveedor5@example.com', '1');

-- Insertar datos de ejemplo en servicios
INSERT INTO servicios (nombre_servicio, descripcion, precio, estado) VALUES
('Servicio de Transporte', 'Transporte de materiales de construcción', 150.00, '1'),
('Servicio de Instalación', 'Instalación de sistemas eléctricos', 200.00, '1'),
('Servicio de Mantenimiento', 'Mantenimiento de maquinaria pesada', 100.00, '1'),
('Servicio de Asesoría', 'Asesoría en proyectos de construcción', 300.00, '1'),
('Servicio de Seguridad', 'Seguridad en obras de construcción', 250.00, '1');