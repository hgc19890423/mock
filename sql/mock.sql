/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : mock

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2018-10-16 14:20:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book_info`
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `book_id` int(4) NOT NULL COMMENT '图书id',
  `book_name` varchar(20) NOT NULL COMMENT '书名',
  `author` varchar(20) NOT NULL COMMENT '作者',
  `press` varchar(20) NOT NULL COMMENT '出版社',
  `number` int(4) NOT NULL DEFAULT '10' COMMENT '数量',
  `price` decimal(16,6) NOT NULL DEFAULT '0.000000' COMMENT '定价',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_id` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='图书信息表';

-- ----------------------------
-- Records of book_info
-- ----------------------------

-- ----------------------------
-- Table structure for `credit_order`
-- ----------------------------
DROP TABLE IF EXISTS `credit_order`;
CREATE TABLE `credit_order` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` int(4) NOT NULL COMMENT '订单号',
  `book_id` int(4) NOT NULL COMMENT '图书id',
  `customer_id` int(4) NOT NULL COMMENT 'cifid',
  `order_state` tinyint(4) NOT NULL COMMENT '订单状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_id` (`order_id`),
  UNIQUE KEY `book_id` (`book_id`),
  UNIQUE KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of credit_order
-- ----------------------------
INSERT INTO `credit_order` VALUES ('1', '1', '1', '1', '1', '2018-10-16 12:22:49', '2018-10-16 12:22:53');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `customer_id` int(4) NOT NULL COMMENT 'cif',
  `gender` tinyint(4) NOT NULL COMMENT '性别，值为1时是男性，值为2时是女性',
  `city` varchar(20) NOT NULL COMMENT '所在城市',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_cif_id` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '1', '1', '北京', '2016-05-18 09:37:15', '2016-05-18 09:34:43');
