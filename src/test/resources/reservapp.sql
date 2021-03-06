-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-07-2017 a las 17:18:57
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
CREATE TABLE IF NOT EXISTS `establecimiento` (
  `codigoEstablecimiento` int(11) UNSIGNED NOT NULL,
  `Nombre` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Nit` varchar(9) CHARACTER SET utf8 NOT NULL,
  `Direccion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Correo` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Telefono` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Longitud` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Latitud` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Mesas` int(11) NOT NULL,
  PRIMARY KEY (`codigoEstablecimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `establecimiento`
--

INSERT INTO `establecimiento` (`codigoEstablecimiento`, `Nombre`, `Nit`, `Direccion`, `Correo`, `Telefono`, `Longitud`, `Latitud`, `Mesas`) VALUES
(1, 'venta al x coco', '890785', 'barrio cristal', 'super@super', '240000', '8', '9', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `CodigoFactura` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `MetodoPago` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `ValorTotal` float DEFAULT NULL,
  `EstadoPago` tinyint(1) DEFAULT NULL,
  `CodigoReserva` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`CodigoFactura`),
  KEY `fk_factura_reserva1_idx` (`CodigoReserva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `CodigoMenu` int(11) NOT NULL,
  `Nombre` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Precio` int(11) NOT NULL,
  `Descripcion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Imagen` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `CodigoEstablecimiento` int(11) UNSIGNED NOT NULL,
  `estado` int(1) DEFAULT NULL,
  PRIMARY KEY (`CodigoMenu`),
  KEY `fk_menu_establecimiento1_idx` (`CodigoEstablecimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

DROP TABLE IF EXISTS `mesa`;
CREATE TABLE IF NOT EXISTS `mesa` (
  `CodigoMesa` int(11) UNSIGNED NOT NULL,
  `Puestos` int(11) NOT NULL,
  `Ubicacion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Estado` tinyint(1) DEFAULT NULL,
  `codigoEstablecimiento` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`CodigoMesa`),
  KEY `fk_mesa_establecimiento1_idx` (`codigoEstablecimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

DROP TABLE IF EXISTS `orden`;
CREATE TABLE IF NOT EXISTS `orden` (
  `CodigoOrden` int(11) NOT NULL,
  `Nombre` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Precio` int(11) NOT NULL,
  `Descripcion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Imagen` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  `menu_CodigoMenu` int(11) NOT NULL,
  `reserva_CodigoReserva` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`CodigoOrden`),
  KEY `fk_orden_menu1_idx` (`menu_CodigoMenu`),
  KEY `fk_orden_reserva1_idx` (`reserva_CodigoReserva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE IF NOT EXISTS `reserva` (
  `CodigoReserva` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Fecha Reserva` date DEFAULT NULL,
  `IdMesa` int(11) DEFAULT NULL,
  `Documento` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `CodigoMesa` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`CodigoReserva`),
  KEY `fk_reserva_usuario1_idx` (`Documento`),
  KEY `fk_reserva_mesa1_idx` (`CodigoMesa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `codigodelRol` int(11) UNSIGNED NOT NULL,
  `rol_Nombre` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`codigodelRol`)
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
CREATE TABLE IF NOT EXISTS `usuario` (
  `documento` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Correo` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Contrasena` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Nombre` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Apellido` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Telefono` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Direccion` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Sexo` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `rol_codigodelRol` int(11) UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`documento`),
  KEY `fk_usuario_rol1_idx` (`rol_codigodelRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`documento`, `Correo`, `Contrasena`, `Nombre`, `Apellido`, `Telefono`, `Direccion`, `Sexo`, `rol_codigodelRol`) VALUES
('123', 'admin@admin.com', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'admin', 'admin', '123456', 'admin', 'MASCULINO', 1),
('1234', 'esterlyn1@yahoo.es', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', '', '', '78', '67', 'masculino', 1),
('12345', 'esterlyn2@yahoo.es', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', '', '', '999', '65', 'masculino', 2),
('1234567', 'esterlyn3@yahoo.es', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', '', '', '98', '89', 'masculino', 3),
('21345', 'gamba@gmail.com', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'leidy', 'gamba', '324321', '213dejh', 'Femenino', 2),
('45', '45', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', '45', '45', '45', '45', '45', 2);

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
