-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 10, 2015 at 07:35 PM
-- Server version: 5.6.13
-- PHP Version: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `omandb`
--

-- --------------------------------------------------------

--
-- Table structure for table `livingorganisms`
--

CREATE TABLE IF NOT EXISTS `livingorganisms` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCIENTIFICNAME` varchar(255) CHARACTER SET utf8 NOT NULL,
  `COMMONNAME` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `LOCALNAME` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `DESCRIPTION` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `FAMILYID` int(11) DEFAULT NULL,
  `SUBFAMILYID` int(11) DEFAULT NULL,
  `WORLD` enum('Marine','Plant','Animal','Microbial') DEFAULT NULL,
  `HABITAT` enum('Grassland','Desert','Mountains','Ocean','Shallow ocean') DEFAULT NULL,
  `POPULATION` varchar(50) DEFAULT NULL,
  `FOODID` int(11) DEFAULT NULL,
  `SEASON` enum('Spring','Summer','Fall','Winter') DEFAULT NULL,
  `INDIGENOUS` tinyint(1) DEFAULT NULL,
  `CULTIVATED` tinyint(1) DEFAULT NULL,
  `ENDANGERED` tinyint(1) DEFAULT NULL,
  `MEDICINAL` tinyint(1) DEFAULT NULL,
  `BENEFITS` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `DEADLINESS` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `THREATS` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `OPPORTUNITIES` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `PHOTO` mediumblob,
  `GAMES` varchar(500) DEFAULT NULL,
  `LINKS` varchar(500) DEFAULT NULL,
  `QR` blob,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `SCIENTIFICNAME` (`SCIENTIFICNAME`),
  KEY `FAMILYID` (`FAMILYID`),
  KEY `SUBFAMILYID` (`SUBFAMILYID`),
  KEY `FOODID` (`FOODID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `livingorganisms`
--
ALTER TABLE `livingorganisms`
  ADD CONSTRAINT `livingorganisms_ibfk_1` FOREIGN KEY (`FAMILYID`) REFERENCES `family` (`FamilyID`),
  ADD CONSTRAINT `livingorganisms_ibfk_2` FOREIGN KEY (`SUBFAMILYID`) REFERENCES `subfamily` (`SubFamilyID`),
  ADD CONSTRAINT `livingorganisms_ibfk_3` FOREIGN KEY (`FOODID`) REFERENCES `foodnotdb` (`FoodNotDB_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
