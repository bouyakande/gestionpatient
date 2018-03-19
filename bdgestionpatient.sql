-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2018 at 12:24 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bdgestionpatient`
--

-- --------------------------------------------------------

--
-- Table structure for table `antecedentpatient`
--

CREATE TABLE IF NOT EXISTS `antecedentpatient` (
  `idA` int(11) NOT NULL AUTO_INCREMENT,
  `AntecedentMedicaux` text NOT NULL,
  `AntecedentChirurgicaux` text NOT NULL,
  `AntecedentFamiliaux` text NOT NULL,
  `AlergiesIntolérance` text NOT NULL,
  `Dossier` int(11) NOT NULL,
  PRIMARY KEY (`idA`),
  KEY `Dossier` (`Dossier`),
  KEY `Dossier_2` (`Dossier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `consultation`
--

CREATE TABLE IF NOT EXISTS `consultation` (
  `idconsul` int(11) NOT NULL AUTO_INCREMENT,
  `MotifConsultation` varchar(80) NOT NULL,
  `Taille` varchar(80) NOT NULL,
  `Poids` varchar(40) NOT NULL,
  `Temperature` varchar(25) NOT NULL,
  `Pouls` varchar(25) NOT NULL,
  `Observation` text NOT NULL,
  `Date` date NOT NULL,
  `Dossier` int(11) NOT NULL,
  PRIMARY KEY (`idconsul`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `dossierpatients`
--

CREATE TABLE IF NOT EXISTS `dossierpatients` (
  `iddossier` int(11) NOT NULL AUTO_INCREMENT,
  `matricul` varchar(80) NOT NULL,
  `idPatient` int(11) NOT NULL,
  `Dossierper` int(11) NOT NULL,
  `DatecCeationS` date NOT NULL,
  PRIMARY KEY (`iddossier`),
  KEY `idPatient` (`idPatient`,`Dossierper`),
  KEY `Dossierper` (`Dossierper`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `idemp` int(11) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(20) NOT NULL,
  `nom` varchar(80) NOT NULL,
  `prenom` varchar(80) NOT NULL,
  `fonction` varchar(50) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `adresse` varchar(150) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`idemp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`idemp`, `matricule`, `nom`, `prenom`, `fonction`, `telephone`, `adresse`, `email`) VALUES
(1, '1', 'charice', 'balkisse', 'gestion de projet', '778000413', 'geulle tappé', 'balkisshassan5@gmail.com'),
(2, '2', 'hassan', 'ladane', 'architecture', '7702536923', 'gueulle tapé', 'ladane@gmail.com'),
(3, 'mat', 'nom', 'prnm', 'fonction', 'tel', 'adr', 'email');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE IF NOT EXISTS `patients` (
  `Nom` varchar(80) NOT NULL,
  `prenom` varchar(80) NOT NULL,
  `adresses` varchar(80) NOT NULL,
  `lieunaissance` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `genre` varchar(15) NOT NULL,
  `dateNaissance` date NOT NULL,
  `idPatient` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPatient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profil` varchar(20) NOT NULL,
  `statut` varchar(20) NOT NULL,
  `idemp` int(11) NOT NULL,
  PRIMARY KEY (`iduser`),
  KEY `idemp` (`idemp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `login`, `password`, `profil`, `statut`, `idemp`) VALUES
(1, 'login', 'passer', 'admin', 'debloquer', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `antecedentpatient`
--
ALTER TABLE `antecedentpatient`
  ADD CONSTRAINT `antecedentpatient_ibfk_1` FOREIGN KEY (`Dossier`) REFERENCES `dossierpatients` (`iddossier`);

--
-- Constraints for table `dossierpatients`
--
ALTER TABLE `dossierpatients`
  ADD CONSTRAINT `dossierpatients_ibfk_3` FOREIGN KEY (`Dossierper`) REFERENCES `dossierpatients` (`iddossier`),
  ADD CONSTRAINT `dossierpatients_ibfk_1` FOREIGN KEY (`idPatient`) REFERENCES `patients` (`idPatient`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`idemp`) REFERENCES `employe` (`idemp`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
