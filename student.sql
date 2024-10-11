/*
Navicat MySQL Data Transfer

Source Server         : localhost_javaee
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : javaeedb

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2024-10-08 13:59:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int NOT NULL DEFAULT '20',
  `intro` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bj_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('7', '22302091007', '李莲花', '30', '莲花楼楼主，活死人肉白骨的神医', '3');
INSERT INTO `student` VALUES ('51', '22302091001', '杨清平', '20', null, '1');
INSERT INTO `student` VALUES ('52', '22302091002', '韦之鹏', '20', null, '1');
INSERT INTO `student` VALUES ('53', '22302091003', '王维', '20', null, '1');
INSERT INTO `student` VALUES ('54', '22302091004', '李梦晴', '20', null, '1');
INSERT INTO `student` VALUES ('55', '22302091005', '杨思宇', '20', null, '1');
INSERT INTO `student` VALUES ('56', '22302091006', '杨雨彤', '20', null, '1');
INSERT INTO `student` VALUES ('57', '22302091007', '徐玮', '20', null, '1');
INSERT INTO `student` VALUES ('58', '22302091008', '张梦云', '20', null, '1');
INSERT INTO `student` VALUES ('59', '22302091009', '徐强强', '20', null, '1');
INSERT INTO `student` VALUES ('60', '22302091010', '朱宗禹', '20', null, '1');
INSERT INTO `student` VALUES ('61', '22302091011', '汪婷婷', '20', null, '1');
INSERT INTO `student` VALUES ('62', '22302091012', '吴筠一', '20', null, '1');
INSERT INTO `student` VALUES ('63', '22302091013', '曹振兴', '20', null, '1');
INSERT INTO `student` VALUES ('64', '22302091014', '王传昊', '20', null, '1');
INSERT INTO `student` VALUES ('65', '22302091015', '黄陈诚', '20', null, '1');
INSERT INTO `student` VALUES ('66', '22302091016', '王亚晨', '20', null, '1');
INSERT INTO `student` VALUES ('67', '22302091017', '苏浩风', '20', null, '1');
INSERT INTO `student` VALUES ('68', '22302091018', '刘威', '20', null, '1');
INSERT INTO `student` VALUES ('69', '22302091019', '伍婷', '20', null, '1');
INSERT INTO `student` VALUES ('70', '22302091020', '杨童童', '20', null, '1');
INSERT INTO `student` VALUES ('71', '22302091021', '李栋梁', '20', null, '1');
INSERT INTO `student` VALUES ('72', '22302091022', '季恒', '20', null, '1');
INSERT INTO `student` VALUES ('73', '22302091023', '胡鸿之', '20', null, '1');
INSERT INTO `student` VALUES ('74', '22302091024', '李嘉乐', '20', null, '1');
INSERT INTO `student` VALUES ('75', '22302091025', '王健翔', '20', null, '1');
INSERT INTO `student` VALUES ('76', '22302091026', '李春友', '20', null, '1');
INSERT INTO `student` VALUES ('77', '22302091027', '常硕', '20', null, '1');
INSERT INTO `student` VALUES ('78', '22302091028', '王冬冬', '20', null, '1');
INSERT INTO `student` VALUES ('79', '22302091029', '李佐锐', '20', null, '1');
INSERT INTO `student` VALUES ('80', '22302091030', '刘逸', '20', null, '1');
INSERT INTO `student` VALUES ('81', '22302091031', '朱亚萌', '20', null, '1');
INSERT INTO `student` VALUES ('82', '22302091032', '昌智诚', '20', null, '1');
INSERT INTO `student` VALUES ('83', '22302091033', '何欣雨', '20', null, '1');
INSERT INTO `student` VALUES ('84', '22302091034', '束悟鹰', '20', null, '1');
INSERT INTO `student` VALUES ('85', '22302091035', '张伟汉', '20', null, '1');
INSERT INTO `student` VALUES ('86', '22302091036', '范佳俊', '20', null, '1');
INSERT INTO `student` VALUES ('87', '22307031030', '江厚芬', '20', null, '1');
INSERT INTO `student` VALUES ('88', '22307033020', '黄李旸', '20', null, '1');
