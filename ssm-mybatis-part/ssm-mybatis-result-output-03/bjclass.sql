
DROP TABLE IF EXISTS `bjclass`;

CREATE TABLE `bjclass` (
  `bj_id` int NOT NULL AUTO_INCREMENT,
  `bj_code` varchar(20) NOT NULL,
  `bj_name` varchar(50) NOT NULL,
  PRIMARY KEY (`bj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `bjclass` VALUES ('1', '22RG01', '2022级软件工程1班');
INSERT INTO `bjclass` VALUES ('2', '22RG02', '2022级软件工程2班');
INSERT INTO `bjclass` VALUES ('3', '23SQ07', '2023级暑期07班');
