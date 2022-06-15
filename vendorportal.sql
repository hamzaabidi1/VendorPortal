-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 14 juin 2022 à 15:21
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `vendorportal`
--

-- --------------------------------------------------------

--
-- Structure de la table `attachement`
--

DROP TABLE IF EXISTS `attachement`;
CREATE TABLE IF NOT EXISTS `attachement` (
  `attachement_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog` int(11) DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`attachement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client_reference`
--

DROP TABLE IF EXISTS `client_reference`;
CREATE TABLE IF NOT EXISTS `client_reference` (
  `client_reference_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(50) DEFAULT NULL,
  `contact_person` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`client_reference_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `commoditie`
--

DROP TABLE IF EXISTS `commoditie`;
CREATE TABLE IF NOT EXISTS `commoditie` (
  `commodities_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`commodities_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `config`
--

DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `logpath` varchar(255) DEFAULT NULL,
  `maximopath` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `config`
--

INSERT INTO `config` (`id`, `email`, `logpath`, `maximopath`, `password`) VALUES
(1, 'hamza.abidi1@esprit.tn', 'C:/Users/ASUS/Desktop/VendorPortalFront/vendorportal/logs/vendorportal.log', 'http://maxgps.smartech-tn.com:9876', '193JMT0786');

-- --------------------------------------------------------

--
-- Structure de la table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
CREATE TABLE IF NOT EXISTS `invoices` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currencycode` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `enterby` varchar(255) DEFAULT NULL,
  `enterdate` varchar(255) DEFAULT NULL,
  `invoicenum` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `totalcost` double NOT NULL,
  `totaltax1` double NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbwr4d4vyqf2bkoetxtt8j9dx7` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `invoices`
--

INSERT INTO `invoices` (`id`, `currencycode`, `description`, `enterby`, `enterdate`, `invoicenum`, `status`, `totalcost`, `totaltax1`, `user_id`) VALUES
(1, '5242', 'b,bjkghjg', 'hfgh', '2022-04-13', '7587', 'hfg', 45, 7, 11);

-- --------------------------------------------------------

--
-- Structure de la table `invoice_line`
--

DROP TABLE IF EXISTS `invoice_line`;
CREATE TABLE IF NOT EXISTS `invoice_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `invoicelinenum` int(11) NOT NULL,
  `invoiceunit` varchar(255) DEFAULT NULL,
  `itemnum` varchar(255) DEFAULT NULL,
  `linecost` double NOT NULL,
  `qtyforui` double NOT NULL,
  `unitcost` double NOT NULL,
  `invoice_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2b91edluue12qy0l4ttn2comt` (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `invoice_line`
--

INSERT INTO `invoice_line` (`id`, `description`, `invoicelinenum`, `invoiceunit`, `itemnum`, `linecost`, `qtyforui`, `unitcost`, `invoice_id`) VALUES
(1, 'gbfnf', 25, ',b', '257', 27, 72, 27, 1);

-- --------------------------------------------------------

--
-- Structure de la table `pos`
--

DROP TABLE IF EXISTS `pos`;
CREATE TABLE IF NOT EXISTS `pos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currencycode` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `ponum` varchar(255) DEFAULT NULL,
  `purchaseagent` varchar(255) DEFAULT NULL,
  `requireddate` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `totalcost` varchar(255) DEFAULT NULL,
  `totaltax1` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `vendeliverydate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9m740mi52bb7paoe336y0j8wh` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pos`
--

INSERT INTO `pos` (`id`, `currencycode`, `description`, `ponum`, `purchaseagent`, `requireddate`, `status`, `totalcost`, `totaltax1`, `user_id`, `vendeliverydate`) VALUES
(1, '335496', 'ergege', '68754', 'gezge', '2022-04-13', 'RYRU', '24', '4', 11, '2022-04-11');

-- --------------------------------------------------------

--
-- Structure de la table `po_line`
--

DROP TABLE IF EXISTS `po_line`;
CREATE TABLE IF NOT EXISTS `po_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `itemnum` varchar(255) DEFAULT NULL,
  `linecost` varchar(255) DEFAULT NULL,
  `orderqty` varchar(255) DEFAULT NULL,
  `orderunit` varchar(255) DEFAULT NULL,
  `polinenum` varchar(255) DEFAULT NULL,
  `unitcost` varchar(255) DEFAULT NULL,
  `po_id` bigint(20) DEFAULT NULL,
  `vendeliverydate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqiptmiqxvdx67iyxsly8m4qy6` (`po_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `po_line`
--

INSERT INTO `po_line` (`id`, `description`, `itemnum`, `linecost`, `orderqty`, `orderunit`, `polinenum`, `unitcost`, `po_id`, `vendeliverydate`) VALUES
(1, 'tyitiy', '2725', '257', '24', '65', '275', '657', 1, '2022-04-11');

-- --------------------------------------------------------

--
-- Structure de la table `request_update_profile`
--

DROP TABLE IF EXISTS `request_update_profile`;
CREATE TABLE IF NOT EXISTS `request_update_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `companywebsite` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `date_established` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `postalcode` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `revenu` varchar(50) DEFAULT NULL,
  `taxclassificationcode` varchar(255) DEFAULT NULL,
  `taxregistrationnumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `rfqs`
--

DROP TABLE IF EXISTS `rfqs`;
CREATE TABLE IF NOT EXISTS `rfqs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `purchaseagent` varchar(255) DEFAULT NULL,
  `requireddate` varchar(255) DEFAULT NULL,
  `rfqnum` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `siteid` varchar(255) DEFAULT NULL,
  `statusof_send` bit(1) NOT NULL,
  `date_envoie` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8b2of6iv9la2qd0ufh2vjg9h3` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rfqs`
--

INSERT INTO `rfqs` (`id`, `description`, `purchaseagent`, `requireddate`, `rfqnum`, `status`, `user_id`, `siteid`, `statusof_send`, `date_envoie`) VALUES
(15, 'jthjgfh,gf', 'fhjfj', '2022-04-13', '2658', 'fhjfj', 11, 'hg', b'0', '2022-06-14'),
(16, 'jthjgfh,gf', 'fhjfj', '2022-04-13', '2658', 'fhjfj', 11, 'hjj', b'1', '2022-06-14'),
(19, 'jthjgfh,gf', 'fhjfj', '2022-04-13', '2658', 'fhjfj', 11, 'kuk', b'1', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `rfq_line`
--

DROP TABLE IF EXISTS `rfq_line`;
CREATE TABLE IF NOT EXISTS `rfq_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `itemnum` varchar(255) DEFAULT NULL,
  `linecost` double NOT NULL,
  `orderqty` double NOT NULL,
  `orderunit` varchar(255) DEFAULT NULL,
  `rfqlinenum` varchar(255) DEFAULT NULL,
  `unitcost` double NOT NULL,
  `rfq_id` bigint(20) DEFAULT NULL,
  `delivry_date` date DEFAULT NULL,
  `quotationqty` double NOT NULL,
  `quote_end_date` date DEFAULT NULL,
  `quote_start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrq4ntmsa8p91fcvu96lhlu6tp` (`rfq_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rfq_line`
--

INSERT INTO `rfq_line` (`id`, `description`, `itemnum`, `linecost`, `orderqty`, `orderunit`, `rfqlinenum`, `unitcost`, `rfq_id`, `delivry_date`, `quotationqty`, `quote_end_date`, `quote_start_date`) VALUES
(5, '1634', '658', 34, 0, 'usd', '658', 17, 15, '2022-04-13', 2, '2022-04-13', '2022-04-13'),
(7, '1634', '658', 7, 0, 'usd', '658', 3, 16, '2022-04-13', 1, '2022-04-13', '2022-04-13'),
(10, '1634', '658', 70, 0, 'usd', '658', 14, 19, '2022-04-13', 5, '2022-04-13', '2022-04-13');

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_FOURNISSEUR'),
(3, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `companywebsite` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `date_established` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `is_admin` bit(1) NOT NULL,
  `is_enabled` bit(1) NOT NULL,
  `is_vendor` bit(1) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `postalcode` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL,
  `revenu` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `taxclassificationcode` varchar(255) DEFAULT NULL,
  `taxregistrationnumber` varchar(255) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `verify_account_token` varchar(255) DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `address`, `city`, `companywebsite`, `country`, `date_established`, `email`, `firstname`, `is_admin`, `is_enabled`, `is_vendor`, `lastname`, `password`, `phone`, `postalcode`, `region`, `reset_password_token`, `revenu`, `status`, `taxclassificationcode`, `taxregistrationnumber`, `username`, `verify_account_token`, `date_creation`) VALUES
(11, 'bardo', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'COMPDEP', 'KR416Hd8nl7yw4EjodYIbUhEdLLD9a', NULL),
(12, NULL, NULL, NULL, NULL, NULL, 'labidihamza099@gmail.com', NULL, b'1', b'1', b'0', NULL, '$2a$10$6MyvXX3cBpraFJe8Ej1tBems1E3PEhyVL1Rj7B9w8.RVy.xT/pShi', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'maxadmin', 'pkytczOs6xfCW4JgcYk1OCuBgJGVjL', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `users_history`
--

DROP TABLE IF EXISTS `users_history`;
CREATE TABLE IF NOT EXISTS `users_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `companywebsite` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `date_established` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `is_admin` bit(1) NOT NULL,
  `is_enabled` bit(1) NOT NULL,
  `is_vendor` bit(1) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `postalcode` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL,
  `revenu` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `taxclassificationcode` varchar(255) DEFAULT NULL,
  `taxregistrationnumber` varchar(255) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `verify_account_token` varchar(255) DEFAULT NULL,
  `status_date` date DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6jy4fsyuq0378806oscioau17` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users_history`
--

INSERT INTO `users_history` (`id`, `address`, `city`, `companywebsite`, `country`, `date_established`, `email`, `firstname`, `is_admin`, `is_enabled`, `is_vendor`, `lastname`, `password`, `phone`, `postalcode`, `region`, `reset_password_token`, `revenu`, `status`, `taxclassificationcode`, `taxregistrationnumber`, `username`, `verify_account_token`, `status_date`, `user_id`) VALUES
(12, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Submitted', '123456', '123456', 'hamzaabidi', NULL, '2022-04-14', 12),
(13, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-06-22', 'hamza199611@live.fr', 'sdvs', b'0', b'1', b'1', 'gsgd', '$2a$10$tOAZAqCLxKPZhOWr4X2E9OYfPHTBkrJsuziAxdo4EqsNCtKCoHBK2', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Submitted', '123456', '123456', 'abidihamza', NULL, '2022-06-08', NULL),
(14, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-06-20', 'hamza199611@live.fr', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$QfIC0iXa2Z6UqjVIMgKPp.4wLpm4i0boWWWg4U/dd9DMl3Rk5nd.6', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Deleted', '123456', '123456', 'hamz', NULL, '2022-06-07', 12),
(15, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'hamzaabidi', NULL, '2022-04-14', 12),
(16, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Draft', '123456', '123456', 'hamzaabidi', NULL, '2022-04-14', 12),
(17, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-06-26', 'hamza199611@live.fr', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$PL/EnYXJ7ysl5ERrvays4uDC5YIM2iH6is1RPJO7jXZTub5KhwvzW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Submitted', '123456', '123456', 'hhhhh', NULL, '2022-06-14', NULL),
(18, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-05-28', 'hamza199611@live.fr', 'ghassen', b'0', b'1', b'1', 'dridi', '$2a$10$DJE1ZL4nsLzVKcqw11CYG.gFK7KHAR5yzF3AQNQIA4WBwhlmsHO0S', '58660243', '2074', 'Ben Arous', NULL, 'kgk', 'Submitted', 'kgk', 'gkgk', 'ghassen', NULL, '2022-05-28', NULL),
(19, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Submitted', '123456', '123456', 'hamzaabidi', NULL, '2022-04-14', 12),
(20, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'hamzaabidi', NULL, '2022-04-14', 12),
(21, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(22, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(23, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(24, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(25, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(26, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Submitted', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(27, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(28, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(29, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'hamzaabidi1', NULL, '2022-04-14', 12),
(30, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'ha', NULL, '2022-04-14', 12),
(31, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'ha', NULL, '2022-04-15', 12),
(32, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'ham', NULL, '2022-04-15', 12),
(33, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'ham', NULL, '2022-04-15', 12),
(34, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'ham', NULL, '2022-04-15', 12),
(35, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'hamz', NULL, '2022-04-15', 12),
(36, 'Rue ennasr mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '26364259', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'hamz', NULL, '2022-04-21', 12),
(37, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'COMPDEP', NULL, '2022-05-09', 12),
(38, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Submitted', '123456', '123456', 'COMPDEP', NULL, '2022-05-09', 12),
(39, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Draft', '123456', '123456', 'COMPDEP', NULL, '2022-05-09', 12),
(40, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'COMPDEP', NULL, '2022-05-09', 12),
(41, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'COMPDEP', NULL, '2022-05-10', 12),
(42, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'COMPDEP', NULL, '2022-05-10', 12),
(43, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'COMPDEP', NULL, '2022-05-10', 12),
(44, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'COMPDEP', NULL, '2022-05-10', 12),
(45, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'COMPDEP', NULL, '2022-05-10', 12),
(46, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'COMPDEP', NULL, '2022-05-10', 12),
(47, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'InProgress', '123456', '123456', 'COMPDEP', NULL, '2022-05-10', 12),
(48, 'hamza.abidi1@esprit.tn', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'COMPDEP', NULL, '2022-05-10', 12),
(49, 'rue ennasr el mourouj 3', 'elmourouJ', 'www.vendorportal.com', 'Tunisie', '2022-04-13', 'hamza.abidi1@esprit.tn', 'hamza', b'0', b'1', b'1', 'ABIDI', '$2a$10$WUpK0RTVh9cxsUDycnFq6.qpC3XZGdr.tZHFkl.O4A.UwnbJQfEEW', '51331321', '2074', 'Ben Arous', NULL, '0287', 'Confirmed', '123456', '123456', 'COMPDEP', NULL, '2022-05-17', 12);

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(11, 2),
(12, 3);

-- --------------------------------------------------------

--
-- Structure de la table `vendor_commodities`
--

DROP TABLE IF EXISTS `vendor_commodities`;
CREATE TABLE IF NOT EXISTS `vendor_commodities` (
  `vendor_commoditie_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) DEFAULT NULL,
  `commoditie_id` bigint(20) DEFAULT NULL,
  `vendor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`vendor_commoditie_id`),
  KEY `FK58unwt52orymlx834vdjuktj2` (`commoditie_id`),
  KEY `FKhs4d58s84ffap7goh31gu1qt0` (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `FKbwr4d4vyqf2bkoetxtt8j9dx7` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `invoice_line`
--
ALTER TABLE `invoice_line`
  ADD CONSTRAINT `FK2b91edluue12qy0l4ttn2comt` FOREIGN KEY (`invoice_id`) REFERENCES `invoices` (`id`);

--
-- Contraintes pour la table `pos`
--
ALTER TABLE `pos`
  ADD CONSTRAINT `FK9m740mi52bb7paoe336y0j8wh` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `po_line`
--
ALTER TABLE `po_line`
  ADD CONSTRAINT `FKqiptmiqxvdx67iyxsly8m4qy6` FOREIGN KEY (`po_id`) REFERENCES `pos` (`id`);

--
-- Contraintes pour la table `rfqs`
--
ALTER TABLE `rfqs`
  ADD CONSTRAINT `FK8b2of6iv9la2qd0ufh2vjg9h3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `rfq_line`
--
ALTER TABLE `rfq_line`
  ADD CONSTRAINT `FKrq4ntmsa8p91fcvu96lhlu6tp` FOREIGN KEY (`rfq_id`) REFERENCES `rfqs` (`id`);

--
-- Contraintes pour la table `users_history`
--
ALTER TABLE `users_history`
  ADD CONSTRAINT `FK6jy4fsyuq0378806oscioau17` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `vendor_commodities`
--
ALTER TABLE `vendor_commodities`
  ADD CONSTRAINT `FK58unwt52orymlx834vdjuktj2` FOREIGN KEY (`commoditie_id`) REFERENCES `commoditie` (`commodities_id`),
  ADD CONSTRAINT `FKhs4d58s84ffap7goh31gu1qt0` FOREIGN KEY (`vendor_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
