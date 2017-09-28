/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 10.1.13-MariaDB : Database - mhsupplier
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mhsupplier` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mhsupplier`;

/*Table structure for table `pemasukan` */

DROP TABLE IF EXISTS `pemasukan`;

CREATE TABLE `pemasukan` (
  `Nomor` int(11) NOT NULL AUTO_INCREMENT,
  `Nama` varchar(50) DEFAULT NULL,
  `Uang` double DEFAULT NULL,
  PRIMARY KEY (`Nomor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `pemasukan` */

insert  into `pemasukan`(`Nomor`,`Nama`,`Uang`) values 
(1,'Ahmad',3000000),
(2,'Mukhlis',4000000);

/*Table structure for table `pengeluaran` */

DROP TABLE IF EXISTS `pengeluaran`;

CREATE TABLE `pengeluaran` (
  `Nomor` int(11) NOT NULL AUTO_INCREMENT,
  `Nama` varchar(50) DEFAULT NULL,
  `Uang` double DEFAULT NULL,
  PRIMARY KEY (`Nomor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `pengeluaran` */

insert  into `pengeluaran`(`Nomor`,`Nama`,`Uang`) values 
(1,'Jana',4000000),
(2,'Malawat',5000000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
