-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: school_db
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
-- Temporary view structure for view `score_summary`
--

DROP TABLE IF EXISTS `score_summary`;
/*!50001 DROP VIEW IF EXISTS `score_summary`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `score_summary` AS SELECT 
 1 AS `stu_name`,
 1 AS `sub_name`,
 1 AS `score_score`,
 1 AS `sub_credit`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `stu_no` int NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(50) NOT NULL,
  PRIMARY KEY (`stu_no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'최시진'),(2,'강승아'),(3,'정예현'),(4,'오승진'),(5,'임현은'),(6,'최서혁'),(7,'최유진'),(8,'최도유'),(9,'신하은'),(10,'박예진'),(11,'정도은'),(12,'정서은');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_score`
--

DROP TABLE IF EXISTS `student_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_score` (
  `score_no` int NOT NULL AUTO_INCREMENT,
  `score_stu_no` int NOT NULL,
  `score_sub_no` int NOT NULL,
  `score_score` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`score_no`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_score`
--

LOCK TABLES `student_score` WRITE;
/*!40000 ALTER TABLE `student_score` DISABLE KEYS */;
INSERT INTO `student_score` VALUES (1,1,1,95),(2,1,2,85),(3,1,3,87),(4,1,4,78),(5,1,5,77),(6,1,6,87),(7,2,1,85),(8,2,2,99),(9,2,3,68),(10,2,4,68),(11,2,5,61),(12,2,6,81),(13,3,1,73),(14,3,2,75),(15,3,3,97),(16,3,4,77),(17,3,5,67),(18,3,6,78),(19,4,1,91),(20,4,2,84),(21,4,3,77),(22,4,4,68),(23,4,5,97),(24,4,6,58),(25,5,1,75),(26,5,2,98),(27,5,3,99),(28,5,4,96),(29,5,5,91),(30,5,6,94);
/*!40000 ALTER TABLE `student_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `sub_no` int NOT NULL AUTO_INCREMENT,
  `sub_name` varchar(50) NOT NULL,
  `sub_credit` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`sub_no`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'객체지향 설계',3),(2,'알고리즘',3),(3,'형식언어론',3),(4,'컴퓨터 구조론',3),(5,'수치해석학',3),(6,'데이터 통신',3),(7,'데이터베이스',3),(8,'자바프로그램',3),(9,'운영체제',3),(10,'소프트웨어 공학',3),(11,'유닉스시스템',3),(12,'이산수학',3),(13,'디지털 설계',3),(14,'프로그래밍 언어론',3),(15,'파일구조론',3),(16,'자료구조론',3);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'school_db'
--

--
-- Final view structure for view `score_summary`
--

/*!50001 DROP VIEW IF EXISTS `score_summary`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `score_summary` AS select `b`.`stu_name` AS `stu_name`,`c`.`sub_name` AS `sub_name`,`a`.`score_score` AS `score_score`,`c`.`sub_credit` AS `sub_credit` from ((`student_score` `a` join `student` `b` on((`a`.`score_stu_no` = `b`.`stu_no`))) join `subject` `c` on((`a`.`score_sub_no` = `c`.`sub_no`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 17:58:49
