-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: projetodb
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `visita`
--

DROP TABLE IF EXISTS `visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visita` (
  `cod_visita` int(11) NOT NULL,
  `monitor` varchar(25) DEFAULT NULL,
  `professor` varchar(50) DEFAULT NULL,
  `cod_trajeto` int(11) DEFAULT NULL,
  `data_visita` date DEFAULT NULL,
  `horario_visita` time DEFAULT NULL,
  `nro_alunos` int(11) DEFAULT NULL,
  `escola` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_visita`),
  KEY `monitor` (`monitor`),
  KEY `visita_ibfk_2` (`professor`),
  KEY `visita_ibfk_3` (`escola`),
  CONSTRAINT `visita_ibfk_1` FOREIGN KEY (`monitor`) REFERENCES `monitor` (`cpf`),
  CONSTRAINT `visita_ibfk_2` FOREIGN KEY (`professor`) REFERENCES `professor` (`cpf`),
  CONSTRAINT `visita_ibfk_3` FOREIGN KEY (`escola`) REFERENCES `escola` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita`
--

LOCK TABLES `visita` WRITE;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
INSERT INTO `visita` VALUES (1361,'49090451803','7894561237',3,'2019-06-25','12:17:32',27,6707),(2036,'16208700884','55555555555',1,'2019-01-15','21:30:00',59,6707),(6213,'16208700884','7894561237',2,'2019-12-20','11:25:00',24,6707);
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02  1:02:55
