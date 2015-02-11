-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 11 feb 2015 om 14:27
-- Serverversie: 5.6.13
-- PHP-versie: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `omandb`
--
CREATE DATABASE IF NOT EXISTS `omandb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `omandb`;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `AdminId` int(11) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `City` varchar(50) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `PassWord` varchar(50) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AdminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `family`
--

CREATE TABLE IF NOT EXISTS `family` (
  `FamilyID` int(11) NOT NULL AUTO_INCREMENT,
  `FamilyName` varchar(50) NOT NULL,
  `Description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`FamilyID`),
  UNIQUE KEY `FamilyName` (`FamilyName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Gegevens worden uitgevoerd voor tabel `family`
--

INSERT INTO `family` (`FamilyID`, `FamilyName`, `Description`) VALUES
(1, 'mammals', 'have fur or hair\r\nneed air to breathe\r\nwarm-blooded\r\nfeed young with their milk'),
(2, 'birds', 'have feathers and wings\r\nwarm-blooded\r\nlay eggs\r\nhave two legs\r\nhave a beak'),
(3, 'reptiles', 'have dry scaly skin\r\ncold-blooded\r\nhave four legs'),
(4, 'amphibians', 'have a slimy skin\r\nhave webbed feet\r\nbreath with their lungs and gills\r\ncold-blooded'),
(5, 'insects', 'have six legs\r\nhave an exoskeleton\r\nthree bodyparts\r\nhear, touch and taste with antennae'),
(6, 'bacteria', NULL),
(7, 'viruses', NULL),
(8, 'algae', NULL),
(9, 'fungi', NULL),
(10, 'protozoa', NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `foodfromdb`
--

CREATE TABLE IF NOT EXISTS `foodfromdb` (
  `FoodFromDB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Eaten_Organisme_ID` int(11) NOT NULL,
  `Eating_organisme_ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  PRIMARY KEY (`FoodFromDB_ID`),
  KEY `Eaten_Organisme_ID` (`Eaten_Organisme_ID`),
  KEY `Eating_organisme_ID` (`Eating_organisme_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geolocation`
--

CREATE TABLE IF NOT EXISTS `geolocation` (
  `AreaID` int(11) NOT NULL AUTO_INCREMENT,
  `Area` varchar(2000) NOT NULL,
  `LatitudeHeight1` varchar(50) DEFAULT NULL,
  `LongitudeHeigth1` varchar(50) DEFAULT NULL,
  `LatudeWidth1` varchar(50) NOT NULL,
  `LongitudeWidth1` varchar(50) NOT NULL,
  `LatudeHeigth2` varchar(50) NOT NULL,
  `LongitudeHeight2` varchar(50) NOT NULL,
  `LatudeWidth2` varchar(50) NOT NULL,
  `LongitudeWidth2` varchar(50) NOT NULL,
  PRIMARY KEY (`AreaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `livingorganisms`
--

CREATE TABLE IF NOT EXISTS `livingorganisms` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCIENTIFICNAME` varchar(255) CHARACTER SET utf8 NOT NULL,
  `COMMONNAME` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `LOCALNAME` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `DESCRIPTION` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `FAMILYID` int(11) DEFAULT NULL,
  `SUBFAMILYID` int(11) DEFAULT NULL,
  `WORLD` enum('Marine','Plant','Animal','Microbial') DEFAULT NULL,
  `HABITAT` enum('Grassland','Desert','Mountains','Ocean','Shallow ocean') DEFAULT NULL,
  `POPULATION` varchar(50) DEFAULT NULL,
  `SEASON` enum('Spring','Summer','Fall','Winter') DEFAULT NULL,
  `INDIGENOUS` tinyint(1) DEFAULT NULL,
  `CULTIVATED` tinyint(1) DEFAULT NULL,
  `ENDANGERED` tinyint(1) DEFAULT NULL,
  `MEDICINAL` tinyint(1) DEFAULT NULL,
  `BENEFITS` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `DEADLINESS` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `THREATS` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `OPPORTUNITIES` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `PHOTO` mediumblob,
  `GAMES` varchar(2000) DEFAULT NULL,
  `LINKS` varchar(2000) DEFAULT NULL,
  `QR` blob,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `SCIENTIFICNAME` (`SCIENTIFICNAME`),
  KEY `FAMILYID` (`FAMILYID`),
  KEY `SUBFAMILYID` (`SUBFAMILYID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `PostID` int(11) NOT NULL AUTO_INCREMENT,
  `LivingOrganismeID` int(11) DEFAULT NULL,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(200) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `Description` varchar(2000) NOT NULL,
  `FotoPost` mediumblob NOT NULL,
  `Longitude` double NOT NULL,
  `Latude` double NOT NULL,
  `NewsLetter` tinyint(1) NOT NULL,
  PRIMARY KEY (`PostID`),
  KEY `LivingOrganismeID` (`LivingOrganismeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subfamily`
--

CREATE TABLE IF NOT EXISTS `subfamily` (
  `SubFamilyID` int(11) NOT NULL AUTO_INCREMENT,
  `SubFamilyName` varchar(50) NOT NULL,
  `Description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`SubFamilyID`),
  UNIQUE KEY `SubFamilyName` (`SubFamilyName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Gegevens worden uitgevoerd voor tabel `subfamily`
--

INSERT INTO `subfamily` (`SubFamilyID`, `SubFamilyName`, `Description`) VALUES
(1, 'Omani Camels ', 'Camels are important to us because wuse them for so many things. \r\nWe eat the meat of young camels and melt fat from its hump and use it to make butter. \r\nYou can drink camel milk and make cheese from it. \r\nCamels also supply wool and leather for clothing and shelter. \r\nDried camel droppings provide fuel.\r\nCamels can also be used as draught animals.\r\nIn the desert, camels are an important   source of transportation, food, clothing and shelter.\r\nCamels have adapted to the different places they live by acquiring different features. \r\nFor example, camels that live in mountainous areas have developed stronger limbs than camels that live in plains and deserts. This is an adaptation \r\n\r\n');

--
-- Beperkingen voor gedumpte tabellen
--

--
-- Beperkingen voor tabel `foodfromdb`
--
ALTER TABLE `foodfromdb`
  ADD CONSTRAINT `Fk_LivingOrganismeEatening_ID` FOREIGN KEY (`Eating_organisme_ID`) REFERENCES `livingorganisms` (`ID`),
  ADD CONSTRAINT `Fk_LivingOrganismeEaten_ID` FOREIGN KEY (`Eaten_Organisme_ID`) REFERENCES `livingorganisms` (`ID`);

--
-- Beperkingen voor tabel `livingorganisms`
--
ALTER TABLE `livingorganisms`
  ADD CONSTRAINT `livingorganisms_ibfk_1` FOREIGN KEY (`FAMILYID`) REFERENCES `family` (`FamilyID`),
  ADD CONSTRAINT `livingorganisms_ibfk_2` FOREIGN KEY (`SUBFAMILYID`) REFERENCES `subfamily` (`SubFamilyID`);

--
-- Beperkingen voor tabel `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_Livingorganisms_ID` FOREIGN KEY (`LivingOrganismeID`) REFERENCES `livingorganisms` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
