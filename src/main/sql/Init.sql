drop table if EXISTS User;
CREATE TABLE `User` (
  `userId` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) DEFAULT NULL,
	`company` varchar(50) DEFAULT NULL,
  `creatorId` varchar(255) DEFAULT NULL,
  `creatorName` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `modifierId` varchar(255) DEFAULT NULL,
  `modifierName` varchar(255) DEFAULT NULL,
  `modifyTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleteFlag` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId1', '张三', '阿里巴巴', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId2', '李四', '阿里巴巴', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId3', '王五', '阿里巴巴', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId4', '王六', '腾讯', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId5', '王七', '腾讯', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
