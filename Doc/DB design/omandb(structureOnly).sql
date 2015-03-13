-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 08 mrt 2015 om 20:34
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
-- Tabelstructuur voor tabel `download`
--

CREATE TABLE IF NOT EXISTS `download` (
  `download_id` int(11) NOT NULL AUTO_INCREMENT,
  `world_id` int(11) DEFAULT NULL,
  `download_funstuff` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`download_id`),
  KEY `world_id` (`world_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `family`
--

CREATE TABLE IF NOT EXISTS `family` (
  `family_id` int(11) NOT NULL AUTO_INCREMENT,
  `family_name` varchar(50) NOT NULL,
  `family_description` varchar(10000) DEFAULT NULL,
  `world_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`family_id`),
  UNIQUE KEY `FamilyName` (`family_name`),
  KEY `fk_world_id_idx` (`world_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `food`
--

CREATE TABLE IF NOT EXISTS `food` (
  `eaten_by_organism_id` int(11) NOT NULL,
  `eating_organism_id` int(11) NOT NULL,
  KEY `Eaten_Organism_ID` (`eaten_by_organism_id`),
  KEY `Eating_organism_ID` (`eating_organism_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geolocation`
--

CREATE TABLE IF NOT EXISTS `geolocation` (
  `geolocation_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(50) NOT NULL,
  `area_description` varchar(10000) NOT NULL,
  `coordinates` varchar(2000) NOT NULL,
  PRIMARY KEY (`geolocation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geolocation_organism`
--

CREATE TABLE IF NOT EXISTS `geolocation_organism` (
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
  `habitat_description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`habitat_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `habitat_organism`
--

CREATE TABLE IF NOT EXISTS `habitat_organism` (
  `habitat_id` int(11) NOT NULL,
  `organism_id` int(11) NOT NULL,
  KEY `habitat_id` (`habitat_id`),
  KEY `organism_id` (`organism_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organism`
--

CREATE TABLE IF NOT EXISTS `organism` (
  `organism_id` int(11) NOT NULL AUTO_INCREMENT,
  `scientific_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `common_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `local_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `subfamily_id` int(11) DEFAULT NULL,
  `organism_description` varchar(9000) CHARACTER SET utf8 DEFAULT NULL,
  `population` varchar(100) DEFAULT NULL,
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
  `isvalidated` tinyint(1) NOT NULL DEFAULT '0',
  `inserted_on` date NOT NULL,
  `updated_on` date DEFAULT NULL,
  PRIMARY KEY (`organism_id`),
  UNIQUE KEY `SCIENTIFICNAME` (`scientific_name`),
  KEY `subfamily_id` (`subfamily_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organism_season`
--

CREATE TABLE IF NOT EXISTS `organism_season` (
  `organism_id` int(11) NOT NULL,
  `season_id` int(11) NOT NULL,
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
  `post_first_name` varchar(50) DEFAULT NULL,
  `post_last_name` varchar(200) NOT NULL,
  `post_email` varchar(200) NOT NULL,
  `post_description` varchar(10000) DEFAULT NULL,
  `post_photo` mediumblob,
  `post_longitude` varchar(50) DEFAULT NULL,
  `post_latitude` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `LivingOrganismID` (`organism_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `season`
--

CREATE TABLE IF NOT EXISTS `season` (
  `season_id` int(11) NOT NULL AUTO_INCREMENT,
  `season_name` varchar(50) NOT NULL,
  `season_description` varchar(10000) NOT NULL,
  PRIMARY KEY (`season_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subfamily`
--

CREATE TABLE IF NOT EXISTS `subfamily` (
  `subfamily_id` int(11) NOT NULL AUTO_INCREMENT,
  `family_id` int(11) DEFAULT NULL,
  `subfamily_name` varchar(50) NOT NULL,
  `subfamily_description` varchar(2000) NOT NULL,
  PRIMARY KEY (`subfamily_id`),
  KEY `family_id` (`family_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subscriber`
--

CREATE TABLE IF NOT EXISTS `subscriber` (
  `subscriber_id` int(11) NOT NULL AUTO_INCREMENT,
  `subscriber_first_name` varchar(50) DEFAULT NULL,
  `subscriber_last_name` varchar(200) NOT NULL,
  `subscriber_email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`subscriber_id`),
  UNIQUE KEY `subscriber_email` (`subscriber_email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `user_account`
--

CREATE TABLE IF NOT EXISTS `user_account` (
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
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `world`
--

CREATE TABLE IF NOT EXISTS `world` (
  `world_id` int(11) NOT NULL AUTO_INCREMENT,
  `world_name` varchar(50) NOT NULL,
  `world_description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`world_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;
--
-- Beperkingen voor tabel `download`
--
ALTER TABLE `download`
  ADD CONSTRAINT `fk_download_world` FOREIGN KEY (`world_id`) REFERENCES `world` (`world_id`);

--
-- Beperkingen voor tabel `family`
--
ALTER TABLE `family`
  ADD CONSTRAINT `fk_family_world` FOREIGN KEY (`world_id`) REFERENCES `world` (`world_id`);

--
-- Beperkingen voor tabel `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `fk_eatenby_eating` FOREIGN KEY (`eaten_by_organism_id`) REFERENCES `organism` (`organism_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_eating_eatenby` FOREIGN KEY (`eating_organism_id`) REFERENCES `organism` (`organism_id`) ON DELETE CASCADE;

--
-- Beperkingen voor tabel `geolocation_organism`
--
ALTER TABLE `geolocation_organism`
  ADD CONSTRAINT `fk_geolocation_organism` FOREIGN KEY (`geolocation_id`) REFERENCES `geolocation` (`geolocation_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_organism_geolocation` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`) ON DELETE CASCADE;

--
-- Beperkingen voor tabel `habitat_organism`
--
ALTER TABLE `habitat_organism`
  ADD CONSTRAINT `fk_habitat_organism` FOREIGN KEY (`habitat_id`) REFERENCES `habitat` (`habitat_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_organism_habitat` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`) ON DELETE CASCADE;

--
-- Beperkingen voor tabel `organism`
--
ALTER TABLE `organism`
  ADD CONSTRAINT `fk_organism_subfamily` FOREIGN KEY (`subfamily_id`) REFERENCES `subfamily` (`subfamily_id`);

--
-- Beperkingen voor tabel `organism_season`
--
ALTER TABLE `organism_season`
  ADD CONSTRAINT `fk_organism_season` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_season_organism` FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`) ON DELETE CASCADE;

--
-- Beperkingen voor tabel `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `fk_post_organism` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`);

--
-- Beperkingen voor tabel `subfamily`
--
ALTER TABLE `subfamily`
  ADD CONSTRAINT `fk_subfamily_family` FOREIGN KEY (`family_id`) REFERENCES `family` (`family_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
