-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: visitas_guiadas
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
INSERT INTO `perfiles` VALUES (1,'ADMIN'),(2,'CLIENTE'),(3,'GUIA');
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `id_visita` int(11) DEFAULT NULL,
  `user_reserva` varchar(45) DEFAULT NULL,
  `precio_venta` decimal(9,2) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `estado` enum('CONFIRMADA','CANCELADA','COMPLETADA') DEFAULT 'CONFIRMADA',
  `fecha_reserva` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id_reserva`),
  KEY `id_visita` (`id_visita`),
  KEY `user_reserva` (`user_reserva`),
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_visita`) REFERENCES `visitas` (`id_visita`),
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`user_reserva`) REFERENCES `usuarios` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,1,'juanp',12.00,'Reserva para pareja',2,'CONFIRMADA','2026-03-15 21:09:11'),(2,1,'anam',12.00,'Grupo pequeño',3,'CONFIRMADA','2026-03-15 21:09:11'),(3,2,'pedror',15.00,'Reserva familiar',4,'CONFIRMADA','2026-03-15 21:09:11'),(4,3,'laurag',10.00,'Interesada en arquitectura',2,'CONFIRMADA','2026-03-15 21:09:11'),(5,2,'juanp',15.00,'No pudo asistir finalmente',1,'CANCELADA','2026-03-15 21:09:11');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_visita`
--

DROP TABLE IF EXISTS `tipos_visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_visita` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_visita`
--

LOCK TABLES `tipos_visita` WRITE;
/*!40000 ALTER TABLE `tipos_visita` DISABLE KEYS */;
INSERT INTO `tipos_visita` VALUES (1,'Histórica','Visitas históricas'),(2,'Nocturna','Visitas nocturnas'),(3,'Misterio','Rutas de misterio'),(4,'Gastronómica','Rutas gastronómicas');
/*!40000 ALTER TABLE `tipos_visita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_perfiles`
--

DROP TABLE IF EXISTS `usuario_perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_perfiles` (
  `username` varchar(45) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`username`,`id_perfil`),
  KEY `id_perfil` (`id_perfil`),
  CONSTRAINT `usuario_perfiles_ibfk_1` FOREIGN KEY (`username`) REFERENCES `usuarios` (`usuario`),
  CONSTRAINT `usuario_perfiles_ibfk_2` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_perfiles`
--

LOCK TABLES `usuario_perfiles` WRITE;
/*!40000 ALTER TABLE `usuario_perfiles` DISABLE KEYS */;
INSERT INTO `usuario_perfiles` VALUES ('admin',1),('anam',2),('juanp',2),('laurag',2),('pedror',2);
/*!40000 ALTER TABLE `usuario_perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usuario` varchar(45) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `activado` int(11) DEFAULT 1,
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('admin','admin123','admin@visitas.com','Carlos','García López','Calle Mayor 10, Toledo',1,'2026-03-01'),('anam','ana123','ana@email.com','Ana','Martínez Ruiz','Calle Sol 22, Toledo',1,'2026-03-06'),('juanp','juan123','juanp@email.com','Juan','Pérez Martín','Av. Europa 12, Madrid',1,'2026-03-05'),('laurag','laura123','laura@email.com','Laura','Gómez Díaz','Av. Castilla 15, Toledo',1,'2026-03-10'),('pedror','pedro123','pedro@email.com','Pedro','Rodríguez Gómez','Calle Luna 8, Sevilla',1,'2026-03-08');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitas`
--

DROP TABLE IF EXISTS `visitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitas` (
  `id_visita` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `estado` enum('ACTIVO','CANCELADO','TERMINADO') DEFAULT 'ACTIVO',
  `aforo_maximo` int(11) DEFAULT NULL,
  `minimo_asistencia` int(11) DEFAULT NULL,
  `precio` decimal(9,2) DEFAULT NULL,
  `id_tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_visita`),
  KEY `id_tipo` (`id_tipo`),
  CONSTRAINT `visitas_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipos_visita` (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitas`
--

LOCK TABLES `visitas` WRITE;
/*!40000 ALTER TABLE `visitas` DISABLE KEYS */;
INSERT INTO `visitas` VALUES (1,'Ruta histórica Toledo','Recorrido guiado por el casco histórico de Toledo','2026-06-10 18:00:00',120,'Plaza de Zocodover, Toledo','ACTIVO',25,5,12.00,1),(2,'Ruta nocturna de leyendas','Visita nocturna con historias y leyendas de Toledo','2026-06-15 21:30:00',90,'Puerta de Bisagra, Toledo','ACTIVO',20,5,15.00,2),(3,'Visita Catedral de Toledo','Tour guiado por el interior de la Catedral de Toledo','2026-06-20 11:00:00',90,'Catedral Primada, Toledo','ACTIVO',30,8,10.00,1),(4,'Ruta Toledo misterioso','Descubre historias de misterio y fenómenos paranormales','2026-05-10 20:00:00',100,'Plaza del Ayuntamiento, Toledo','TERMINADO',18,5,14.00,3),(5,'Ruta gastronómica Toledo','Tour por bares y restaurantes tradicionales','2026-06-25 13:00:00',150,'Plaza de Zocodover, Toledo','ACTIVO',15,4,20.00,4);
/*!40000 ALTER TABLE `visitas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-15 21:28:55
