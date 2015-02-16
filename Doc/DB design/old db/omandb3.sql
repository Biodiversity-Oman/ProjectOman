-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 16 feb 2015 om 13:11
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
-- Tabelstructuur voor tabel `downloads`
--

CREATE TABLE IF NOT EXISTS `downloads` (
  `downloads_id` int(11) NOT NULL,
  `world_id` int(11) DEFAULT NULL,
  `download_funstuff` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`downloads_id`),
  KEY `world_id` (`world_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `family`
--

CREATE TABLE IF NOT EXISTS `family` (
  `family_id` int(11) NOT NULL AUTO_INCREMENT,
  `family_name` varchar(50) NOT NULL,
  `family_description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`family_id`),
  UNIQUE KEY `FamilyName` (`family_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Gegevens worden uitgevoerd voor tabel `family`
--

INSERT INTO `family` (`family_id`, `family_name`, `family_description`) VALUES
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
  `eaten_by_organism_id` int(11) DEFAULT NULL,
  `eating_organism_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  KEY `Eaten_Organism_ID` (`eaten_by_organism_id`),
  KEY `Eating_organism_ID` (`eating_organism_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geolocation`
--

CREATE TABLE IF NOT EXISTS `geolocation` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geolocation_organisme`
--

CREATE TABLE IF NOT EXISTS `geolocation_organisme` (
  `organism_id` int(11) NOT NULL,
  `geolocation_id` int(11) NOT NULL,
  KEY `organism_id` (`organism_id`),
  KEY `geolocation_id` (`geolocation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `habitat`
--

CREATE TABLE IF NOT EXISTS `habitat` (
  `habitat_id` int(11) NOT NULL AUTO_INCREMENT,
  `habitat_name` varchar(50) DEFAULT NULL,
  `description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`habitat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `habitat_organism`
--

CREATE TABLE IF NOT EXISTS `habitat_organism` (
  `habitat_id` int(11) DEFAULT NULL,
  `organism_id` int(11) DEFAULT NULL,
  KEY `habitat_id` (`habitat_id`),
  KEY `organism_id` (`organism_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organism`
--

CREATE TABLE IF NOT EXISTS `organism` (
  `organism_id` int(11) NOT NULL AUTO_INCREMENT,
  `scientific_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `common_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `local_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `subfamily_id` int(11) DEFAULT NULL,
  `world_id` int(11) DEFAULT NULL,
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
  `food_name` varchar(50) NOT NULL,
  `food_description` varchar(10000) NOT NULL,
  `isvalidated` tinyint(1) NOT NULL,
  `date_input` datetime NOT NULL,
  PRIMARY KEY (`organism_id`),
  UNIQUE KEY `SCIENTIFICNAME` (`scientific_name`),
  KEY `FAMILYID` (`subfamily_id`),
  KEY `subfamily_id` (`subfamily_id`),
  KEY `world` (`world_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organism_season`
--

CREATE TABLE IF NOT EXISTS `organism_season` (
  `organism_id` int(11) DEFAULT NULL,
  `season_id` int(11) DEFAULT NULL,
  KEY `living_organism_id` (`organism_id`),
  KEY `season_id` (`season_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `organism_id` int(11) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `post_description` varchar(10000) DEFAULT NULL,
  `photo_post` mediumblob,
  `longitude` varchar(50) DEFAULT NULL,
  `latitude` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `LivingOrganismID` (`organism_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `season`
--

CREATE TABLE IF NOT EXISTS `season` (
  `season_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `description` varchar(10000) NOT NULL,
  PRIMARY KEY (`season_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subfamily`
--

CREATE TABLE IF NOT EXISTS `subfamily` (
  `subfamily_id` int(11) NOT NULL AUTO_INCREMENT,
  `family_id` int(11) NOT NULL,
  `subfamily_name` varchar(50) NOT NULL,
  `subfamily_description` varchar(2000) NOT NULL,
  PRIMARY KEY (`subfamily_id`),
  KEY `family_id` (`family_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subscribed`
--

CREATE TABLE IF NOT EXISTS `subscribed` (
  `subscribed_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`subscribed_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `user_account`
--

CREATE TABLE IF NOT EXISTS `user_account` (
  `user_account_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `password` char(60) NOT NULL,
  `username` varchar(50) NOT NULL,
  `isadmin` tinyint(1) NOT NULL,
  `phone` varchar(50) NOT NULL,
  PRIMARY KEY (`user_account_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Gegevens worden uitgevoerd voor tabel `user_account`
--

INSERT INTO `user_account` (`user_account_id`, `first_name`, `last_name`, `email`, `city`, `country`, `password`, `username`, `isadmin`, `phone`) VALUES
(1, 'test', '', 'test', 'fsdfsdf', 'test', '$2a$10$mgSBZu.7A3F7iaLotdCBUeMGjV7fyhIZdmSE8vdjkSAhM4N51KcDC', 'test', 0, '0');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `world`
--

CREATE TABLE IF NOT EXISTS `world` (
  `world_id` int(11) NOT NULL AUTO_INCREMENT,
  `world_name` varchar(50) NOT NULL,
  `world_description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`world_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Beperkingen voor gedumpte tabellen
--

--
-- Beperkingen voor tabel `downloads`
--
ALTER TABLE `downloads`
  ADD CONSTRAINT `downloads_ibfk_1` FOREIGN KEY (`world_id`) REFERENCES `world` (`world_id`);

--
-- Beperkingen voor tabel `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `Fk_LivingOrganismEatening_ID` FOREIGN KEY (`eating_organism_id`) REFERENCES `organism` (`organism_id`),
  ADD CONSTRAINT `Fk_LivingOrganismEaten_ID` FOREIGN KEY (`eaten_by_organism_id`) REFERENCES `organism` (`organism_id`);

--
-- Beperkingen voor tabel `geolocation_organisme`
--
ALTER TABLE `geolocation_organisme`
  ADD CONSTRAINT `geolocation_organisme_ibfk_1` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`),
  ADD CONSTRAINT `geolocation_organisme_ibfk_2` FOREIGN KEY (`geolocation_id`) REFERENCES `geolocation` (`geolocation_id`);

--
-- Beperkingen voor tabel `habitat_organism`
--
ALTER TABLE `habitat_organism`
  ADD CONSTRAINT `habitat_organism_ibfk_1` FOREIGN KEY (`habitat_id`) REFERENCES `habitat` (`habitat_id`),
  ADD CONSTRAINT `habitat_organism_ibfk_2` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`);

--
-- Beperkingen voor tabel `organism`
--
ALTER TABLE `organism`
  ADD CONSTRAINT `organism_ibfk_1` FOREIGN KEY (`subfamily_id`) REFERENCES `subfamily` (`family_id`),
  ADD CONSTRAINT `organism_ibfk_5` FOREIGN KEY (`world_id`) REFERENCES `world` (`world_id`);

--
-- Beperkingen voor tabel `organism_season`
--
ALTER TABLE `organism_season`
  ADD CONSTRAINT `organism_season_ibfk_1` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`),
  ADD CONSTRAINT `organism_season_ibfk_2` FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`);

--
-- Beperkingen voor tabel `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_Livingorganisms_ID` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`);

--
-- Beperkingen voor tabel `subfamily`
--
ALTER TABLE `subfamily`
  ADD CONSTRAINT `subfamily_ibfk_1` FOREIGN KEY (`family_id`) REFERENCES `family` (`family_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;