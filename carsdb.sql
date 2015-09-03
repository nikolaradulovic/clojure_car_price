-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2015 at 11:43 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `carsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE IF NOT EXISTS `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(30) DEFAULT NULL,
  `yearprod` int(11) DEFAULT NULL,
  `kilometres` int(11) DEFAULT NULL,
  `horsepower` int(11) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `manufracturerId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `manufracturerId` (`manufracturerId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`id`, `model`, `yearprod`, `kilometres`, `horsepower`, `price`, `manufracturerId`) VALUES
(1, 'Megan', 2006, 120000, 100, 3200, 1),
(2, 'Clio', 2004, 66000, 100, 2200, 1),
(4, 'X5', 2010, 45000, 130, 40000, 2),
(5, 'X3', 2011, 44320, 120, 30000, 2),
(9, 'Modus', 2013, 66323, 80, 4200, 1),
(10, 'Scenic', 2005, 140000, 90, 3600, 1),
(11, 'X6', 2012, 80000, 132, 42000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`cityId`),
  KEY `countryId` (`countryId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`cityId`, `name`, `countryId`) VALUES
(1, 'Munich', 2),
(2, 'Boulogne', 1);

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `countryId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`countryId`, `name`) VALUES
(1, 'France'),
(2, 'Germany');

-- --------------------------------------------------------

--
-- Table structure for table `manufracturer`
--

CREATE TABLE IF NOT EXISTS `manufracturer` (
  `manufracturerId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `yearFounded` int(11) NOT NULL,
  `cityId` int(11) NOT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`manufracturerId`),
  KEY `countryId` (`countryId`),
  KEY `cityId` (`cityId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `manufracturer`
--

INSERT INTO `manufracturer` (`manufracturerId`, `name`, `yearFounded`, `cityId`, `countryId`) VALUES
(1, 'Renault', 1898, 2, 1),
(2, 'BMW', 1916, 1, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `fk_city` FOREIGN KEY (`countryId`) REFERENCES `country` (`countryId`);

--
-- Constraints for table `manufracturer`
--
ALTER TABLE `manufracturer`
  ADD CONSTRAINT `manufracturer_ibfk_1` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`),
  ADD CONSTRAINT `fk_country` FOREIGN KEY (`countryId`) REFERENCES `country` (`countryId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
