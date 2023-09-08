CREATE DATABASE  IF NOT EXISTS `bookingdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bookingdb`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookingdb
-- ------------------------------------------------------
-- Server version	5.7.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cum_rap`
--

DROP TABLE IF EXISTS `cum_rap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cum_rap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `dia_chi` varchar(255) CHARACTER SET utf8 NOT NULL,
  `hinh_anh` varchar(255) NOT NULL,
  `ten_cum_rap` varchar(255) CHARACTER SET utf8 NOT NULL,
  `he_thong_rap_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4y2q2c4vnd7hkbm21ygkwadei` (`dia_chi`),
  UNIQUE KEY `UK_dx04spkdo6dluvlwf0a0x6o9a` (`ten_cum_rap`),
  KEY `FK3hju15vl3v4s5826ocfeb72xn` (`he_thong_rap_id`),
  CONSTRAINT `FK3hju15vl3v4s5826ocfeb72xn` FOREIGN KEY (`he_thong_rap_id`) REFERENCES `he_thong_rap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cum_rap`
--

LOCK TABLES `cum_rap` WRITE;
/*!40000 ALTER TABLE `cum_rap` DISABLE KEYS */;
INSERT INTO `cum_rap` VALUES (1,'2023-09-08 03:17:11.733293','2023-09-08 03:17:11.733293','Tầng 3, TTTM Aeon Mall Bình Tân, Số 1 đường số 17A, khu phố 11, Bình Trị Đông B, Bình Tân','string','CGV - Aeon Bình Tân',1),(2,'2023-09-08 03:17:49.257068','2023-09-08 03:17:49.257068','30 Bờ Bao Tân Thắng, Sơn Kỳ, Tân Phú','string','CCGV - Aeon Tân Phú',1);
/*!40000 ALTER TABLE `cum_rap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ghe`
--

DROP TABLE IF EXISTS `ghe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ghe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `da_dat` bit(1) NOT NULL,
  `loai_ghe` varchar(255) NOT NULL,
  `so_ghe` varchar(255) NOT NULL,
  `rap_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9pmoie2m2jcw5vqgn9dmq05a8` (`so_ghe`),
  KEY `FK3vmjxg9w3h9luqdwleb9j6tgh` (`rap_id`),
  CONSTRAINT `FK3vmjxg9w3h9luqdwleb9j6tgh` FOREIGN KEY (`rap_id`) REFERENCES `rap` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ghe`
--

LOCK TABLES `ghe` WRITE;
/*!40000 ALTER TABLE `ghe` DISABLE KEYS */;
/*!40000 ALTER TABLE `ghe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `he_thong_rap`
--

DROP TABLE IF EXISTS `he_thong_rap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `he_thong_rap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `hinh_anh` varchar(255) NOT NULL,
  `ten_he_thong_rap` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_crdqj2b4exlwlp8yryn8ncy7k` (`ten_he_thong_rap`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `he_thong_rap`
--

LOCK TABLES `he_thong_rap` WRITE;
/*!40000 ALTER TABLE `he_thong_rap` DISABLE KEYS */;
INSERT INTO `he_thong_rap` VALUES (1,'2023-09-08 03:12:11.403782','2023-09-08 03:12:11.403782','https://movie0706.cybersoft.edu.vn/hinhanh/cgv.png','CGV'),(2,'2023-09-08 03:12:11.467412','2023-09-08 03:12:11.467412','https://movie0706.cybersoft.edu.vn/hinhanh/bhd-star-cineplex.png','BHD'),(3,'2023-09-08 03:12:11.475678','2023-09-08 03:12:11.475678','https://movie0706.cybersoft.edu.vn/hinhanh/cinestar.png','Cinestar'),(4,'2023-09-08 03:12:11.484143','2023-09-08 03:12:11.484143','https://movie0706.cybersoft.edu.vn/hinhanh/galaxy-cinema.png','Galaxy'),(5,'2023-09-08 03:12:11.493095','2023-09-08 03:12:11.493095','https://movie0706.cybersoft.edu.vn/hinhanh/lotte-cinema.png','Lotte');
/*!40000 ALTER TABLE `he_thong_rap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lich_chieu`
--

DROP TABLE IF EXISTS `lich_chieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lich_chieu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `ngay_chieu` datetime(6) DEFAULT NULL,
  `cum_rap_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK111m6mbfqe2rw9txuajeytry3` (`cum_rap_id`),
  CONSTRAINT `FK111m6mbfqe2rw9txuajeytry3` FOREIGN KEY (`cum_rap_id`) REFERENCES `cum_rap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lich_chieu`
--

LOCK TABLES `lich_chieu` WRITE;
/*!40000 ALTER TABLE `lich_chieu` DISABLE KEYS */;
INSERT INTO `lich_chieu` VALUES (1,'2023-09-08 03:35:31.122260','2023-09-08 03:35:31.122260','2023-09-07 20:34:57.556000',1),(2,'2023-09-08 03:42:10.933671','2023-09-08 03:42:10.933671','2023-09-08 20:34:57.556000',2);
/*!40000 ALTER TABLE `lich_chieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phim`
--

DROP TABLE IF EXISTS `phim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phim` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `do_tuoi` int(11) NOT NULL,
  `hinh_anh` varchar(255) NOT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ngay_phat_hanh` datetime(6) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `ten_phim` varchar(255) CHARACTER SET utf8 NOT NULL,
  `the_loai` varchar(255) CHARACTER SET utf8 NOT NULL,
  `trailer` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phim`
--

LOCK TABLES `phim` WRITE;
/*!40000 ALTER TABLE `phim` DISABLE KEYS */;
INSERT INTO `phim` VALUES (1,'2023-09-08 03:23:01.493548','2023-09-08 03:23:01.493548',18,'http://localhost:8080/13d01432ed40ce8e6b628a247ed1b7d7.png','ko co','2023-05-06 00:00:00.000000',5,'very hot','jav','null'),(2,'2023-09-08 03:38:52.006344','2023-09-08 03:38:52.006344',18,'http://localhost:8080/c32669a357501fa42f5d25b2914d6e37.jpeg','nude','2023-05-06 00:00:00.000000',5,'super hot','jav','null'),(3,'2023-09-08 03:40:02.199611','2023-09-08 03:40:02.199611',18,'http://localhost:8080/c4e2ddb56a8a010ac21a967d33fc8df0.png','badass','2023-05-06 00:00:00.000000',5,'mlem','jav','null'),(4,'2023-09-08 03:44:51.549071','2023-09-08 03:44:51.549071',18,'http://localhost:8080/ff76e82987defc6a649a5229291286dc.png','badass','2023-05-06 00:00:00.000000',5,'mlem','jav','null');
/*!40000 ALTER TABLE `phim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phim_lich_chieu`
--

DROP TABLE IF EXISTS `phim_lich_chieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phim_lich_chieu` (
  `phim_id` bigint(20) NOT NULL,
  `lich_chieu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`phim_id`,`lich_chieu_id`),
  KEY `FKg5f8q2bxavfmqw7avhnuv03j0` (`lich_chieu_id`),
  CONSTRAINT `FKg5f8q2bxavfmqw7avhnuv03j0` FOREIGN KEY (`lich_chieu_id`) REFERENCES `lich_chieu` (`id`),
  CONSTRAINT `FKixywmwuv3xd80xrurpybasni2` FOREIGN KEY (`phim_id`) REFERENCES `phim` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phim_lich_chieu`
--

LOCK TABLES `phim_lich_chieu` WRITE;
/*!40000 ALTER TABLE `phim_lich_chieu` DISABLE KEYS */;
INSERT INTO `phim_lich_chieu` VALUES (1,1),(2,1),(3,1),(4,1),(1,2),(2,2),(3,2);
/*!40000 ALTER TABLE `phim_lich_chieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rap`
--

DROP TABLE IF EXISTS `rap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `ten_rap` varchar(255) CHARACTER SET utf8 NOT NULL,
  `cum_rap_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrs3la3aak7510p9o704r18eek` (`cum_rap_id`),
  CONSTRAINT `FKrs3la3aak7510p9o704r18eek` FOREIGN KEY (`cum_rap_id`) REFERENCES `cum_rap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rap`
--

LOCK TABLES `rap` WRITE;
/*!40000 ALTER TABLE `rap` DISABLE KEYS */;
INSERT INTO `rap` VALUES (1,'2023-09-08 03:18:20.871958','2023-09-08 03:18:20.871958','Rạp 1',1),(2,'2023-09-08 03:18:27.306801','2023-09-08 03:18:27.306801','Rạp 2',1),(3,'2023-09-08 03:18:32.169069','2023-09-08 03:18:32.169069','Rạp 3',1),(4,'2023-09-08 03:18:37.206418','2023-09-08 03:18:37.206418','Rạp 4',1),(5,'2023-09-08 03:18:46.104164','2023-09-08 03:18:46.104164','Rạp 1',2),(6,'2023-09-08 03:18:51.756766','2023-09-08 03:18:51.756766','Rạp 2',2),(7,'2023-09-08 03:45:24.817275','2023-09-08 03:45:24.817275','Rạp 2',1);
/*!40000 ALTER TABLE `rap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2023-09-08 03:12:11.638092','2023-09-08 03:12:11.638092','tanvuu998@gamil.com','$2a$10$3QFGbutv8RbNWeANQgzVy.QaUq0DuxF/Hdmx8EYtpCIFTR7/VyaYa','ROLE_Admin','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ve`
--

DROP TABLE IF EXISTS `ve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `gia_ve` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `xuat_chieu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj271r77rtms1fqofr3udlb7wa` (`user_id`),
  KEY `FK79gfe4tel9lo4p3qjw75kcj5n` (`xuat_chieu_id`),
  CONSTRAINT `FK79gfe4tel9lo4p3qjw75kcj5n` FOREIGN KEY (`xuat_chieu_id`) REFERENCES `xuat_chieu` (`id`),
  CONSTRAINT `FKj271r77rtms1fqofr3udlb7wa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ve`
--

LOCK TABLES `ve` WRITE;
/*!40000 ALTER TABLE `ve` DISABLE KEYS */;
/*!40000 ALTER TABLE `ve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuat_chieu`
--

DROP TABLE IF EXISTS `xuat_chieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xuat_chieu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `ngay_chieu` datetime(6) NOT NULL,
  `thoi_gian_bat_dau` datetime(6) NOT NULL,
  `thoi_gian_ket_thuc` datetime(6) NOT NULL,
  `lich_chieu_id` bigint(20) DEFAULT NULL,
  `phim_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8iosh7539591xhsl1fd5j5a0g` (`lich_chieu_id`),
  KEY `FK97g0hs94pyy7se9lj7ckbbsqb` (`phim_id`),
  CONSTRAINT `FK8iosh7539591xhsl1fd5j5a0g` FOREIGN KEY (`lich_chieu_id`) REFERENCES `lich_chieu` (`id`),
  CONSTRAINT `FK97g0hs94pyy7se9lj7ckbbsqb` FOREIGN KEY (`phim_id`) REFERENCES `phim` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuat_chieu`
--

LOCK TABLES `xuat_chieu` WRITE;
/*!40000 ALTER TABLE `xuat_chieu` DISABLE KEYS */;
INSERT INTO `xuat_chieu` VALUES (1,'2023-09-08 03:47:31.655437','2023-09-08 03:47:31.655437','2023-09-07 20:46:39.000000','2023-09-08 20:46:39.000000','2023-09-08 22:46:39.000000',1,1);
/*!40000 ALTER TABLE `xuat_chieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bookingdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-08 22:22:16
