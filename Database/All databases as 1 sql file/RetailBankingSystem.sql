-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: retail_banking
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_no` bigint NOT NULL,
  `account_bal` double NOT NULL,
  `account_nick_name` varchar(255) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `credit_card_number` bigint NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beneficiary`
--

DROP TABLE IF EXISTS `beneficiary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beneficiary` (
  `beneficiary_account_number` bigint NOT NULL AUTO_INCREMENT,
  `beneficiary_account_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`beneficiary_account_number`)
) ENGINE=MyISAM AUTO_INCREMENT=790 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficiary`
--

LOCK TABLES `beneficiary` WRITE;
/*!40000 ALTER TABLE `beneficiary` DISABLE KEYS */;
INSERT INTO `beneficiary` VALUES (789,'bank1');
/*!40000 ALTER TABLE `beneficiary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditcard` (
  `creditcardnumber` bigint NOT NULL,
  `accountno` bigint DEFAULT NULL,
  `availablelimit` decimal(19,2) DEFAULT NULL,
  `creditlimit` decimal(19,2) DEFAULT NULL,
  `minimumpayment` decimal(19,2) DEFAULT NULL,
  `paymentduedate` date DEFAULT NULL,
  PRIMARY KEY (`creditcardnumber`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` bigint NOT NULL AUTO_INCREMENT,
  `account_number` bigint NOT NULL,
  `beneficiary_account_number` bigint NOT NULL,
  `transaction_amount` double NOT NULL,
  `transaction_date` date DEFAULT NULL,
  `transaction_type` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=MyISAM AUTO_INCREMENT=858 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (125,444333222111,456,500,'2021-01-01','CREDITCARD','1'),(456,444333222111,789,1000,'2020-05-06','DEBITCARD','1'),(856,444333222111,562,456,'2021-01-05','CREDITCARD','1'),(321,444333222111,123,7500,'2020-10-06','DEBITCARD','1'),(857,444333222111,789,1000,'2021-01-07','DEBIT','1'),(200,444333222111,987654321,20,'2020-12-31','NEFT','1'),(104,444333222111,987654321,20,'2020-12-31','UPI','1'),(105,444333222222,987654321,20,'2019-12-31','NEFT','1'),(106,444333222222,987654321,20,'2020-12-31','UPI','1'),(107,444333222222,987654321,20,'2019-06-25','UPI','1'),(109,444333222222,987654321,20,'2020-05-15','NEFT','1'),(250,444333222222,982476321,1500,'2019-02-15','DEBITCARD','1'),(301,444333222111,9671354999,2500,'2021-01-08','CREDITCARD','1'),(151,444333222333,897654321,500,'2019-11-28','NEFT','1'),(111,444333222333,987654321,4000,'2020-01-10','UPI','1'),(112,444333222333,9671354999,1700,'2019-06-25','UPI','1'),(175,111222333444,987564122,500,'2019-10-06','CREDITCARD','1'),(114,444333222444,987654321,150,'2020-05-15','NEFT','1'),(115,444333222444,987654321,362,'2019-03-13','NEFT','1'),(116,444333222444,987654321,800,'2019-09-28','NEFT','1'),(117,444333222444,987654321,670,'2019-07-29','NEFT','1'),(118,444333222555,987654321,9000,'2019-08-18','NEFT','1'),(119,444333222555,987654321,870,'2019-10-12','DEBITCARD','1'),(120,444333222555,987654321,980,'2019-10-11','CREDITCARD','1'),(121,444333222555,987654321,320,'2018-12-30','UPI','1'),(122,444333222555,987654321,350,'2019-12-02','UPI','1');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 13:08:59
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: acc_new
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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `accountno` bigint NOT NULL,
  `accountbalance` decimal(19,2) DEFAULT NULL,
  `accountnickname` varchar(255) DEFAULT NULL,
  `accounttype` varchar(255) DEFAULT NULL,
  `userid` double DEFAULT NULL,
  PRIMARY KEY (`accountno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (444333222111,1000000.00,'SAV2111','savings',1),(444333222222,2000000.00,'SAV2222','savings',1),(444333222333,3000000.00,'SAV2333','savings',1),(444333222444,900000.00,'SAV2444','savings',1),(444333222555,11000000.00,'SAV2555','savings',1),(444333222666,25000000.00,'SAV2666','savings',1),(555333222110,1000000.00,'DDA2110','dda',1);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditcard` (
  `creditcardnumber` bigint NOT NULL,
  `availablelimit` decimal(19,2) DEFAULT NULL,
  `creditlimit` decimal(19,2) DEFAULT NULL,
  `minimumpayment` decimal(19,2) DEFAULT NULL,
  `paymentduedate` date DEFAULT NULL,
  `userid` double DEFAULT NULL,
  PRIMARY KEY (`creditcardnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES (111222333444,30000.00,60000.00,2000.00,'2021-01-15',1),(111222333555,300000.00,600000.00,20000.00,'2021-01-15',1);
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 13:08:59
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: retailbanking
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
-- Table structure for table `creditscoredetails`
--

DROP TABLE IF EXISTS `creditscoredetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditscoredetails` (
  `creditId` int NOT NULL AUTO_INCREMENT,
  `userId` bigint DEFAULT NULL,
  `months` varchar(10) DEFAULT NULL,
  `creditScore` int DEFAULT NULL,
  PRIMARY KEY (`creditId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditscoredetails`
--

LOCK TABLES `creditscoredetails` WRITE;
/*!40000 ALTER TABLE `creditscoredetails` DISABLE KEYS */;
INSERT INTO `creditscoredetails` VALUES (1,1,'january',789),(2,1,'december',600),(3,1,'novemebr',500),(4,1,'october',745),(5,1,'september',760),(6,1,'august',698),(7,1,'july',912),(8,1,'june',950),(9,1,'may',870),(10,1,'April',818),(11,1,'march',750),(12,1,'february',641);
/*!40000 ALTER TABLE `creditscoredetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 13:08:59
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: userdetails
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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'root','shantanu'),(2,'cts','root');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 13:08:59
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

--
-- Table structure for table `seq`
--

DROP TABLE IF EXISTS `seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq`
--

LOCK TABLES `seq` WRITE;
/*!40000 ALTER TABLE `seq` DISABLE KEYS */;
INSERT INTO `seq` VALUES (1042);
/*!40000 ALTER TABLE `seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet` (
  `customer_id` int NOT NULL,
  `wallet_amount` int NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (1,45655),(2,300);
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-11 13:09:00
