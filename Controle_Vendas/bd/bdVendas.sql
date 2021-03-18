-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 18-Mar-2021 às 04:45
-- Versão do servidor: 5.7.26
-- versão do PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdvendas`
--
CREATE DATABASE IF NOT EXISTS `bdvendas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdvendas`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcliente`
--

DROP TABLE IF EXISTS `tbcliente`;
CREATE TABLE IF NOT EXISTS `tbcliente` (
  `cpfCli` varchar(20) NOT NULL,
  `nomeCli` varchar(50) NOT NULL,
  PRIMARY KEY (`cpfCli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbcliente`
--

INSERT INTO `tbcliente` (`cpfCli`, `nomeCli`) VALUES
('111', 'teste'),
('1212', 'Chico'),
('1234', 'Gustavo'),
('12345', 'Thais'),
('12346', 'Fulano'),
('12347', 'kdsjnhas'),
('46872162856', 'Gustavo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbestoque`
--

DROP TABLE IF EXISTS `tbestoque`;
CREATE TABLE IF NOT EXISTS `tbestoque` (
  `codProd` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProd` varchar(50) NOT NULL,
  `descricaoProd` varchar(100) NOT NULL,
  `quantidadeProd` int(11) NOT NULL,
  `precoProd` double NOT NULL,
  PRIMARY KEY (`codProd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;