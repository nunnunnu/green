-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: book_db
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
-- Temporary view structure for view `author_detail_info`
--

-- create database book_db;

DROP TABLE IF EXISTS `author_detail_info`;
/*!50001 DROP VIEW IF EXISTS `author_detail_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `author_detail_info` AS SELECT 
 1 AS `ba_seq`,
 1 AS `ba_ai_seq`,
 1 AS `ba_bi_seq`,
 1 AS `ai_seq`,
 1 AS `ai_name`,
 1 AS `ai_introduce`,
 1 AS `ai_country`,
 1 AS `ai_birth`,
 1 AS `author`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `author_info`
--

DROP TABLE IF EXISTS `author_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author_info` (
  `ai_seq` int NOT NULL AUTO_INCREMENT,
  `ai_name` varchar(20) NOT NULL,
  `ai_introduce` text NOT NULL,
  `ai_country` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ai_birth` date DEFAULT NULL,
  PRIMARY KEY (`ai_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_info`
--

LOCK TABLES `author_info` WRITE;
/*!40000 ALTER TABLE `author_info` DISABLE KEYS */;
INSERT INTO `author_info` VALUES (1,'룰루 밀러','‘방송계의 퓰리처상’으로 불리는 피버디상(Peabody Awards)을 수상한 과학 전문기자로, 15년 넘게 미국공영라디오방송국(NPR)에서 일하고 있다.\r\n인간의 행동을 형성하는 ‘보이지 않는 힘들’에 관한 이야기를 나누는 NPR의 〈인비저빌리아(Invisibilia)〉의 공동 기획자',NULL,NULL),(2,'데일 카네기','1888년 미국 미주리주에서 태어나 워렌스버그 주립대학을 졸업한 후 교사·세일즈맨 등으로 일하며 수많은 실패를 경험했다. 1912년 뉴욕 YMCA에서 대화 및 연설 기술을 강연하면서 이름이 점차 알려지게 되었다. 사례 중심으로 펼쳐지는 그의 강의는 인간관계를 잘하기 위한 실질적 기술들을 제시하면서 선풍적인 인기를 끌었다. 그의 강연은 사람들이 자신의 경험과 성취를 나누는 나눔의 장이 되었다. 이어서 그는 카네기 연구소를 설립해 인간 경영과 자기 계발 분야에서 기념비적인 업적을 남겼다. 처세, 자기 관리, 화술, 리더십 등에 대한 그의 가르침은 지금까지도 수많은 사람들을 성공으로 이끌고 있다. 1936년에 출간된 『카네기 인간관계론』은 전 세계적으로 6,000만 부나 판매되는 경이로운 기록을 세웠다.\r\n\r\n카네기 최고의 장점은 바로 단순, 명료함에 있다. 많은 문제에 단순하지만 진리가 되는 철학들을 제시, 스스로 풀어나갈 수 있도록 도우며 전 세계 사람들에게 많은 영감과 도움을 주었다.\r\n\r\n카네기의 책들은 핵심을 찌르는 원칙들로 정평이 나 있다. 그가 펴낸 책 중에서도 『데일 카네기 인간관계론』, 『데일 카네기 자기관리론』, 『데일 카네기 성공대화론』 삼부작은 불후의 고전으로 평가받고 있으며, 특히 『데일 카네기 인간관계론』은 처음 출간된 이래 전 세계적으로 6천만 부 이상 판매된 최고의 인간관계 바이블이다. 『성공대화론』은 대중 앞에서 자신 있고 설득력 있게 말하는 방법을 알려주는 책으로 그는 이 책을 통해 ‘효과적으로 말하는 빠르고 쉬운 방법’을 알려주었고 세계로 번역되어 사랑받고 있다.\r\n\r\n',NULL,NULL),(3,'올리버 색스','1933년 영국 런던에서 태어났다. 옥스퍼드 대학 퀸스칼리지에서 의학 학위를 받았고, 미국으로 건너가 샌프란시스코와 UCLA에서 레지던트 생활을 했다. 1965년 뉴욕으로 옮겨 가 이듬해부터 베스에이브러햄 병원에서 신경과 전문의로 일하기 시작했다. 그 후 알베르트 아인슈타인 의과대학과 뉴욕 대학을 거쳐 2007년부터 2012년까지 컬럼비아 대학에서 신경정신과 임상 교수로 일했다. 2012년 록펠러 대학이 탁월한 과학 저술가에게 수여하는 ‘루이스 토머스상’을 수상했고, 모교인 옥스퍼드 대학을 비롯한 여러 대학에서 명예박사 학위를 받았다. 2015년 안암이 간으로 전이되면서 향년 82세로 타계했다.\r\n\r\n올리버 색스는 신경과 전문의로 활동하면서 여러 환자들의 사연을 책으로 펴냈다. 인간의 뇌와 정신 활동에 대한 흥미로운 이야기들을 쉽고 재미있게 그리고 감동적으로 들려주어 수많은 독자들에게 큰 사랑을 받았다. 〈뉴욕타임스〉는 이처럼 문학적인 글쓰기로 대중과 소통하는 올리버 색스를 ‘의학계의 계관시인’이라고 불렀으며, 〈로스앤젤레스타임스〉는 “색스는 독자들을 다른 사람의 마음속으로 초대하여 근본적인 형태의 공감을 느끼게 해준다”고 썼다. 그는 왕립내과학회, 미국문화예술아카데미, 미국예술과학아카데미의 회원이었으며, 2008년 엘리자베스 2세는 그에게 대영제국 명예기사 작위를 수여했다.\r\n\r\n지은 책으로 베스트셀러 《아내를 모자로 착각한 남자》를 비롯해 《색맹의 섬》 《뮤지코필리아》 《환각》 《마음의 눈》 《목소리를 보았네》 《나는 침대에서 내 다리를 주 웠다》 《깨어남》 《편두통》 등 10여 권이 있다. 생을 마감하기 전에 자신의 삶과 연구, 저술 등을 감동적으로 서술한 자서전 《온 더 무브》와 삶과 죽음을 담담한 어조로 통찰한 칼럼집 《고맙습니다》, 인간과 과학에 대한 무한한 애정이 담긴 과학에세이 《의식의 강》, 자신이 평생 사랑하고 추구했던 것들에 관한 우아하면서도 사려 깊은 에세이집 《모든 것은 그 자리에》를 남겨 잔잔한 감동을 불러일으켰다.\r\n\r\n',NULL,NULL),(4,'한강','1970년 늦은 11월에 태어났다. 연세대 국문과를 졸업한 뒤 1993년 『문학과사회』에 시를 발표하고, 이듬해 서울신문 신춘문예에 단편소설 「붉은 닻」이 당선되어 작품활동을 시작했다. 장편소설 『검은 사슴』 『그대의 차가운 손』, 『채식주의자』, 『바람이 분다, 가라』, 『희랍어 시간』, 『소년이 온다』, 소설집 『여수의 사랑』, 『내 여자의 열매』, 『노랑무늬영원』, 시집 『서랍에 저녁을 넣어 두었다』 등이 있다. 만해문학상, 황순원문학상, 동리문학상, 이상문학상, 오늘의 젊은예술가상, 한국소설문학상을 수상했다.\r\n\r\n한편 2007년 출간한 『채식주의자』는 올해 영미판 출간에 대한 호평 기사가 뉴욕타임스 등 여러 언론에 소개되고 2016년 맨부커 인터내셔널상을 수상하며 인간의 폭력성과 존엄에 질문을 던지는 한강 작품에 대한 국내외 관심이 높아지고 있다. 만해문학상 수상작 『소년이 온다』의 해외 번역 판권도 20개국에 팔리며 한국문학에 활기를 더해주고 있다.','한국',NULL),(5,'김지수','1971년 서울 출생. 질문하고 경청하고 기록하며 23년째 기자라는 ‘업’을 이어 오고 있다. 패션지 [마리끌레르], [보그] 에디터를 거쳐 현재 조선일보 디지털 편집국에서 문화부장을 맡고 있다.\r\n','한국',NULL),(6,'이어령','1933년 충남 아산에서 출생. 서울대학교 문리과대학 및 동 대학원을 졸업하고 단국대학교 대학원에서 박사학위를 취득했다. 서울대 재학 시절 [문리대학보]의 창간을 주도 ‘이상론’으로 문단의 주목을 끌었으며, [한국일보]에 당시 문단의 거장들을 비판하는 「우상의 파괴」를 발표, 새로운 ‘개성의 탄생’을 알렸다. 20대부터 [서울신문], [한국일보], [중앙일보], [조선일보], [경향신문] 등의 논설위원을 두루 맡으면서 우리 시대의 가장 탁월한 논객으로 활약했다. [새벽] 주간으로 최인훈의 『광장』 전작을 게재했고, 월간 [문학사상]의 주간을 맡아 ‘문학의 상상력’과 ‘문화의 신바람’을 역설했다. 1966년 이화여자대학교 강단에 선 후 30여 년간 교수로 재직하여 수많은 제자들을 양성했다. 1988년 서울 올림픽 개폐회식 총괄 기획자로 ‘벽을 넘어서’라는 슬로건과 ‘굴렁쇠 소년’ ‘천지인’ 등의 행사로 전 세계에 한국인의 문화적 역량을 각인시켰다. 1990년 초대 문화부장관으로 취임하여 한국예술종합학교 설립과 국립국어원 발족의 굳건한 터를 닦았다. 2021년 금관문화 훈장을 받았다. 에세이 『흙 속에 저 바람 속에』 『하나의 나뭇잎이 흔들릴 때』 『지성의 오솔길』 『젊음의 탄생』 『한국인 이야기』, 문학평론 『저항의 문학』 『전후문학의 새물결』 『통금시대의 문학』, 문명론 『축소지향의 일본인』 『디지로그』 『가위바위보 문명론』 『생명이 자본이다』 등 160권이 넘는 방대한 저작물을 남겼다. 마르지 않는 지적 호기심과 창조적 상상력, 쉼 없는 말과 글의 노동으로 분열과 이분법의 낡은 벽을 넘어 통합의 문화와 소통의 새로운 패러다임을 끝없이 열어 보인 ‘시대의 지성’ 이어령은 2022년 2월 향년 89세를 일기로 영면에 들었다.','한국',NULL);
/*!40000 ALTER TABLE `author_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_author`
--

DROP TABLE IF EXISTS `book_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_author` (
  `ba_seq` int NOT NULL AUTO_INCREMENT,
  `ba_ai_seq` int NOT NULL,
  `ba_bi_seq` int NOT NULL,
  PRIMARY KEY (`ba_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_author`
--

LOCK TABLES `book_author` WRITE;
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
INSERT INTO `book_author` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,5);
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_cart`
--

DROP TABLE IF EXISTS `book_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_cart` (
  `bc_seq` int NOT NULL AUTO_INCREMENT,
  `bc_mi_seq` int NOT NULL,
  `bc_bi_seq` int NOT NULL,
  `bc_count` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`bc_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_cart`
--

LOCK TABLES `book_cart` WRITE;
/*!40000 ALTER TABLE `book_cart` DISABLE KEYS */;
INSERT INTO `book_cart` VALUES (1,1,1,2),(2,1,2,1),(3,1,3,1),(4,1,4,1),(5,2,2,1),(6,2,3,2),(7,2,4,1),(8,3,2,2),(9,3,3,1),(10,3,4,2),(11,4,2,1),(12,4,3,3),(13,4,4,1);
/*!40000 ALTER TABLE `book_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_detail`
--

DROP TABLE IF EXISTS `book_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_detail` (
  `bd_seq` int NOT NULL AUTO_INCREMENT,
  `bd_page` int NOT NULL,
  `bd_weight` int NOT NULL,
  `bd_size` varchar(20) NOT NULL,
  `bd_sales` int NOT NULL DEFAULT '0',
  `bd_bi_seq` int NOT NULL,
  PRIMARY KEY (`bd_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_detail`
--

LOCK TABLES `book_detail` WRITE;
/*!40000 ALTER TABLE `book_detail` DISABLE KEYS */;
INSERT INTO `book_detail` VALUES (1,300,480,'135*210*20mm',427755,1),(2,424,542,'150*225*30mm',286440,2),(3,396,632,'142*225*30mm',30738,3),(4,216,301,'153*224*20mm',85962,4),(5,320,480,'135*210*30mm',460344,5);
/*!40000 ALTER TABLE `book_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_explanation`
--

DROP TABLE IF EXISTS `book_explanation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_explanation` (
  `be_seq` int NOT NULL AUTO_INCREMENT,
  `be_exp` text NOT NULL,
  `be_type` int NOT NULL,
  `be_bi_seq` int NOT NULL,
  PRIMARY KEY (`be_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_explanation`
--

LOCK TABLES `book_explanation` WRITE;
/*!40000 ALTER TABLE `book_explanation` DISABLE KEYS */;
INSERT INTO `book_explanation` VALUES (1,'‘방송계의 퓰리처상’ 피버디상 수상자 룰루 밀러의\r\n사랑과 혼돈, 과학적 집착에 관한 경이롭고도 충격적인 데뷔작!\r\n\r\n‘방송계의 퓰리처상’으로 불리는 피버디상(Peabody Awards)을 수상한 과학 전문기자 룰루 밀러의 경이로운 논픽션 《물고기는 존재하지 않는다》는 여러 언론 매체에서 ‘2020년 최고의 책’으로 선정할 만큼 수많은 찬사를 받은 화제의 베스트셀러다.\r\n집착에 가까울 만큼 자연계에 질서를 부여하려 했던 19세기 어느 과학자의 삶을 흥미롭게 좇아가는 이 책은 어느 순간 독자들을 혼돈의 한복판으로 데려가서 우리가 믿고 있던 삶의 질서에 관해 한 가지 의문을 제기한다. “물고기가 존재하지 않는다는 것은 엄연한 하나의 사실이다. 그렇다면 우리는 또 무엇을 잘못 알고 있을까?” 하고 말이다. 누군가에게는 이 질문이 살아가는 데 아무런 영향을 미치지 않을 수도 있다. 하지만 세상을 바라보는 “진실한 관계들”에 한층 가까이 다가가기 위해 노력하는 사람들에게는 분명 이 책이 놀라운 영감과 어느 한쪽으로도 치우치지 않는 폭넓은 시야를 제공해줄 것이다.\r\n\r\n물고기가 존재하지 않는다면, 우리가 이 세계에 관해 아직 모르고 있는 것은 또 뭐가 있을까? 또 어떤 범주들이 무너질 참일까? 구름도 생명이 있는 존재일 수 있을까? 누가 알겠는가. 해왕성에서는 다이아몬드가 비로 내린다는데. 그건 정말이다. 바로 몇 년 전에 과학자들이 그 사실을 알아냈다. 우리가 세상을 더 오래 검토할수록 세상은 더 이상한 곳으로 밝혀질 것이다. _265쪽',0,1),(2,'fish.png',1,1),(3,'『인간관계론』과 짝을 이루는 데일 카네기 최고의 역작\r\n걱정이 내 인생을 망치기 전에 반드시 읽어야 할 책!\r\n\r\n워런 버핏이 직접 적용한, 걱정 없는 인생의 핵심 원리\r\n세계 최초의 ‘걱정 극복 실험실’에서 탄생한 마법의 공식 수록!\r\n\r\n현대지성에서는 출간 즉시 베스트셀러가 된 『데일 카네기 인간관계론』에 이어 저자의 또 다른 역작 『데일 카네기 자기관리론』을 펴냈다. 이 책은 국내에서 유일하게 1948년 초판의 10부까지 고스란히 담은 ‘오리지널’ 초판 완역본이다.\r\n\r\n벼락을 맞아도 끄떡없고, 숱한 폭풍우를 꿋꿋이 견뎌낸 아름드리 고목이 사람의 손가락 마디만 한 딱정벌레의 공격을 받아 맥없이 쓰러진다. 사자도 함부로 덤비지 못할 만큼 전투력이 강한 코끼리가 꿀벌의 가느다란 침에 속수무책으로 당한다. 우리 인생도 다르지 않다. “개미구멍 하나가 큰 제방 둑을 무너뜨린다”라는 속담처럼 사소한 걱정에 쉽게 마음을 내주어 인생을 망치는 사람이 수두룩하다. 걱정은 내일의 슬픔을 덜어주지 않고 도리어 오늘 살아갈 힘을 앗아가기에, 걱정이 인생을 좀먹도록 내버려둔다면 언젠가 큰 대가를 치르게 된다.\r\n\r\n베스트셀러 『인간관계론』 저자인 데일 카네기는 성인들에게 화술과 인간관계를 가르치는 동안 ‘걱정’이 모든 인생 문제의 주원인이자 자기관리의 핵심 요소임을 깨달았다. 그래서 ‘걱정을 멈추고 새로운 인생을 사는 법’을 교육하기로 마음먹었다. 하지만 문제가 생겼다. 교과서로 삼기에 적합한 책을 찾을 수 없었던 것이다. 결국 직접 쓸 수밖에 없었다. 이것이 또 한 권의 세계적인 베스트셀러가 탄생하게 된 배경이다.\r\n\r\n그는 동서고금의 온갖 자료를 샅샅이 훑으면서 각 분야의 전문가에게 조언을 들었다. 뿐만 아니라 170여 개 도시에서 열린 강좌를 ‘걱정 극복 실험실’로 삼아 수많은 사례를 수집하고 분석한 끝에 ‘마법의 공식’을 도출했다. 준비 기간 포함 7년에 걸쳐 집필한 이 책에는 걱정을 떨쳐내게 해줄 모든 지혜가 간결하고도 명확하게 담겨 있다. 또한 각계각층의 명사들 및 평범한 이웃들의 생생한 사례와 함께 당장 적용할 수 있는 구체적인 해결책을 제시했다. 모두 그가 활동하던 20세기 초부터 한 세기에 걸쳐 효과가 입증된 방법들이다.\r\n\r\n걱정 없이 살게 해줄 가장 적실하고 효과적인 실행법을 수록한 이 책은 카네기의 또 다른 역작 『인간관계론』과 함께 자기계발서의 원전(原典)으로 손꼽힌다. 지금의 나를 넘어 보다 행복한 인생을 꿈꾼다면, 핵심을 콕콕 집어 전달하면서 무기력한 일상을 깨우고 변화의 길로 이끄는 카네기의 조언에 귀를 기울여보자.\r\n\r\n“나는 데일 카네기에게 인생에서 가장 중요한 것을 배웠다.” _워런 버핏',0,2),(4,'Carnegie.png',1,2),(5,'우리 시대의 위대한 의사, 별이 되다\r\n인간을 보는 새롭고 따뜻한 눈을 제시한 올리버 색스의 대표작.\r\n2016월드일러스트레이션 어워즈 수상작가 이정호의 그림과 만나다.\r\n\r\n이 시대 가장 영향력 있는 신경학자이자 베스트셀러 저술가였던 올리버 색스. 1985년 영국 현지 출간 이래 30년 넘게 전 세계 독자들에게 폭 넓게 사랑받았으며 국내 독자들에게도 널리 알려진 대표작 《아내를 모자로 착각한 남자》 개정판이 출간되었다. 일상생활에 불편을 겪는 경증 환자부터 현실과 완전히 격리될 정도로 중증의 정신질환을 겪는 환자들까지… 올리버 색스가 엄밀히 관찰하고 따뜻하게 써낸 ‘우리와는 조금 다른’ 사람들의 독특한 임상 기록은, 인간 뇌에 관한 현대의학의 이해를 바꾸었다는 평가와 더불어 의학적·문학적으로 최고의 가치를 인정받고 있다. ‘알마’에서는 올리버 색스의 타계 1주기를 맞아 글과 디자인을 세심히 다듬은 개정판을 마련하였다. 누구보다 앞선 시선을 가졌던 작가의 목소리가 오늘의 독자들에게 온전히 전해질 수 있도록.',0,3),(6,'섬세한 감수성과 치밀한 문장으로 인간 존재의 본질을 탐구해온 작가 한강의 여섯번째 장편소설 『소년이 온다』가 출간되었다. 1980년 광주의 5월을 다뤄 창비문학블로그 ‘창문’에 연재할 당시(2013년 11월~2014년 1월)부터 독자들의 이목을 끌었던 열다섯살 소년의 이야기는 ‘상처의 구조에 대한 투시와 천착의 서사’를 통해 한강만이 풀어낼 수 있는 방식으로 1980년 5월을 새롭게 조명한다.\r\n\r\n한강은 무고한 영혼들의 말을 대신 전하는 듯한 진심 어린 문장들로 어느덧 그 시절을 잊고 무심하게 5.18 이후를 살고 있는 우리에게 묵직한 질문을 던지고, 여전히 5.18의 트라우마를 안고 힘겹게 살아가는 사람들을 위무한다. 『소년이 온다』는 광주민주화운동 당시 계엄군에 맞서 싸우던 중학생 동호를 비롯한 주변 인물들과 그후 남겨진 사람들의 고통받는 내면을 생생하게 그려내고, 당시의 처절한 장면들을 핍진하게 묘사하며 지금 “우리가 ‘붙들어야 할’ 역사적 기억이 무엇인지를 절실하게 환기하고 있다(백지연 평론가).”\r\n\r\n“이 소설을 피해갈 수 없었”고, “이 소설을 통과하지 않고는 어디로도 갈 수 없다고 느꼈”다는 작가 스스로의 고백처럼 이 소설은 소설가 한강의 지금까지의 작품세계를 한단계 끌어올리는, “한강을 뛰어넘은 한강의 소설(신형철 평론가)”이라고 자신 있게 말할 수 있는 작품이다.\r\n',0,4),(7,'518.youtube.com',3,4);
/*!40000 ALTER TABLE `book_explanation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_img`
--

DROP TABLE IF EXISTS `book_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_img` (
  `bimg_seq` int NOT NULL AUTO_INCREMENT,
  `bimg_img` varchar(50) NOT NULL,
  `bimg_bi_seq` int NOT NULL,
  `bimg_main` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`bimg_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_img`
--

LOCK TABLES `book_img` WRITE;
/*!40000 ALTER TABLE `book_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_info`
--

DROP TABLE IF EXISTS `book_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_info` (
  `bi_seq` int NOT NULL AUTO_INCREMENT,
  `bi_title` varchar(100) NOT NULL,
  `bi_sub_title` text,
  `bi_publisher` int NOT NULL,
  `bi_pub_dt` date NOT NULL,
  `bi_cate` int NOT NULL,
  `bi_pay` int NOT NULL,
  `bi_status` int NOT NULL DEFAULT '0',
  `bi_translation` int DEFAULT NULL,
  PRIMARY KEY (`bi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_info`
--

LOCK TABLES `book_info` WRITE;
/*!40000 ALTER TABLE `book_info` DISABLE KEYS */;
INSERT INTO `book_info` VALUES (1,'물고기는 존재하지 않는다','상실, 사랑 그리고 숨어 있는 삶의 질서에 관한 이야기',1,'2021-12-17',4,15300,0,1),(2,'데일 카네기 자기관리론',NULL,2,'2021-01-13',6,10350,0,2),(3,'아내를 모자로 착각한 남자',NULL,3,'2016-08-18',10,16650,0,3),(4,'소년이 온다',NULL,4,'2014-05-19',13,12600,0,NULL),(5,'이어령의 마지막 수업',NULL,5,'2021-10-26',15,14850,0,NULL);
/*!40000 ALTER TABLE `book_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_order`
--

DROP TABLE IF EXISTS `book_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_order` (
  `bo_seq` int NOT NULL AUTO_INCREMENT,
  `bo_mi_seq` int NOT NULL,
  `bo_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bo_msg` text,
  `bo_payment` int NOT NULL,
  `bo_status` int NOT NULL,
  `bo_delevery` int NOT NULL,
  PRIMARY KEY (`bo_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_order`
--

LOCK TABLES `book_order` WRITE;
/*!40000 ALTER TABLE `book_order` DISABLE KEYS */;
INSERT INTO `book_order` VALUES (1,1,'2022-11-23 10:07:29','문앞에 놔두고 가주세요',1,0,1),(2,2,'2022-11-23 10:07:43','부재시 연락주세요',1,0,1),(3,3,'2022-11-23 12:46:53',NULL,1,0,1);
/*!40000 ALTER TABLE `book_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_review`
--

DROP TABLE IF EXISTS `book_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_review` (
  `br_seq` int NOT NULL AUTO_INCREMENT,
  `br_score` int NOT NULL DEFAULT '0',
  `br_comment` text NOT NULL,
  `br_mi_seq` int NOT NULL,
  `br_like` int NOT NULL DEFAULT '0',
  `br_bi_seq` int NOT NULL,
  `br_status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`br_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_review`
--

LOCK TABLES `book_review` WRITE;
/*!40000 ALTER TABLE `book_review` DISABLE KEYS */;
INSERT INTO `book_review` VALUES (1,1,'몇줄 짜리 소재를 300페이지 가까이 늘여 쓸 수 있다는 작가의 능력에 경외감이 생긴다',1,0,1,0),(2,5,'마지막이 충격.. 아.. 스포.. ',2,1,1,0),(3,3,'뒤로 갈수록 흥미 떨어져서 꾸역꾸역 읽음',3,0,1,0),(4,5,'너무 재밌게 읽었어요.',4,0,1,0),(5,5,'정말 재밌어요~ 한번쯤 고민했을 법한 문제를 재밌게 풀어놓은 책.',5,0,1,0),(6,5,'정말 재밌게 읽은 책. 중후반부터 예상치못한 전개가 신선했습니다',6,0,1,0),(7,5,'스테디는 이유가 있음',1,0,2,0),(8,4,'읽은 후 실천이 중요할 것 같아요.',2,0,2,0),(9,5,'자기관리를 어떻게 하는지 알려줍니다.',3,0,2,0),(10,5,'도움이 많이 됩니다.',6,0,2,0),(11,5,'무조건 읽는 것을 추천합니다',4,0,2,0),(12,5,'두려움과 불안에 대해 잘 소개하고 있습니다.',5,0,2,0),(13,4,'재밌게 잘 읽었습니다.',1,0,3,0),(14,5,'정신과 관련된 병을 차분하게 잘 써내려간 책입니다.',2,0,3,0),(15,5,'마음을 지켜야 합니다',3,0,3,0),(16,4,'뇌에 자극을 주는 책',6,0,3,0),(17,5,'아주 좋습니다.',4,0,3,0),(18,5,'드디어 샀다 ㅎㅎㅎㅎㅎ',5,0,3,0),(19,4,'잘볼께요',1,0,4,0),(20,5,'빠른 배송 좋아요',2,0,4,0),(21,5,'그 시절의 아픔을 간직한 글...',3,0,4,0),(22,5,'모두가 한번씩은 읽어봤으면 좋겠다. 책을 한장한장 넘기는게 너무 힘들고 가슴아픈책',6,0,4,0),(23,5,'만족하며 흥미있게 읽었습니다.',4,0,4,0),(24,5,'한번쯤읽어보길바랍니다',5,0,4,0),(25,5,'재밌게 잘봤어요',1,0,5,0),(26,2,'내가 이해하기엔 너무 어려운 고학력자들의 고상한 수다',2,0,5,0),(27,4,'잘 읽었습니다.',3,0,5,0),(28,5,'선물을 위해 재구매합니다.',4,0,5,0),(29,5,'그저 좋습니다. 이어령 선생님의 책',5,0,5,0),(30,5,'참교훈을 얻었습니다.',6,0,5,0);
/*!40000 ALTER TABLE `book_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_review_like`
--

DROP TABLE IF EXISTS `book_review_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_review_like` (
  `brl_seq` int NOT NULL AUTO_INCREMENT,
  `brl_like` int NOT NULL DEFAULT '0',
  `brl_mi_seq` int NOT NULL,
  PRIMARY KEY (`brl_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_review_like`
--

LOCK TABLES `book_review_like` WRITE;
/*!40000 ALTER TABLE `book_review_like` DISABLE KEYS */;
INSERT INTO `book_review_like` VALUES (1,2,1);
/*!40000 ALTER TABLE `book_review_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `book_view`
--

DROP TABLE IF EXISTS `book_view`;
/*!50001 DROP VIEW IF EXISTS `book_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `book_view` AS SELECT 
 1 AS `bi_title`,
 1 AS `bi_sub_title`,
 1 AS `bi_cate`,
 1 AS `bi_pay`,
 1 AS `bd_sales`,
 1 AS `author`,
 1 AS `score`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `category_info`
--

DROP TABLE IF EXISTS `category_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_info` (
  `ci_seq` int NOT NULL AUTO_INCREMENT,
  `ci_cate` varchar(20) NOT NULL,
  `ci_parent_seq` int DEFAULT NULL,
  `ci_level` int NOT NULL,
  PRIMARY KEY (`ci_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_info`
--

LOCK TABLES `category_info` WRITE;
/*!40000 ALTER TABLE `category_info` DISABLE KEYS */;
INSERT INTO `category_info` VALUES (1,'국내도서',NULL,1),(2,'자연과학',1,2),(3,'생명과학',2,3),(4,'생물학',3,4),(5,'자기계발',1,2),(6,'처세술/삶의 자세',5,3),(7,'인문',1,2),(8,'심리',7,3),(9,'주제로 읽는 심리학',8,4),(10,'쉽게 읽는 심리학',9,5),(11,'소설/시/희곡',1,2),(12,'한국소설',11,3),(13,'한국 장편소설',12,4),(14,'인문/교양',7,3),(15,'교양으로 읽는 인문',14,4);
/*!40000 ALTER TABLE `category_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_info`
--

DROP TABLE IF EXISTS `delivery_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_info` (
  `di_seq` int NOT NULL AUTO_INCREMENT,
  `di_name` varchar(10) NOT NULL,
  PRIMARY KEY (`di_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_info`
--

LOCK TABLES `delivery_info` WRITE;
/*!40000 ALTER TABLE `delivery_info` DISABLE KEYS */;
INSERT INTO `delivery_info` VALUES (1,'현금'),(2,'카드'),(3,'네이버페이'),(4,'카카오페이');
/*!40000 ALTER TABLE `delivery_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_info`
--

DROP TABLE IF EXISTS `member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_info` (
  `mi_seq` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(50) NOT NULL,
  `mi_pwd` varchar(50) NOT NULL,
  `mi_name` varchar(50) NOT NULL,
  `mi_gen` int NOT NULL DEFAULT '0',
  `mi_birth` date NOT NULL,
  `mi_address` varchar(100) NOT NULL,
  `mi_email` varchar(20) NOT NULL,
  `mi_reg_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mi_status` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`mi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
INSERT INTO `member_info` VALUES (1,'user001','1234','서민영',2,'1982-05-27','서울','user001@book.com','2022-11-21 17:44:27',1),(2,'user002','1234','최민은',2,'1976-01-01','인천','user002@book.com','2022-11-21 17:44:27',1),(3,'user003','1234','이예영',2,'1968-10-19','대구','user003@book.com','2022-11-21 17:44:27',1),(4,'user004','1234','장시혁',1,'2004-05-12','부산','user004@book.com','2022-11-21 17:44:27',1),(5,'user005','1234','한서원',1,'1979-06-03','울산','user005@book.com','2022-11-21 17:44:27',1),(6,'user006','1234','박예진',2,'1986-06-07','대전','user006@book.com','2022-11-21 17:44:27',1),(7,'user007','1234','박하혁',1,'2001-11-25','광주','user007@book.com','2022-11-21 17:44:27',1),(8,'user008','1234','박예은',1,'2006-03-27','공주','user008@book.com','2022-11-21 17:44:27',1),(9,'user009','1234','서은진',2,'1997-10-06','경주','user009@book.com','2022-11-21 17:44:27',1),(10,'user010','1234','임은우',1,'1995-09-10','포항','user010@book.com','2022-11-21 17:44:27',1);
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
  `od_bo_seq` int NOT NULL,
  `od_bi_seq` int NOT NULL,
  `od_count` int NOT NULL,
  `od_mi_seq` int NOT NULL,
  PRIMARY KEY (`od_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,1,2,1),(2,1,2,1,1),(3,1,3,1,1),(4,1,4,1,1),(5,2,2,1,2),(6,2,3,2,2),(7,2,4,1,2),(8,3,2,2,3),(9,3,3,1,3),(10,3,4,2,3);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `order_list`
--

DROP TABLE IF EXISTS `order_list`;
/*!50001 DROP VIEW IF EXISTS `order_list`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `order_list` AS SELECT 
 1 AS `od_bo_seq`,
 1 AS `mi_name`,
 1 AS `mi_id`,
 1 AS `bi_title`,
 1 AS `bi_pay`,
 1 AS `sum(a.od_count )`,
 1 AS `total`,
 1 AS `bo_msg`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `payment_info`
--

DROP TABLE IF EXISTS `payment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_info` (
  `pi_seq` int NOT NULL AUTO_INCREMENT,
  `pi_name` varchar(10) NOT NULL,
  PRIMARY KEY (`pi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_info`
--

LOCK TABLES `payment_info` WRITE;
/*!40000 ALTER TABLE `payment_info` DISABLE KEYS */;
INSERT INTO `payment_info` VALUES (1,'대한통운'),(2,'롯데택배');
/*!40000 ALTER TABLE `payment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher_info`
--

DROP TABLE IF EXISTS `publisher_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher_info` (
  `pi_seq` int NOT NULL AUTO_INCREMENT,
  `pi_name` varchar(50) NOT NULL,
  PRIMARY KEY (`pi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher_info`
--

LOCK TABLES `publisher_info` WRITE;
/*!40000 ALTER TABLE `publisher_info` DISABLE KEYS */;
INSERT INTO `publisher_info` VALUES (1,'곰출판'),(2,'현대지성'),(3,'알마'),(4,'창비'),(5,'열림원');
/*!40000 ALTER TABLE `publisher_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `translation_info`
--

DROP TABLE IF EXISTS `translation_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `translation_info` (
  `ti_seq` int NOT NULL AUTO_INCREMENT,
  `ti_name` varchar(50) NOT NULL,
  PRIMARY KEY (`ti_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `translation_info`
--

LOCK TABLES `translation_info` WRITE;
/*!40000 ALTER TABLE `translation_info` DISABLE KEYS */;
INSERT INTO `translation_info` VALUES (1,'정지인'),(2,'임상훈'),(3,'조석현');
/*!40000 ALTER TABLE `translation_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'book_db'
--

--
-- Final view structure for view `author_detail_info`
--

/*!50001 DROP VIEW IF EXISTS `author_detail_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `author_detail_info` AS select `ba`.`ba_seq` AS `ba_seq`,`ba`.`ba_ai_seq` AS `ba_ai_seq`,`ba`.`ba_bi_seq` AS `ba_bi_seq`,`ai`.`ai_seq` AS `ai_seq`,`ai`.`ai_name` AS `ai_name`,`ai`.`ai_introduce` AS `ai_introduce`,`ai`.`ai_country` AS `ai_country`,`ai`.`ai_birth` AS `ai_birth`,group_concat(`ai`.`ai_name` separator ',') AS `author` from (`book_author` `ba` join `author_info` `ai` on((`ai`.`ai_seq` = `ba`.`ba_ai_seq`))) group by `ba`.`ba_bi_seq` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `book_view`
--

/*!50001 DROP VIEW IF EXISTS `book_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_view` AS select `bi`.`bi_title` AS `bi_title`,`bi`.`bi_sub_title` AS `bi_sub_title`,`bi`.`bi_cate` AS `bi_cate`,`bi`.`bi_pay` AS `bi_pay`,`bd`.`bd_sales` AS `bd_sales`,`adi`.`author` AS `author`,avg(`br`.`br_score`) AS `score` from ((((`book_info` `bi` join `book_detail` `bd` on((`bi`.`bi_seq` = `bd`.`bd_bi_seq`))) join `author_detail_info` `adi` on((`adi`.`ba_bi_seq` = `bi`.`bi_seq`))) join `book_review` `br` on((`bi`.`bi_seq` = `br`.`br_bi_seq`))) join `category_info` `ci` on((`bi`.`bi_cate` = `ci`.`ci_seq`))) group by `br`.`br_bi_seq` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `order_list`
--

/*!50001 DROP VIEW IF EXISTS `order_list`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `order_list` AS select `a`.`od_bo_seq` AS `od_bo_seq`,`c`.`mi_name` AS `mi_name`,`c`.`mi_id` AS `mi_id`,`b`.`bi_title` AS `bi_title`,`b`.`bi_pay` AS `bi_pay`,sum(`a`.`od_count`) AS `sum(a.od_count )`,sum((`b`.`bi_pay` * `a`.`od_count`)) AS `total`,`d`.`bo_msg` AS `bo_msg` from (((`order_detail` `a` join `book_info` `b` on((`a`.`od_bi_seq` = `b`.`bi_seq`))) join `member_info` `c` on((`c`.`mi_seq` = `a`.`od_mi_seq`))) join `book_order` `d` on((`a`.`od_bo_seq` = `d`.`bo_seq`))) group by `c`.`mi_seq` */;
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

-- Dump completed on 2022-11-25 17:58:48
