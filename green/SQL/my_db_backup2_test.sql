-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: test
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
-- Table structure for table `comment_info`
--

DROP TABLE IF EXISTS `comment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_info` (
  `ci_seq` int NOT NULL AUTO_INCREMENT,
  `ci_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ci_mi_seq` int NOT NULL,
  `ci_pi_seq` int NOT NULL,
  `ci_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ci_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf16le;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_info`
--

LOCK TABLES `comment_info` WRITE;
/*!40000 ALTER TABLE `comment_info` DISABLE KEYS */;
INSERT INTO `comment_info` VALUES (1,'내일점심은',1,1,'2022-11-17 16:55:14'),(2,'오늘 저녁은',2,2,'2022-11-17 16:55:14'),(4,'ㅇㅇㅇㅇㅇ',4,4,'2022-11-17 16:55:14'),(5,'안녕하세요5',5,5,'2022-11-17 16:55:14'),(6,'안녕6',6,6,'2022-11-17 17:14:43');
/*!40000 ALTER TABLE `comment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_no` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL,
  `emp_jikgup` varchar(10) NOT NULL,
  `emp_fee` int NOT NULL,
  PRIMARY KEY (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'서용재','과장',8000),(2,'오경환','과장',6000),(3,'이재용','사장',15500),(4,'최현우','부장',9000),(5,'유윤선','대리',4700),(6,'이준호','사원',3800),(7,'한현희','과장',7700),(8,'유원미','차장',8200),(9,'함필규','과장',5700),(10,'권민규','이사',10500);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_info`
--

DROP TABLE IF EXISTS `member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_info` (
  `mi_seq` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) NOT NULL,
  `mi_pwd` varchar(128) NOT NULL,
  `mi_name` varchar(60) DEFAULT NULL,
  `mi_email` varchar(100) NOT NULL,
  `mi_birth` date NOT NULL,
  `mi_gen` int NOT NULL DEFAULT '0',
  `mi_address` varchar(255) DEFAULT NULL,
  `mi_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mi_status` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`mi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
INSERT INTO `member_info` VALUES (1,'user001','123456','곽두팔','data@service.com','2022-11-17',0,NULL,'2022-11-17 15:23:48',1),(2,'user002','123456','서팔광','data1@service.com','2022-11-17',0,NULL,'2022-11-17 15:27:11',1),(3,'user003','123456','김덕협','data2@service.com','2022-11-17',0,NULL,'2022-11-17 15:27:11',1),(4,'user004','123456','남궁협식','data3@service.com','2022-11-17',0,NULL,'2022-11-17 15:27:11',1),(5,'user005','123456','김협두','data4@service.com','2022-11-17',0,NULL,'2022-11-17 15:27:11',1),(6,'user006','123456','왕대협','data5@service.com','2022-11-17',0,NULL,'2022-11-17 15:27:11',1),(7,'user007','123456','여춘팔','data6@service.com','2022-11-17',0,NULL,'2022-11-17 15:27:11',1),(8,'user008','123456','황데이터','data7@service.com','2022-11-17',0,NULL,'2022-11-17 15:27:11',1);
/*!40000 ALTER TABLE `member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_info`
--

DROP TABLE IF EXISTS `post_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_info` (
  `pi_mi_seq` int NOT NULL AUTO_INCREMENT,
  `pi_seq` int DEFAULT NULL,
  `pi_title` varchar(255) NOT NULL,
  `pi_content` text NOT NULL,
  `pi_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pi_mod_dt` datetime DEFAULT NULL,
  `pi_status` int NOT NULL DEFAULT '0',
  `pi_category` int NOT NULL,
  `pi_view` int NOT NULL DEFAULT '0',
  `pi_like` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`pi_mi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_info`
--

LOCK TABLES `post_info` WRITE;
/*!40000 ALTER TABLE `post_info` DISABLE KEYS */;
INSERT INTO `post_info` VALUES (1,1,'글 제목1','글 내용입니다.1','2022-11-17 00:00:00',NULL,0,1,0,0),(2,2,'글 제목2','글 내용입니다.2','2022-11-17 00:00:00',NULL,0,3,0,0),(3,3,'글 제목3','글 내용입니다.3','2022-11-17 00:00:00',NULL,0,5,0,0),(4,4,'글 제목4','글 내용입니다.4','2022-11-17 00:00:00',NULL,0,4,0,0),(5,5,'글 제목5','글 내용입니다.5','2022-11-17 00:00:00',NULL,0,3,0,0),(6,6,'글 제목6','글 내용입니다.6','2022-11-17 00:00:00',NULL,0,2,0,0),(7,7,'글 제목7','글 내용입니다.7','2022-11-17 00:00:00',NULL,0,1,0,0),(8,8,'글 제목8','글 내용입니다.8','2022-11-17 00:00:00',NULL,0,2,0,0);
/*!40000 ALTER TABLE `post_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'test'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 17:58:50
