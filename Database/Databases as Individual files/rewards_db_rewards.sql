-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: rewards_db
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `rewards`
--

DROP TABLE IF EXISTS `rewards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rewards` (
  `reward_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `reward_amount` int NOT NULL,
  `reward_expiry_date` date DEFAULT NULL,
  `reward_name` varchar(255) DEFAULT NULL,
  `reward_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reward_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewards`
--

LOCK TABLES `rewards` WRITE;
/*!40000 ALTER TABLE `rewards` DISABLE KEYS */;
INSERT INTO `rewards` VALUES (1,2,1000,'2021-02-12','credit card','active'),(1000,3,100,'2021-01-21','tansactionFor2000','active'),(1003,1,100,'2021-01-21','tansactionFor2000','inactive'),(1004,1,250,'2021-01-21','tansactionFor5000','inactive'),(1005,1,250,'2021-01-21','tansactionFor5000','inactive'),(1006,1,500,'2021-01-21','tansactionFor10000','inactive'),(1007,2,200,'2021-01-21','tansactionFor4000','active'),(1008,1,225,'2021-01-21','tansactionFor4500','inactive'),(1009,1,225,'2021-01-22','tansactionFor4500','inactive'),(1010,1,275,'2021-01-22','tansactionFor5500','inactive'),(1011,1,500,'2021-01-22','tansactionFor10000','inactive'),(1013,1,250,'2021-01-24','tansactionFor5000','inactive'),(1014,1,2750,'2021-01-24','tansactionFor55000','inactive'),(1015,1,3000,'2021-01-24','tansactionFor60000','inactive'),(1016,1,2100,'2021-01-24','tansactionFor42000','inactive'),(1017,1,28100,'2021-01-24','tansactionFor562000','inactive'),(1018,1,50,'2021-01-25','tansactionFor1000','inactive'),(1019,1,50,'2021-01-25','tansactionFor1000','inactive'),(1020,1,50,'2021-01-25','tansactionFor1000','inactive'),(1021,1,50,'2021-01-25','tansactionFor1000','inactive'),(1022,1,50,'2021-01-25','tansactionFor1000','inactive'),(1023,1,375,'2021-01-25','tansactionFor7500','inactive'),(1024,1,125,'2021-01-25','tansactionFor2500','inactive'),(1025,1,75,'2021-01-25','tansactionFor1500','inactive'),(1026,1,225,'2021-01-25','tansactionFor4500','inactive'),(1027,1,225,'2021-01-25','tansactionFor4500','inactive'),(1028,1,175,'2021-01-25','tansactionFor3500','inactive'),(1029,1,175,'2021-01-25','tansactionFor3500','inactive'),(1030,1,175,'2021-01-25','tansactionFor3500','inactive'),(1031,1,75,'2021-01-25','tansactionFor1500','inactive'),(1032,1,90,'2021-01-25','tansactionFor1800','inactive'),(1033,1,90,'2021-01-25','tansactionFor1800','inactive'),(1035,1,75,'2021-01-26','tansactionFor1500','inactive'),(1036,1,177,'2021-01-26','tansactionFor3540','active'),(1037,1,350,'2021-01-26','tansactionFor7000','active'),(1038,1,500,'2021-01-26','tansactionFor10000','active'),(1039,1,75,'2021-01-26','tansactionFor1500','active');
/*!40000 ALTER TABLE `rewards` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 13:07:31
