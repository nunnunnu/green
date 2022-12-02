-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: haeji.coupangdb.kro.kr    Database: coupang_db
-- ------------------------------------------------------
-- Server version	8.0.31-0ubuntu0.20.04.2

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

DROP TABLE IF EXISTS `category_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_info` (
  `cate_seq` int NOT NULL AUTO_INCREMENT,
  `cate_parent_seq` int DEFAULT NULL,
  `cate_name` varchar(20) NOT NULL,
  PRIMARY KEY (`cate_seq`),
  KEY `category_info_FK` (`cate_parent_seq`),
  CONSTRAINT `category_info_FK` FOREIGN KEY (`cate_parent_seq`) REFERENCES `category_info` (`cate_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_info`
--

LOCK TABLES `category_info` WRITE;
/*!40000 ALTER TABLE `category_info` DISABLE KEYS */;
INSERT INTO `category_info` VALUES (1,NULL,'패션의류/잡화'),(2,NULL,'뷰티'),(3,NULL,'출산/유아동'),(4,NULL,'식품'),(5,NULL,'주방용품'),(6,NULL,'생활용품'),(7,NULL,'홈인테리어'),(8,NULL,'가전디지털'),(9,NULL,'스포츠/레저'),(10,NULL,'자동차용품'),(11,NULL,'도서/음반/DVD'),(12,NULL,'완구/취미'),(13,NULL,'문구/오피스'),(14,NULL,'반려동물용품'),(15,NULL,'헬스/건강식품');
/*!40000 ALTER TABLE `category_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupang_cart`
--

DROP TABLE IF EXISTS `coupang_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupang_cart` (
  `cc_seq` int NOT NULL AUTO_INCREMENT,
  `cc_mi_seq` int NOT NULL,
  `cc_pbi_seq` int NOT NULL,
  `cc_count` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`cc_seq`),
  KEY `coupang_cart_FK` (`cc_mi_seq`),
  KEY `coupang_cart_FK_1` (`cc_pbi_seq`),
  CONSTRAINT `coupang_cart_FK` FOREIGN KEY (`cc_mi_seq`) REFERENCES `member_info` (`mi_seq`),
  CONSTRAINT `coupang_cart_FK_1` FOREIGN KEY (`cc_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupang_cart`
--

LOCK TABLES `coupang_cart` WRITE;
/*!40000 ALTER TABLE `coupang_cart` DISABLE KEYS */;
INSERT INTO `coupang_cart` VALUES (1,1,2,1),(2,1,5,3),(3,1,11,1),(4,12,6,1),(5,12,8,1);
/*!40000 ALTER TABLE `coupang_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupang_explain`
--

DROP TABLE IF EXISTS `coupang_explain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupang_explain` (
  `ce_seq` int NOT NULL AUTO_INCREMENT,
  `ce_cate` int NOT NULL,
  `ce_view` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ce_pbi_seq` int NOT NULL,
  PRIMARY KEY (`ce_seq`),
  KEY `ce_pbi_seq` (`ce_pbi_seq`),
  CONSTRAINT `coupang_explain_ibfk_1` FOREIGN KEY (`ce_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`),
  CONSTRAINT `coupang_explain_ibfk_2` FOREIGN KEY (`ce_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupang_explain`
--

LOCK TABLES `coupang_explain` WRITE;
/*!40000 ALTER TABLE `coupang_explain` DISABLE KEYS */;
INSERT INTO `coupang_explain` VALUES (1,1,'texp.jpg',1),(2,1,'pantexp.jpg',2),(3,1,'beautyexp.jpg',11),(4,1,'babyexp.jpg',16),(5,1,'baby2exp.jpg',17),(6,1,'img18',18),(7,1,'img19',19),(8,1,'img28',28),(9,1,'img29',29),(10,1,'img33',33),(11,1,'img34',34),(12,1,'img37',35),(13,1,'img38',36),(14,1,'image20',20),(15,1,'imgae21',21),(16,1,'image22',22),(17,1,'image23',23),(18,1,'image24',24),(19,1,'image25',25),(20,1,'image26',26),(21,1,'image27',27);
/*!40000 ALTER TABLE `coupang_explain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupang_review`
--

DROP TABLE IF EXISTS `coupang_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupang_review` (
  `cr_seq` int NOT NULL AUTO_INCREMENT,
  `cr_mi_seq` int NOT NULL,
  `cr_score` int NOT NULL,
  `cr_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cr_option` int DEFAULT NULL,
  `cr_title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cr_view` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `cr_pbi_seq` int NOT NULL,
  PRIMARY KEY (`cr_seq`),
  KEY `coupang_review_FK` (`cr_option`),
  KEY `cr_mi_seq` (`cr_mi_seq`),
  KEY `cr_pbi_seq` (`cr_pbi_seq`),
  CONSTRAINT `coupang_review_FK` FOREIGN KEY (`cr_option`) REFERENCES `product_buy_option` (`pbo_seq`),
  CONSTRAINT `coupang_review_ibfk_1` FOREIGN KEY (`cr_mi_seq`) REFERENCES `member_info` (`mi_seq`),
  CONSTRAINT `coupang_review_ibfk_2` FOREIGN KEY (`cr_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupang_review`
--

LOCK TABLES `coupang_review` WRITE;
/*!40000 ALTER TABLE `coupang_review` DISABLE KEYS */;
INSERT INTO `coupang_review` VALUES (1,1,5,'2022-11-30 17:26:58',3,'너무잘샀어요 운동할때도 평소에도 잘 입을것같아요',NULL,3),(3,6,5,'2022-11-30 17:50:19',NULL,'**눈알샷 무서움주의','한달에 한번씩 속눈썸펌하고있는데 속눈썹펌하고 마스카라하면 안좋다는얘기를들어서..영양제를발라고면어떨까하고 구매했는데 엄청 쳐발쳐발했음에도 티가별로안나네요ㅜㅜ',7),(4,4,5,'2022-11-30 17:50:19',NULL,NULL,'마스카라보다 영양제에 더 가까워요ㅋ',7),(5,13,4,'2022-11-30 17:59:07',10,'제품은 엄청 좋아요','유분기번들거리는화장을 좋아하는데 톤업이 자연스럽게되고 화사해지니 너무 만족이에요.',11),(6,20,4,'2022-11-30 17:59:07',9,'은은한 광으로 가볍고 마스크에 일도 안묻는ㅋ','광고와 같이 사용시 투명에 가깝네요 사용해보니 붉은기는 잡아줍니다. 막 하해지거나하진안치만...보송보송하니 티도 안나고 좋아요',11),(7,5,5,'2022-11-30 18:00:21',NULL,'레이저 좋네요','pc에 연결해서 사용중입니다\r\n\r\n게이밍모드가 있어서 그런지 확실히 지연되는 느낌은 못받아요\r\n\r\n다른 블루투스 이어폰들은 유독 pc랑 연결하면 반응이 느렸는데\r\n\r\n레이저 크롬 덕분에 정말 편하게 사용중입니다',2),(8,10,3,'2022-11-30 18:00:56',NULL,'괜찮네요','게이밍 이어폰으로 명성이있어 구매했습니다.\r\n1. 디자인은 맘에 듬니다\r\n2. 유닛이 미끄러워 꺼내기가 어렵네요\r\n3. 이정도 출고가에 무선충전이 안되네요\r\n4. 게이밍 모드를 사용하면 저지연모드가 맘에드네요\r\n5. 노이즈캔슬링은 보통인데 조용한데서 그냥 노캔만 켜면 노이즈가 끼네요\r\n6. 5달전 리뷰에서 21년 5월 제품을 받았다고 봤는데.\r\n22년 10월인데 아직도 21년 5월 재고품을 주시네요 아쉽네요\r\n7. 유닛이 무겁네요',2),(9,8,3,'2022-11-30 18:01:55',NULL,'과한 어그로를 피하기 위해led감성은 밝기 30%로!','LED가 너무 어그로라 LED는 30퍼정도로 해놓습니다.\r\n버즈와 비교했더니 저음에 하이햇사운드가 좀 묻힙니다.\r\n50퍼 할인할 때 사서 겁나 가성비에 이득이라 불만은 없습니다.\r\npc에 연결해서 씁니다. 지연률이 없습니다. 게임에 최적이더군요.\r\n노이즈캔슬링 기능도 있어서 좋습니다.\r\n5점만점 4점입니다 이유는 LED 때문입니다.',2),(10,8,5,'2022-11-30 18:43:05',11,'얇고 뽀송뽀송합니다','아기가 3박4일 응가를 한번에할때가있는데 하기스 2단계가 다 커버해줬습니다',16),(11,16,4,'2022-11-30 18:43:05',12,'저렴, 발진도 없음, 많이움직이면 샘','이미 재구매 여러번 했고 활동성이 많이질때까지는 재구매할거에요',16),(12,20,5,'2022-12-01 09:12:48',NULL,'좋아용','울애기 소근육발달하라고 서줬습니다.',17),(13,17,5,'2022-12-01 09:12:48',NULL,'가성비 최고❤','❤❤가성비 최고의 장난김이예요. 진짜추천합니다❤❤',17),(14,1,5,'2022-12-01 09:48:14',NULL,'전에거보다 훨씬 음질이 짱입니다!!','전에는 버즈프로를 사용하고 있었는데요.\r\n전에는 제 귀에 큰 감이 없지 않아 있었는데\r\n확실히 이어버드 크기가 작아져서 그런지\r\n착용감이 더 좋아졌어요!!',4),(15,9,5,'2022-12-01 09:48:51',NULL,'성능좋고~ 디자인 맘에들어요♡','무광인듯 고급스러운 느낌에~\r\n디자인도 깔끔해요^^\r\n아들이 원하는 스타일이라 시험잘 본 선물로 줬는데 너무 좋아합니다~ㅎㅎㅎ',4),(16,13,5,'2022-12-01 09:49:38',NULL,'만족합니다.','중국산 QCY 쓰다가 음질도 떨어지고 버즈2랑 고민하다 이왕이면 점 더 나은걸로해서 버즈2프로 선택했는데 기존 쓰던게 워낙 구닥다리라 그런지 신세계를 경험합니다.',4),(17,20,5,'2022-12-01 09:57:23',NULL,'아이 생일선물로~','초3딸 생일선물로 사줬어요.\r\n아이가 롱보드 사달라기에\r\n한번도 타본적 없어서 롱보드는 힘들것 같아서 며칠을 비교하며 상품평 확인하며 고른 제품이예요.\r\n가격대비 내구성도 튼튼하고 디자인도 예뻐요.\r\n완제품으로 오기에 조립이나 그런 번거로움도 없고 튼튼해요.\r\n초보 입문용으로 괜찮은것 같아요.\r\n크기도 적당해서 초등생이 타기에도 사이즈 적당한것 같아요. 저도 타봤는데 재밌네요^^',5),(18,3,5,'2022-12-01 09:57:46',NULL,'튼튼해보이고 색상도 맘에 듭니다','큼직하고 튼튼해 보이긴 한데\r\n제가 보드에 대해 잘 몰라 잘 만들어진 제품인지는 잘 모르겠어요^^;\r\n\r\n색상이나 크기는 맘에 들고요\r\n\r\n잘 굴러갑니다..단지 보도 블럭에서 잠시 탔는데 어찌나 소리가 요란스럽던지...ㅠ\r\n\r\n바퀴가 원래 요만한 사이즈인건지...좀 컸더라면 더 안정적으로 보일거 같네요\r\n\r\n올라탔을 때.흔들림이 있는건 정상인거지요?ㅋ\r\n\r\n저렴한거니 크게 욕심 안부리고\r\n고장 안나고 안전하게 잘 굴러가기만 바랄뿐입니다~..',5),(19,17,4,'2022-12-01 09:58:27',NULL,'전문적으로 탈 것이 아니라면 충분하다','보드에 관심이 생겨서 여러가지 알아보다가 오래 타지는 않을거같아서 그냥 저렴하고 리뷰가 제일 좋은거 샀는데 일단 포장 상태는 좋았어요! 도착하자마자 올라타봤는데 바퀴도 잘 굴러가고요 옆으로 기우는?것도 잘 됐어요 보드를 전문적으로 탈 것이 아니라면 충분히 살만하다고 생각합니다! 좋은 상품 빠른배송 감사드려요~^^',5),(20,9,5,'2022-12-01 10:03:00',NULL,'가성비 최고인듯.','라운딩전 상품평:\r\n라운딩이 내일이라 필드에서 사용해 보지 않았지만 집에서 간단하게 테스트 해 보니 좋은것 같아요. 라운딩 후에 추가 상품평 올릴겠습니다.\r\n\r\n라운딩 후 :\r\n라운딩 나가서 사용 해 보니 가격 대비 성능 짱 입니다.\r\n거리 측정도 정확하고 빠르네요.',6),(21,14,5,'2022-12-01 10:04:40',NULL,'만족합니다.','골린이지만. 매번. 거리물어보기 눈치보여서. 골프워치와 고민하다가 구매햇습니다. 필드나가보니. 캐디거리와 비교해보니 거리 정확하면서. 빠르게 측정되서 좋네요.',6),(22,5,5,'2022-12-01 10:06:14',NULL,'최곱니다','가성비 짱 심플 그자체\r\n테스트갑니다\r\n모든분들 즐골하세요',6),(23,3,5,'2022-12-01 10:10:52',NULL,NULL,NULL,7),(24,7,5,'2022-12-01 10:12:40',9,'이거 진짜 괜찮음','얇게 얹어진 것에 비해 출근 후 시간이 꽤 플렀음에도 탄탄하게 잘 유지 중 만족하므로 앞으로 이것으로 갈아탈 예정',11),(25,11,5,'2022-12-01 10:13:04',NULL,'순정가로바 구입했는데 설치도 쉽고 야무진것 같아서 만족',NULL,8),(26,6,5,'2022-12-01 10:13:24',NULL,NULL,NULL,8),(27,2,5,'2022-12-01 10:13:40',NULL,NULL,NULL,8),(28,9,4,'2022-12-01 10:14:42',12,'자주 갈아줘야 하는 아기에게 완전 딱!','가격이 저렴해서 자주 갈아주기 좋고 예쁘고 발진이 생기지않으나 많은 양의 소면과 움직임은 감당 못해서 새기도 함',16),(29,6,5,'2022-12-01 10:17:10',NULL,'공부도 되고, 놀이도 되고!! 일석이조!!','마침 과일, 야채 등등 먹는 사물 알려주고 있었는데 놀이도 하면서 공부도하는 놀이가 되니 너무 좋아요',17),(30,3,3,'2022-12-01 10:18:42',NULL,'보류','다른 후기에 덜렁거려서 불안하단 글을 봤는데 실제로 그러네요\r\n일단 써봐야 알겠지만 분안불안함\r\n떨어질지는 써봐야 알듯 하겠지만\r\n잘보이고 쓸만 하네요 떨어지지 불안 하지만 그것만 아니면 괜찬을듯 하네요',9),(31,19,5,'2022-12-01 10:19:18',NULL,'차가 작아서 사각지대가 더더더더','큰차 탈때는 차가 커서 사각지대가 당연 하다 생각 해는데..\r\n작은 차는.. 차가 작으니 다 보일꺼라 생각 ??\r\n차가 작으니 더 안보이고 갑갑 해서 보조미러 달아보아요',9),(32,12,4,'2022-12-01 10:19:47',NULL,'고정핀이 완벽하게 고정이 안되서 불안한데 좋은지는 잘','운전하다가 사이드미러의 사각지대가 있어서 사고날뻔한적이 있어서 구매하게 되었어요. 이 제품이 상품평이 좋아서 구매해봤는데 제가 고정을 잘 못하는건지 100%로 고정이 안되고 고정핀이 자꾸 미끄러지네요;; 문제는 없는데 먼가 불안해요. 그리고 위에 로고가 너무 시강.',9),(33,11,5,'2022-12-01 10:46:13',NULL,'자바스크립트 입문자 딥 추천!','자바스크립트 공부를 하는 중에 좀 더 자세한 책을 원하다 사게되었는데 페이지마다 자세한 설명과 기초~중급자 까지 원하는 방향으로 공부하기 좋은 책 같아요 필수로 한권 씩 추천!',12),(35,3,5,'2022-12-01 10:47:22',NULL,'기본 개념 공부하기 좋은 책','자바스크립트 공부를 하는 중에 좀 더 자세한 책을 원하다 사게되었는데 페이지마다 자세한 설명과 기초~중급자 까지 원하는 방향으로 공부하기 좋은 책 같아요 필수로 한권 씩 추천!',12),(36,1,1,'2022-12-01 10:47:46',1,'비계실화??','수육에 비계가 어느정도 있어야 부들부들 맛있는 건 맞지만 넘 심한거 아니오 ..?',18),(37,2,5,'2022-12-01 10:47:46',1,'신선해요.구워봤어요','훌륭합니다',18),(38,4,3,'2022-12-01 10:47:46',1,'비계가 너무 많았어요. 잡내가 좀 났어요','잡내가 나서 매운 김치랑 먹었어요',18),(39,5,5,'2022-12-01 10:47:46',1,'소금의 맛이 달라요','김치를 담아도 음식에 사용해도 좋아요',19),(40,6,5,'2022-12-01 10:47:46',1,'선물 받은 후 다른 소금을 안쓰게되네요~^^','예상보다 맛있어요',19),(41,6,5,'2022-12-01 10:47:46',1,NULL,NULL,19),(42,1,5,'2022-12-01 10:47:49',NULL,'당연히 저 큰 책이니 두껍고 무겁지만 내용은 알찹니다.','좋네요',12),(43,4,5,'2022-12-01 10:49:16',NULL,'넷플릭스에서 애니 보고 주문했는데','너무 재밋었습니다 ㅋㅋㅋㅋ 주말 2일만에 다 읽어버려서 조금 아쉽네요 ㅠ',13),(44,10,5,'2022-12-01 10:49:42',NULL,'아이 생일선물로 원해서 샀어요','이미 다 읽은 거지만 소장하고 싶다고 해서 구매했어요 깨끗하고 제일 저렴하게 구매한것같아요!!',13),(45,7,5,'2022-12-01 10:50:05',NULL,'꼭 보셔야 합니다. ㅎㅎㅎ','재미있는 만화책...\r\n꼭 보셔야 합니다.\r\n좋은 책이에요...ㅎㅎ',13),(46,10,4,'2022-12-01 11:36:57',1,'가위식이라 잘 집어져요','고기 잡고 썰 용도론 아닌 거 같아요',28),(47,6,5,'2022-12-01 11:36:57',1,'38cm는 사용하기 좀 커요','작은 사이즈로 구매해서 쓰려구요~',28),(48,3,5,'2022-12-01 11:36:57',1,'잘 쓰겠습니다','만족합니다',28),(49,7,4,'2022-12-01 11:36:57',1,'집에서 막 쓸수있는 컵으로 구매했어요','빨대는 좀 별로에요',29),(50,8,5,'2022-12-01 11:36:57',1,'가볍고 튼튼한 스테이터 빨대컵 ! 공룡이 사랑스러워요♡','10년 전 첫째 때부터 즐겨 사용하던 제품이에요 ! ',29),(51,9,5,'2022-12-01 11:36:57',1,'휴대용으로도 좋아요 ! ','식기세척도 가능해서 좋아요 ! ',29),(52,1,5,'2022-12-01 11:41:30',NULL,'건강식품이 맛도 좋네요','집에 애들과 너무 잘먹고있어요. 재구매 예정입니다.',20),(53,3,4,'2022-12-01 11:41:30',NULL,'양이 적지만 괜찮네요','생각보다 양이 적어서 다음엔 두박스 구매해야겠어요',20),(54,5,5,'2022-12-01 11:41:30',NULL,'잘먹겠습니다','위장에 좋다는 말 듣고 바로 시켰습니다',20),(55,7,5,'2022-12-01 11:41:30',15,'40대 여성, 혈관에 좋다고 해서','HACCP마크 있어서 안심하고 구입했어요',21),(56,8,2,'2022-12-01 11:41:30',15,'쓴맛없어 좋아요','아주 찐한맛은 아니지만 쓴맛없이 마실수 있어서 좋아요',21),(57,10,1,'2022-12-01 11:41:30',16,'당뇨에 좋은 여주즙 재구매 의사 있습니다!','맛이 궁금해서 저도 하나 먹어봤는데 생각보다 그렇게 쓰지 않네요. 부모님이 다 드시면 재구매 예정입니다.',21),(58,12,3,'2022-12-01 11:41:30',17,'기호성이 대박이긴 하네요','공복토 할정도로 밥 잘 안먹는 두 공주님인데 사료 바꾸니 엄청 잘먹습니다',22),(59,15,5,'2022-12-01 11:41:30',18,'상품명값 하네요~ 잘먹잘잘쌉니다^^','사료 특유의 꼬릿한 냄새도 덜하고 너무 만족하고있습니다!',22),(60,11,5,'2022-12-01 11:41:30',17,'작명센스ㅎ','작명센스 최고!! 진짜 잘먹고 잘싸는듯?ㅎㅎ',22),(61,3,5,'2022-12-01 11:41:30',NULL,'여드름,뾰루지에도 휘슬 허브샴푸로 버블버블~','샴푸후 지켜보니 목덜미 터는것도 없고 개운한가 보더라고요. 대만족합니다',23),(62,4,2,'2022-12-01 11:41:30',NULL,'#오래모자 #초록샴푸','이거 쓰고나서부터 강아지 비듬이 싹 사라졌네요',23),(63,3,3,'2022-12-01 11:41:30',NULL,'좋아요!','거품도 일반샴푸보다 훨 잘나고 향기도 적당해요!',23),(64,5,5,'2022-12-01 11:41:30',20,'너무 부들부들 부부부부드드드드들','독후활동으로 화석만들기 놀이 해보려고 샀어요. 근데 이거 느낌이 너무 좋아요!',24),(65,17,5,'2022-12-01 11:41:30',20,'양 많고 부드러움','양이 많아서 꽤 쓴거 같은데 아직 한통도 다 못썼네요. 넘 좋아요~',24),(66,15,5,'2022-12-01 11:41:30',19,'괜춘','생각보다 사이즈 크구요. 아이랑 이거저거 만들면서 잘 놀았어요.',24),(67,1,5,'2022-12-01 11:41:30',NULL,'가격대비 만족해요. 출력물 상태 좋아요','출력물 상태도 괜찮고 속도도 빠른데 출력될때 많이 시끄럽긴 하네요.',25),(68,9,1,'2022-12-01 11:41:30',NULL,'생각보다 훨씬 만족해요!!!','자주안쓰고 한번하실때 몇장 출력 안하시면 이거 추천드립니다.',25),(69,10,5,'2022-12-01 11:41:30',NULL,'좋아요','집에서 가~~끔 인쇄하다보니 잉크젯은 도저히 쓸수가 없더라고요.. 레이저로 바꾸니 잉크 굳을 걱정 없어 속이 다 시원합니다',25),(70,6,3,'2022-12-01 11:41:30',NULL,'16개월 아기 제일 좋아하는 장난감 중 하나','청소기를 자꾸 장난감처럼 써서 뺏기도 뭐하고 그래서 장난감 청소기를 사줬는데 너무 맘에 들어하네요!',26),(71,8,2,'2022-12-01 11:41:30',NULL,'이제 안뺏겨도 되겠어요ㅋㅋ','이거 산 덕분에 이제 청소기 지옥에서 벗어날수있을꺼 같아요',26),(72,11,5,'2022-12-01 11:41:30',NULL,'두돌이상 청소관심있는 아이에게 강추','생김새도 비슷 소리나도 약하지만 흡입력도 있어 따라쟁이 아이에게 강추',26),(73,12,4,'2022-12-01 11:41:30',NULL,'아이가 정말 좋아해요. 잘샀어요','그릇이랑 집게 포크 수저 등이 같이 들어있어서 다른 준비없이 이것만으로도 재밌게 놀수있어요',27),(74,20,4,'2022-12-01 11:41:30',NULL,'신기한 장난감이네요','최근 아이가 요리에 관심을 가져서 구매해봤는데 상당히 만족합니다.',27),(75,19,1,'2022-12-01 11:41:30',NULL,'말랑 신기','물감이 빨리 닳는게 좀 아쉽네요',27),(76,3,5,'2022-12-01 12:01:34',1,'응.. 우리집 불 났다','집에 불나서 구매했어요 ',33),(77,5,5,'2022-12-01 12:01:34',1,'예상보다 무거워요 ','남자도 못 들겠어요',33),(78,2,5,'2022-12-01 12:01:34',1,'안전을 위해 ! ','든든하고,, 좋내요,,',33),(79,1,5,'2022-12-01 12:01:34',1,'그동안 백화점구매 쿠팡가격 완전 굿 품질은 역시 굿',NULL,34),(80,7,5,'2022-12-01 12:01:34',1,'보습력이 좋아요',NULL,34),(81,9,5,'2022-12-01 12:01:34',1,NULL,NULL,34),(82,3,5,'2022-12-01 13:11:43',1,'잘 사용중입니다 어떡 각도 구도 잘 어울려요','만족합니다 가격대비 정말 잘 사용하고 있어요',35),(83,5,4,'2022-12-01 13:11:43',1,'녹이 좀 있지만 인테리어용 추천해요 ','오늘 집 꾸미는 유명한 곳에서 보다가 로켓에 있길래 당장 구했어요 무게감이 상당하네요',35),(84,2,1,'2022-12-01 13:11:43',1,'최악이네요 절대 사지마세요','싼맛에 쓰려는 것도 있지만 이 의자는 다들 인테리어 용도로 사실텐데.. 이정도로 품질관리가 안될 줄은 몰랐네요',35);
/*!40000 ALTER TABLE `coupang_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_info`
--

DROP TABLE IF EXISTS `delivery_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_info` (
  `di_seq` int NOT NULL AUTO_INCREMENT,
  `di_type` varchar(20) NOT NULL,
  `di_peroid` int NOT NULL,
  `di_delivery_price` int NOT NULL,
  `di_region` varchar(20) NOT NULL,
  `di_return_price` int NOT NULL,
  PRIMARY KEY (`di_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_info`
--

LOCK TABLES `delivery_info` WRITE;
/*!40000 ALTER TABLE `delivery_info` DISABLE KEYS */;
INSERT INTO `delivery_info` VALUES (1,'로켓배송(와우)',1,0,'전국',0),(2,'로켓배송',1,0,'전국',0),(3,'로켓와우',1,0,'전국',0),(4,'로켓프레시(와우)',1,0,'전국',0),(5,'로켓직구(와우)',4,0,'외국',5000),(6,'로켓직구',4,2500,'외국',5000),(7,'무료배송',7,0,'전국',7000),(8,'제트배송',1,0,'전국',0);
/*!40000 ALTER TABLE `delivery_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluation_detail`
--

DROP TABLE IF EXISTS `evaluation_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluation_detail` (
  `ed_seq` int NOT NULL AUTO_INCREMENT,
  `ed_re_seq` int NOT NULL,
  `ed_detail` varchar(20) NOT NULL,
  PRIMARY KEY (`ed_seq`),
  KEY `evaluation_detail_FK` (`ed_re_seq`),
  CONSTRAINT `evaluation_detail_FK` FOREIGN KEY (`ed_re_seq`) REFERENCES `review_evaluation` (`re_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluation_detail`
--

LOCK TABLES `evaluation_detail` WRITE;
/*!40000 ALTER TABLE `evaluation_detail` DISABLE KEYS */;
INSERT INTO `evaluation_detail` VALUES (1,1,'예상보다 작아요'),(2,1,'정사이즈예요'),(3,1,'예상보다 커요'),(4,3,'예상보다 작아요'),(5,3,'정사이즈예요'),(6,3,'예상보다 커요'),(7,4,'화면과 비슷해요'),(8,4,'화면과 같아요'),(9,4,'화면과 달라요');
/*!40000 ALTER TABLE `evaluation_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufactor_info`
--

DROP TABLE IF EXISTS `manufactor_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufactor_info` (
  `manu_seq` int NOT NULL AUTO_INCREMENT,
  `manu_name` varchar(50) NOT NULL,
  `manu_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `manu_pho` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `manu_reg_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`manu_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufactor_info`
--

LOCK TABLES `manufactor_info` WRITE;
/*!40000 ALTER TABLE `manufactor_info` DISABLE KEYS */;
INSERT INTO `manufactor_info` VALUES (1,'고스트리퍼플릭',NULL,NULL,NULL),(2,'레이저',NULL,NULL,NULL),(3,'언더아머',NULL,NULL,NULL),(4,'삼성전자',NULL,NULL,NULL),(5,'농업회사법인 (주)피오에스싸이언스',NULL,NULL,NULL),(6,'애경산업',NULL,NULL,NULL),(7,'(주)도너랜드',NULL,NULL,NULL),(8,'Weihai Xinxing Digital Electronics Co.,Ltd.',NULL,NULL,NULL),(9,'CASDON',NULL,NULL,NULL),(10,'U.S.TOY',NULL,NULL,NULL),(11,'Qingdao Hanenter Trading Com',NULL,NULL,NULL),(12,'주식회사투힘',NULL,NULL,NULL),(15,'마르시끄',NULL,NULL,NULL),(16,'에이에이(Aa)',NULL,NULL,NULL),(17,'오토반',NULL,NULL,NULL),(18,'아멜리',NULL,NULL,NULL),(19,'위키북스',NULL,NULL,NULL),(20,'학산문화사',NULL,NULL,NULL),(21,'하기스',NULL,NULL,NULL),(22,'플레이맥스',NULL,NULL,NULL),(23,'트라이앵글(캡틴컴퍼니) ',NULL,NULL,NULL),(24,'THE SKATER CO., LTD(스케이터코리아)',NULL,NULL,NULL),(25,'에스제이컴퍼니',NULL,NULL,NULL),(26,'테리무역',NULL,NULL,NULL),(27,'(주)몽돌',NULL,NULL,NULL),(28,'오네스초이',NULL,NULL,NULL);
/*!40000 ALTER TABLE `manufactor_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_info`
--

DROP TABLE IF EXISTS `member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_info` (
  `mi_seq` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(255) NOT NULL,
  `mi_pwd` varchar(255) NOT NULL,
  `mi_name` varchar(100) NOT NULL,
  `mi_date` date NOT NULL,
  `mi_gender` int NOT NULL DEFAULT '3',
  `mi_phone` varchar(50) DEFAULT NULL,
  `mi_address` varchar(255) NOT NULL,
  `mi_grade` int NOT NULL DEFAULT '1',
  `mi_exp_grop` int NOT NULL DEFAULT '2',
  PRIMARY KEY (`mi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
INSERT INTO `member_info` VALUES (1,'user01','1234','신예현','2002-05-15',1,'010-1111-1111','서울특별시',1,2),(2,'user02','1234','박우영','1986-08-28',3,'010-2222-2222','제주특별시',1,2),(3,'user03','1234','장우우','1971-11-24',2,'010-3333-3333','경상북도 의성시',1,2),(4,'user04','1234','임현유','2001-04-08',2,'010-4444-4444','광주광역시',1,2),(5,'user05','1234','최서후','1997-12-21',1,'010-5555-5555','경기도 성남',1,2),(6,'user06','1234','최현진','1990-06-14',2,'010-6666-6666','인천광역시',1,2),(7,'user07','1234','윤서후','1970-12-13',1,'010-7777-7777','전라남도 순천시',1,2),(8,'user08','1234','임시현','1982-06-14',1,'010-8888-8888','부산광역시',1,2),(9,'user09','1234','조시후','1989-05-13',2,'010-9999-9999','경상북도 울진군',1,2),(10,'user10','1234','정시혁','2001-08-23',3,'010-1010-1010','충청북도 청주시',1,2),(11,'user011','1234','최서아','1998-04-24',2,'010-0011-0011','서울',1,2),(12,'user012','1234','이우영','1982-01-20',1,'010-0012-0012','대전',1,2),(13,'user013','1234','윤지우','1987-08-09',2,'010-0013-0013','대구',1,2),(14,'user014','1234','신현우','1968-05-09',1,'010-0014-0014','부산',1,2),(15,'user015','1234','신예현','2002-05-15',1,'010-0015-0015','제주',1,2),(16,'user016','1234','박우영','1986-08-28',2,'010-0016-0016','인천',1,2),(17,'user017','1234','장우우','1971-11-24',1,'010-0017-0017','경기',1,2),(18,'user018','1234','임현유','2001-04-08',1,'010-0018-0018','광주',1,2),(19,'user019','1234','최서후','1997-12-21',1,'010-0019-0019','경주',1,2),(20,'user020','1234','최현진','1990-06-14',2,'010-0020-0020','포항',1,2);
/*!40000 ALTER TABLE `member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `od_seq` int NOT NULL AUTO_INCREMENT,
  `od_po_seq` int NOT NULL,
  `od_pbi_seq` int NOT NULL,
  `od_count` int NOT NULL,
  PRIMARY KEY (`od_seq`),
  KEY `order_detail_FK` (`od_po_seq`),
  KEY `order_detail_FK_1` (`od_pbi_seq`),
  CONSTRAINT `order_detail_FK` FOREIGN KEY (`od_po_seq`) REFERENCES `product_order` (`po_seq`),
  CONSTRAINT `order_detail_FK_1` FOREIGN KEY (`od_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,20,1),(2,1,9,2),(3,1,12,3),(4,2,16,5),(5,2,2,1);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `order_price_sum_view`
--

DROP TABLE IF EXISTS `order_price_sum_view`;
/*!50001 DROP VIEW IF EXISTS `order_price_sum_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `order_price_sum_view` AS SELECT 
 1 AS `od_po_seq`,
 1 AS `total`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `product_ask`
--

DROP TABLE IF EXISTS `product_ask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_ask` (
  `pa_seq` int NOT NULL AUTO_INCREMENT,
  `pa_explain` varchar(255) NOT NULL,
  `pa_mi_seq` int NOT NULL,
  `pa_pbi_seq` int NOT NULL,
  `pa_answer` varchar(500) DEFAULT NULL,
  `pa_ask_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pa_answer_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pa_seq`),
  KEY `product_ask_FK` (`pa_mi_seq`),
  CONSTRAINT `product_ask_FK` FOREIGN KEY (`pa_mi_seq`) REFERENCES `member_info` (`mi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_ask`
--

LOCK TABLES `product_ask` WRITE;
/*!40000 ALTER TABLE `product_ask` DISABLE KEYS */;
INSERT INTO `product_ask` VALUES (1,'키165 몸무베88키로 나가는데 XL입으면 되겠죠? 평소바지 사이즈도 XL입습니다ᆢ일자바지는 기장줄여서 입는데 이바지는 밑단에 시보리가 있어서 안줄여입어도 되겠죠?혹시 기장이 많이긴가요? 다리근육이 많아 굵은데 종아리 허벅지가 많이 조이나요?',3,2,'안녕하세요 고객님 문의하신 제품은 조거팬츠로 종아리 단면이 xl경우 약18cm입니다. 제품주문시 참고하시면 좋을거같아요 감사합니다.','2022-11-22 03:25:18','2022-11-22 10:00:30'),(2,'리뉴얼 된거로 오나요!??',15,11,'아멜리 베이크드파우더 6.2g 상품은 리뉴얼 전 제품인 점 참고하여 이용 부탁드립니다','2022-07-12 08:17:41','2022-07-12 11:00:19'),(3,'리뉴얼 버전인가요 구 버전인가요??',15,11,'아멜리 베이크드파우더 6.2g 상품은 리뉴얼 전 제품인 점 참고하여 이용 부탁드립니다','2022-07-01 00:49:35','2022-07-01 11:27:49'),(4,'키185 체중82에 허리사이즈34~35입니다 사이즈선택이 애매합니다 XL해도 되겠습니까?',3,2,'안녕하세요 xxl 추천드립니다.','2022-11-12 01:31:04','2022-11-13 11:11:19'),(6,'기저귀는 받앗는데 애기가 한달정도되니 너무딱맞아서 3단계로 교환할수없을까해서 문의드려요',10,16,'안녕하세요. 쿠팡고객센터로 문의바랍니다.','2022-10-21 12:04:36','2022-10-21 13:07:38'),(7,'1박스면 몇매 선택해야하나요?',12,16,'1박스에 68매 *3 팩이며, 총 204매구매하시면 한박스로 출고됩니다.\r\n감사합니다.','2022-07-26 15:23:48','2022-07-26 23:57:27'),(8,'보관통 크기 알 수 있을까요??',11,17,'플레이맥스 싹둑요리 과일자르기 놀이 세트 상품의 보관통 사이즈는 가로 14cm, 세로 22.5cm인 점 상세페이지 내 안내드리고 있으니 참고하여 이용 부탁드립니다.','2022-11-30 14:19:38','2022-11-30 14:30:22'),(9,'받고 나서 별도 살균 소독하나요 ?아니면 바로 갖고 놀아도 되는지요 ?',4,17,'플레이맥스 싹둑요리 과일자르기 놀이 세트 상품은 제품 사용 시 살균 소독보다는 장난감 세정제를 수건에 적셔서 닦아주는 것을 권장하는 점 참고 부탁드립니다','2022-08-31 12:05:35','2022-08-31 13:22:31'),(10,'동봉되어있는 케이블은 몇w 케이블인가요?',19,4,'삼성전자 갤럭시 버즈2 프로, SM-R510N 상품은 케이블에는 별도 W 값이 있지 않으며, 전류를 흘려 전달해 주는 역할인 A 암페어(전류) 값이 있습니다. 동봉된 케이블은 3A인 점 참고 부탁드립니다.','2022-12-01 09:51:16','2022-12-01 09:51:16'),(11,'정품인가요? AS필요시 삼성서비스센터에서 1년무상받을수있나요?',11,4,'삼성전자 갤럭시 버즈2 프로 상품은 정품만을 발송해 드리고 있으며, 보증기간은 12개월입니다. A/S는 상품 또는 브랜드에 따라 상이하므로 자세한 내용은 상품페이지 또는 필수표기정보에서 삼성전자서비스센터/ 1588-3366 정보를 참고하여주시기 바랍니다. 상품에 기재되어 있는 제조사 및 판매처로 AS 문의 시 자세한 안내를 받으실 수 있으며 확인이 어려운 경우 쿠팡 고객센터로 연락주시면 확인 후 도움드리겠습니다.','2022-12-01 09:52:38','2022-12-01 09:52:38'),(12,'제품무게궁금해요',16,5,'페락 스케이트보드 상품의 무게는 약 2.5kg인 점 상세페이지 내 안내드리고 있으니 참고 부탁드립니다.','2022-12-01 09:59:38','2022-12-01 09:59:38'),(13,'3개중에 별모양 없는 것이 어떤게 있나요??',2,5,'페락 스케이트보드 상품은 세가지 모두 별모양이 있는 점 참고하여 이용 부탁드립니다.','2022-12-01 10:00:26','2022-12-01 10:00:26'),(14,'골프 말고 다른 용도 로 거리 제도 되는건가요?',7,6,'투힘 버디버디 골프 레이저 거리 속도 측정기 TB-01, 혼합색상 상품은 다른 용도로도 거리 측정이 가능하나 다만, 경사 20도 이상에서는 측정이 되지 않기 때문에 높이 측정은 되지 않는 점 이용에 참고 부탁드립니다.','2022-12-01 10:07:33','2022-12-01 10:07:33'),(15,'혹시 자동꺼짐 기능이 있으신가요?',3,6,'투힘 버디버디 골프 레이저 거리 속도 측정기 TB-01 상품은 16초 후 자동으로 꺼지는 점 참고하여 구매 부탁드립니다.','2022-12-01 10:08:06','2022-12-01 10:08:06'),(16,'현재 재입고 판매 계획이 있으신가요?',2,8,'안녕하세요. 올란도 유틸리티바는 11월 중순 이후 입고 예정입니다. 감사합니다.','2022-12-01 10:14:45','2022-12-01 10:14:45'),(17,'2012년식 올란도 가로바 설치하러고 하는데 모든 부속품이 다 포함되어 있나요? 상세 설명이 없네요',7,8,'안녕하세요. 장착에 관련한 모든 부품들이 포함되어 출고 됩니다. 제품내 포함되어 있는 메뉴얼을 확인이 가능하십니다. 혹 장착에 궁굼하신 점이 있으시면 담당자(010-0000-0000)로 연락주시면 안내가 가능하십니다. 감사합니다.','2022-12-01 10:15:32','2022-12-01 10:15:32'),(18,'냉동보관하면 언제까지 보관이 가능할까요?',1,18,'곰곰 한돈 삼겹살 수육용 (냉장) 상품은\r\n제조일로부터 10일 동안 냉장보관 가능하며,\r\n유통기한 내 섭취하지 못하는 경우 냉동 보관 권장하는 점 참고하여 구매 부탁드립니다.','2022-12-01 10:17:47','2022-11-23 00:00:00'),(19,'모니터에는 2개가 보이는데 수량이 2개가 1세트인가요?',2,18,'곰곰 한돈 삼겹살 수육용 (냉장) 상품은 1kg가 1개로 구성 되어있는 점\r\n상세페이지 내 안내 드리고 있으니 참고하여 구매 부탁 드립니다.','2022-12-01 10:17:47','2022-11-01 00:00:00'),(20,'쇼핑백 포함인가요?',2,19,'소금이오는소리 소금 굵은입자 480g + 고은입자 480g + 그라인더 명품 프리미엄세트 상품은 쇼핑백 포함이며,\r\n이 점 참고 부탁드리겠습니다.','2022-12-01 10:17:47','2022-09-08 00:00:00'),(21,'이거혹시 포터2 에도 달수있나요 !?',12,9,'오토반 차량용 와인아트 보조 왕미러2 화이트 AL-18S 상품은 전 차종에 사용 가능한 점 상품페이지 내 안내드리고 있으니 참고하여 이용 부탁드립니다.','2022-12-01 10:38:09','2022-12-01 10:38:09'),(22,'쿠퍼 컨트리맨에 부착가능할까요?',14,9,'오토반 차량용 와인아트 보조 왕미러2 화이트 AL-18S, 전차종, 2개 상품은 폭이 8mm 이상인 차종의 경우 적용되지 않는 점 상세페이지 내 안내드리고 있으니 참고하여 실측 사이즈와 비교 후 이용 부탁드립니다.','2022-12-01 10:38:51','2022-12-01 10:38:51'),(23,'13살학생이 봐도 문제 없을까요?',4,13,'귀멸의 칼날 1~23권 세트(완결) 상품은 15세 이상 사용 가능한 점 참고하여 이용 부탁드립니다.','2022-12-01 10:51:05','2022-12-01 10:51:05'),(24,'그림 흑백인가요?',18,13,'안녕하세요\r\n문의주신 상품은 흑백 상품입니다.\r\n참고하시어 구매 부탁드립니다.\r\n감사합니다.','2022-12-01 10:51:56','2022-12-01 10:51:56'),(28,'스테인리스 304소재인가요?',1,28,'트라이앵글 주방집게, 24cm, 1개 상품은 스테인리스 304 재질 여부는\r\n확인이 되지 않는 점 참고하여 이용 부탁드립니다.','2022-12-01 11:21:12','2022-05-10 00:00:00'),(29,'아가프라 빨대 사용 가능한가요?',1,29,'스케이터 빨대컵 3p 세트, 클리어 공룡, 230ml 상품은 지름이 6mm보다\r\n작은 빨대일 경우 호환 가능한 점 참고하여 이용 부탁드립니다.','2022-12-01 11:21:12','2022-11-22 00:00:00'),(30,'열탕가능한가요',2,29,'스케이터 빨대컵 3p 세트 상품은 열탕 소독이 가능하지 않은 점 참고하여 이용 부탁드립니다.','2022-12-01 11:21:12','2022-11-10 00:00:00'),(31,'화물차에 사용가능한가요??',1,33,'차량용에는 적합하지 않습니다','2022-12-01 11:56:14','2022-05-10 00:00:00'),(32,'어린이집 주방에서 사용할건데 가능 한지요? 그리고 8월 6일까지는 반드시 배송 완료 되어야 하는데 가능 한지요 지역은 남양주 입니다',1,33,'어린이집에서 많이 구매하시는 상품입니다.지금 주문해주시면 오늘 출고가능합니다만, 배송완료일자는 8월6일이 가능할수도 있고 택배사 상황에따라 조금더 걸릴수 있습니다.\r\n감사합니다.','2022-12-01 11:56:14','2022-08-04 00:00:00'),(33,'이사해서주소지가변경되엇어요..전화한번부탁드립니다..',1,34,'일시품절 배송일 확인 중입니다 확인하여 빠른처리 하겠습니다 구매자 취소 원하시면 취소 요청해 주세요','2022-12-01 11:56:14','2020-02-23 00:00:00'),(34,'정제수가 써있던데 물이 썩인건가요 여주 100%라고 들었는데',1,21,'하이헬스 100% 참진한 여주즙 상품은 여주를 고기압으로 추출하는 제품으로 여주 추출물이 100%이며 액상차 종류로 정제수와 혼합되어 있는 점 참고바랍니다.','2022-10-18 00:00:00','2022-10-31 00:00:00'),(35,'몇포인강..?',3,21,'저희 참진한 여주즙은 70ml 30포 1달분을 1박스에 담고있습니다. 감사합니다','2022-10-21 00:00:00','2022-10-31 00:00:00'),(36,'2kg 에몇 칼로리 인가요?',4,22,'본 상품은 1kg당 3435kcal인 점 참고하여 이용 부탁드립니다.','2022-10-05 00:00:00','2022-10-31 00:00:00'),(37,'건식인가요 습식인가요?',6,22,'본 상품은 건식 사료인 점 상세페이지 내 안내드리고 있으니 참고하여 이용 부탁드립니다.','2022-11-28 00:00:00','2022-11-30 00:00:00'),(38,'ph가 어떻게 될까요?',10,23,'본 상품의 pH 는5인 점 참고하여 이용 부탁드립니다','2022-11-18 00:00:00','2022-11-30 00:00:00'),(39,'배송은 언제 되나요??',2,23,'주문하신건이 없는것으로 확인되는데요? 다시한번 확인하고 문의 주시면 감사하겠습니다','2022-11-01 00:00:00','2022-11-30 00:00:00'),(40,'천사점토 지점토라고 쓰여있는데 천사점토랑은 다른 제품인 지점토인가요?',3,24,'천사점토 지점토 상품은 천사점토가 맞는 점 참고하여 이용 부탁드립니다.','2022-08-18 00:00:00','2022-08-31 00:00:00'),(41,'국산인가요?',1,24,'본 상품의 제조국은 대한민국으로 상세페이지 내 안내드리고 있는 점 참고하여 이용 부탁드립니다.','2022-07-22 00:00:00','2022-07-31 00:00:00'),(42,'모바일 데이터 출력이 가능한지요?',11,25,'본 상품은 무선 연결 불가 제품인 점 참고하여 구매 부탁드립니다.','2022-05-18 00:00:00','2022-05-31 00:00:00'),(43,'120g 복사지도 사용 가능한가요?',19,25,'본 상품은 120g 복사지 출력이 가능하며 급지 지원용지 무게는 60~220g인점 상세페이지 내 안내드리고 있으니 참고하여 구매 부탁드립니다.','2022-07-01 00:00:00','2022-07-31 00:00:00'),(44,'아이가 거실에 끌고다니다 떨어트려서 깨졌는데 AS문의는 어디에 해아하나요?',15,26,'A/S는 상품 또는 브랜드에 따라 상이하므로 자세한 내용은 상품페이지 또는 필수표기정보에서 [A/S고객센터/070-4349-1700] 정보를 참고하여 주시기 바랍니다.','2022-12-12 00:00:00','2022-12-31 00:00:00'),(45,'구매했는데 이틀만에 버튼이 안먹어요! 어떻게 해야하나요?',18,26,'본 상품은 큐이디/070-4349-1700을 통해 자세한 AS 상담이 가능한 점 상세페이지에서 확인 가능합니다.','2022-12-23 00:00:00','2022-12-31 00:00:00'),(46,'배터리부분 파손이 많은거 같은데 꼼꼼히 검수하시고 선물용이라서 안전하게 포장 해주시고 하자 없는거로 배송부탁 드립니다.',8,27,'네 알겠습니다^^','2022-01-02 00:00:00','2022-01-31 00:00:00'),(47,'언제 입고되나요?',6,27,'문의주신 제품은 추석 연휴 택배량 증가와 입고상태가 원활하지 않아 정확한 일정을 확답드리기 어렵습니다. 만족스러운 답변을 드리지 못해 죄송합니다.','2022-08-15 00:00:00','2022-08-31 00:00:00'),(48,'나사가 자꾸 헐거워지면서 빠지려고 하는데 일반적인 드라이버로는 안 조여지는 것 같아요. 어떻게 조여야 하나요..?',1,37,'안녕하세요 고객님 구매하신 구매처로 재문의 위해 쿠팡고객센터[1577-7011]연락하셔서 재문의 바랍니다','2022-12-01 13:08:38','2022-10-24 00:00:00'),(49,'안녕하세요. 저는 중국입니다. 당신과 합작하기를 기대합니다. 제 위챗은 17733639563입니다.',1,37,'no','2022-12-01 13:08:38','2020-02-23 00:00:00');
/*!40000 ALTER TABLE `product_ask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_basic_info`
--

DROP TABLE IF EXISTS `product_basic_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_basic_info` (
  `pbi_seq` int NOT NULL AUTO_INCREMENT,
  `pbi_cate_seq` int NOT NULL,
  `pbi_recommend` int DEFAULT '2',
  `pbi_title` text NOT NULL,
  `pbi_price` int NOT NULL DEFAULT '0',
  `pbi_wow_price` int DEFAULT '0',
  `pbi_delivery_seq` int NOT NULL,
  `pbi_dis_price` int DEFAULT '0',
  `pbi_store_seq` int NOT NULL,
  `pbi_stock` int NOT NULL DEFAULT '0',
  `pbi_ship_seq` int NOT NULL,
  `pbi_manu_seq` int DEFAULT NULL,
  `pbi_reg_dt` date DEFAULT NULL,
  PRIMARY KEY (`pbi_seq`),
  KEY `product_basic_info_FK` (`pbi_delivery_seq`),
  KEY `product_basic_info_FK_1` (`pbi_store_seq`),
  KEY `product_basic_info_FK_2` (`pbi_ship_seq`),
  KEY `product_basic_info_FK_4` (`pbi_cate_seq`),
  KEY `pbi_manu_seq` (`pbi_manu_seq`),
  CONSTRAINT `product_basic_info_FK` FOREIGN KEY (`pbi_delivery_seq`) REFERENCES `delivery_info` (`di_seq`),
  CONSTRAINT `product_basic_info_FK_1` FOREIGN KEY (`pbi_store_seq`) REFERENCES `store_info` (`si_seq`),
  CONSTRAINT `product_basic_info_FK_2` FOREIGN KEY (`pbi_ship_seq`) REFERENCES `shipping_info` (`ship_seq`),
  CONSTRAINT `product_basic_info_FK_4` FOREIGN KEY (`pbi_cate_seq`) REFERENCES `category_info` (`cate_seq`),
  CONSTRAINT `product_basic_info_ibfk_1` FOREIGN KEY (`pbi_manu_seq`) REFERENCES `manufactor_info` (`manu_seq`),
  CONSTRAINT `product_basic_info_ibfk_2` FOREIGN KEY (`pbi_manu_seq`) REFERENCES `manufactor_info` (`manu_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_basic_info`
--

LOCK TABLES `product_basic_info` WRITE;
/*!40000 ALTER TABLE `product_basic_info` DISABLE KEYS */;
INSERT INTO `product_basic_info` VALUES (1,1,2,'고스트리퍼블릭 세미 스트라이프 앰보 오버핏 반팔 티셔츠 GT-3145 1+1 패키지',45900,NULL,7,NULL,1,100,1,1,'2018-03-06'),(2,8,2,'레이저 Hammerhead True Wireless Chroma 블루투스 이어폰',91250,NULL,2,87600,2,100,8,2,'2018-01-18'),(3,1,2,'언더아머 아웃스트링 기모 조거팬츠 검정 기모',79000,NULL,7,46800,3,100,1,3,'2021-06-10'),(4,8,2,'삼성전자 갤럭시 버즈2 프로',279000,NULL,2,172700,4,100,8,4,'2018-09-25'),(5,9,2,'페락 스케이트보드',45000,NULL,2,33000,5,100,8,11,'2018-02-20'),(6,9,1,'투힘 버디버디 골프 레이저 거리 속도 측정기 TB-01',109000,NULL,3,NULL,6,100,8,12,'2018-10-04'),(7,2,2,'마르시끄 래쉬 앤 브로우 홈 스파 블랙 세럼 속눈썹 영양제',32000,NULL,2,24800,7,100,8,15,'2021-02-26'),(8,10,2,'GM 쉐보레 순정품 올란도 유틸리티바 가로바',165000,NULL,7,NULL,8,100,5,16,'2018-12-23'),(9,10,1,'오토반 차량용 와인아트 보조 왕미러2 화이트 AL-18S',16290,NULL,3,NULL,9,100,8,17,'2020-01-09'),(11,2,2,'아멜리 베이크드파우더 6.2g',34000,NULL,2,30600,10,100,8,18,'2018-05-10'),(12,11,2,'모던 자바스크립트 Deep Dive:자바스크립트의 기본 개념과 동작 원리',45000,NULL,3,40500,11,100,8,19,'2022-08-20'),(13,11,1,'귀멸의 칼날 1~23권 세트(완결)',138000,NULL,3,124200,12,100,8,20,'2018-05-07'),(16,3,2,'하기스 2022 보송보송 밴드형 기저귀 공용 소형 2단계(4~8kg)',38680,NULL,2,36800,16,100,8,21,'2019-07-23'),(17,3,2,'플레이맥스 싹둑요리 과일자르기 놀이 세트',18000,NULL,2,15860,17,100,8,22,'2020-07-02'),(18,4,2,'곰곰 한돈 삼겹살 수육용 (냉장)',29990,NULL,4,NULL,18,100,8,23,'2022-12-12'),(19,4,2,'소금이오는소리 소금 굵은입자 480g + 고은입자 480g + 그라인더 명품 프리미엄세트',59440,49500,2,38110,19,100,8,22,'2019-02-23'),(20,15,2,'우준식품 천년초 줄기즙',37000,NULL,2,NULL,15,100,8,NULL,'2019-02-16'),(21,15,2,'하이헬스 100% 참진한 여주즙',52000,NULL,8,26020,15,100,8,NULL,'2019-04-15'),(22,14,2,'로반 잘먹잘싸 전연령 강아지 사료 기호성좋은',80100,NULL,2,42800,15,100,8,5,'2021-05-18'),(23,14,2,'휘슬 허브4 약용 반려동물 샴푸',36500,NULL,2,10730,15,100,8,6,'2019-01-02'),(24,13,2,'천사점토 지점토 120g',18450,NULL,2,11750,15,100,8,7,'2021-02-12'),(25,13,2,'삼성전자 컬러 레이저 프린터',189000,NULL,2,179000,15,100,8,8,'2019-03-17'),(26,12,2,'다이슨 코드프리 장난감 청소기',39800,NULL,2,NULL,15,100,8,9,'2018-02-02'),(27,12,2,'아쿠아매직 보글보글 요리놀이 세트',40900,NULL,2,37940,15,100,8,10,'2019-04-19'),(28,5,2,'트라이앵글 주방집게',23900,NULL,2,22900,20,100,8,28,'2022-06-05'),(29,5,2,'스케이터 빨대컵 3p 세트, 클리어 공룡, 230ml',18900,NULL,2,12440,21,100,8,23,'2022-02-03'),(33,6,2,'한국소방산업기술원 K급 소화기 3L + 스티커',60000,NULL,7,57500,22,100,1,NULL,'2021-01-03'),(34,6,2,'더바디샵 올리브 바디 버터',2173600,NULL,7,NULL,23,100,1,NULL,'2019-07-24'),(35,7,2,'밴프 퓨어체어 OC202',42900,NULL,2,40900,24,100,1,NULL,'2018-08-04'),(36,7,2,'자게화병 신 중국식 현대 심플 레드 과일알 껍데기 거실 진열 장식품 탁상 꽃술 A스윙 설치함 팬시 룩 2586761617',18311800,NULL,7,11332000,25,100,1,NULL,'2018-07-09');
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
  `pbo_pbi_seq` int NOT NULL,
  PRIMARY KEY (`pbo_seq`),
  KEY `product_buy_option_FK` (`pbo_pbi_seq`),
  CONSTRAINT `product_buy_option_FK` FOREIGN KEY (`pbo_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_buy_option`
--

LOCK TABLES `product_buy_option` WRITE;
/*!40000 ALTER TABLE `product_buy_option` DISABLE KEYS */;
INSERT INTO `product_buy_option` VALUES (1,'블랙ⓢ:02.네이비',45900,1),(2,'블랙ⓢ:02.블랙',45900,1),(3,'2XL(35_36)',46800,3),(4,'L(31_32)',46800,3),(5,'그라파이트',172700,4),(6,'화이트',172700,4),(7,'맨체스터',33000,5),(8,'리버풀',33000,5),(9,'001 내추럴베이지 * 1개',30600,11),(10,'003 밀키바이올렛 * 1개',30600,11),(11,'68매',18920,16),(12,'204매',36800,16),(13,'전차종 * 4개',33250,9),(14,'전차종 * 6개',49780,9),(15,'70m x 60 개입',26020,21),(16,'70m x 90 개입',38750,21),(17,'연어 x 2kg x 1개',16800,22),(18,'연어 x 2kg x 2개',32040,22),(19,'흰색 x 1개',21350,24),(20,'흰색 x 2개',11750,24);
/*!40000 ALTER TABLE `product_buy_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail_info`
--

DROP TABLE IF EXISTS `product_detail_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_detail_info` (
  `pdi_seq` int NOT NULL AUTO_INCREMENT,
  `pdi_pbi_seq` int NOT NULL,
  `pdi_country` varchar(100) DEFAULT NULL,
  `pdi_laws` varchar(255) DEFAULT NULL,
  `pdi_importor` varchar(100) DEFAULT NULL,
  `pdi_weight` varchar(50) DEFAULT NULL,
  `pdi_distribute_days` int DEFAULT NULL,
  `pdi_built_date` date DEFAULT NULL,
  PRIMARY KEY (`pdi_seq`),
  KEY `pdi_pbi_seq` (`pdi_pbi_seq`),
  CONSTRAINT `product_detail_info_ibfk_1` FOREIGN KEY (`pdi_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail_info`
--

LOCK TABLES `product_detail_info` WRITE;
/*!40000 ALTER TABLE `product_detail_info` DISABLE KEYS */;
INSERT INTO `product_detail_info` VALUES (1,1,'한국',NULL,'고스트리퍼블릭',NULL,NULL,NULL),(2,3,NULL,NULL,'미국 캄보디아 인도네시아 등',NULL,NULL,NULL),(3,7,NULL,NULL,NULL,'7.5ml',NULL,NULL),(4,11,'한국',NULL,NULL,'6.2g',515,NULL),(5,16,'대한민국',NULL,NULL,NULL,NULL,NULL),(6,17,'중국',NULL,'Playmax.inc/(주)플레이맥스','690g',NULL,NULL),(7,2,'싱가포르','이어버드 : R-R-RAZ-382 / 크래들: R-R-RAZ-382C / 크래들 전지 : ZU10838-20003 / 이어버드 전지 : XU101308-21015A','레이저',NULL,NULL,NULL),(8,4,'대한민국','R-C-SEC-SMR510','삼성전자',NULL,NULL,NULL),(9,5,'대한민국',NULL,'사라코리아','2.5kg',NULL,NULL),(10,18,'대한민국','HACCP',NULL,'1kg',3,'2022-12-05'),(11,19,'대한민국',NULL,NULL,'480g',1361,'2016-08-26'),(12,6,'대한민국',NULL,'주식회사투힘',NULL,NULL,NULL),(13,9,'대한민국',NULL,'㈜오토반',NULL,NULL,NULL),(14,20,'상품 상세설명 참조',NULL,NULL,'100ml/30개',372,'2021-12-29'),(15,21,'상품 상세설명 참조','HACCP',NULL,'70ml/60개',550,'2022-06-15'),(16,22,'대한민국','사료관리법에 따른 성분등록번호 : 컨텐츠 참조','농업회사법인 (주)피오에스싸이언스','2kg/3개',350,'2022-08-31'),(17,23,'대한민국','동물용 의약외품','애경산업','500ml/1개',540,NULL),(18,24,'대한민국','CB113H011-6004','(주)도너랜드','203g/2개',NULL,NULL),(19,25,'중국','R-R-HpS-SLC510W, XU101933-19001A','HPPK',NULL,NULL,NULL),(20,26,'인도네시아','CB067R483-0001, R-R-bnm-dysoncodefree','(주)밤나무',NULL,NULL,NULL),(21,27,'중국','요리놀이 : CB067R594-0002 , R-R-Cy2-JY679447 , 물감 : CB063R2598-8001','주식회사 주영이앤씨',NULL,NULL,NULL),(22,13,'한국',NULL,'학산문화사',NULL,NULL,'2022-05-01'),(23,12,'한국',NULL,'위키북스',NULL,NULL,'2020-09-25'),(24,29,'독일',NULL,'캡틴 컴퍼니','100',NULL,NULL),(25,28,'일본',NULL,'스케이터 코리아','100',NULL,NULL),(26,8,'한국',NULL,'에이에이(Aa)',NULL,NULL,NULL),(28,33,'대한민국','KFI','에스제이컴퍼티','100',NULL,NULL),(29,34,NULL,NULL,'테리무역','100',NULL,NULL),(30,35,'중국OEM',NULL,'(주)몽돌','100',NULL,NULL),(31,36,'중국',NULL,'오네스초이','100',NULL,NULL);
/*!40000 ALTER TABLE `product_detail_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail_option`
--

DROP TABLE IF EXISTS `product_detail_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_detail_option` (
  `pdo_seq` int NOT NULL AUTO_INCREMENT,
  `pdo_pbo_seq` int NOT NULL,
  `pdo_explain` text NOT NULL,
  PRIMARY KEY (`pdo_seq`),
  KEY `product_detail_option_FK` (`pdo_pbo_seq`),
  CONSTRAINT `product_detail_option_FK` FOREIGN KEY (`pdo_pbo_seq`) REFERENCES `product_buy_option` (`pbo_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail_option`
--

LOCK TABLES `product_detail_option` WRITE;
/*!40000 ALTER TABLE `product_detail_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_detail_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_img`
--

DROP TABLE IF EXISTS `product_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_img` (
  `pi_seq` int NOT NULL AUTO_INCREMENT,
  `pi_rew_img` text NOT NULL,
  `pi_pbi_seq` int NOT NULL,
  PRIMARY KEY (`pi_seq`),
  KEY `pi_pbi_seq` (`pi_pbi_seq`),
  CONSTRAINT `product_img_ibfk_1` FOREIGN KEY (`pi_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_img`
--

LOCK TABLES `product_img` WRITE;
/*!40000 ALTER TABLE `product_img` DISABLE KEYS */;
INSERT INTO `product_img` VALUES (1,'T.jpg',1),(2,'pants.jpg',3),(3,'beauty1.jpg',7),(4,'beauty2.jpg',11),(5,'baby1.jpg',16),(6,'baby2.jpg',17),(7,'img18',18),(8,'img19',19),(9,'img28',28),(10,'img29',29),(11,'img33',33),(12,'img34',34),(13,'img37',35),(14,'img38',36),(15,'razerchroma1.jpg',2),(16,'razerchroma2.jpg',2),(17,'buds1.jpg',3),(18,'buds2.jpg',4),(19,'peracs.jpg',5),(20,'bdbd.jpg',6),(21,'shebo1.jpg',8),(22,'shebo2.jpg',8),(23,'al18.jpg',9),(24,'mddv.jpg',12),(25,'demon.jpg',13),(26,'image20-1',20),(27,'image21-1',21),(28,'image22-1',22),(29,'image23-1',23),(30,'image24-1',24),(31,'image25-1',25),(32,'image26-1',26),(33,'image27-1',27);
/*!40000 ALTER TABLE `product_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `product_main_img_view`
--

DROP TABLE IF EXISTS `product_main_img_view`;
/*!50001 DROP VIEW IF EXISTS `product_main_img_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `product_main_img_view` AS SELECT 
 1 AS `pi_seq`,
 1 AS `pi_rew_img`,
 1 AS `pi_pbi_seq`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `product_order`
--

DROP TABLE IF EXISTS `product_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_order` (
  `po_seq` int NOT NULL AUTO_INCREMENT,
  `po_mi_seq` int NOT NULL,
  `po_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `po_msg` text,
  `po_set_seq` int NOT NULL,
  `po_status` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`po_seq`),
  KEY `product_order_FK` (`po_mi_seq`),
  CONSTRAINT `product_order_FK` FOREIGN KEY (`po_mi_seq`) REFERENCES `member_info` (`mi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_order`
--

LOCK TABLES `product_order` WRITE;
/*!40000 ALTER TABLE `product_order` DISABLE KEYS */;
INSERT INTO `product_order` VALUES (1,5,'2022-12-01 13:45:48','문앞에 두고 가주세요',3,1),(2,3,'2022-12-01 13:45:48',NULL,3,1);
/*!40000 ALTER TABLE `product_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_evaluation`
--

DROP TABLE IF EXISTS `review_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_evaluation` (
  `re_seq` int NOT NULL AUTO_INCREMENT,
  `re_pbi_seq` int NOT NULL,
  `re_evaluation` varchar(10) NOT NULL,
  PRIMARY KEY (`re_seq`),
  KEY `review_evaluation_FK` (`re_pbi_seq`),
  CONSTRAINT `review_evaluation_FK` FOREIGN KEY (`re_pbi_seq`) REFERENCES `product_basic_info` (`pbi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_evaluation`
--

LOCK TABLES `review_evaluation` WRITE;
/*!40000 ALTER TABLE `review_evaluation` DISABLE KEYS */;
INSERT INTO `review_evaluation` VALUES (1,16,'사이즈'),(3,3,'사이즈'),(4,3,'색상');
/*!40000 ALTER TABLE `review_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_help`
--

DROP TABLE IF EXISTS `review_help`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_help` (
  `rh_seq` int NOT NULL AUTO_INCREMENT,
  `rh_mi_seq` int NOT NULL,
  `rh_cr_seq` int NOT NULL,
  `rh_type` int DEFAULT NULL,
  PRIMARY KEY (`rh_seq`),
  KEY `review_help_FK` (`rh_mi_seq`),
  KEY `review_help_FK_1` (`rh_cr_seq`),
  CONSTRAINT `review_help_FK` FOREIGN KEY (`rh_mi_seq`) REFERENCES `member_info` (`mi_seq`),
  CONSTRAINT `review_help_FK_1` FOREIGN KEY (`rh_cr_seq`) REFERENCES `coupang_review` (`cr_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_help`
--

LOCK TABLES `review_help` WRITE;
/*!40000 ALTER TABLE `review_help` DISABLE KEYS */;
INSERT INTO `review_help` VALUES (1,1,1,1),(2,2,1,1),(3,3,1,3),(4,4,1,1),(5,5,1,2),(6,6,1,1),(7,7,1,1),(8,8,1,2),(9,9,1,1),(10,10,1,1),(11,1,3,2),(12,2,3,1),(13,3,3,3),(14,4,3,1),(15,5,3,1),(16,6,3,1),(17,7,3,1),(18,8,3,2),(19,9,3,2),(20,10,1,1),(21,1,4,1),(22,2,4,1),(23,3,4,1),(24,4,4,1),(25,5,4,1);
/*!40000 ALTER TABLE `review_help` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_img`
--

DROP TABLE IF EXISTS `review_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_img` (
  `ri_seq` int NOT NULL AUTO_INCREMENT,
  `ri_img` text NOT NULL,
  `ri_cr_seq` int NOT NULL,
  PRIMARY KEY (`ri_seq`),
  KEY `ri_cr_seq` (`ri_cr_seq`),
  CONSTRAINT `review_img_ibfk_1` FOREIGN KEY (`ri_cr_seq`) REFERENCES `coupang_review` (`cr_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_img`
--

LOCK TABLES `review_img` WRITE;
/*!40000 ALTER TABLE `review_img` DISABLE KEYS */;
INSERT INTO `review_img` VALUES (1,'pant_review1.jpg',1),(3,'beauty1_review1.jpg',3),(4,'beauty1_review2.jpg',4),(5,'beauty2_review1.jpg',5),(6,'beauty2_review2.jpg',6),(7,'baby1_review1.jpg',10),(8,'baby1_review2.jpg',11),(12,'baby2_review1.jpg',12),(13,'baby2_review2.jpg',13),(14,'razor_review1.jpg',7),(15,'razor_review2.jpg',7),(16,'buds_review1.jpg',4),(17,'buds_review2.jpg',4),(18,'perac_review.jpg',5),(19,'bdbd_review.jpg',6),(20,'shebo_review.jpg',8),(21,'al18_review.jpg',9),(22,'java_review1.jpg',12),(23,'java_review2.jpg',12),(24,'demon_review.jpg',13);
/*!40000 ALTER TABLE `review_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `review_like_cnt_view`
--

DROP TABLE IF EXISTS `review_like_cnt_view`;
/*!50001 DROP VIEW IF EXISTS `review_like_cnt_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `review_like_cnt_view` AS SELECT 
 1 AS `rh_cr_seq`,
 1 AS `rh_type`,
 1 AS `like_cnt`,
 1 AS `unlike_cnt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `review_report`
--

DROP TABLE IF EXISTS `review_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_report` (
  `rr_seq` int NOT NULL AUTO_INCREMENT,
  `rr_mi_seq` int NOT NULL,
  `rr_cr_seq` int NOT NULL,
  `rr_reason` text NOT NULL,
  `rr_type` int NOT NULL,
  PRIMARY KEY (`rr_seq`),
  KEY `review_report_FK` (`rr_mi_seq`),
  KEY `review_report_FK_1` (`rr_cr_seq`),
  CONSTRAINT `review_report_FK` FOREIGN KEY (`rr_mi_seq`) REFERENCES `member_info` (`mi_seq`),
  CONSTRAINT `review_report_FK_1` FOREIGN KEY (`rr_cr_seq`) REFERENCES `coupang_review` (`cr_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_report`
--

LOCK TABLES `review_report` WRITE;
/*!40000 ALTER TABLE `review_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller_account`
--

DROP TABLE IF EXISTS `seller_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller_account` (
  `sa_seq` int NOT NULL AUTO_INCREMENT,
  `sa_id` varchar(255) NOT NULL,
  `sa_pwd` varchar(255) NOT NULL,
  `sa_si_seq` int NOT NULL,
  `sa_grade` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`sa_seq`),
  KEY `seller_account_FK` (`sa_si_seq`),
  CONSTRAINT `seller_account_FK` FOREIGN KEY (`sa_si_seq`) REFERENCES `store_info` (`si_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller_account`
--

LOCK TABLES `seller_account` WRITE;
/*!40000 ALTER TABLE `seller_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `seller_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller_block_list`
--

DROP TABLE IF EXISTS `seller_block_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller_block_list` (
  `sbl_seq` int NOT NULL AUTO_INCREMENT,
  `sbl_sa_seq` int NOT NULL,
  `sbl_reason` text NOT NULL,
  `sbl_date` date NOT NULL,
  PRIMARY KEY (`sbl_seq`),
  KEY `seller_block_list_FK` (`sbl_sa_seq`),
  CONSTRAINT `seller_block_list_FK` FOREIGN KEY (`sbl_sa_seq`) REFERENCES `seller_account` (`sa_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller_block_list`
--

LOCK TABLES `seller_block_list` WRITE;
/*!40000 ALTER TABLE `seller_block_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `seller_block_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_info`
--

DROP TABLE IF EXISTS `shipping_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_info` (
  `ship_seq` int NOT NULL AUTO_INCREMENT,
  `ship_name` varchar(10) NOT NULL,
  PRIMARY KEY (`ship_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_info`
--

LOCK TABLES `shipping_info` WRITE;
/*!40000 ALTER TABLE `shipping_info` DISABLE KEYS */;
INSERT INTO `shipping_info` VALUES (1,'CJ대한통운'),(2,'롯데글로벌로지스'),(3,'한진'),(4,'우체국택배'),(5,'로젠택배'),(6,'경동택배'),(7,'대신택배'),(8,'쿠팡');
/*!40000 ALTER TABLE `shipping_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_info`
--

DROP TABLE IF EXISTS `store_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_info` (
  `si_seq` int NOT NULL AUTO_INCREMENT,
  `si_name` varchar(50) NOT NULL,
  `si_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `si_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `si_reg_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`si_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_info`
--

LOCK TABLES `store_info` WRITE;
/*!40000 ALTER TABLE `store_info` DISABLE KEYS */;
INSERT INTO `store_info` VALUES (1,'주식회사 티알엔',NULL,NULL,NULL),(2,'레이저',NULL,NULL,NULL),(3,'제임스컴퍼니',NULL,NULL,NULL),(4,'삼성전자',NULL,NULL,NULL),(5,'사라코리아',NULL,NULL,NULL),(6,'주식회사투힘',NULL,NULL,NULL),(7,'(주)한국콜마',NULL,NULL,NULL),(8,'에이에이(Aa)',NULL,NULL,NULL),(9,'오토반',NULL,NULL,NULL),(10,'코스맥스(주)',NULL,NULL,NULL),(11,'위키북스',NULL,NULL,NULL),(12,'학산문화사',NULL,NULL,NULL),(15,'쿠팡',NULL,'1577-7011',NULL),(16,'유한킴벌리',NULL,NULL,NULL),(17,'(주)플레이맥스',NULL,NULL,NULL),(18,'gomgom',NULL,NULL,NULL),(19,'소금이오는소리','충남 서산시 팔봉2로 194-116','041-667-3331',NULL),(20,'트라이앵글',NULL,NULL,NULL),(21,'스케이터',NULL,NULL,NULL),(22,'에스제이컴퍼니','경기도 시흥시 마유로186번길 41 시화공단3다207호','010-2790-1199','836-50-00592'),(23,'테리무역','경기도 용인시 수지구 풍덕천로 135 3층 302호 A218 (풍덕천동)','010-2667-7946','558-13-02093'),(24,'(주)몽돌',NULL,NULL,NULL),(25,'오네스초이 ','경기도 성남시 수정구 논골로 87 101동 208호','010-3640-8870','417-17-94849');
/*!40000 ALTER TABLE `store_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_block_list`
--

DROP TABLE IF EXISTS `user_block_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_block_list` (
  `ubl_seq` int NOT NULL AUTO_INCREMENT,
  `ubl_mi_seq` int NOT NULL,
  `ubl_reason` text NOT NULL,
  `ubl_date` date NOT NULL,
  PRIMARY KEY (`ubl_seq`),
  KEY `user_block_list_FK` (`ubl_mi_seq`),
  CONSTRAINT `user_block_list_FK` FOREIGN KEY (`ubl_mi_seq`) REFERENCES `member_info` (`mi_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_block_list`
--

LOCK TABLES `user_block_list` WRITE;
/*!40000 ALTER TABLE `user_block_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_block_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_evaluation`
--

DROP TABLE IF EXISTS `user_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_evaluation` (
  `ue_seq` int NOT NULL AUTO_INCREMENT,
  `ue_re_seq` int NOT NULL,
  `ue_ed_seq` int NOT NULL,
  `ue_mi_seq` int NOT NULL,
  PRIMARY KEY (`ue_seq`),
  KEY `user_evaluation_FK` (`ue_re_seq`),
  KEY `user_evaluation_FK_1` (`ue_ed_seq`),
  KEY `ue_mi_seq` (`ue_mi_seq`),
  CONSTRAINT `user_evaluation_FK` FOREIGN KEY (`ue_re_seq`) REFERENCES `review_evaluation` (`re_seq`),
  CONSTRAINT `user_evaluation_FK_1` FOREIGN KEY (`ue_ed_seq`) REFERENCES `evaluation_detail` (`ed_seq`),
  CONSTRAINT `user_evaluation_ibfk_1` FOREIGN KEY (`ue_mi_seq`) REFERENCES `member_info` (`mi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_evaluation`
--

LOCK TABLES `user_evaluation` WRITE;
/*!40000 ALTER TABLE `user_evaluation` DISABLE KEYS */;
INSERT INTO `user_evaluation` VALUES (1,1,2,8),(2,1,2,16),(3,1,1,9),(4,3,2,5),(5,3,2,2),(6,3,2,6),(7,4,1,7),(8,4,2,8),(9,4,2,9);
/*!40000 ALTER TABLE `user_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'coupang_db'
--

--
-- Final view structure for view `order_price_sum_view`
--

/*!50001 DROP VIEW IF EXISTS `order_price_sum_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `order_price_sum_view` AS select `a`.`od_po_seq` AS `od_po_seq`,sum(ifnull(`b`.`pbi_dis_price`,`b`.`pbi_price`)) AS `total` from (`order_detail` `a` join `product_basic_info` `b` on((`a`.`od_pbi_seq` = `b`.`pbi_seq`))) group by `a`.`od_po_seq` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `product_main_img_view`
--

/*!50001 DROP VIEW IF EXISTS `product_main_img_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `product_main_img_view` AS select `a`.`pi_seq` AS `pi_seq`,`a`.`pi_rew_img` AS `pi_rew_img`,`a`.`pi_pbi_seq` AS `pi_pbi_seq` from (`product_img` `a` join (select min(`b`.`pi_seq`) AS `pi_seq` from `product_img` `b` group by `b`.`pi_pbi_seq`) `c` on((`c`.`pi_seq` = `a`.`pi_seq`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `review_like_cnt_view`
--

/*!50001 DROP VIEW IF EXISTS `review_like_cnt_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `review_like_cnt_view` AS select `a`.`rh_cr_seq` AS `rh_cr_seq`,`a`.`rh_type` AS `rh_type`,count(0) AS `like_cnt`,`c`.`unlike_cnt` AS `unlike_cnt` from (`review_help` `a` left join (select `b`.`rh_cr_seq` AS `rh_cr_seq`,`b`.`rh_type` AS `rh_type`,count(0) AS `unlike_cnt` from `review_help` `b` where (`b`.`rh_type` = 2) group by `b`.`rh_cr_seq`,`b`.`rh_type`) `c` on((`c`.`rh_cr_seq` = `a`.`rh_cr_seq`))) where (`a`.`rh_type` = 1) group by `a`.`rh_cr_seq`,`a`.`rh_type` union select `a`.`rh_cr_seq` AS `rh_cr_seq`,`a`.`rh_type` AS `rh_type`,ifnull(count(0),0) AS `like_cnt`,`c`.`unlike_cnt` AS `unlike_cnt` from ((select `b`.`rh_cr_seq` AS `rh_cr_seq`,`b`.`rh_type` AS `rh_type`,ifnull(count(0),0) AS `unlike_cnt` from `review_help` `b` where (`b`.`rh_type` = 2) group by `b`.`rh_cr_seq`,`b`.`rh_type`) `c` left join `review_help` `a` on((`c`.`rh_cr_seq` = `a`.`rh_cr_seq`))) where (`a`.`rh_type` = 1) group by `a`.`rh_cr_seq`,`a`.`rh_type` */;
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

-- Dump completed on 2022-12-02 14:23:39
