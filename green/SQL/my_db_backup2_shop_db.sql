-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: shop_db
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
  `b_seq` int NOT NULL AUTO_INCREMENT,
  `b_title` varchar(100) NOT NULL,
  `b_content` varchar(10000) NOT NULL,
  `b_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `b_author` int NOT NULL,
  PRIMARY KEY (`b_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_info`
--

LOCK TABLES `board_info` WRITE;
/*!40000 ALTER TABLE `board_info` DISABLE KEYS */;
INSERT INTO `board_info` VALUES (1,'글제목수정2','글내용수정','2022-11-18 13:07:15',1),(2,'글제목수정2','글내용수정','2022-11-18 14:31:41',1),(3,'글제목','글내용','2022-11-18 14:34:17',1),(4,'글제목','글내용','2022-11-18 14:34:17',1),(5,'글제목','글내용','2022-11-18 14:34:18',1),(6,'글제목','글내용','2022-11-18 14:34:18',1),(7,'글제목','글내용','2022-11-18 14:34:18',1),(8,'글제목','글내용','2022-11-18 14:34:18',1),(9,'글제목','글내용','2022-11-18 14:34:19',1),(10,'글제목','글내용','2022-11-18 14:34:19',1);
/*!40000 ALTER TABLE `board_info` ENABLE KEYS */;
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
  `mi_pwd` varchar(20) NOT NULL,
  `mi_name` varchar(20) NOT NULL,
  `mi_email` varchar(50) NOT NULL,
  `mi_gen` int NOT NULL,
  `mi_birth` int NOT NULL,
  `mi_grade` int DEFAULT '1',
  `mi_status` int DEFAULT '1',
  `mi_reg_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`mi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
INSERT INTO `member_info` VALUES (1,'user01','1234','김현식','user01@service.com',0,1984,1,2,'2021-05-01 00:00:00'),(2,'user02','1234','표종옥','user02@service.com',1,1983,1,2,'2021-11-10 00:00:00'),(3,'user03','1234','강승혜','user03@service.com',1,2001,3,2,'2021-03-01 00:00:00'),(5,'user05','1234','이혜주','user05@service.com',1,2003,3,2,'2019-01-25 00:00:00'),(9,'user09','1234','박선우','user09@service.com',1,1973,3,2,'2017-11-24 00:00:00'),(10,'user10','1234','김현우','user00@service.com',0,1977,1,3,'2018-03-23 00:00:00'),(11,'user11','1234','이정민','user11@service.com',1,1967,1,3,'2018-09-06 00:00:00'),(12,'user12','1234','김연준','user12@service.com',0,1988,3,2,'2018-05-07 00:00:00'),(13,'user13','1234','박세영','user13@service.com',1,1989,3,2,'2017-06-16 00:00:00'),(14,'user14','1234','표민정','user14@service.com',1,1995,3,2,'2018-09-09 00:00:00'),(15,'user15','1234','송홍재','user15@service.com',0,1999,3,2,'2018-09-11 00:00:00'),(16,'user16','1234','배은용','user16@service.com',0,1956,1,3,'2021-02-03 00:00:00'),(17,'user17','1234','이은비','user17@service.com',1,1977,1,2,'2021-11-09 00:00:00'),(18,'user19','1234','최이슬','user19@service.com',1,1978,1,2,'2021-11-10 00:00:00'),(19,'user18','1234','권버들','user18@service.com',0,1988,1,2,'2021-10-06 00:00:00'),(20,'user20','1234','김우람','user20@service.com',0,1989,1,2,'2021-09-27 00:00:00'),(21,'admin','1234','관리자','admin@service.com',0,1900,4,2,'2015-01-01 00:00:00');
/*!40000 ALTER TABLE `member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_info` (
  `pi_seq` int NOT NULL AUTO_INCREMENT,
  `pi_name` varchar(255) NOT NULL,
  `pi_sub` varchar(255) DEFAULT NULL,
  `pi_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pi_div` int NOT NULL,
  `pi_price` int DEFAULT '0',
  `pi_stock` int DEFAULT '0',
  `pi_like` int DEFAULT '0',
  PRIMARY KEY (`pi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` VALUES (1,'노지햇감자 3kg','놓치지마세요! 21년 첫 수확 노지 햇감자','2022-11-18 12:57:17',1,6680,100,0),(2,'햇 양파 1.8Kg','믿고 먹을 수 있는 상품을 합리적인 가격에','2022-11-18 12:57:17',1,3500,100,0),(4,'다짐육 200g','100g당 판매가 3,750원','2022-11-18 12:57:17',2,6750,100,0),(5,'닭 안심살','무항생제 친환경 닭고기 닭 안심살','2022-11-18 12:57:17',2,4100,100,0),(6,'감동란 6구','맛도, 영양도 감동 !','2022-11-18 12:57:17',2,4800,100,0),(9,'크림치즈','부드럽고 담백한 인기 크림치즈','2022-11-18 12:57:17',4,8900,100,0),(10,'통밀 견과스틱','고소한 맛, 다채로운 식감','2022-11-18 12:57:17',4,5000,100,0),(11,'해양심층수','매일 마시는 청정 바다의 심층수','2022-11-18 14:28:05',3,5600,100,0);
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `u_seq` int NOT NULL AUTO_INCREMENT,
  `u_id` varchar(20) NOT NULL,
  `u_pwd` varchar(20) NOT NULL,
  `u_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`u_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `ui_seq` int NOT NULL AUTO_INCREMENT,
  `ui_id` varchar(20) NOT NULL,
  `ui_pwd` varchar(64) NOT NULL,
  `ui_name` varchar(50) NOT NULL,
  `ui_birth` date NOT NULL,
  `ui_gen` int NOT NULL DEFAULT '0',
  `ui_address` varchar(255) DEFAULT NULL,
  `ui_phone` varchar(20) NOT NULL,
  `ui_email` varchar(100) DEFAULT NULL,
  `ui_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ui_grade` int NOT NULL DEFAULT '1',
  `ui_status` int NOT NULL DEFAULT '1',
  `ui_access_level` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`ui_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'user001','123456','사용자1','2022-10-10',1,'대구광역시 중구','010-1111-1111','sss@dddd.com','2022-11-18 10:01:55',1,1,1),(2,'user002','123456','사용자2','2022-10-10',1,'대구광역시 중구','010-2222-2222','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(3,'user003','123456','사용자3','2022-10-10',1,'대구광역시 중구','010-3333-3333','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(4,'user004','123456','사용자4','2022-10-10',1,'대구광역시 중구','010-4444-4444','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(5,'user005','123456','사용자5','2022-10-10',1,'대구광역시 중구','010-5555-5555','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(6,'user006','123456','사용자6','2022-10-10',1,'대구광역시 중구','010-6666-6666','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(7,'user007','123456','사용자7','2022-10-10',1,'대구광역시 중구','010-7777-7777','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(8,'user008','123456','사용자8','2022-10-10',1,'대구광역시 중구','010-8888-8888','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(9,'user009','123456','사용자9','2022-10-10',1,'대구광역시 중구','010-9999-9999','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(10,'user010','123456','사용자10','2022-10-10',1,'대구광역시 중구','010-1010-1010','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(11,'user011','123456','사용자11','2022-10-10',1,'대구광역시 중구','010-0011-0011','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(12,'user012','123456','사용자12','2022-10-10',1,'대구광역시 중구','010-0012-0012','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(13,'user013','123456','사용자13','2022-10-10',1,'대구광역시 중구','010-0013-0013','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(14,'user014','123456','사용자14','2022-10-10',1,'대구광역시 중구','010-0014-0014','sss@dddd.com','2022-11-18 10:09:36',1,1,1),(15,'user015','123456','사용자15','2022-10-10',1,'대구광역시 중구','010-0015-0015','sss@dddd.com','2022-11-18 10:09:36',1,1,1);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'shop_db'
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
