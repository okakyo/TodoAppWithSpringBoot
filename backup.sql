-- MySQL dump 10.13  Distrib 8.0.15, for osx10.14 (x86_64)
--
-- Host: localhost    Database: todo
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `main_model`
--

DROP TABLE IF EXISTS `main_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `main_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `done` tinyint(1) DEFAULT '0',
  `expiration` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_model`
--

LOCK TABLES `main_model` WRITE;
/*!40000 ALTER TABLE `main_model` DISABLE KEYS */;
INSERT INTO `main_model` VALUES (13,'2019-07-19 19:27:03',0,'2019-08-21 09:00:00','提出物','2019-07-23 21:45:51'),(3,'2019-07-15 22:28:44',0,'2019-07-26 09:00:00','宿題','2019-07-24 20:40:40'),(11,'2019-07-19 18:29:00',0,'2019-07-31 09:00:00','買い物','2019-07-24 15:08:17'),(14,'2019-07-19 19:27:26',1,'2019-07-04 09:00:00','DENX内でのリマインド機能、進捗度合いを伝えてくれる','2019-07-19 19:53:06'),(15,'2019-07-19 19:32:24',1,'2019-07-20 09:00:00','機械学習','2019-07-19 19:53:07'),(16,'2019-07-19 19:32:33',1,'2019-07-25 09:00:00','機械学習用データ','2019-07-24 15:21:07'),(17,'2019-07-24 15:09:12',1,'2019-07-26 09:00:00','にゃーん','2019-07-24 15:20:04'),(18,'2019-07-24 15:20:52',1,'2019-07-26 09:00:00','機械学習','2019-07-29 14:38:23');
/*!40000 ALTER TABLE `main_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restmodel`
--

DROP TABLE IF EXISTS `restmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `restmodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `done` tinyint(1) DEFAULT '0',
  `expiration` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restmodel`
--

LOCK TABLES `restmodel` WRITE;
/*!40000 ALTER TABLE `restmodel` DISABLE KEYS */;
/*!40000 ALTER TABLE `restmodel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-01 17:06:13
