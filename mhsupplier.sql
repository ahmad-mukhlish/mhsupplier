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
  `Info` varchar(50) DEFAULT NULL,
  `Uang` double DEFAULT NULL,
  PRIMARY KEY (`Nomor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `pemasukan` */

insert  into `pemasukan`(`Nomor`,`Info`,`Uang`) values 
(1,'Gisty Amelia',20000),
(2,'Hasan Syadzilli',20000),
(3,'Gilang Dirga',50000),
(4,'Sherlock Holmes',70000),
(5,'Ahmad Mukhlis ',10000),
(6,'Ahmad Mukhlis S',100000);

/*Table structure for table `pengeluaran` */

DROP TABLE IF EXISTS `pengeluaran`;

CREATE TABLE `pengeluaran` (
  `Nomor` int(11) NOT NULL AUTO_INCREMENT,
  `Info` varchar(50) DEFAULT NULL,
  `Uang` double DEFAULT NULL,
  PRIMARY KEY (`Nomor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `pengeluaran` */

insert  into `pengeluaran`(`Nomor`,`Info`,`Uang`) values 
(1,'Jana Fitria Malawat',5000),
(2,'Ahmad Mukhlis Saputra',5000),
(3,'Ami Gusmiati',5000),
(6,'Rosmi Alhandani',6000),
(7,'Fitriya Rohimah',69000),
(8,'Watson',50000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
