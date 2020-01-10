/*
SQLyog Community Edition- MySQL GUI v7.01 
MySQL - 5.1.36-community-log : Database - dataleak
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`dataleak` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dataleak`;

/*Table structure for table `cgroup` */

DROP TABLE IF EXISTS `cgroup`;

CREATE TABLE `cgroup` (
  `gname` varchar(255) DEFAULT NULL,
  `member` varchar(255) DEFAULT NULL,
  `totalm` varchar(255) DEFAULT NULL,
  `createby` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `cgroup` */

insert  into `cgroup`(`gname`,`member`,`totalm`,`createby`) values ('Inbo Group','m,sh','2','s');

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `file` varchar(255) DEFAULT NULL,
  `filenameextn` varchar(255) DEFAULT NULL,
  `filesize` varchar(255) DEFAULT NULL,
  `filenameDrive` varchar(255) DEFAULT NULL,
  `uploder` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `enckey` varchar(255) DEFAULT NULL,
  `bkey` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `files` */

insert  into `files`(`file`,`filenameextn`,`filesize`,`filenameDrive`,`uploder`,`logo`,`enckey`,`bkey`) values ('Enc_idback12.jpg','Enc_idback12.jpg.png','50.5712890625','Enc_idback12.jpg.png','s','PNG//png.png','ZncY2334WmWx9797',NULL),('AuditingForNetwork','AuditingForNetwork.rar','2385.9853515625','AuditingForNetwork.rar','s','PNG//rar.png','CgzM1664QdHz9696',NULL),('IMG_20161023_180005','IMG_20161023_180005.jpg','1877.484375','IMG_20161023_180005.jpg','s','PNG//jpg.png','AfpK2220EwQf2121',NULL),('1Desert','1Desert.jpg','826.1142578125','1Desert.jpg','s','PNG//jpg.png','RwzH9449FzPs1515','QbqE0990NaYm6262');

/*Table structure for table `leak` */

DROP TABLE IF EXISTS `leak`;

CREATE TABLE `leak` (
  `lfile` varchar(255) DEFAULT NULL,
  `uploader` varchar(255) DEFAULT NULL,
  `leaker` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `leak` */

insert  into `leak`(`lfile`,`uploader`,`leaker`) values ('575443Enc_idback12.jpg.png','s','sh');

/*Table structure for table `request` */

DROP TABLE IF EXISTS `request`;

CREATE TABLE `request` (
  `reqfile` varchar(255) DEFAULT NULL,
  `reqdate` varchar(255) DEFAULT NULL,
  `reqtime` varchar(255) DEFAULT NULL,
  `reqfrom` varchar(255) DEFAULT NULL,
  `reqto` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `request` */

insert  into `request`(`reqfile`,`reqdate`,`reqtime`,`reqfrom`,`reqto`,`logo`,`action`) values ('Enc_idback12.jpg','12/18/2016','12.51 AM','sh','s','PNG//png.png','A'),('AuditingForNetwork','12/18/2016','02.13 AM','sh','s','PNG//rar.png','A'),('sumit_java_php','12/20/2016','12.50 PM','sh','s','null','A'),('Enc_idback12.jpg','01/31/2017','03.44 PM','sh','s','PNG//png.png','A'),('1Desert','01/31/2017','03.46 PM','sh','s','PNG//jpg.png','A');

/*Table structure for table `sharefiles` */

DROP TABLE IF EXISTS `sharefiles`;

CREATE TABLE `sharefiles` (
  `file` varchar(255) DEFAULT NULL,
  `filenameextn` varchar(255) DEFAULT NULL,
  `filesize` varchar(255) DEFAULT NULL,
  `filenameDrive` varchar(255) DEFAULT NULL,
  `uploder` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `enckey` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sharefiles` */

insert  into `sharefiles`(`file`,`filenameextn`,`filesize`,`filenameDrive`,`uploder`,`receiver`,`logo`,`enckey`) values ('Enc_idback12.jpg','Enc_idback12.jpg.png','50.5712890625','Enc_idback12.jpg.png','s','sh','PNG//png.png','ZncY2334WmWx9797'),('AuditingForNetwork','AuditingForNetwork.rar','2385.9853515625','AuditingForNetwork.rar','s','sh','PNG//rar.png','CgzM1664QdHz9696'),('sumit_java_php','sumit_java_php.xlsx','11.07421875','sumit_java_php.xlsx','s','sh','null','GtvA8334ZtDg5252'),('AuditingForNetwork','AuditingForNetwork.rar','2385.9853515625','AuditingForNetwork.rar','s','m','PNG//rar.png','CgzM1664QdHz9696'),('1Desert','1Desert.jpg','826.1142578125','1Desert.jpg','s','sh','PNG//jpg.png','RwzH9449FzPs1515');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `name` varchar(255) DEFAULT NULL,
  `emailid` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`name`,`emailid`,`mobile`,`username`,`password`,`type`) values ('sumit balkrushna tawte','tawte.sumit65@gmail.com','7208764131','s','s','user'),('mahendra ramchandra gawade','inboticstesting0@gmail.com','9874561230','m','m','user'),('shailes shivaji bhokare','shailesh@gmail.com','9517531269','sh','sh','user'),('swapnil tawate','swapnil@gmail.com','9856231470','sw','sw','user');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
