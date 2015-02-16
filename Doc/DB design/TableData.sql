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
-- Dumping data for table `download`
--

LOCK TABLES `download` WRITE;
/*!40000 ALTER TABLE `download` DISABLE KEYS */;
/*!40000 ALTER TABLE `download` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `family`
--

LOCK TABLES `family` WRITE;
/*!40000 ALTER TABLE `family` DISABLE KEYS */;
INSERT INTO `family` VALUES (1,'Mammals','These animals give birth rather than lay eggs',4),(2,'Reptiles','Ancient creatures who are cold blooded',4),(3,'Amphibians','These animals live in wetlands and are well adapted in the water aswell as on land',4),(4,'Birds','The creatures of the air. They have the abillity to fly and travel vast distances',4),(5,'Insects','Indestructable organisms whom live in great quantities together ',4);
/*!40000 ALTER TABLE `family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `geolocation`
--

LOCK TABLES `geolocation` WRITE;
/*!40000 ALTER TABLE `geolocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `geolocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `geolocation_organisme`
--

LOCK TABLES `geolocation_organisme` WRITE;
/*!40000 ALTER TABLE `geolocation_organisme` DISABLE KEYS */;
/*!40000 ALTER TABLE `geolocation_organisme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `habitat`
--

LOCK TABLES `habitat` WRITE;
/*!40000 ALTER TABLE `habitat` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `habitat_organism`
--

LOCK TABLES `habitat_organism` WRITE;
/*!40000 ALTER TABLE `habitat_organism` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitat_organism` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `organism`
--

LOCK TABLES `organism` WRITE;
/*!40000 ALTER TABLE `organism` DISABLE KEYS */;
INSERT INTO `organism` VALUES (2,NULL,'Batinah goats',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','',1,'0000-00-00 00:00:00'),(3,NULL,'Dhofari goat',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','',1,'0000-00-00 00:00:00'),(4,NULL,'Jabal Akhdar goat',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','',1,'0000-00-00 00:00:00'),(5,NULL,'Sahrawi goat',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','',1,'0000-00-00 00:00:00'),(6,NULL,'Jabali goat',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','',1,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `organism` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `organism_season`
--

LOCK TABLES `organism_season` WRITE;
/*!40000 ALTER TABLE `organism_season` DISABLE KEYS */;
/*!40000 ALTER TABLE `organism_season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `season`
--

LOCK TABLES `season` WRITE;
/*!40000 ALTER TABLE `season` DISABLE KEYS */;
/*!40000 ALTER TABLE `season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subfamily`
--

LOCK TABLES `subfamily` WRITE;
/*!40000 ALTER TABLE `subfamily` DISABLE KEYS */;
INSERT INTO `subfamily` VALUES (1,1,'goat','Herd animal'),(2,1,'cow','Big gras eaters'),(3,4,'chicken','These birds stay most of there live on ground'),(4,1,'orycx','Herd animal. big horns.');
/*!40000 ALTER TABLE `subfamily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subscriber`
--

LOCK TABLES `subscriber` WRITE;
/*!40000 ALTER TABLE `subscriber` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscriber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `world`
--

LOCK TABLES `world` WRITE;
/*!40000 ALTER TABLE `world` DISABLE KEYS */;
INSERT INTO `world` VALUES (1,'Marine world','Organisms that live i the water'),(2,'Plant world','Organic organisms'),(3,'Microbial world','Small organisms'),(4,'Animal world','Organisms of the animal world.');
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

-- Dump completed on 2015-02-16 23:54:53
