-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: board_db
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board_info`
--

DROP TABLE IF EXISTS `board_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board_info` (
  `bi_no` int NOT NULL AUTO_INCREMENT,
  `bi_title` varchar(100) NOT NULL,
  `bi_content` text NOT NULL,
  `bi_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bi_status` int DEFAULT '0',
  `bi_mi_no` int NOT NULL,
  PRIMARY KEY (`bi_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_info`
--

LOCK TABLES `board_info` WRITE;
/*!40000 ALTER TABLE `board_info` DISABLE KEYS */;
INSERT INTO `board_info` VALUES (1,'글제목1','글내용1','2022-11-18 17:31:44',0,1),(2,'글제목2','글내용2','2022-11-18 17:31:44',0,2),(3,'글제목3','글내용3','2022-11-18 17:31:44',0,3),(4,'글제목4','글내용4','2022-11-18 17:31:44',0,4),(5,'글제목5','글내용5','2022-11-18 17:31:44',0,5),(6,'글제목6','글내용6','2022-11-18 17:31:44',0,6),(7,'글제목7','글내용7','2022-11-18 17:31:44',0,7),(8,'글제목8','글내용8','2022-11-18 17:31:44',0,8),(9,'글제목9','글내용9','2022-11-18 17:31:44',0,9),(10,'글제목10','글내용10','2022-11-18 17:31:44',0,10);
/*!40000 ALTER TABLE `board_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_info`
--

DROP TABLE IF EXISTS `member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_info` (
  `mi_no` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(50) NOT NULL,
  `mi_pwd` varchar(50) NOT NULL,
  `mi_name` varchar(50) NOT NULL,
  `mi_email` varchar(50) NOT NULL,
  `mi_gen` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`mi_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
INSERT INTO `member_info` VALUES (1,'user001','pwd001','이름1','user001@data.com',0),(2,'user002','pwd002','이름2','user002@data.com',0),(3,'user003','pwd003','이름3','user003@data.com',0),(4,'user004','pwd004','이름4','user004@data.com',0),(5,'user005','pwd005','이름5','user005@data.com',0),(6,'user006','pwd006','이름6','user006@data.com',0),(7,'user007','pwd007','이름7','user007@data.com',0),(8,'user008','pwd008','이름8','user008@data.com',0),(9,'user009','pwd009','이름9','user009@data.com',0),(10,'user010','pwd010','이름10','user010@data.com',0);
/*!40000 ALTER TABLE `member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'board_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 17:57:10
