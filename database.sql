-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `comments` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` int(11) NOT NULL AUTO_INCREMENT,
  `personId` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `value` float NOT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`recordId`,`type`),
  KEY `id` (`personId`),
  CONSTRAINT `id` FOREIGN KEY (`personId`) REFERENCES `people` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;