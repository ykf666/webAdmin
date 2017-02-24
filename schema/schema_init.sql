/*
Navicat MySQL Data Transfer

Source Server         : 10.60.1.248-mysql_5.6.30
Source Server Version : 50630
Source Host           : 10.60.1.248:3306
Source Database       : webadmin

Target Server Type    : MYSQL
Target Server Version : 50630
File Encoding         : 65001

Date: 2017-02-24 16:44:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_login_time` datetime NOT NULL COMMENT '最后登陆时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', null, 'admin', null, '2017-02-24 16:38:39', '2017-02-24 16:38:43');
