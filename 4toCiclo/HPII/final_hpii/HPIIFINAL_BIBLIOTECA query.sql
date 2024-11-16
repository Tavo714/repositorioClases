create database HPIIFINAL_BIBLIOTECA

drop database HPIIFINAL_BIBLIOTECA

use HPIIFINAL_BIBLIOTECA



USE master;



-- Crear la tabla Distritos primero
CREATE TABLE Distritos (
    DistritoID INT PRIMARY KEY IDENTITY(1,1),
    Nombre NVARCHAR(100) NOT NULL
);

-- Crear la tabla Usuarios sin las claves for�neas inicialmente
CREATE TABLE Usuarios (
    UsuarioID INT PRIMARY KEY IDENTITY(1,1),
    Nombre NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100)  NOT NULL,
    FechaRegistro DATE NOT NULL,
    DNI CHAR(8)  NOT NULL,
    Direccion NVARCHAR(255) NOT NULL,
    DistritoID INT NOT NULL,
    Telefono CHAR(9) NOT NULL,
    EstadoUsuario NVARCHAR(10) NOT NULL,
    Penalidad NVARCHAR(2) NOT NULL
);



CREATE TABLE Autores (
    AutorID INT PRIMARY KEY IDENTITY(1,1),
    Nombre NVARCHAR(100) NOT NULL,
    Nacionalidad NVARCHAR(50),
    FechaNacimiento DATE NULL -- Permitir valores NULL
);


drop table Autores


-- Crear la tabla Libros
CREATE TABLE Libros (
    LibroID INT PRIMARY KEY IDENTITY(1,1),
    Titulo NVARCHAR(150) NOT NULL,
    A�oPublicacion INT,
    AutorID INT,
    Stock INT NOT NULL,
    FOREIGN KEY (AutorID) REFERENCES Autores(AutorID)
);

-- Crear la tabla Prestamos
CREATE TABLE Prestamos (
    PrestamoID INT PRIMARY KEY IDENTITY(1,1),
    UsuarioID INT NOT NULL,
    LibroID INT NOT NULL,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE,
    TiempoPrestamo INT NOT NULL,
    FOREIGN KEY (LibroID) REFERENCES Libros(LibroID)
);

-- Agregar la clave for�nea de DistritoID en Usuarios
ALTER TABLE Usuarios
ADD CONSTRAINT FK_Usuarios_Distritos FOREIGN KEY (DistritoID) REFERENCES Distritos(DistritoID);

-- Agregar la clave for�nea de UsuarioID en Prestamos
ALTER TABLE Prestamos
ADD CONSTRAINT FK_Prestamos_Usuarios FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID);

INSERT INTO Distritos (Nombre)
VALUES
('Anc�n'),
('Ate'),
('Barranco'),
('Bre�a'),
('Carabayllo'),
('Chaclacayo'),
('Chorrillos'),
('Cieneguilla'),
('Comas'),
('El Agustino'),
('Independencia'),
('Jes�s Mar�a'),
('La Molina'),
('La Victoria'),
('Lima'),
('Lince'),
('Los Olivos'),
('Lurigancho-Chosica'),
('Lur�n'),
('Magdalena del Mar'),
('Miraflores'),
('Pachac�mac'),
('Pucusana'),
('Pueblo Libre'),
('Puente Piedra'),
('Punta Hermosa'),
('Punta Negra'),
('R�mac'),
('San Bartolo'),
('San Borja'),
('San Isidro'),
('San Juan de Lurigancho'),
('San Juan de Miraflores'),
('San Luis'),
('San Mart�n de Porres'),
('San Miguel'),
('Santa Anita'),
('Santa Mar�a del Mar'),
('Santa Rosa'),
('Santiago de Surco'),
('Surquillo'),
('Villa El Salvador'),
('Villa Mar�a del Triunfo');

