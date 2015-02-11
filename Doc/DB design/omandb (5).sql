-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 11 feb 2015 om 20:36
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
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  `pass_word` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `family`
--

CREATE TABLE IF NOT EXISTS `family` (
  `familly_id` int(11) NOT NULL AUTO_INCREMENT,
  `familly_name` varchar(50) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`familly_id`),
  UNIQUE KEY `FamilyName` (`familly_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Gegevens worden uitgevoerd voor tabel `family`
--

INSERT INTO `family` (`familly_id`, `familly_name`, `description`) VALUES
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
-- Tabelstructuur voor tabel `food`
--

CREATE TABLE IF NOT EXISTS `food` (
  `food_id` int(11) NOT NULL AUTO_INCREMENT,
  `eaten_organisme_id` int(11) DEFAULT NULL,
  `eating_organisme_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  KEY `Eaten_Organisme_ID` (`eaten_organisme_id`),
  KEY `Eating_organisme_ID` (`eating_organisme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geolocation`
--

CREATE TABLE IF NOT EXISTS `geolocation` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(2000) NOT NULL,
  `latitude_height_1` varchar(50) DEFAULT NULL,
  `longitude_heigth_1` varchar(50) DEFAULT NULL,
  `latude_width_1` varchar(50) DEFAULT NULL,
  `longitude_width_1` varchar(50) DEFAULT NULL,
  `latude_heigth_2` varchar(50) DEFAULT NULL,
  `longitude_height_2` varchar(50) DEFAULT NULL,
  `latude_width_2` varchar(50) DEFAULT NULL,
  `longitude_width_2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `habitat`
--

CREATE TABLE IF NOT EXISTS `habitat` (
  `habitat_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`habitat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organism`
--

CREATE TABLE IF NOT EXISTS `organism` (
  `organism_id` int(11) NOT NULL AUTO_INCREMENT,
  `scientific_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `commmon_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `local_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `subfamilly_id` int(11) DEFAULT NULL,
  `world_id` int(11) DEFAULT NULL,
  `habitat_id` int(11) DEFAULT NULL,
  `season_id` int(11) DEFAULT NULL,
  `description` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
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
  `downloads` varchar(2000) DEFAULT NULL,
  `links` varchar(2000) DEFAULT NULL,
  `qr` blob,
  PRIMARY KEY (`organism_id`),
  UNIQUE KEY `SCIENTIFICNAME` (`scientific_name`),
  KEY `FAMILYID` (`subfamilly_id`),
  KEY `subfamilly_id` (`subfamilly_id`),
  KEY `season_id` (`season_id`),
  KEY `season_id_2` (`season_id`),
  KEY `world` (`world_id`),
  KEY `habitat` (`habitat_id`),
  KEY `habitat_2` (`habitat_id`),
  KEY `habitat_3` (`habitat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organism_season`
--

CREATE TABLE IF NOT EXISTS `organism_season` (
  `organism_season_id` int(11) NOT NULL AUTO_INCREMENT,
  `living_organisme_id` int(11) DEFAULT NULL,
  `season_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`organism_season_id`),
  KEY `living_organisme_id` (`living_organisme_id`),
  KEY `season_id` (`season_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `organisme_id` int(11) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `photo_post` mediumblob,
  `longitude` varchar(50) DEFAULT NULL,
  `latude` varchar(50) DEFAULT NULL,
  `news_letter` tinyint(1) NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `LivingOrganismeID` (`organisme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `season`
--

CREATE TABLE IF NOT EXISTS `season` (
  `season_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `description` varchar(2000) NOT NULL,
  PRIMARY KEY (`season_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subfamilly`
--

CREATE TABLE IF NOT EXISTS `subfamilly` (
  `subfamily_id` int(11) NOT NULL AUTO_INCREMENT,
  `familly_id` int(11) NOT NULL,
  `subfamilly_name` varchar(50) NOT NULL,
  `description` varchar(2000) NOT NULL,
  PRIMARY KEY (`subfamily_id`),
  KEY `familly_id` (`familly_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `worlds`
--

CREATE TABLE IF NOT EXISTS `worlds` (
  `world_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`world_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Beperkingen voor gedumpte tabellen
--

--
-- Beperkingen voor tabel `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `Fk_LivingOrganismeEatening_ID` FOREIGN KEY (`Eating_organisme_ID`) REFERENCES `organism` (`organism_id`),
  ADD CONSTRAINT `Fk_LivingOrganismeEaten_ID` FOREIGN KEY (`Eaten_Organisme_ID`) REFERENCES `organism` (`organism_id`);

--
-- Beperkingen voor tabel `organism`
--
ALTER TABLE `organism`
  ADD CONSTRAINT `organism_ibfk_1` FOREIGN KEY (`subfamilly_id`) REFERENCES `subfamilly` (`familly_id`),
  ADD CONSTRAINT `organism_ibfk_5` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`world_id`),
  ADD CONSTRAINT `organism_ibfk_6` FOREIGN KEY (`habitat_id`) REFERENCES `habitat` (`habitat_id`),
  ADD CONSTRAINT `organism_ibfk_7` FOREIGN KEY (`season_id`) REFERENCES `organism_season` (`season_id`);

--
-- Beperkingen voor tabel `organism_season`
--
ALTER TABLE `organism_season`
  ADD CONSTRAINT `organism_season_ibfk_1` FOREIGN KEY (`living_organisme_id`) REFERENCES `organism` (`organism_id`),
  ADD CONSTRAINT `organism_season_ibfk_2` FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`);

--
-- Beperkingen voor tabel `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_Livingorganisms_ID` FOREIGN KEY (`organisme_id`) REFERENCES `organism` (`organism_id`);

--
-- Beperkingen voor tabel `subfamilly`
--
ALTER TABLE `subfamilly`
  ADD CONSTRAINT `subfamilly_ibfk_1` FOREIGN KEY (`familly_id`) REFERENCES `family` (`familly_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
