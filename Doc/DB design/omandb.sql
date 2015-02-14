-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Gegenereerd op: 14 feb 2015 om 14:47
-- Serverversie: 5.6.21
-- PHP-versie: 5.6.3

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
  `download_funstuff` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `family`
--

CREATE TABLE IF NOT EXISTS `family` (
`family_id` int(11) NOT NULL,
  `family_name` varchar(50) NOT NULL,
  `description` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `family`
--

INSERT INTO `family` (`family_id`, `family_name`, `description`) VALUES
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
`food_id` int(11) NOT NULL,
  `eaten_by_organism_id` int(11) DEFAULT NULL,
  `eating_organism_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geolocation`
--

CREATE TABLE IF NOT EXISTS `geolocation` (
`geolocation_id` int(11) NOT NULL,
  `organism_id` int(11) NOT NULL,
  `area_name` varchar(50) NOT NULL,
  `area_description` varchar(10000) NOT NULL,
  `latitude_height_1` varchar(50) DEFAULT NULL,
  `longitude_height_1` varchar(50) DEFAULT NULL,
  `latitude_width_1` varchar(50) DEFAULT NULL,
  `longitude_width_1` varchar(50) DEFAULT NULL,
  `latitude_height_2` varchar(50) DEFAULT NULL,
  `longitude_height_2` varchar(50) DEFAULT NULL,
  `latitude_width_2` varchar(50) DEFAULT NULL,
  `longitude_width_2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `habitat`
--

CREATE TABLE IF NOT EXISTS `habitat` (
`habitat_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `habitat_organism`
--

CREATE TABLE IF NOT EXISTS `habitat_organism` (
`habitat_organism_id` int(11) NOT NULL,
  `habitat_id` int(11) DEFAULT NULL,
  `organism_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organism`
--

CREATE TABLE IF NOT EXISTS `organism` (
`organism_id` int(11) NOT NULL,
  `scientific_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `commmon_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `local_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `subfamily_id` int(11) DEFAULT NULL,
  `world_id` int(11) DEFAULT NULL,
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
  `links` varchar(2000) DEFAULT NULL,
  `qr` blob,
  `food_name` varchar(50) NOT NULL,
  `food_description` varchar(10000) NOT NULL,
  `isvalidated` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organism_season`
--

CREATE TABLE IF NOT EXISTS `organism_season` (
`organism_season_id` int(11) NOT NULL,
  `living_organism_id` int(11) DEFAULT NULL,
  `season_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `post`
--

CREATE TABLE IF NOT EXISTS `post` (
`post_id` int(11) NOT NULL,
  `organism_id` int(11) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `description` varchar(10000) DEFAULT NULL,
  `photo_post` mediumblob,
  `longitude` varchar(50) DEFAULT NULL,
  `latitude` varchar(50) DEFAULT NULL,
  `news_letter` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `season`
--

CREATE TABLE IF NOT EXISTS `season` (
`season_id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `description` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subfamily`
--

CREATE TABLE IF NOT EXISTS `subfamily` (
`subfamily_id` int(11) NOT NULL,
  `family_id` int(11) NOT NULL,
  `subfamily_name` varchar(50) NOT NULL,
  `description` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `user_accounts`
--

CREATE TABLE IF NOT EXISTS `user_accounts` (
`admin_id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  `password` char(60) NOT NULL,
  `username` varchar(50) NOT NULL,
  `isadmin` tinyint(1) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `user_accounts`
--

INSERT INTO `user_accounts` (`admin_id`, `first_name`, `last_name`, `email`, `city`, `country`, `address`, `password`, `username`, `isadmin`, `phone`) VALUES
(1, 'test', 'test', 'test', 'fsdfsdf', 'test', 'test', '$2a$10$mgSBZu.7A3F7iaLotdCBUeMGjV7fyhIZdmSE8vdjkSAhM4N51KcDC', 'test', 0, 0);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `worlds`
--

CREATE TABLE IF NOT EXISTS `worlds` (
`world_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `downloads`
--
ALTER TABLE `downloads`
 ADD PRIMARY KEY (`downloads_id`), ADD KEY `world_id` (`world_id`);

--
-- Indexen voor tabel `family`
--
ALTER TABLE `family`
 ADD PRIMARY KEY (`family_id`), ADD UNIQUE KEY `FamilyName` (`family_name`);

--
-- Indexen voor tabel `food`
--
ALTER TABLE `food`
 ADD PRIMARY KEY (`food_id`), ADD KEY `Eaten_Organism_ID` (`eaten_by_organism_id`), ADD KEY `Eating_organism_ID` (`eating_organism_id`);

--
-- Indexen voor tabel `geolocation`
--
ALTER TABLE `geolocation`
 ADD PRIMARY KEY (`geolocation_id`), ADD KEY `organism_id` (`organism_id`);

--
-- Indexen voor tabel `habitat`
--
ALTER TABLE `habitat`
 ADD PRIMARY KEY (`habitat_id`);

--
-- Indexen voor tabel `habitat_organism`
--
ALTER TABLE `habitat_organism`
 ADD PRIMARY KEY (`habitat_organism_id`), ADD KEY `habitat_id` (`habitat_id`), ADD KEY `organism_id` (`organism_id`);

--
-- Indexen voor tabel `organism`
--
ALTER TABLE `organism`
 ADD PRIMARY KEY (`organism_id`), ADD UNIQUE KEY `SCIENTIFICNAME` (`scientific_name`), ADD KEY `FAMILYID` (`subfamily_id`), ADD KEY `subfamily_id` (`subfamily_id`), ADD KEY `season_id` (`season_id`), ADD KEY `season_id_2` (`season_id`), ADD KEY `world` (`world_id`);

--
-- Indexen voor tabel `organism_season`
--
ALTER TABLE `organism_season`
 ADD PRIMARY KEY (`organism_season_id`), ADD KEY `living_organism_id` (`living_organism_id`), ADD KEY `season_id` (`season_id`);

--
-- Indexen voor tabel `post`
--
ALTER TABLE `post`
 ADD PRIMARY KEY (`post_id`), ADD KEY `LivingOrganismID` (`organism_id`);

--
-- Indexen voor tabel `season`
--
ALTER TABLE `season`
 ADD PRIMARY KEY (`season_id`);

--
-- Indexen voor tabel `subfamily`
--
ALTER TABLE `subfamily`
 ADD PRIMARY KEY (`subfamily_id`), ADD KEY `family_id` (`family_id`);

--
-- Indexen voor tabel `user_accounts`
--
ALTER TABLE `user_accounts`
 ADD PRIMARY KEY (`admin_id`);

--
-- Indexen voor tabel `worlds`
--
ALTER TABLE `worlds`
 ADD PRIMARY KEY (`world_id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `family`
--
ALTER TABLE `family`
MODIFY `family_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT voor een tabel `food`
--
ALTER TABLE `food`
MODIFY `food_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `geolocation`
--
ALTER TABLE `geolocation`
MODIFY `geolocation_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `habitat`
--
ALTER TABLE `habitat`
MODIFY `habitat_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `habitat_organism`
--
ALTER TABLE `habitat_organism`
MODIFY `habitat_organism_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `organism`
--
ALTER TABLE `organism`
MODIFY `organism_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `organism_season`
--
ALTER TABLE `organism_season`
MODIFY `organism_season_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `post`
--
ALTER TABLE `post`
MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `season`
--
ALTER TABLE `season`
MODIFY `season_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `subfamily`
--
ALTER TABLE `subfamily`
MODIFY `subfamily_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `user_accounts`
--
ALTER TABLE `user_accounts`
MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `worlds`
--
ALTER TABLE `worlds`
MODIFY `world_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `downloads`
--
ALTER TABLE `downloads`
ADD CONSTRAINT `downloads_ibfk_1` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`world_id`);

--
-- Beperkingen voor tabel `food`
--
ALTER TABLE `food`
ADD CONSTRAINT `Fk_LivingOrganismEaten_ID` FOREIGN KEY (`eaten_by_organism_id`) REFERENCES `organism` (`organism_id`),
ADD CONSTRAINT `Fk_LivingOrganismEatening_ID` FOREIGN KEY (`eating_organism_id`) REFERENCES `organism` (`organism_id`);

--
-- Beperkingen voor tabel `geolocation`
--
ALTER TABLE `geolocation`
ADD CONSTRAINT `geolocation_ibfk_1` FOREIGN KEY (`organism_id`) REFERENCES `organism` (`organism_id`);

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
ADD CONSTRAINT `organism_ibfk_5` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`world_id`),
ADD CONSTRAINT `organism_ibfk_7` FOREIGN KEY (`season_id`) REFERENCES `organism_season` (`season_id`);

--
-- Beperkingen voor tabel `organism_season`
--
ALTER TABLE `organism_season`
ADD CONSTRAINT `organism_season_ibfk_1` FOREIGN KEY (`living_organism_id`) REFERENCES `organism` (`organism_id`),
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
