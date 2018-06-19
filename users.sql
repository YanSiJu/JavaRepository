/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : ibatistest

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-11-12 11:08:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('981', 'Mikeal', '12431123%', '12398128732', '912030912@qq.com');
INSERT INTO `users` VALUES ('13', 'Linus', '193113', '8771339123', '98139433@sina.com');
INSERT INTO `users` VALUES ('21', 'Junia', '131244*', '0988712093', '98120311@163.com');
INSERT INTO `users` VALUES ('12', 'Mike', '1231`23', '987711033', '8987821@163.com');
INSERT INTO `users` VALUES ('134', 'sarin', '123aBN', '1', '121@186.com');
INSERT INTO `users` VALUES ('131', '??', '123aBN', '1', '981348@186.com');