INSERT INTO Usuarios (Nombre, Email, FechaRegistro, DNI, Direccion, DistritoID, Telefono, EstadoUsuario, Penalidad)
VALUES
('Carlos P�rez', 'cperez@example.com', '2024-01-15', '12345678', 'Av. Siempre Viva 123', 1, '999999999', 'Activo', 'No'),
('Mar�a Garc�a', 'mgarcia@example.com', '2024-02-20', '23456789', 'Calle Falsa 456', 2, '988888888', 'Activo', 'No'),
('Luis Rodr�guez', 'lrodriguez@example.com', '2024-03-10', '34567890', 'Jr. Los Cedros 789', 3, '977777777', 'Inactivo', 'Si'),
('Ana Fern�ndez', 'afernandez@example.com', '2024-04-05', '45678901', 'Av. Las Flores 101', 4, '966666666', 'Activo', 'No'),
('Jorge Gonzales', 'jgonzales@example.com', '2024-05-22', '56789012', 'Calle Los Pinos 202', 5, '955555555', 'Activo', 'No'),
('Laura Torres', 'ltorres@example.com', '2024-06-18', '67890123', 'Jr. Las Rosas 303', 6, '944444444', 'Inactivo', 'Si'),
('Pedro S�nchez', 'psanchez@example.com', '2024-07-30', '78901234', 'Av. Los Eucaliptos 404', 7, '933333333', 'Activo', 'No'),
('Sof�a D�az', 'sdiaz@example.com', '2024-08-12', '89012345', 'Calle Los �lamos 505', 8, '922222222', 'Activo', 'No'),
('Jos� Castro', 'jcastro@example.com', '2024-09-14', '90123456', 'Jr. Los Tulipanes 606', 9, '911111111', 'Activo', 'No'),
('Elena Rivas', 'erivas@example.com', '2024-10-10', '01234567', 'Av. Los Laureles 707', 10, '900000000', 'Inactivo', 'Si'),
('Ra�l Vega', 'rvega@example.com', '2024-11-19', '11111111', 'Calle Las Orqu�deas 808', 11, '989898989', 'Activo', 'No'),
('Gabriela Ramos', 'gramos@example.com', '2024-12-21', '22222222', 'Jr. Las Margaritas 909', 12, '979797979', 'Activo', 'No'),
('Miguel L�pez', 'mlopez@example.com', '2024-01-15', '33333333', 'Av. Los Jazmines 111', 13, '969696969', 'Activo', 'No'),
('Andrea Ruiz', 'aruiz@example.com', '2024-02-20', '44444444', 'Calle Las Gardenias 222', 14, '959595959', 'Activo', 'No'),
('Ricardo Morales', 'rmorales@example.com', '2024-03-10', '55555555', 'Jr. Las Camelias 333', 15, '949494949', 'Activo', 'No'),
('Patricia Ortiz', 'portiz@example.com', '2024-04-05', '66666666', 'Av. Los Claveles 444', 16, '939393939', 'Inactivo', 'Si'),
('Daniela Mendoza', 'dmendoza@example.com', '2024-05-22', '77777777', 'Calle Las Violetas 555', 17, '929292929', 'Activo', 'No'),
('Fernando Medina', 'fmedina@example.com', '2024-06-18', '88888888', 'Jr. Las Hortensias 666', 18, '919191919', 'Activo', 'No'),
('Luc�a Herrera', 'lherrera@example.com', '2024-07-30', '99999999', 'Av. Las Azaleas 777', 19, '909090909', 'Activo', 'No'),
('Javier Vargas', 'jvargas@example.com', '2024-08-12', '10101010', 'Calle Las Lirios 888', 20, '898989898', 'Inactivo', 'Si'),
('Carmen Paredes', 'cparedes@example.com', '2024-09-14', '12121212', 'Jr. Las Dalias 999', 21, '888888888', 'Activo', 'No'),
('Carlos Pe�a', 'cpena@example.com', '2024-10-10', '13131313', 'Av. Los Geranios 101', 22, '878787878', 'Activo', 'No'),
('In�s Romero', 'iromero@example.com', '2024-11-19', '14141414', 'Calle Las Begonias 202', 23, '868686868', 'Activo', 'No'),
('Diego Alvarado', 'dalvarado@example.com', '2024-12-21', '15151515', 'Jr. Los Tulipanes 303', 24, '858585858', 'Activo', 'No'),
('M�nica Espinoza', 'mespinoza@example.com', '2024-01-15', '16161616', 'Av. Los Eucaliptos 404', 25, '848484848', 'Activo', 'No');

INSERT INTO Autores (Nombre, Nacionalidad, FechaNacimiento)
VALUES
('Gabriel Garc�a M�rquez', 'Colombiano', '1927-03-06'),
('Miguel de Cervantes', 'Espa�ol', '1547-09-29'),
('Herman Melville', 'Estadounidense', '1819-08-01'),
('Jane Austen', 'Brit�nica', '1775-12-16'),
('George Orwell', 'Brit�nico', '1903-06-25'),
('Franz Kafka', 'Austroh�ngaro', '1883-07-03'),
('William Shakespeare', 'Brit�nico', '1564-04-26'),
('Antoine de Saint-Exup�ry', 'Franc�s', '1900-06-29'),
('Fi�dor Dostoyevski', 'Ruso', '1821-11-11'),
('Victor Hugo', 'Franc�s', '1802-02-26'),
('F. Scott Fitzgerald', 'Estadounidense', '1896-09-24'),
('James Joyce', 'Irland�s', '1882-02-02'),
('Homero', 'Griego', NULL), -- Fecha desconocida
('Julio Cort�zar', 'Argentino', '1914-08-26'),
('Umberto Eco', 'Italiano', '1932-01-05'),
('Dante Alighieri', 'Italiano', '1265-05-30'),
('Albert Camus', 'Franc�s', '1913-11-07'),
('Ernest Hemingway', 'Estadounidense', '1899-07-21'),
('J.R.R. Tolkien', 'Brit�nico', '1892-01-03'),
('Lewis Carroll', 'Brit�nico', '1832-01-27'),
('Ray Bradbury', 'Estadounidense', '1920-08-22'),
('H.G. Wells', 'Brit�nico', '1866-09-21'),
('Bram Stoker', 'Irland�s', '1847-11-08'),
('Jos� Mar�a Arguedas', 'Peruano', '1911-01-18'),
('Mario Vargas Llosa', 'Peruano', '1936-03-28');

