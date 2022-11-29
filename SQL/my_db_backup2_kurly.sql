-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: kurly
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
-- Table structure for table `category_info`
--

-- create database kurly;

DROP TABLE IF EXISTS `category_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_info` (
  `cate_seq` int NOT NULL AUTO_INCREMENT,
  `cate_parent_seq` int DEFAULT NULL,
  `cate_name` varchar(20) NOT NULL,
  PRIMARY KEY (`cate_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_info`
--

LOCK TABLES `category_info` WRITE;
/*!40000 ALTER TABLE `category_info` DISABLE KEYS */;
INSERT INTO `category_info` VALUES (1,NULL,'정육·계란'),(2,1,'수입산 소고기'),(3,NULL,'베이커리·치즈·델리'),(4,3,'식빵·빵류'),(5,NULL,'간식·과자·떡'),(6,5,'아이스크림'),(7,1,'돼지고기'),(8,NULL,'면·양념·오일'),(9,8,'파스타·면류');
/*!40000 ALTER TABLE `category_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_grade_info`
--

DROP TABLE IF EXISTS `member_grade_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_grade_info` (
  `mgi_seq` int NOT NULL AUTO_INCREMENT,
  `mgi_name` varchar(20) NOT NULL,
  `mgi_prev_payment` int DEFAULT '0',
  `mgi_point_rate` double NOT NULL DEFAULT '0.001',
  `mgi_benefit` int DEFAULT '0',
  `mgi_max_point` int DEFAULT '0',
  `mgi_review_point_rate` int DEFAULT '0',
  `mgi_gift` int DEFAULT '0',
  PRIMARY KEY (`mgi_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_grade_info`
--

LOCK TABLES `member_grade_info` WRITE;
/*!40000 ALTER TABLE `member_grade_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_grade_info` ENABLE KEYS */;
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
  `mi_pwd` varchar(64) NOT NULL,
  `mi_name` varchar(100) NOT NULL,
  `mi_nickname` varchar(20) DEFAULT NULL,
  `mi_birth` date NOT NULL,
  `mi_gen` int NOT NULL DEFAULT '0',
  `mi_address` varchar(255) NOT NULL,
  `mi_phone` varchar(20) NOT NULL,
  `mi_email` varchar(100) NOT NULL,
  `mi_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mi_status` int NOT NULL DEFAULT '1',
  `mi_grade` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`mi_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menufacturer_info`
--

DROP TABLE IF EXISTS `menufacturer_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menufacturer_info` (
  `manu_seq` int NOT NULL AUTO_INCREMENT,
  `manu_name` varchar(255) NOT NULL,
  PRIMARY KEY (`manu_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menufacturer_info`
--

LOCK TABLES `menufacturer_info` WRITE;
/*!40000 ALTER TABLE `menufacturer_info` DISABLE KEYS */;
INSERT INTO `menufacturer_info` VALUES (1,'perfect Cut'),(2,'이상복 명과'),(3,'상하목장'),(4,'근대골목단팥빵'),(5,'존쿡 델리미트'),(6,'전주 베테랑');
/*!40000 ALTER TABLE `menufacturer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `product_all_info_view`
--

DROP TABLE IF EXISTS `product_all_info_view`;
/*!50001 DROP VIEW IF EXISTS `product_all_info_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `product_all_info_view` AS SELECT 
 1 AS `pbi_seq`,
 1 AS `pbi_name`,
 1 AS `pbi_sub`,
 1 AS `pbi_price`,
 1 AS `pbi_discount_rate`,
 1 AS `pbi_delivery`,
 1 AS `pbi_sell_unit`,
 1 AS `pbi_pack_type`,
 1 AS `pbi_notice`,
 1 AS `pbi_cate_seq`,
 1 AS `pbi_pdi_seq`,
 1 AS `pbi_stock`,
 1 AS `pbi_date`,
 1 AS `pbi_manu_seq`,
 1 AS `pbi_si_seq`,
 1 AS `cate_name`,
 1 AS `pdi_seq`,
 1 AS `pdi_weight`,
 1 AS `pdi_prod_origin`,
 1 AS `pdi_distribute_dats`,
 1 AS `pdi_importor`,
 1 AS `pdi_laws`,
 1 AS `pdi_prod_comp`,
 1 AS `pdi_storage`,
 1 AS `pdi_make_dt`,
 1 AS `si_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `product_basic_info`
--

DROP TABLE IF EXISTS `product_basic_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_basic_info` (
  `pbi_seq` int NOT NULL AUTO_INCREMENT,
  `pbi_name` varchar(255) NOT NULL,
  `pbi_sub` varchar(255) DEFAULT NULL,
  `pbi_price` int NOT NULL DEFAULT '0',
  `pbi_discount_rate` double NOT NULL DEFAULT '0',
  `pbi_delivery` int NOT NULL DEFAULT '1',
  `pbi_sell_unit` varchar(20) NOT NULL,
  `pbi_pack_type` varchar(20) NOT NULL,
  `pbi_notice` varchar(255) DEFAULT NULL,
  `pbi_cate_seq` int NOT NULL,
  `pbi_pdi_seq` int NOT NULL,
  `pbi_stock` int NOT NULL DEFAULT '0',
  `pbi_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pbi_manu_seq` int NOT NULL,
  `pbi_si_seq` int NOT NULL,
  PRIMARY KEY (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_basic_info`
--

LOCK TABLES `product_basic_info` WRITE;
/*!40000 ALTER TABLE `product_basic_info` DISABLE KEYS */;
INSERT INTO `product_basic_info` VALUES (1,'우대꽃갈비 스테이크 600g/최대혜택가 : 23,740','스테이크에 딱 알맞은 두께로 정형',39900,0.3,2,'냉동','1팩','해당 제품은 냉동 제품입니다;정육 상품의 특성상 3% 내외의 중량차이가 발생할 수 있습니다;이미 냉동된 바 있으니 해동된 제품은 재냉동시키지 마십시오',2,1,100,'2022-11-25 14:58:08',1,1),(2,'찰보리빵 30개입','경주의 보름달을 닮은 빵',27000,0,2,'냉동(종이포장)','1개',NULL,4,2,100,'2022-11-25 15:20:32',2,1),(3,'얼려먹는 아이스주스 망고','유기농 망고로 만든 간식',6480,0,2,'상온(종이포장)','1박스',NULL,6,3,100,'2022-11-25 15:20:32',3,1),(4,'치즈라떼번','달콤한 내음으로 사로잡는 빵',3300,0,2,'냉장(종이포장)','1개',NULL,4,4,100,'2022-11-25 15:20:32',4,1),(5,'사각잠봉 400g','돼지고기를 통째로 사용한',9980,0.08,2,'냉동(종이포장)','1개',NULL,7,5,100,'2022-11-25 15:20:32',5,1),(6,'칼국수','베테랑의 대표메뉴를 집에서',5800,0,2,'냉동(종이포장)','1팩',NULL,9,6,100,'2022-11-25 15:20:32',6,1);
/*!40000 ALTER TABLE `product_basic_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_buy_option`
--

DROP TABLE IF EXISTS `product_buy_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_buy_option` (
  `pbo_seq` int NOT NULL AUTO_INCREMENT,
  `pbo_title` varchar(255) NOT NULL,
  `pbo_price` int NOT NULL DEFAULT '0',
  `pbo_stock` int NOT NULL DEFAULT '0',
  `pbo_pbi_seq` int NOT NULL,
  PRIMARY KEY (`pbo_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_buy_option`
--

LOCK TABLES `product_buy_option` WRITE;
/*!40000 ALTER TABLE `product_buy_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_buy_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_description`
--

DROP TABLE IF EXISTS `product_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_description` (
  `pd_seq` int NOT NULL AUTO_INCREMENT,
  `pd_type` int NOT NULL DEFAULT '1',
  `pd_content` text NOT NULL,
  `pd_pbi_seq` int NOT NULL,
  PRIMARY KEY (`pd_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_description`
--

LOCK TABLES `product_description` WRITE;
/*!40000 ALTER TABLE `product_description` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail_info`
--

DROP TABLE IF EXISTS `product_detail_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_detail_info` (
  `pdi_seq` int NOT NULL AUTO_INCREMENT,
  `pdi_weight` varchar(10) DEFAULT NULL,
  `pdi_prod_origin` varchar(50) DEFAULT NULL,
  `pdi_distribute_dats` int DEFAULT NULL,
  `pdi_importor` varchar(100) DEFAULT NULL,
  `pdi_laws` varchar(255) DEFAULT NULL,
  `pdi_prod_comp` varchar(100) DEFAULT NULL,
  `pdi_storage` varchar(100) DEFAULT NULL,
  `pdi_make_dt` datetime NOT NULL,
  PRIMARY KEY (`pdi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail_info`
--

LOCK TABLES `product_detail_info` WRITE;
/*!40000 ALTER TABLE `product_detail_info` DISABLE KEYS */;
INSERT INTO `product_detail_info` VALUES (1,'600g','미국산',155,NULL,NULL,NULL,NULL,'2022-11-25 00:00:00'),(2,'20g X 30개입',NULL,60,NULL,NULL,NULL,NULL,'2022-11-25 00:00:00'),(3,'85ml X 6개입',NULL,45,NULL,NULL,NULL,NULL,'2022-11-25 00:00:00'),(4,'105g',NULL,2,NULL,NULL,NULL,NULL,'2022-11-25 00:00:00'),(5,'400g',NULL,NULL,NULL,NULL,NULL,NULL,'2022-11-25 00:00:00'),(6,'196.5g',NULL,165,NULL,NULL,NULL,NULL,'2022-11-25 00:00:00');
/*!40000 ALTER TABLE `product_detail_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `pimg_seq` int NOT NULL AUTO_INCREMENT,
  `pimg_file_name` varchar(255) NOT NULL,
  `pimg_pbi_seq` int NOT NULL,
  PRIMARY KEY (`pimg_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_qna`
--

DROP TABLE IF EXISTS `product_qna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_qna` (
  `qna_seq` int NOT NULL AUTO_INCREMENT,
  `qna_title` varchar(255) NOT NULL,
  `qna_content` text NOT NULL,
  `qna_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `qna_pbi_seq` int NOT NULL,
  `qna_mi_seq` int NOT NULL,
  `qna_answer` text,
  `qna_answer_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`qna_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_qna`
--

LOCK TABLES `product_qna` WRITE;
/*!40000 ALTER TABLE `product_qna` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_qna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `product_summary_view`
--

DROP TABLE IF EXISTS `product_summary_view`;
/*!50001 DROP VIEW IF EXISTS `product_summary_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `product_summary_view` AS SELECT 
 1 AS `pbi_seq`,
 1 AS `pbi_name`,
 1 AS `pbi_sub`,
 1 AS `pbi_price`,
 1 AS `discount_percent`,
 1 AS `discounted`,
 1 AS `pbi_delivery`,
 1 AS `pbi_cate_seq`,
 1 AS `pbi_manu_seq`,
 1 AS `manu_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `review_answer_info`
--

DROP TABLE IF EXISTS `review_answer_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_answer_info` (
  `rai_seq` int NOT NULL AUTO_INCREMENT,
  `rai_content` text NOT NULL,
  `rai_ri_seq` int NOT NULL,
  `rai_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rai_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_answer_info`
--

LOCK TABLES `review_answer_info` WRITE;
/*!40000 ALTER TABLE `review_answer_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_answer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_image_info`
--

DROP TABLE IF EXISTS `review_image_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_image_info` (
  `rii_seq` int NOT NULL AUTO_INCREMENT,
  `rii_filename` varchar(255) NOT NULL,
  `rii_ri_seq` int NOT NULL,
  PRIMARY KEY (`rii_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_image_info`
--

LOCK TABLES `review_image_info` WRITE;
/*!40000 ALTER TABLE `review_image_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_image_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_info`
--

DROP TABLE IF EXISTS `review_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_info` (
  `ri_seq` int NOT NULL AUTO_INCREMENT,
  `ri_content` text NOT NULL,
  `ri_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ri_mi_seq` int NOT NULL,
  `ri_pbi_seq` int NOT NULL,
  PRIMARY KEY (`ri_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_info`
--

LOCK TABLES `review_info` WRITE;
/*!40000 ALTER TABLE `review_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_likes`
--

DROP TABLE IF EXISTS `review_likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_likes` (
  `rl_seq` int NOT NULL AUTO_INCREMENT,
  `rl_ri_seq` int NOT NULL,
  `rl_mi_seq` int NOT NULL,
  `rl_click` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`rl_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_likes`
--

LOCK TABLES `review_likes` WRITE;
/*!40000 ALTER TABLE `review_likes` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_info`
--

DROP TABLE IF EXISTS `store_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_info` (
  `si_seq` int NOT NULL AUTO_INCREMENT,
  `si_id` varchar(20) NOT NULL,
  `si_pwd` varchar(64) NOT NULL,
  `si_name` varchar(100) NOT NULL,
  `si_address` varchar(255) NOT NULL,
  `si_phone` varchar(20) NOT NULL,
  `si_business_no` varchar(20) NOT NULL,
  `si_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `si_status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`si_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_info`
--

LOCK TABLES `store_info` WRITE;
/*!40000 ALTER TABLE `store_info` DISABLE KEYS */;
INSERT INTO `store_info` VALUES (1,'shop_kurly','1234','컬리','서울특별시 강남구 테헤란로 133, 18층(역삼동)','070-7500-6098','261-81-23567','2022-11-25 14:44:29',0);
/*!40000 ALTER TABLE `store_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'kurly'
--

--
-- Final view structure for view `product_all_info_view`
--

/*!50001 DROP VIEW IF EXISTS `product_all_info_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `product_all_info_view` AS select `a`.`pbi_seq` AS `pbi_seq`,`a`.`pbi_name` AS `pbi_name`,`a`.`pbi_sub` AS `pbi_sub`,`a`.`pbi_price` AS `pbi_price`,`a`.`pbi_discount_rate` AS `pbi_discount_rate`,`a`.`pbi_delivery` AS `pbi_delivery`,`a`.`pbi_sell_unit` AS `pbi_sell_unit`,`a`.`pbi_pack_type` AS `pbi_pack_type`,`a`.`pbi_notice` AS `pbi_notice`,`a`.`pbi_cate_seq` AS `pbi_cate_seq`,`a`.`pbi_pdi_seq` AS `pbi_pdi_seq`,`a`.`pbi_stock` AS `pbi_stock`,`a`.`pbi_date` AS `pbi_date`,`a`.`pbi_manu_seq` AS `pbi_manu_seq`,`a`.`pbi_si_seq` AS `pbi_si_seq`,`b`.`cate_name` AS `cate_name`,`c`.`pdi_seq` AS `pdi_seq`,`c`.`pdi_weight` AS `pdi_weight`,`c`.`pdi_prod_origin` AS `pdi_prod_origin`,`c`.`pdi_distribute_dats` AS `pdi_distribute_dats`,`c`.`pdi_importor` AS `pdi_importor`,`c`.`pdi_laws` AS `pdi_laws`,`c`.`pdi_prod_comp` AS `pdi_prod_comp`,`c`.`pdi_storage` AS `pdi_storage`,`c`.`pdi_make_dt` AS `pdi_make_dt`,`d`.`si_name` AS `si_name` from ((((`product_basic_info` `a` join `category_info` `b` on((`a`.`pbi_cate_seq` = `b`.`cate_seq`))) join `product_detail_info` `c` on((`a`.`pbi_pdi_seq` = `c`.`pdi_seq`))) join `store_info` `d` on((`a`.`pbi_si_seq` = `d`.`si_seq`))) join `menufacturer_info` `e` on((`a`.`pbi_manu_seq` = `e`.`manu_seq`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `product_summary_view`
--

/*!50001 DROP VIEW IF EXISTS `product_summary_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `product_summary_view` AS select `a`.`pbi_seq` AS `pbi_seq`,`a`.`pbi_name` AS `pbi_name`,`a`.`pbi_sub` AS `pbi_sub`,`a`.`pbi_price` AS `pbi_price`,(`a`.`pbi_discount_rate` * 100) AS `discount_percent`,(`a`.`pbi_price` * (1 - `a`.`pbi_discount_rate`)) AS `discounted`,`a`.`pbi_delivery` AS `pbi_delivery`,`a`.`pbi_cate_seq` AS `pbi_cate_seq`,`a`.`pbi_manu_seq` AS `pbi_manu_seq`,`b`.`manu_name` AS `manu_name` from (`product_basic_info` `a` join `menufacturer_info` `b` on((`a`.`pbi_manu_seq` = `b`.`manu_seq`))) */;
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
