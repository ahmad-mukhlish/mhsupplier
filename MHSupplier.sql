/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 10.1.26-MariaDB : Database - mhsupplier
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

/*Table structure for table `distributor` */

DROP TABLE IF EXISTS `distributor`;

CREATE TABLE `distributor` (
  `kd_dis` int(11) NOT NULL AUTO_INCREMENT,
  `nama_dis` varchar(30) DEFAULT NULL,
  `alamat` varchar(80) DEFAULT NULL,
  `no_telp` varchar(13) DEFAULT NULL,
  `total_hutang` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`kd_dis`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `distributor` */

insert  into `distributor`(`kd_dis`,`nama_dis`,`alamat`,`no_telp`,`total_hutang`) values 
(1,'Pa Didi','Jl. Soeta no 80','089567821233',2000000),
(2,'Ahmada','Jl. ppd iv no 31','0895105807756',500000),
(4,'CIkan','123','41412',5000);

/*Table structure for table `minuman` */

DROP TABLE IF EXISTS `minuman`;

CREATE TABLE `minuman` (
  `kd_min` char(13) NOT NULL,
  `nama_min` varchar(30) NOT NULL,
  `ukuran` int(11) NOT NULL,
  `isi` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga_beli` bigint(11) NOT NULL,
  `harga_jual` bigint(20) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `kd_dis` int(11) NOT NULL,
  PRIMARY KEY (`kd_min`),
  KEY `kd_dis` (`kd_dis`),
  CONSTRAINT `minuman_ibfk_1` FOREIGN KEY (`kd_dis`) REFERENCES `distributor` (`kd_dis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `minuman` */

insert  into `minuman`(`kd_min`,`nama_min`,`ukuran`,`isi`,`stok`,`harga_beli`,`harga_jual`,`tgl_masuk`,`kd_dis`) values 
('ALE0660170118','Ale-ale',660,48,23,62000,63000,'2018-01-17',2),
('COC1500050118','Coca Cola',1500,24,21,123123,123400,'2018-01-05',1),
('FRU1500010118','Frutang',1500,12,32,24000,25000,'2018-01-01',1),
('KOP1200100118','Kopikap',1200,48,41,50000,52000,'2018-01-10',1);

/*Table structure for table `pembeli` */

DROP TABLE IF EXISTS `pembeli`;

CREATE TABLE `pembeli` (
  `kd_pbl` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pbl` varchar(30) DEFAULT NULL,
  `alamat` varchar(80) DEFAULT NULL,
  `no_telp` varchar(13) DEFAULT NULL,
  `total_hutang` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`kd_pbl`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `pembeli` */

insert  into `pembeli`(`kd_pbl`,`nama_pbl`,`alamat`,`no_telp`,`total_hutang`) values 
(1,'Mang Iin','Jl. Sindangpanon no 20','081321456789',4000000),
(2,'Joni','Janji Joni\n','089543215678',600000);

/*Table structure for table `pembelian` */

DROP TABLE IF EXISTS `pembelian`;

CREATE TABLE `pembelian` (
  `nomor_nota` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `kd_min` char(13) NOT NULL,
  `kd_dis` int(11) NOT NULL,
  `harga_beli` bigint(20) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `sub_total` bigint(20) NOT NULL,
  PRIMARY KEY (`nomor_nota`),
  KEY `kd_dis` (`kd_dis`),
  CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`kd_dis`) REFERENCES `distributor` (`kd_dis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pembelian` */

/*Table structure for table `penjualan` */

DROP TABLE IF EXISTS `penjualan`;

CREATE TABLE `penjualan` (
  `nomor_nota` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `kd_min` char(13) NOT NULL,
  `kd_pbl` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `sub_total` bigint(20) NOT NULL,
  PRIMARY KEY (`nomor_nota`),
  KEY `kd_min` (`kd_min`),
  KEY `kd_pbl` (`kd_pbl`),
  CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`kd_min`) REFERENCES `minuman` (`kd_min`),
  CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`kd_pbl`) REFERENCES `pembeli` (`kd_pbl`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `penjualan` */

insert  into `penjualan`(`nomor_nota`,`tanggal`,`kd_min`,`kd_pbl`,`harga_jual`,`jumlah`,`sub_total`) values 
(1,'2018-01-30','COC1500050118',2,40000,2,80000);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`username`,`password`) values 
('admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
