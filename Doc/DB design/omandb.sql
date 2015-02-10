-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 10 feb 2015 om 16:51
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
-- Tabelstructuur voor tabel `familie`
--

CREATE TABLE IF NOT EXISTS `family` (
  `FamilyID` int(11) NOT NULL AUTO_INCREMENT,
  `FamilyName` varchar(50) NOT NULL,
  `Description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`FamilyID`),
  UNIQUE KEY `FamilyName` (`FamilyName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Gegevens worden uitgevoerd voor tabel `familie`
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
  `ID_From_DB` int(11) NOT NULL,
  PRIMARY KEY (`FoodFromDB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `foodnotdb`
--

CREATE TABLE IF NOT EXISTS `foodnotdb` (
  `FoodNotDB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  PRIMARY KEY (`FoodNotDB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geolocation`
--

CREATE TABLE IF NOT EXISTS `geolocation` (
  `GeoLocationID` int(11) NOT NULL AUTO_INCREMENT,
  `Latitude` double DEFAULT NULL,
  `Longitude` double DEFAULT NULL,
  `Description` varchar(2000) NOT NULL,
  PRIMARY KEY (`GeoLocationID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subfamilly`
--

CREATE TABLE IF NOT EXISTS `subfamily` (
  `SubFamilyID` int(11) NOT NULL AUTO_INCREMENT,
  `SubFamilyName` varchar(50) NOT NULL,
  `Description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`SubFamilyID`),
  UNIQUE KEY `SubFamilyName` (`SubFamilyName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Gegevens worden uitgevoerd voor tabel `subfamilly`
--

INSERT INTO `subfamily` (`SubFamilyID`, `SubFamilyName`, `Description`) VALUES
(1, 'Omani Camels ', 'Camels are important to us because wuse them for so many things. \r\nWe eat the meat of young camels and melt fat from its hump and use it to make butter. \r\nYou can drink camel milk and make cheese from it. \r\nCamels also supply wool and leather for clothing and shelter. \r\nDried camel droppings provide fuel.\r\nCamels can also be used as draught animals.\r\nIn the desert, camels are an important   source of transportation, food, clothing and shelter.\r\nCamels have adapted to the different places they live by acquiring different features. \r\nFor example, camels that live in mountainous areas have developed stronger limbs than camels that live in plains and deserts. This is an adaptation \r\n\r\n');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
