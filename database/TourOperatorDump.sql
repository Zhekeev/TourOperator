-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tour_operator
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `cashbox`
--

DROP TABLE IF EXISTS `cashbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashbox` (
  `id_client` int DEFAULT NULL,
  `id_tour` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `amount` bigint DEFAULT NULL,
  `date_current` varchar(25) DEFAULT NULL,
  KEY `cashbox_fk_id_client` (`id_client`),
  CONSTRAINT `cashbox_fk_id_client` FOREIGN KEY (`id_client`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashbox`
--

LOCK TABLES `cashbox` WRITE;
/*!40000 ALTER TABLE `cashbox` DISABLE KEYS */;
INSERT INTO `cashbox` VALUES (14,'6',300000,'2020.06.18 at 14:34:55'),(15,'1',519538,'2020.08.21 at 16:15:20'),(101,'4',435666,'2020.09.12 at 13:01:29');
/*!40000 ALTER TABLE `cashbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_client` int DEFAULT NULL,
  `id_tour` int NOT NULL,
  `tour_start_date` timestamp NOT NULL,
  `tour_finish_date` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_clinet_idx` (`id_client`),
  KEY `id_tour_idx` (`id_tour`),
  CONSTRAINT `contract_fk_1` FOREIGN KEY (`id_client`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `contract_fk_3` FOREIGN KEY (`id_tour`) REFERENCES `tour` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (5,NULL,1,'2020-06-02 18:00:00','2020-06-10 18:00:00'),(6,NULL,5,'2020-06-15 18:00:00','2020-06-28 18:00:00'),(7,NULL,2,'2020-06-05 18:00:00','2020-06-12 18:00:00'),(8,NULL,5,'2020-06-05 18:00:00','2020-06-26 18:00:00'),(9,NULL,4,'2020-05-31 18:00:00','2020-06-30 18:00:00'),(10,NULL,1,'2020-06-04 18:00:00','2020-06-06 18:00:00'),(11,NULL,1,'2020-06-10 18:00:00','2020-06-19 18:00:00'),(12,NULL,1,'2020-06-25 18:00:00','2020-06-23 18:00:00'),(13,NULL,4,'2020-06-17 18:00:00','2020-06-27 18:00:00'),(14,NULL,1,'2020-06-11 18:00:00','2020-06-19 18:00:00'),(15,NULL,1,'2020-06-11 18:00:00','2020-06-11 18:00:00'),(16,NULL,5,'2020-06-11 18:00:00','2020-06-25 18:00:00'),(17,NULL,1,'2020-06-12 18:00:00','2020-06-18 18:00:00'),(18,NULL,1,'2020-06-11 18:00:00','2020-06-19 18:00:00'),(19,NULL,2,'2020-06-11 18:00:00','2020-06-29 18:00:00'),(20,NULL,6,'2020-06-17 18:00:00','2020-06-18 18:00:00'),(21,NULL,4,'2020-06-11 18:00:00','2020-06-13 18:00:00'),(22,NULL,3,'2020-06-11 18:00:00','2020-06-27 18:00:00'),(23,NULL,4,'2020-06-10 18:00:00','2020-06-18 18:00:00'),(24,NULL,4,'2020-06-12 18:00:00','2020-06-25 18:00:00'),(25,NULL,1,'2020-06-12 18:00:00','2020-06-20 18:00:00'),(26,NULL,2,'2020-06-12 18:00:00','2020-06-19 18:00:00'),(27,NULL,1,'2020-06-18 18:00:00','2020-06-25 18:00:00'),(28,NULL,6,'2020-06-10 18:00:00','2020-06-20 18:00:00'),(29,NULL,1,'2020-06-18 18:00:00','2020-06-20 18:00:00'),(30,NULL,1,'2020-06-19 18:00:00','2020-06-25 18:00:00'),(31,NULL,1,'2020-06-21 18:00:00','2020-06-25 18:00:00'),(32,NULL,1,'2020-06-12 18:00:00','2020-06-19 18:00:00'),(33,NULL,1,'2020-06-19 18:00:00','2020-06-20 18:00:00'),(34,NULL,1,'2020-06-13 18:00:00','2020-06-23 18:00:00'),(35,NULL,1,'2020-06-12 18:00:00','2020-06-22 18:00:00'),(36,NULL,1,'2020-06-20 18:00:00','2020-06-30 18:00:00'),(37,NULL,5,'2020-06-13 18:00:00','2020-06-20 18:00:00'),(38,NULL,6,'2020-06-20 18:00:00','2020-06-27 18:00:00'),(39,NULL,5,'2020-06-12 18:00:00','2020-06-19 18:00:00'),(41,NULL,6,'2020-06-19 18:00:00','2020-06-26 18:00:00'),(42,NULL,2,'2020-06-19 18:00:00','2020-06-27 18:00:00'),(43,NULL,3,'2020-06-13 18:00:00','2020-06-21 18:00:00'),(44,NULL,1,'2020-06-19 18:00:00','2020-06-29 18:00:00'),(45,NULL,3,'2020-06-20 18:00:00','2020-06-28 18:00:00'),(46,NULL,2,'2020-06-26 18:00:00','2020-07-04 18:00:00'),(47,NULL,4,'2020-06-20 18:00:00','2020-06-27 18:00:00'),(48,NULL,1,'2020-06-12 18:00:00','2020-06-22 18:00:00'),(49,NULL,1,'2020-06-19 18:00:00','2020-06-29 18:00:00'),(50,NULL,6,'2020-06-13 18:00:00','2020-06-20 18:00:00'),(51,NULL,5,'2020-06-20 18:00:00','2020-06-27 18:00:00'),(52,NULL,3,'2020-07-04 18:00:00','2020-07-12 18:00:00'),(53,NULL,3,'2020-06-19 18:00:00','2020-06-27 18:00:00'),(54,NULL,6,'2020-06-19 18:00:00','2020-06-26 18:00:00'),(55,NULL,6,'2020-06-19 18:00:00','2020-06-26 18:00:00'),(56,NULL,2,'2020-06-19 18:00:00','2020-06-27 18:00:00'),(57,NULL,6,'2020-06-20 18:00:00','2020-06-27 18:00:00'),(58,NULL,1,'2020-06-20 18:00:00','2020-06-30 18:00:00'),(59,NULL,6,'2020-06-19 18:00:00','2020-06-26 18:00:00'),(60,14,6,'2020-06-18 18:00:00','2020-06-25 18:00:00'),(61,NULL,4,'2020-07-01 18:00:00','2020-07-08 18:00:00'),(62,NULL,3,'2020-06-24 18:00:00','2020-07-02 18:00:00'),(63,NULL,3,'2020-06-24 18:00:00','2020-07-02 18:00:00'),(64,NULL,1,'2020-06-06 18:00:00','2020-06-16 18:00:00'),(65,15,1,'2020-08-22 18:00:00','2020-09-01 18:00:00'),(66,101,4,'2020-09-12 18:00:00','2020-09-19 18:00:00');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_ru` varchar(45) NOT NULL,
  `name_eng` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_ru_UNIQUE` (`name_ru`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Мальдивы','Maldives'),(2,'Египт','Egypt'),(3,'ОАЭ','UAE'),(4,'Индонезия','Indonesia');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_tour`
--

DROP TABLE IF EXISTS `country_tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country_tour` (
  `id_tour` int DEFAULT NULL,
  `id_country` int DEFAULT NULL,
  KEY `country_tour_fk_1_idx` (`id_tour`),
  KEY `country_tour_fk_2_idx` (`id_country`),
  CONSTRAINT `country_tour_fk_1` FOREIGN KEY (`id_tour`) REFERENCES `tour` (`id`),
  CONSTRAINT `country_tour_fk_2` FOREIGN KEY (`id_country`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_tour`
--

LOCK TABLES `country_tour` WRITE;
/*!40000 ALTER TABLE `country_tour` DISABLE KEYS */;
INSERT INTO `country_tour` VALUES (1,1),(2,1),(3,1),(4,2),(5,2),(6,3);
/*!40000 ALTER TABLE `country_tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_ru` varchar(45) NOT NULL,
  `name_eng` varchar(45) NOT NULL,
  `description_ru` varchar(150) DEFAULT NULL,
  `description_eng` varchar(150) DEFAULT NULL,
  `price` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `service_contract`
--

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_ru` varchar(45) NOT NULL,
  `name_eng` varchar(45) DEFAULT NULL,
  `price` bigint NOT NULL,
  `duration` int NOT NULL,
  `description_ru` varchar(500) DEFAULT NULL,
  `description_eng` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tour_fk_1_idx` (`id`),
  KEY `fk_first_idx` (`description_eng`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'Пляж Хулхумале','Еhe aquzz beach hulhumale',519538,10,'В отеле Aquzz, расположенном в нескольких шагах от пляжа Восточной/Хулхумале и в 600 м от паромного терминала в городе Хулхумале, к услугам гостей номера с кондиционером и собственной ванной комнатой. В числе удобств ресторан, доставка еды и напитков в номер, общий лаундж и бесплатный Wi-Fi на всей территории. В отеле имеются семейные номера.','Located a few steps from East/Hulhumale beach and 600 metres from the ferry terminal in Hulhumale, Aqua hotel offers air-conditioned rooms with a private bathroom. Guests can enjoy the on-site restaurant, room service, and a shared lounge.free wifi is available throughout the property. The hotel offers family rooms.'),(2,'Сан-Айленд Резорт & Спа','Sun Island Resort & Spa',661440,8,'К услугам гостей роскошного курортного спа-отеля Sun Island открытый бассейн и 9 ресторанов. В числе удобств бесплатный Wi-Fi. Все просторные виллы с балконом оснащены телевизором с кабельными каналами.','The luxury Sun Island resort & Spa features an outdoor pool and 9 restaurants. Free Wi-Fi is available. Each spacious Villa has a balcony and a TV with cable channels.'),(3,'Роял Айленд-Курорт & Спа','Royal Island Resort & Spa',752036,8,'Курортный спа-отель Royal Island расположен на атолле Баа Мальдивских островов. К услугам гостей бесплатный Wi-Fi и спа-центр. С этого тропического острова с тихими пляжами, покрытыми белоснежным песком, открывается красивый вид на Индийский океан.','Royal Island resort & Spa is located on the BAA Atoll of the Maldives. It offers free Wi-Fi and a Spa centre. This tropical island offers beautiful views of the Indian ocean and quiet beaches covered with white sand.'),(4,'ВЕЛИКАЯ ПИРАМИДА КАИРА 4 *','GRAND PYRAMID CAIRO 4 *',435666,7,'Этот роскошный курортный отель расположен в 2 км от Пирамид и Большого Сфинкса Гизы. К услугам гостей 7 ресторанов, 3 бассейна и спа-центр с рядом расслабляющих процедур.','This luxury resort is located 2 km from the Pyramids and the Great Sphinx of Giza. It offers 7 restaurants, 3 pools and a Spa with a range of relaxing treatments.'),(5,'ОТЕЛЬ ELYSEES DREAM BEACH','ELYSEES DREAM BEACH HOTEL 4* ',478962,7,'Отель удобно расположен в самом центре оживленного города Хургада, не далеко от бухты с песчаным пляжем. Центр города находится всего в нескольких минутах с большим количеством магазинов, кафе, ресторанов и достопримечательностей и в 5 км от аэропорта Хургады.   Типы номеров: - Standard Room. - Family Room   Описание номеров: - 1-2 спальни - ванная / душ - туалет - фен - спутниковое ТВ - ЖК-телевизор - телефон - сейф - мини-бар / холодильник (наполнение - за дополнительную плату) - кондиционер','The hotel is conveniently located in the heart of the lively city of Hurghada, close to a Bay with a sandy beach. The city center is just a few minutes away with many shops, cafes, restaurants and attractions and 5 km from Hurghada airport. Room types: - Standard Room. - Family Room room Description: - 1-2 bedrooms-bathroom / shower-toilet-hair dryer-satellite TV-LCD TV - telephone-safe - mini bar / refrigerator (filling - extra charge) - air conditioning'),(6,'ХИЛТОН ГАРДЕН В ДУБАЕ ','HILTON GARDEN INN DUBAI AL MURAQABAT',578555,9,'Отель Hilton Garden Inn Al Muraqabat удобно расположен в центре района Дейра, всего в 15 минутах езды от пляжа Аль-Мамзар. К услугам гостей бесплатный Wi-Fi во всех зонах, открытый бассейн и 1 ресторан. Предоставляются вкусный завтрак и бесплатная парковка.','Hilton Garden Inn Al Muraqabat is conveniently located in the heart of Deira, just a 15-minute drive from al Mamzar beach. It offers free Wi-Fi in all areas, an outdoor pool and 1 restaurant. A delicious Breakfast and free Parking are provided.');
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `address` varchar(30) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `IIN` varchar(30) NOT NULL,
  `date_of_IIN` varchar(30) NOT NULL,
  `is_admin` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  UNIQUE KEY `IIN_UNIQUE` (`IIN`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (100,'mozg','a19dbd790d391005beab40a5d4e67e21','Yerg','Zhek','joker','87754626432','Krg','male','990411350683','2010-06-05',1),(101,'timamozg','a19dbd790d391005beab40a5d4e67e21','Timofey','Mozgov','jokerkaraganda@gmail.com','+77075978434','Karaganda','man','990411358899','2015-04-25',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-12 13:44:34
