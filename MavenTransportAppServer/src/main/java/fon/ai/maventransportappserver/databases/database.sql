/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `transportapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `transportapp`;

/*Table structure for table `driver` */
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
                          `idcard` int(25) NOT NULL,
                          `name` varchar(25) DEFAULT NULL,
                          `surname` varchar(25) DEFAULT NULL,
                          PRIMARY KEY (`idcard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `driver` */
INSERT INTO `driver` (`idcard`, `name`, `surname`) VALUES
                                                       (123456789, 'Vladimir', 'Lazic'),
                                                       (203023021, 'Laza', 'Lazic'),
                                                       (203023022, 'Vladimir', 'Lazic'),
                                                       (290600012, 'Bratislav', 'Lazic'),
                                                       (333333333, 'Mika', 'Mikic'),
                                                       (999999999, 'Baba', 'Babic'),
                                                       (123456788, 'Vlada', 'Vladic');

/*Table structure for table `vehicle` */
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
                           `registrationMark` varchar(25) NOT NULL,
                           `brand` varchar(25) DEFAULT NULL,
                           `productYear` int(20) DEFAULT NULL,
                           `weight` double DEFAULT NULL,
                           `transmission` varchar(20) DEFAULT NULL,
                           `vehicletype` varchar(20) DEFAULT NULL,
                           `loadcapacity` double DEFAULT NULL,
                           `oznakavozila` varchar(5) DEFAULT NULL,
                           PRIMARY KEY (`registrationMark`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `vehicle` */
INSERT INTO `vehicle` (`registrationMark`, `brand`, `productYear`, `weight`, `transmission`, `vehicletype`, `loadcapacity`, `oznakavozila`) VALUES
                                                                                                                                                ('AA447BG', 'Smitz', 2012, 8880, NULL, 'HLADNJACA', 22000, 'P'),
                                                                                                                                                ('AA447RA', 'Svarcmiler', 2007, 8350, NULL, 'HLADNJACA', 15000, 'P'),
                                                                                                                                                ('AA644RA', 'Smitz', 2020, 8400, NULL, 'HLADNJACA', 22000, 'P'),
                                                                                                                                                ('RA013CD', 'Daf', 2007, 8850, 'AUTOMATIC', NULL, NULL, 'K'),
                                                                                                                                                ('RA013CG', 'daf', 1995, 8800, 'AUTOMATIC', NULL, NULL, 'K'),
                                                                                                                                                ('RA015CC', 'Daf', 1995, 222, 'MANUAL', NULL, NULL, 'K'),
                                                                                                                                                ('RA021CV', 'Daf', 2008, 9350, 'MANUAL', NULL, NULL, 'K'),
                                                                                                                                                ('RA030HK', 'Daf', 2014, 8120, 'AUTOMATIC', NULL, NULL, 'K');

/*Table structure for table `drive` */
DROP TABLE IF EXISTS `drive`;
CREATE TABLE `drive` (
                         `id` int(20) NOT NULL,
                         `date` date DEFAULT NULL,
                         `factureprice` double DEFAULT NULL,
                         `truck` varchar(255) DEFAULT NULL,
                         `trailer` varchar(255) DEFAULT NULL,
                         `driver` int(20) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `trailerforeign` (`truck`),
                         KEY `truckforeign` (`trailer`),
                         KEY `driverforeign` (`driver`),
                         CONSTRAINT `driverforeign` FOREIGN KEY (`driver`) REFERENCES `driver` (`idcard`),
                         CONSTRAINT `trailerforeign` FOREIGN KEY (`truck`) REFERENCES `vehicle` (`registrationMark`),
                         CONSTRAINT `truckforeign` FOREIGN KEY (`trailer`) REFERENCES `vehicle` (`registrationMark`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `drive` */
INSERT INTO `drive` (`id`, `date`, `factureprice`, `truck`, `trailer`, `driver`) VALUES
                                                                                     (15, '2023-05-05', 2200, 'RA015CC', 'AA447RA', 203023021),
                                                                                     (1203, '2023-10-10', 2250, 'RA013CD', 'AA447BG', 123456789),
                                                                                     (12345622, '2012-12-12', 5000, 'RA013CD', 'AA447BG', 123456789);

/*Table structure for table `costlist` */
DROP TABLE IF EXISTS `costlist`;
CREATE TABLE `costlist` (
                            `id` int(10) NOT NULL,
                            `total` double DEFAULT NULL,
                            `drive` int(11) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `drive` (`drive`),
                            CONSTRAINT `costlist_ibfk_1` FOREIGN KEY (`drive`) REFERENCES `drive` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `costlist` */
INSERT INTO `costlist` (`id`, `total`, `drive`) VALUES
                                                    (15, 1417, 15),
                                                    (1203, 1850, 1203),
                                                    (12345622, 55, 12345622);

/*Table structure for table `costitem` */
DROP TABLE IF EXISTS `costitem`;
CREATE TABLE `costitem` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `costList` int(11) NOT NULL,
                            `costtype` varchar(255) DEFAULT NULL,
                            `amount` double DEFAULT NULL,
                            PRIMARY KEY (`id`,`costList`),
                            KEY `costtype` (`costtype`),
                            KEY `foreign` (`costList`),
                            CONSTRAINT `costitem_ibfk_1` FOREIGN KEY (`costList`) REFERENCES `costlist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `costitem` */
INSERT INTO `costitem` (`id`, `costList`, `costtype`, `amount`) VALUES
                                                                    (69, 12345622, 'driverSallary', 300),
                                                                    (70, 12345622, 'fuel', 400),
                                                                    (71, 12345622, 'toll', 500),
                                                                    (72, 12345622, 'other', 500),
                                                                    (77, 1203, 'driverSallary', 250),
                                                                    (78, 1203, 'fuel', 1240),
                                                                    (79, 1203, 'toll', 180),
                                                                    (80, 1203, 'other', 180),
                                                                    (81, 15, 'driverSallary', 250),
                                                                    (82, 15, 'fuel', 1000),
                                                                    (83, 15, 'toll', 120),
                                                                    (84, 15, 'other', 47);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
