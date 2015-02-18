CREATE DATABASE  IF NOT EXISTS `omandb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `omandb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: omandb
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `download`
--

DROP TABLE IF EXISTS `download`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `download` (
  `download_id` int(11) NOT NULL,
  `world_id` int(11) DEFAULT NULL,
  `download_funstuff` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`download_id`),
  KEY `world_id` (`world_id`),
  CONSTRAINT `download_ibfk_1` FOREIGN KEY (`world_id`) REFERENCES `world` (`world_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `download`
--

LOCK TABLES `download` WRITE;
/*!40000 ALTER TABLE `download` DISABLE KEYS */;
/*!40000 ALTER TABLE `download` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family`
--

DROP TABLE IF EXISTS `family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family` (
  `family_id` int(11) NOT NULL AUTO_INCREMENT,
  `family_name` varchar(50) NOT NULL,
  `family_description` varchar(10000) DEFAULT NULL,
  `world_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`family_id`),
  UNIQUE KEY `FamilyName` (`family_name`),
  KEY `fk_world_id_idx` (`world_id`),
  CONSTRAINT `fk_world_id` FOREIGN KEY (`world_id`) REFERENCES `world` (`world_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family`
--

LOCK TABLES `family` WRITE;
/*!40000 ALTER TABLE `family` DISABLE KEYS */;
/*!40000 ALTER TABLE `family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `food_id` int(11) NOT NULL AUTO_INCREMENT,
  `eaten_by_organism_id` int(11) DEFAULT NULL,
  `eating_organism_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  KEY `Eaten_Organism_ID` (`eaten_by_organism_id`),
  KEY `Eating_organism_ID` (`eating_organism_id`),
  CONSTRAINT `Fk_LivingOrganismEaten_ID` FOREIGN KEY (`eaten_by_organism_id`) REFERENCES `organism` (`organism_id`),
  CONSTRAINT `Fk_LivingOrganismEatening_ID` FOREIGN KEY (`eating_organism_id`) REFERENCES `organism` (`organism_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geolocation`
--

DROP TABLE IF EXISTS `geolocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geolocation` (
  `geolocation_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(50) NOT NULL,
  `area_description` varchar(10000) NOT NULL,
  `latitude_height_1` varchar(50) DEFAULT NULL,
  `longitude_height_1` varchar(50) DEFAULT NULL,
  `latitude_width_1` varchar(50) DEFAULT NULL,
  `longitude_width_1` varchar(50) DEFAULT NULL,
  `latitude_height_2` varchar(50) DEFAULT NULL,
  `longitude_height_2` varchar(50) DEFAULT NULL,
  `latitude_width_2` varchar(50) DEFAULT NULL,
  `longitude_width_2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`geolocation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geolocation`
--

LOCK TABLES `geolocation` WRITE;
/*!40000 ALTER TABLE `geolocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `geolocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geolocation_organism`
--

DROP TABLE IF EXISTS `geolocation_organism`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geolocation_organism` (
  `organism_id` int(11) NOT NULL,
  `geolocation_id` int(11) NOT NULL,
  KEY `organism_id` (`organism_id`),
  KEY `geolocation_id` (`geolocation_id`),
  CONSTRAINT `geolocation_organism_ibfk_1` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`),
  CONSTRAINT `geolocation_organism_ibfk_2` FOREIGN KEY (`geolocation_id`) REFERENCES `geolocation` (`geolocation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geolocation_organism`
--

LOCK TABLES `geolocation_organisme` WRITE;
/*!40000 ALTER TABLE `geolocation_organism` DISABLE KEYS */;
/*!40000 ALTER TABLE `geolocation_organism` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitat`
--

DROP TABLE IF EXISTS `habitat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitat` (
  `habitat_id` int(11) NOT NULL AUTO_INCREMENT,
  `habitat_name` varchar(50) DEFAULT NULL,
  `habitat_description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`habitat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitat`
--

LOCK TABLES `habitat` WRITE;
/*!40000 ALTER TABLE `habitat` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitat_organism`
--

DROP TABLE IF EXISTS `habitat_organism`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitat_organism` (
  `habitat_id` int(11) DEFAULT NULL,
  `organism_id` int(11) DEFAULT NULL,
  KEY `habitat_id` (`habitat_id`),
  KEY `organism_id` (`organism_id`),
  CONSTRAINT `habitat_organism_ibfk_1` FOREIGN KEY (`habitat_id`) REFERENCES `habitat` (`habitat_id`),
  CONSTRAINT `habitat_organism_ibfk_2` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitat_organism`
--

LOCK TABLES `habitat_organism` WRITE;
/*!40000 ALTER TABLE `habitat_organism` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitat_organism` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organism`
--

DROP TABLE IF EXISTS `organism`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organism` (
  `organism_id` int(11) NOT NULL AUTO_INCREMENT,
  `scientific_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `common_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `local_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `subfamily_id` int(11) DEFAULT NULL,
  `organism_description` varchar(9000) CHARACTER SET utf8 DEFAULT NULL,
  `population` varchar(50) DEFAULT NULL,
  `indigenous` tinyint(1) DEFAULT NULL,
  `cultivated` tinyint(1) DEFAULT NULL,
  `endangered` tinyint(1) DEFAULT NULL,
  `medicinal` tinyint(1) DEFAULT NULL,
  `benefits` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `dangerous` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `threats` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `opportunities` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `photo` mediumblob,
  `links` varchar(2000) DEFAULT NULL,
  `food_name` varchar(50) DEFAULT NULL,
  `food_description` varchar(10000) DEFAULT NULL,
  `isvalidated` tinyint(1) NOT NULL,
  `inserted_on` datetime NOT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`organism_id`),
  UNIQUE KEY `SCIENTIFICNAME` (`scientific_name`),
  KEY `subfamily_id` (`subfamily_id`),
  CONSTRAINT `organism_ibfk_1` FOREIGN KEY (`subfamily_id`) REFERENCES `subfamily` (`subfamily_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organism`
--

LOCK TABLES `organism` WRITE;
/*!40000 ALTER TABLE `organism` DISABLE KEYS */;
/*!40000 ALTER TABLE `organism` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organism_season`
--

DROP TABLE IF EXISTS `organism_season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organism_season` (
  `organism_id` int(11) DEFAULT NULL,
  `season_id` int(11) DEFAULT NULL,
  KEY `living_organism_id` (`organism_id`),
  KEY `season_id` (`season_id`),
  CONSTRAINT `organism_season_ibfk_1` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`),
  CONSTRAINT `organism_season_ibfk_2` FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organism_season`
--

LOCK TABLES `organism_season` WRITE;
/*!40000 ALTER TABLE `organism_season` DISABLE KEYS */;
/*!40000 ALTER TABLE `organism_season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `organism_id` int(11) DEFAULT NULL,
  `post_first_name` varchar(50) DEFAULT NULL,
  `post_last_name` varchar(200) NOT NULL,
  `post_email` varchar(200) NOT NULL,
  `post_description` varchar(10000) DEFAULT NULL,
  `photo_post` mediumblob,
  `post_longitude` varchar(50) DEFAULT NULL,
  `post_latitude` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `LivingOrganismID` (`organism_id`),
  CONSTRAINT `FK_Livingorganisms_ID` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `season`
--

DROP TABLE IF EXISTS `season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season` (
  `season_id` int(11) NOT NULL AUTO_INCREMENT,
  `season_name` varchar(10) NOT NULL,
  `season_description` varchar(10000) NOT NULL,
  PRIMARY KEY (`season_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season`
--

LOCK TABLES `season` WRITE;
/*!40000 ALTER TABLE `season` DISABLE KEYS */;
/*!40000 ALTER TABLE `season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subfamily`
--

DROP TABLE IF EXISTS `subfamily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subfamily` (
  `subfamily_id` int(11) NOT NULL AUTO_INCREMENT,
  `family_id` int(11) NOT NULL,
  `subfamily_name` varchar(50) NOT NULL,
  `subfamily_description` varchar(2000) NOT NULL,
  PRIMARY KEY (`subfamily_id`),
  KEY `family_id` (`family_id`),
  CONSTRAINT `subfamily_ibfk_1` FOREIGN KEY (`family_id`) REFERENCES `family` (`family_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subfamily`
--

LOCK TABLES `subfamily` WRITE;
/*!40000 ALTER TABLE `subfamily` DISABLE KEYS */;
/*!40000 ALTER TABLE `subfamily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriber`
--

DROP TABLE IF EXISTS `subscriber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscriber` (
  `subscribed_id` int(11) NOT NULL AUTO_INCREMENT,
  `subscriber_first_name` varchar(50) DEFAULT NULL,
  `subscriber_last_name` varchar(200) NOT NULL,
  `subscriber_email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`subscribed_id`),
  UNIQUE KEY `subscriber_email` (`subscriber_email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriber`
--

LOCK TABLES `subscriber` WRITE;
/*!40000 ALTER TABLE `subscriber` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscriber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `username` varchar(50) NOT NULL,
  `password` char(60) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `isadmin` tinyint(1) NOT NULL,
  `phone` varchar(50) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES ('admin','$2a$10$RAt.PEEQXHnV/sCj2VIwNOUige9631BllsXqUITcJK3kpcp0/SAB2','admin','admin','admin@admin.com','admin','admin',0,'0123456789'),('admin1','$2a$10$1jvdazlPQRKLFD7qkjMGFeOkY6shhl3GVtf27DHPTX5/Hdr9rMDLK','admin1','admin1','admin1@admin.com','admin1','admin1',0,'0123456789'),('user','$2a$10$MK7bYaL2mun7kD4vza6BEO.n1eUypaAjs/zuxYuXkxOfOe853doDa','user','user','user@admin.com','user','user',1,'0123456789');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `world`
--

DROP TABLE IF EXISTS `world`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `world` (
  `world_id` int(11) NOT NULL AUTO_INCREMENT,
  `world_name` varchar(50) NOT NULL,
  `world_description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`world_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `world`
--

LOCK TABLES `world` WRITE;
/*!40000 ALTER TABLE `world` DISABLE KEYS */;
INSERT INTO `world` VALUES (2,'micro','dit is een update'),(3,'micro','dit is een test'),(5,'micro','dit is een test'),(6,'micro','dit is een test'),(7,'micro','dit is een test');
/*!40000 ALTER TABLE `world` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-18 12:06:21
