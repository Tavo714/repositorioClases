-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2024 a las 03:41:06
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `academico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `codcar` int(11) NOT NULL,
  `descar` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`codcar`, `descar`) VALUES
(1, 'Rector'),
(2, 'Administrador'),
(3, 'Caja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escuela`
--

CREATE TABLE `escuela` (
  `codesc` int(11) NOT NULL,
  `codfac` int(11) NOT NULL,
  `desesc` varchar(70) NOT NULL,
  `ubiesc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `escuela`
--

INSERT INTO `escuela` (`codesc`, `codfac`, `desesc`, `ubiesc`) VALUES
(1, 1, 'Escuela de Ingenieria Civil', 'Pabellon 01'),
(2, 1, 'Escuela de Arquitectura', 'Pabellon 01'),
(3, 1, 'Escuela de Ingenieria de Sistemas', 'Pabellon 01'),
(4, 2, 'Escuela de Estomatologia', 'Pabellon 02'),
(5, 2, 'Escuela de Medicina', 'Pabellon 02'),
(6, 3, 'Escuela de Administracion', 'Pabellon 03'),
(7, 3, 'Escuela de Turismo', 'Pabellon 03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `codest` int(11) NOT NULL,
  `dniest` varchar(8) NOT NULL,
  `apeest` varchar(25) NOT NULL,
  `nomest` varchar(25) NOT NULL,
  `direst` varchar(80) NOT NULL,
  `telest` varchar(9) DEFAULT NULL,
  `corest` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`codest`, `dniest`, `apeest`, `nomest`, `direst`, `telest`, `corest`) VALUES
(125, '45678342', 'Mendoza Gonzales', 'Martin', 'Lima Norte', '956476453', NULL),
(225, '40967858', 'Pacherrez Peña', 'Omar', 'Lima Sur', NULL, 'peom23@gmail.com'),
(325, '45738921', 'Arismendiz Ruiz', 'Cecilia', 'Ate', '967564532', 'ariru@hotmail.com'),
(326, '88888888', 'Dos Santos Aveiro', 'Cristiano Ronaldo', 'Portugal', '999888777', 'cr7@gmail.com'),
(327, '55554444', 'Nazario Lima', 'Ronaldo', 'Brazilzilzil', '985658896', 'r9fenomeno@hotmail.com'),
(328, '99992222', 'Sanchez Borrero', 'Joysie', 'Miraflores', '985687452', 'jsanchez@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facultad`
--

CREATE TABLE `facultad` (
  `codfac` int(11) NOT NULL,
  `desfac` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `facultad`
--

INSERT INTO `facultad` (`codfac`, `desfac`) VALUES
(1, 'Facultad de Arquitectura e Ingenieria'),
(2, 'Facultad de Ciencias de la Salud'),
(3, 'Facultad de Gestion Empresarial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `codmat` int(11) NOT NULL,
  `fecmat` varchar(12) NOT NULL,
  `codesc` int(11) NOT NULL,
  `codtra` int(11) NOT NULL,
  `codest` int(11) NOT NULL,
  `codper` varchar(6) NOT NULL,
  `cicmat` int(11) NOT NULL,
  `turmat` varchar(10) NOT NULL,
  `impmat` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`codmat`, `fecmat`, `codesc`, `codtra`, `codest`, `codper`, `cicmat`, `turmat`, `impmat`) VALUES
(1, '2024-12-01', 3, 2, 125, '202501', 1, 'M', 350.00),
(2, '2024-12-01', 3, 2, 225, '202501', 1, 'M', 350.00),
(3, '2024-12-02', 1, 1, 325, '202501', 2, 'T', 300.00),
(5, '2024-12-12', 1, 2, 125, '202501', 1, 'T', 450.00),
(7, '2024-12-11', 1, 2, 326, '202501', 1, 'tarde', 700.00),
(9, '2024-12-04', 1, 1, 328, '202503', 1, 'tarde', 250.00),
(10, '2024-12-05', 6, 1, 327, '202502', 3, 'noche', 652.00),
(11, '2024-12-12', 3, 2, 125, '202501', 1, 'M', 450.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE `periodo` (
  `codper` varchar(6) NOT NULL,
  `desper` varchar(100) NOT NULL,
  `iniper` varchar(12) NOT NULL,
  `finper` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `periodo`
--

INSERT INTO `periodo` (`codper`, `desper`, `iniper`, `finper`) VALUES
('202501', 'Periodo 2025 Primer Semestre', '2024-01-06', '2024-04-25'),
('202502', 'Periodo 2025 Segundo Semestre', '2024-05-05', '2024-08-29'),
('202503', 'Periodo 2025 Tercer Semestre', '2024-09-08', '2024-12-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `codtra` int(11) NOT NULL,
  `dnitra` varchar(8) NOT NULL,
  `apetra` varchar(25) NOT NULL,
  `nomtra` varchar(25) NOT NULL,
  `codcar` int(11) NOT NULL,
  `nictra` varchar(25) NOT NULL,
  `pastra` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`codtra`, `dnitra`, `apetra`, `nomtra`, `codcar`, `nictra`, `pastra`) VALUES
(1, '42126203', 'Benites Anton', 'Luis', 3, 'user01', '123456'),
(2, '02841245', 'Mendieta Cueva', 'Carlos', 3, 'user02', '12345678'),
(3, '40356372', 'Arrunategui Li', 'Elsa', 2, 'admin', '123456'),
(4, '77777777', 'Valera Mendoza', 'Gustavo', 1, 'rector', '1234567');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`codcar`);

--
-- Indices de la tabla `escuela`
--
ALTER TABLE `escuela`
  ADD PRIMARY KEY (`codesc`),
  ADD KEY `fk_esc_fac` (`codfac`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`codest`);

--
-- Indices de la tabla `facultad`
--
ALTER TABLE `facultad`
  ADD PRIMARY KEY (`codfac`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`codmat`),
  ADD KEY `fk_mat_esc` (`codesc`),
  ADD KEY `fk_mat_tra` (`codtra`),
  ADD KEY `fk_mat_est` (`codest`),
  ADD KEY `fk_mat_per` (`codper`);

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`codper`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`codtra`),
  ADD KEY `fk_tra_car` (`codcar`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `codcar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `escuela`
--
ALTER TABLE `escuela`
  MODIFY `codesc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `codest` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=329;

--
-- AUTO_INCREMENT de la tabla `facultad`
--
ALTER TABLE `facultad`
  MODIFY `codfac` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `matricula`
--
ALTER TABLE `matricula`
  MODIFY `codmat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `codtra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `escuela`
--
ALTER TABLE `escuela`
  ADD CONSTRAINT `fk_esc_fac` FOREIGN KEY (`codfac`) REFERENCES `facultad` (`codfac`);

--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `fk_mat_esc` FOREIGN KEY (`codesc`) REFERENCES `escuela` (`codesc`),
  ADD CONSTRAINT `fk_mat_est` FOREIGN KEY (`codest`) REFERENCES `estudiante` (`codest`),
  ADD CONSTRAINT `fk_mat_per` FOREIGN KEY (`codper`) REFERENCES `periodo` (`codper`),
  ADD CONSTRAINT `fk_mat_tra` FOREIGN KEY (`codtra`) REFERENCES `trabajador` (`codtra`);

--
-- Filtros para la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD CONSTRAINT `fk_tra_car` FOREIGN KEY (`codcar`) REFERENCES `cargo` (`codcar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
