CREATE DATABASE  IF NOT EXISTS `bd_eventos` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_eventos`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_eventos
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `even_id` int NOT NULL AUTO_INCREMENT,
  `even_nome` varchar(45) NOT NULL,
  `even_descricao` text NOT NULL,
  `even_dt_inicio` datetime NOT NULL,
  `even_dt_fim` datetime NOT NULL,
  `even_cep` varchar(45) NOT NULL,
  `even_bairro` varchar(45) NOT NULL,
  `even_rua` varchar(45) NOT NULL,
  `even_numero` int NOT NULL,
  `usuario_usua_id` int NOT NULL,
  PRIMARY KEY (`even_id`),
  KEY `fk_eventos_usuario1_idx` (`usuario_usua_id`),
  CONSTRAINT `fk_eventos_usuario1` FOREIGN KEY (`usuario_usua_id`) REFERENCES `usuario` (`usua_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,'Conferência de Tecnologia','Um evento sobre as novas tecnologias emergentes.','2024-09-01 09:00:00','2024-09-01 17:00:00','76820-243','Agenor de Carvalho','Avenida Guaporé',2881,1),(2,'teste','teste','2024-08-24 23:39:33','2024-08-24 23:39:33','76820-243','Agenor de Carvalho','Avenida Guaporé',2881,3),(3,'expovel','bruno e marrone','2024-08-21 21:00:00','2024-08-25 23:59:59','76801-806','Nacional','Beco Tupi',7306,6);
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-25 21:05:14
