-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 30, 2015 at 12:58 PM
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
  `model` varchar(30) NOT NULL,
  `yearprod` int(11) NOT NULL,
  `kilometres` int(11) NOT NULL,
  `horsepower` int(11) NOT NULL,
  `manufracturerId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `manufracturerId` (`manufracturerId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`id`, `model`, `yearprod`, `kilometres`, `horsepower`, `manufracturerId`) VALUES
(1, 'Megan', 2005, 120000, 100, 1),
(2, 'Clio', 2006, 66000, 100, 1),
(3, 'Megan', 2009, 80323, 110, 1),
(4, 'X5', 2010, 45000, 130, 2),
(5, 'X3', 2011, 44320, 120, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
