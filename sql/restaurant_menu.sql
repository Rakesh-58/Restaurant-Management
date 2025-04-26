CREATE DATABASE  IF NOT EXISTS `restaurant` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `restaurant`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `item_id` int NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `category` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `image_url` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (101,'Bischoff Shake','Shake','veg',250,'shake1.jpg'),(102,'Strawberry Shake','Shake','veg',200,'shake2.jpg'),(103,'Oreo Shake','Shake','veg',230,'shake3.jpg'),(104,'Tri-Burst Shake','Shake','veg',280,'shake4.jpeg'),(105,'KitKat Shake','Shake','veg',250,'shake5.jpg'),(106,'Chocolate Shake','Shake','veg',200,'shake6.jpg'),(201,'Strawberry Juice','Juice','veg',90,'juice1.jpeg'),(202,'Apple Juice','Juice','veg',100,'juice2.jpg'),(203,'Watermelon Juice','Juice','veg',70,'juice3.jpg'),(204,'Muskmelon Juice','Juice','veg',80,'juice4.jpg'),(205,'Lemon Juice','Juice','veg',50,'juice5.jpg'),(206,'Pomegrante Juice','Juice','veg',110,'juice6.jpg'),(301,'Veg Sandwich ','Sandwich','veg',150,'sandwich1.jpeg'),(302,'Club Sandwich','Sandwich','veg',180,'sandwich2.jpeg'),(303,'Corn Sandwich','Sandwich','veg',130,'sandwich3.jpg'),(304,'Egg Sandwich','Sandwich','nonveg',170,'sandwich4.jpeg'),(305,'Grilled Chicken Sandwich','Sandwich','nonveg',200,'sandwich5.jpg'),(306,'Beef Sandwich','Sandwich','nonveg',280,'sandwich6.jpg'),(401,'5 Chicken Feast','Pizza','nonveg',400,'pizza1.jpeg'),(402,'Blazing Paprika Chicken','Pizza','nonveg',250,'pizza2.jpeg'),(403,'Non Veg Loaded','Pizza','nonveg',260,'pizza3.jpeg'),(404,'4 Cheese Pizza','Pizza','veg',350,'pizza4.jpeg'),(405,'Indi-Tandoori Veg Pizza','Pizza','veg',350,'pizza5.jpeg'),(406,'PepSpiCue pizza','Pizza','nonveg',450,'pizza6.jpeg'),(501,'Paneer Burger','Burger','veg',150,'burger1.jpg'),(502,'Chicken Burger','Burger','nonveg',200,'burger2.jpg'),(503,'Cheese Burger','Burger','veg',180,'burger3.webp'),(504,'Beef Burger','Burger','nonveg',250,'burger4.jpg'),(505,'Veg Burger','Burger','veg',150,'burger5.webp'),(506,'Grilled Chicken Burger','Burger','nonveg',280,'burger6.jpg');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-04 12:10:57
