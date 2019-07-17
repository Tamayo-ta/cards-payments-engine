-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Jul 17, 2019 at 08:17 PM
-- Server version: 8.0.15
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app-cards`
--

-- --------------------------------------------------------

--
-- Table structure for table `Card`
--

CREATE TABLE `Card` (
  `Id` bigint(20) NOT NULL,
  `Country` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  `Status` int(11) NOT NULL,
  `OwnerId` int(11) NOT NULL,
  `Number` bigint(20) NOT NULL,
  `Cvv` smallint(6) NOT NULL,
  `Pin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `Card`
--

INSERT INTO `Card` (`Id`, `Country`, `Status`, `OwnerId`, `Number`, `Cvv`, `Pin`) VALUES
(1, 'ES', 1, 1, 2000909709703266, 161, 1411),
(2, 'GB', 1, 2, 9293680621983676, 350, 7975);

-- --------------------------------------------------------

--
-- Table structure for table `CardStatus`
--

CREATE TABLE `CardStatus` (
  `id` int(11) NOT NULL,
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `CardStatus`
--

INSERT INTO `CardStatus` (`id`, `description`) VALUES
(-3, 'Defective'),
(-2, 'Lost'),
(-1, 'Stolen'),
(0, 'Disabled'),
(1, 'Enabled'),
(2, 'Fraud checking'),
(3, 'Expired');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Card`
--
ALTER TABLE `Card`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Number` (`Number`),
  ADD UNIQUE KEY `OwnerId_2` (`OwnerId`);

--
-- Indexes for table `CardStatus`
--
ALTER TABLE `CardStatus`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Card`
--
ALTER TABLE `Card`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