INSERT INTO Libros (Titulo, A�oPublicacion, AutorID, Stock)
VALUES
('Cien A�os de Soledad', 1967, 1, 5),
('Don Quijote de la Mancha', 1605, 2, 3),
('Moby Dick', 1851, 3, 4),
('Orgullo y Prejuicio', 1813, 4, 6),
('1984', 1949, 5, 2),
('La Metamorfosis', 1915, 6, 5),
('Hamlet', 1603, 7, 3),
('El Principito', 1943, 8, 10),
('Crimen y Castigo', 1866, 9, 4),
('Los Miserables', 1862, 10, 6),
('El Gran Gatsby', 1925, 11, 5),
('Ulises', 1922, 12, 2),
('La Odisea', -800, 13, 8),
('Rayuela', 1963, 14, 4),
('El Nombre de la Rosa', 1980, 15, 3),
('La Divina Comedia', 1320, 16, 2),
('El Extranjero', 1942, 17, 7),
('El Viejo y el Mar', 1952, 18, 5),
('El Se�or de los Anillos', 1954, 19, 8),
('Alicia en el Pa�s de las Maravillas', 1865, 20, 4),
('Fahrenheit 451', 1953, 21, 6),
('La Guerra de los Mundos', 1898, 22, 3),
('El Hobbit', 1937, 19, 7),
('Dr�cula', 1897, 23, 5),
('Los R�os Profundos', 1958, 24, 4);

INSERT INTO Prestamos (UsuarioID, LibroID, FechaPrestamo, FechaDevolucion, TiempoPrestamo)
VALUES
(1, 1, '2024-01-01', '2024-01-15', 14),
(1, 2, '2024-01-10', '2024-01-24', 14),
(2, 3, '2024-02-01', '2024-02-15', 14),
(3, 4, '2024-03-01', '2024-03-14', 13),
(3, 5, '2024-03-10', '2024-03-24', 14),
(4, 6, '2024-04-01', '2024-04-15', 14),
(5, 7, '2024-05-01', '2024-05-15', 14),
(5, 8, '2024-05-10', '2024-05-24', 14),
(6, 9, '2024-06-01', '2024-06-15', 14),
(7, 10, '2024-07-01', '2024-07-15', 14),
(8, 11, '2024-08-01', '2024-08-15', 14),
(9, 12, '2024-09-01', '2024-09-15', 14),
(10, 13, '2024-10-01', '2024-10-15', 14),
(11, 14, '2024-11-01', '2024-11-15', 14),
(12, 15, '2024-12-01', '2024-12-15', 14),
(13, 16, '2024-01-01', '2024-01-15', 14),
(14, 17, '2024-02-01', '2024-02-15', 14),
(15, 18, '2024-03-01', '2024-03-15', 14),
(16, 19, '2024-04-01', '2024-04-15', 14),
(17, 20, '2024-05-01', '2024-05-15', 14),
(18, 21, '2024-06-01', '2024-06-15', 14),
(19, 22, '2024-07-01', '2024-07-15', 14),
(20, 23, '2024-08-01', '2024-08-15', 14),
(21, 24, '2024-09-01', '2024-09-15', 14),
(22, 25, '2024-10-01', '2024-10-15', 14);



-- Agregar columna Estado a la tabla Autores
ALTER TABLE Autores
ADD Estado NVARCHAR(10) DEFAULT 'Activo' NOT NULL;

-- Agregar columna Estado a la tabla Libros
ALTER TABLE Libros
ADD Estado NVARCHAR(10) DEFAULT 'Activo' NOT NULL;

-- Agregar columna Estado a la tabla Prestamos
ALTER TABLE Prestamos
ADD Estado NVARCHAR(10) DEFAULT 'Activo' NOT NULL;




select * from Usuarios
select * from autores
select * from Libros
select * from Prestamos
select * from Distritos