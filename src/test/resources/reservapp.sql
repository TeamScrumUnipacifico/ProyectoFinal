-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-07-2017 a las 16:16:46
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reservapp`
--
CREATE DATABASE IF NOT EXISTS `reservapp` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `reservapp`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `establecimiento`
--

DROP TABLE IF EXISTS `establecimiento`;
CREATE TABLE `establecimiento` (
  `codigoEstablecimiento` int(11) UNSIGNED NOT NULL,
  `Nombre` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Nit` varchar(9) CHARACTER SET utf8 NOT NULL,
  `Direccion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Correo` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Telefono` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Longitud` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Latitud` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Mesas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE `factura` (
  `CodigoFactura` int(11) UNSIGNED NOT NULL,
  `MetodoPago` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `ValorTotal` float DEFAULT NULL,
  `EstadoPago` tinyint(1) DEFAULT NULL,
  `CodigoReserva` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `CodigoMenu` int(11) NOT NULL,
  `Nombre` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Precio` int(11) NOT NULL,
  `Descripcion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Imagen` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `CodigoEstablecimiento` int(11) UNSIGNED NOT NULL,
  `estado` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

DROP TABLE IF EXISTS `mesa`;
CREATE TABLE `mesa` (
  `CodigoMesa` int(11) UNSIGNED NOT NULL,
  `Puestos` int(11) NOT NULL,
  `Ubicacion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Estado` tinyint(1) DEFAULT NULL,
  `codigoEstablecimiento` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

DROP TABLE IF EXISTS `orden`;
CREATE TABLE `orden` (
  `CodigoOrden` int(11) NOT NULL,
  `Nombre` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Precio` int(11) NOT NULL,
  `Descripcion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Imagen` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  `menu_CodigoMenu` int(11) NOT NULL,
  `reserva_CodigoReserva` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `CodigoReserva` int(11) UNSIGNED NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Fecha Reserva` date DEFAULT NULL,
  `IdMesa` int(11) DEFAULT NULL,
  `Documento` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `CodigoMesa` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `codigodelRol` int(11) UNSIGNED NOT NULL,
  `rol_Nombre` varchar(45) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`codigodelRol`, `rol_Nombre`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'GERENTE'),
(3, 'USUARIO_FINAL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `documento` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Correo` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Contrasena` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Nombre` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Apellido` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Telefono` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Direccion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Sexo` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `rol_codigodelRol` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`documento`, `Correo`, `Contrasena`, `Nombre`, `Apellido`, `Telefono`, `Direccion`, `Sexo`, `rol_codigodelRol`) VALUES
('123', 'admin@admin.com', '12345', 'admin', 'admin', '123456', 'admin', 'MASCULINO', 1),
('1234', 'esterlyn1@yahoo.es', '12345', '', '', '78', '67', 'masculino', 1),
('12345', 'esterlyn2@yahoo.es', '12345', '', '', '999', '65', 'masculino', 2),
('1234567', 'esterlyn3@yahoo.es', '12345', '', '', '98', '89', 'masculino', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `establecimiento`
--
ALTER TABLE `establecimiento`
  ADD PRIMARY KEY (`codigoEstablecimiento`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`CodigoFactura`),
  ADD KEY `fk_factura_reserva1_idx` (`CodigoReserva`);

--
-- Indices de la tabla `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`CodigoMenu`),
  ADD KEY `fk_menu_establecimiento1_idx` (`CodigoEstablecimiento`);

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`CodigoMesa`),
  ADD KEY `fk_mesa_establecimiento1_idx` (`codigoEstablecimiento`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`CodigoOrden`),
  ADD KEY `fk_orden_menu1_idx` (`menu_CodigoMenu`),
  ADD KEY `fk_orden_reserva1_idx` (`reserva_CodigoReserva`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`CodigoReserva`),
  ADD KEY `fk_reserva_usuario1_idx` (`Documento`),
  ADD KEY `fk_reserva_mesa1_idx` (`CodigoMesa`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`codigodelRol`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`documento`),
  ADD KEY `fk_usuario_rol1_idx` (`rol_codigodelRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `CodigoFactura` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `CodigoReserva` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_factura_reserva1` FOREIGN KEY (`CodigoReserva`) REFERENCES `reserva` (`CodigoReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `fk_menu_establecimiento1` FOREIGN KEY (`CodigoEstablecimiento`) REFERENCES `establecimiento` (`codigoEstablecimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD CONSTRAINT `fk_mesa_establecimiento1` FOREIGN KEY (`codigoEstablecimiento`) REFERENCES `establecimiento` (`codigoEstablecimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `fk_orden_menu1` FOREIGN KEY (`menu_CodigoMenu`) REFERENCES `menu` (`CodigoMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orden_reserva1` FOREIGN KEY (`reserva_CodigoReserva`) REFERENCES `reserva` (`CodigoReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_reserva_mesa1` FOREIGN KEY (`CodigoMesa`) REFERENCES `mesa` (`CodigoMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reserva_usuario1` FOREIGN KEY (`Documento`) REFERENCES `usuario` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`rol_codigodelRol`) REFERENCES `rol` (`codigodelRol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
