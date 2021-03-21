-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21-Mar-2021 às 02:23
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdvendas`
--
CREATE DATABASE IF NOT EXISTS `bdvendas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdvendas`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcliente`
--

CREATE TABLE `tbcliente` (
  `cpfCli` varchar(20) NOT NULL,
  `nomeCli` varchar(50) NOT NULL
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

CREATE TABLE `tbestoque` (
  `codProd` int(11) NOT NULL,
  `nomeProd` varchar(50) NOT NULL,
  `descricaoProd` varchar(100) NOT NULL,
  `quantidadeProd` int(11) NOT NULL,
  `precoProd` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbestoque`
--

INSERT INTO `tbestoque` (`codProd`, `nomeProd`, `descricaoProd`, `quantidadeProd`, `precoProd`) VALUES
(1, 'ckdoopkc', 'okopkopok', 1, 20);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbvenda`
--

CREATE TABLE `tbvenda` (
  `nomeCli` varchar(50) NOT NULL,
  `codProd` int(11) NOT NULL,
  `nomeProd` varchar(50) NOT NULL,
  `descricaoProd` varchar(100) NOT NULL,
  `totalVenda` double NOT NULL,
  `precoProd` double NOT NULL,
  `quantidadeItens` int(11) NOT NULL,
  `cpfCli` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbvenda`
--

INSERT INTO `tbvenda` (`nomeCli`, `codProd`, `nomeProd`, `descricaoProd`, `totalVenda`, `precoProd`, `quantidadeItens`, `cpfCli`) VALUES
('Gustavo', 1, 'ckdoopkc', 'okopkopok', 40, 20, 2, '1234');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`cpfCli`);

--
-- Índices para tabela `tbestoque`
--
ALTER TABLE `tbestoque`
  ADD PRIMARY KEY (`codProd`);

--
-- Índices para tabela `tbvenda`
--
ALTER TABLE `tbvenda`
  ADD KEY `fk_codProd` (`codProd`),
  ADD KEY `fk_cpfCli` (`cpfCli`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbestoque`
--
ALTER TABLE `tbestoque`
  MODIFY `codProd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tbvenda`
--
ALTER TABLE `tbvenda`
  ADD CONSTRAINT `fk_codProd` FOREIGN KEY (`codProd`) REFERENCES `tbestoque` (`codProd`),
  ADD CONSTRAINT `fk_cpfCli` FOREIGN KEY (`cpfCli`) REFERENCES `tbcliente` (`cpfCli`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
