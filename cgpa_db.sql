-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2020 at 06:06 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cgpa_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `coursedb`
--

CREATE TABLE `coursedb` (
  `courseName` varchar(100) NOT NULL,
  `midTermMarks` double(7,2) DEFAULT NULL,
  `finalTermMarks` double(7,2) DEFAULT NULL,
  `finalMarks` double(7,2) DEFAULT NULL,
  `courseType` varchar(30) DEFAULT NULL,
  `semesterName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coursedb`
--

INSERT INTO `coursedb` (`courseName`, `midTermMarks`, `finalTermMarks`, `finalMarks`, `courseType`, `semesterName`) VALUES
('ALGORITHMS [P]', 81.00, 95.00, 90.00, 'Theory', 'Spring, 208-19'),
('COMPLEX VARIABLE,LAPLACE & Z-TRANSFORMATION [V]', 91.00, 88.00, 90.00, 'Theory', 'Fall, 2018-19'),
('COMPUTER FUNDAMENTALS [CS] [B11a]', 94.00, 100.00, 98.00, 'Theory', 'Spring, 2017-18'),
('COMPUTER ORGANIZATION AND ARCHITECTURE [D]', 92.80, 81.00, 86.00, 'Theory', 'Summer, 2018-19'),
('DATA STRUCTURE [L]', 75.00, 90.00, 84.00, 'Theory', 'Fall, 2018-19'),
('DIFF CALCULUS AND COORDINATE GEOMETRY [CS] [B11]', 85.00, 98.00, 93.00, 'Theory', 'Spring, 2017-18'),
('DISCRETE MATHEMATICS [R]', 100.00, 98.00, 99.00, 'Theory', 'Summer,  2017-18'),
('ELECTRICAL CIRCUITS -1 (DC) [E]', 90.00, 90.00, 90.00, 'Theory', 'Spring, 208-19'),
('ELECTRICAL CIRCUITS -1 LAB (DC) [B]', 95.00, 90.00, 92.00, 'Lab', 'Spring, 208-19'),
('ELECTRICAL CIRCUITS 2 (AC) [J]', 75.00, 95.00, 87.00, 'Theory', 'Summer, 2018-19'),
('ELECTRICAL CIRCUITS-2 (AC) LAB [M]', 87.00, 97.00, 93.00, 'Lab', 'Summer, 2018-19'),
('ELECTRONIC DEVICES LAB [F]', 91.00, 93.00, 93.00, 'Lab', 'Fall, 2019-20'),
('ELECTRONIC DEVICES [H]', 90.00, 96.00, 94.00, 'Theory', 'Fall, 2019-20'),
('ENGLISH READING SKILLS & PUBLIC SPEAKING [CS] [B11]', 91.00, 92.00, 92.00, 'Theory', 'Spring, 2017-18'),
('ENGLISH WRITING SKILLS & COMMUNICATIONS [CS/ENGG] [K]', 91.00, 90.00, 91.00, 'Theory', 'Summer,  2017-18'),
('INTEGRAL CALCULUS & ORD. DIFF EQUATION [Z]', 95.00, 93.00, 94.00, 'Theory', 'Summer,  2017-18'),
('INTRODUCTION TO DATABASE [G]', 100.00, 95.00, 97.00, 'Theory', 'Fall, 2018-19'),
('MATRICES, VECTORS, FOURIER ANALYSIS [M]', 94.00, 90.00, 92.00, 'Theory', 'Spring, 208-19'),
('NUMERICAL METHODS FOR SCIENCE AND ENGINEERING [F]', 76.00, 99.00, 90.00, 'Theory', 'Summer, 2018-19'),
('OBJECT ORIENTED ANALYSIS AND DESIGN [K]', 84.00, 86.00, 86.00, 'Theory', 'Summer, 2018-19'),
('OBJECT ORIENTED PROGRAMMING 1 (JAVA) [Q]', 99.00, 98.00, 99.00, 'Theory', 'Summer, 2018-19'),
('OBJECT ORIENTED PROGRAMMING 2 [H]', 100.00, 99.00, 100.00, 'Theory', 'Fall, 2019-20'),
('OPERATING SYSTEM [J]', 95.00, 100.00, 98.00, 'Theory', 'Fall, 2019-20'),
('PHYSICS 1 LAB [J]', 86.00, 87.00, 87.00, 'Lab', 'Fall, 2018-19'),
('PHYSICS 1 [I]', 90.00, 91.00, 91.00, 'Theory', 'Fall, 2018-19'),
('PHYSICS 2 LAB [I]', 88.00, 82.60, 85.00, 'Lab', 'Spring, 208-19'),
('PHYSICS 2 [F]', 86.50, 96.00, 93.00, 'Theory', 'Spring, 208-19'),
('PRINCIPLES OF ACCOUNTING [I]', 98.00, 100.00, 100.00, 'Theory', 'Summer,  2017-18'),
('PRINCIPLES OF ECONOMICS [B11]', 85.00, 95.00, 91.00, 'Theory', 'Spring, 2017-18'),
('PROGRAMMING LANGUAGE 1 (CS) [B11a]', 90.00, 90.00, 90.00, 'Theory', 'Spring, 2017-18'),
('PROGRAMMING LANGUAGE 2 (CS) [M]', 98.00, 85.00, 91.00, 'Theory', 'Summer,  2017-18'),
('SOFTWARE ENGINEERING [G]', 96.00, 90.00, 93.00, 'Theory', 'Fall, 2019-20'),
('STATISTICS AND PROBABILITY [N]', 92.00, 95.00, 94.00, 'Theory', 'Fall, 2018-19'),
('THEORY OF COMPUTATION [G]', 100.00, 92.00, 96.00, 'Theory', 'Fall, 2019-20');

-- --------------------------------------------------------

--
-- Table structure for table `semesterdb`
--

CREATE TABLE `semesterdb` (
  `semesterName` varchar(100) NOT NULL,
  `c1` varchar(100) DEFAULT NULL,
  `c2` varchar(100) DEFAULT NULL,
  `c3` varchar(100) DEFAULT NULL,
  `c4` varchar(100) DEFAULT NULL,
  `c5` varchar(100) DEFAULT NULL,
  `c6` varchar(100) DEFAULT NULL,
  `GPA_Semester` double(7,2) DEFAULT NULL,
  `CGPA_Semester` double(7,2) DEFAULT NULL,
  `takenCredits` int(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semesterdb`
--

INSERT INTO `semesterdb` (`semesterName`, `c1`, `c2`, `c3`, `c4`, `c5`, `c6`, `GPA_Semester`, `CGPA_Semester`, `takenCredits`) VALUES
('Fall, 2018-19', 'PHYSICS 1 [I]', 'COMPLEX VARIABLE,LAPLACE & Z-TRANSFORMATION [V]', 'INTRODUCTION TO DATABASE [G]', 'DATA STRUCTURE [L]', 'STATISTICS AND PROBABILITY [N]', 'PHYSICS 1 LAB [J]', 3.89, 3.96, 16),
('Fall, 2019-20', 'OBJECT ORIENTED PROGRAMMING 2 [H]', 'OPERATING SYSTEM [J]', 'ELECTRONIC DEVICES [H]', 'SOFTWARE ENGINEERING [G]', 'THEORY OF COMPUTATION [G]', 'ELECTRONIC DEVICES LAB [F]', 4.00, 3.95, 16),
('Spring, 2017-18', 'ENGLISH READING SKILLS & PUBLIC SPEAKING [CS] [B11]', 'DIFF CALCULUS AND COORDINATE GEOMETRY [CS] [B11]', 'PRINCIPLES OF ECONOMICS [B11]', 'COMPUTER FUNDAMENTALS [CS] [B11a]', 'PROGRAMMING LANGUAGE 1 (CS) [B11a]', 'null', 4.00, 3.94, 15),
('Spring, 208-19', 'PHYSICS 2 [F]', 'PHYSICS 2 LAB [I]', 'MATRICES, VECTORS, FOURIER ANALYSIS [M]', 'ALGORITHMS [P]', 'ELECTRICAL CIRCUITS -1 (DC) [E]', 'ELECTRICAL CIRCUITS -1 LAB (DC) [B]', 3.98, 3.97, 14),
('Summer,  2017-18', 'DISCRETE MATHEMATICS [R]', 'PROGRAMMING LANGUAGE 2 (CS) [M]', 'ENGLISH WRITING SKILLS & COMMUNICATIONS [CS/ENGG] [K]', 'INTEGRAL CALCULUS & ORD. DIFF EQUATION [Z]', 'PRINCIPLES OF ACCOUNTING [I]', 'null', 4.00, 3.95, 15),
('Summer, 2018-19', 'ELECTRICAL CIRCUITS 2 (AC) [J]', 'COMPUTER ORGANIZATION AND ARCHITECTURE [D]', 'OBJECT ORIENTED PROGRAMMING 1 (JAVA) [Q]', 'ELECTRICAL CIRCUITS-2 (AC) LAB [M]', 'NUMERICAL METHODS FOR SCIENCE AND ENGINEERING [F]', 'OBJECT ORIENTED ANALYSIS AND DESIGN [K]', 3.86, 3.93, 16);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coursedb`
--
ALTER TABLE `coursedb`
  ADD PRIMARY KEY (`courseName`);

--
-- Indexes for table `semesterdb`
--
ALTER TABLE `semesterdb`
  ADD PRIMARY KEY (`semesterName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
