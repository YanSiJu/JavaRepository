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



-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int  PRIMARY KEY AUTO_INCREMENT,
  `nickName` varchar(25) DEFAULT NULL,
  `email` varchar(35) NOT NULL,
   `tel`  varchar(16) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user` varchar(18) NOT NULL,
  UNIQUE KEY `emailUnique` (`email`),
  UNIQUE KEY `nickNameUnique` (`nicKName`),
  UNIQUE KEY `userUnique` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_project
-- ----------------------------
DROP TABLE IF EXISTS `Blog`;
CREATE TABLE `Blog` (
   `id` int PRIMARY KEY AUTO_INCREMENT,
   `author` varchar(25) NOT NULL,#博客作者，即用户的昵称
   `viewCount` int  DEFAULT NULL,#阅读数
   `commentsCount` int  DEFAULT NULL,#评论数
   `publishDate` date  NOT NULL,#博客发表时间
    `status` varchar(5) NOT NULL,
  CONSTRAINT `fk_Blog` FOREIGN KEY (`author`) REFERENCES `user` (`nickName`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `viewCount` CHECK(viewCount > 0),
  CONSTRAINT `commentsCount` CHECK(commentsCount > 0),
  CONSTRAINT `statusChk` CHECK( status in('未发布','发布'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_project
-- ----------------------------
