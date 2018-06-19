/*
Navicat MySQL Data Transfer

Source Server         : Linking
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : buildingmaterialsmanagementsys

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-05-16 07:22:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for constructionteam
-- ----------------------------
DROP TABLE IF EXISTS `constructionteam`;
CREATE TABLE `constructionteam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task` varchar(255) NOT NULL,
  `projectId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_constructionTeam` (`projectId`),
  CONSTRAINT `fk_constructionTeam` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of constructionteam
-- ----------------------------

-- ----------------------------
-- Table structure for inputrecord
-- ----------------------------
DROP TABLE IF EXISTS `inputrecord`;
CREATE TABLE `inputrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operator` varchar(16) NOT NULL,
  `date` date NOT NULL,
  `materialId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_inputRecord` (`materialId`),
  CONSTRAINT `fk_inputRecord` FOREIGN KEY (`materialId`) REFERENCES `material` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inputrecord
-- ----------------------------

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit` varchar(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `modelNumber` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------

-- ----------------------------
-- Table structure for outputrecord
-- ----------------------------
DROP TABLE IF EXISTS `outputrecord`;
CREATE TABLE `outputrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operator` varchar(16) NOT NULL,
  `date` date NOT NULL,
  `materialId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` double NOT NULL,
  `constructionTeam` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_outputrecord` (`materialId`),
  CONSTRAINT `fk_outputrecord` FOREIGN KEY (`materialId`) REFERENCES `material` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outputrecord
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `duration` varchar(255) NOT NULL,
  `manager` varchar(16) NOT NULL,
  `introduction` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for project_material
-- ----------------------------
DROP TABLE IF EXISTS `project_material`;
CREATE TABLE `project_material` (
  `projectId` int(11) NOT NULL,
  `materialId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`projectId`,`materialId`),
  KEY `fk_project_material_2` (`materialId`),
  CONSTRAINT `fk_project_material_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_material_2` FOREIGN KEY (`materialId`) REFERENCES `material` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_material
-- ----------------------------

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reporter` varchar(14) NOT NULL,
  `duraion` varchar(255) NOT NULL,
  `schedule` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `userType` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emailUnique` (`email`),
  UNIQUE KEY `nameUnique` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_project
-- ----------------------------
DROP TABLE IF EXISTS `user_project`;
CREATE TABLE `user_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userProject_1` (`userId`),
  KEY `fk_userProject_2` (`projectId`),
  CONSTRAINT `fk_userProject_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_userProject_2` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_project
-- ----------------------------
