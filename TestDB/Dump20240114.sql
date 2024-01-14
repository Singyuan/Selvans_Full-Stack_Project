CREATE DATABASE  IF NOT EXISTS `test01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test01`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test01
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `Task_Allocation`
--

DROP TABLE IF EXISTS `Task_Allocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Task_Allocation` (
  `task_allocation_id` int NOT NULL AUTO_INCREMENT,
  `workarea_id` int NOT NULL,
  `task_example_id` int NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`task_allocation_id`),
  KEY `workarea_id_idx` (`workarea_id`),
  KEY `task_example_id_idx` (`task_example_id`),
  CONSTRAINT `task_example_id` FOREIGN KEY (`task_example_id`) REFERENCES `Task_Example` (`task_example_id`),
  CONSTRAINT `workarea_id` FOREIGN KEY (`workarea_id`) REFERENCES `Work_Area` (`workarea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Task_Allocation`
--

LOCK TABLES `Task_Allocation` WRITE;
/*!40000 ALTER TABLE `Task_Allocation` DISABLE KEYS */;
INSERT INTO `Task_Allocation` VALUES (1,1,1,'2024-01-08');
/*!40000 ALTER TABLE `Task_Allocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Task_Allocation_Detail`
--

DROP TABLE IF EXISTS `Task_Allocation_Detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Task_Allocation_Detail` (
  `task_allocation_id` int NOT NULL,
  `emp_id` int NOT NULL,
  PRIMARY KEY (`task_allocation_id`,`emp_id`),
  KEY `emp_id_idx` (`emp_id`),
  KEY `task_allocation_id_idx` (`task_allocation_id`),
  CONSTRAINT `emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `task_allocation_id` FOREIGN KEY (`task_allocation_id`) REFERENCES `Task_Allocation` (`task_allocation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Task_Allocation_Detail`
--

LOCK TABLES `Task_Allocation_Detail` WRITE;
/*!40000 ALTER TABLE `Task_Allocation_Detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `Task_Allocation_Detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Task_Example`
--

DROP TABLE IF EXISTS `Task_Example`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Task_Example` (
  `task_example_id` int NOT NULL,
  `task_name` varchar(45) NOT NULL,
  `task_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`task_example_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Task_Example`
--

LOCK TABLES `Task_Example` WRITE;
/*!40000 ALTER TABLE `Task_Example` DISABLE KEYS */;
INSERT INTO `Task_Example` VALUES (1,'澆水',NULL),(2,'施肥',NULL),(3,'扦插',NULL),(4,'除草',NULL);
/*!40000 ALTER TABLE `Task_Example` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Work_Area`
--

DROP TABLE IF EXISTS `Work_Area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Work_Area` (
  `workarea_id` int NOT NULL,
  `workarea_name` varchar(45) NOT NULL,
  PRIMARY KEY (`workarea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Work_Area`
--

LOCK TABLES `Work_Area` WRITE;
/*!40000 ALTER TABLE `Work_Area` DISABLE KEYS */;
INSERT INTO `Work_Area` VALUES (1,'A'),(2,'B'),(3,'C'),(4,'D'),(5,'E'),(6,'F');
/*!40000 ALTER TABLE `Work_Area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_id` int NOT NULL,
  `account` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `emp_name` varchar(45) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'BOSS','123456','老闆'),(2,'EMP1','PASSWORD','員工A'),(3,'EMP2','PASSWORD','員工B');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-14 18:21:13
