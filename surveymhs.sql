-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2020 at 06:31 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `surveymhs`
--

-- --------------------------------------------------------

--
-- Table structure for table `survey`
--

CREATE TABLE `survey` (
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(255) DEFAULT NULL,
  `negBag` varchar(255) DEFAULT NULL,
  `pos` varchar(255) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `suka` varchar(255) DEFAULT NULL,
  `how` varchar(255) DEFAULT NULL,
  `rekomendasi` varchar(255) DEFAULT NULL,
  `komentar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey`
--

INSERT INTO `survey` (`nama`, `email`, `alamat`, `kota`, `negBag`, `pos`, `tgl`, `suka`, `how`, `rekomendasi`, `komentar`) VALUES
('AA', 'AA', 'AA', 'AA', 'AA', 'AA', '2020-06-17', 'Suasana', 'Televisi', NULL, 'adssad'),
('Jo', 'jo@gmail', 'Klaten', 'Klaten', 'diy', '3127', '2020-06-09', 'Kampus', 'Teman', 'Sangat Mungkin', 'sANGAT mEMMUASTKAN KARENA MANTAP'),
('Kukuh', 'kukuh@gmail.com', 'Jl. Brebes', 'Brebes', 'Jawa Tengah', '52272', '2020-06-08', 'Suasana', 'Internet', 'Sangat', 'Sangat Mantap');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `survey`
--
ALTER TABLE `survey`
  ADD PRIMARY KEY (`nama`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
