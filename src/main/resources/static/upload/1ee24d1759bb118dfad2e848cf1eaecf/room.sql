/*
 Navicat Premium Data Transfer

 Source Server         : 我本地的mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : room

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 09/09/2019 20:06:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_brand_company
-- ----------------------------
DROP TABLE IF EXISTS `t_brand_company`;
CREATE TABLE `t_brand_company`  (
  `projectId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目代号',
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '图片数量',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌企业图片介绍',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_brand_company
-- ----------------------------
INSERT INTO `t_brand_company` VALUES ('abc1', 1, 'p1');
INSERT INTO `t_brand_company` VALUES ('abc1', 3, 'p2');
INSERT INTO `t_brand_company` VALUES ('222', 4, 'p1');
INSERT INTO `t_brand_company` VALUES ('222', 5, 'p3');
INSERT INTO `t_brand_company` VALUES ('abc1', 6, 'C:\\Users\\ASUS-PC\\AppData\\Local\\Temp\\tomcat-docbase.2010946861763601678.8081\\abc1\\pic\\(EHDH))[3U}}8`786XUB~TT.png');
INSERT INTO `t_brand_company` VALUES ('abc1', 7, 'C:\\Users\\ASUS-PC\\AppData\\Local\\Temp\\tomcat-docbase.6039850911173600702.8081\\abc1\\pic\\(EHDH))[3U}}8`786XUB~TT.png');
INSERT INTO `t_brand_company` VALUES ('abc1', 8, 'C:\\Users\\ASUS-PC\\AppData\\Local\\Temp\\tomcat-docbase.7050954082057952950.8081\\abc1\\pic\\1.png');
INSERT INTO `t_brand_company` VALUES ('abc1', 9, 'C:\\Users\\ASUS-PC\\AppData\\Local\\Temp\\tomcat-docbase.7050954082057952950.8081\\abc1\\pic\\%36U2U}$4O]~Y]INT3%ZC~Q.png');
INSERT INTO `t_brand_company` VALUES ('abc1', 10, 'D:\\Excellent-Room\\src\\main\\resources\\abc1\\pic\\avatar.jpg');
INSERT INTO `t_brand_company` VALUES ('abc1', 11, 'D:\\Excellent-Room\\src\\main\\resources\\abc1\\pic\\life is strange.jpg');
INSERT INTO `t_brand_company` VALUES ('abc1', 12, 'D:\\Excellent-Room\\src\\main\\resources\\abc1\\pic\\20180903144033_1.jpg');

-- ----------------------------
-- Table structure for t_brand_culture
-- ----------------------------
DROP TABLE IF EXISTS `t_brand_culture`;
CREATE TABLE `t_brand_culture`  (
  `projectId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目代号',
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '企业文化计数',
  `title` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业文化标题',
  `text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业文化文本',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_brand_culture
-- ----------------------------
INSERT INTO `t_brand_culture` VALUES ('333', 6, '1', '1');
INSERT INTO `t_brand_culture` VALUES ('abc1', 7, '2', '2');
INSERT INTO `t_brand_culture` VALUES ('abc1', 8, 't2', 'tt3');

-- ----------------------------
-- Table structure for t_brand_history
-- ----------------------------
DROP TABLE IF EXISTS `t_brand_history`;
CREATE TABLE `t_brand_history`  (
  `projectId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目代号',
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '发展历史计数',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌发展史图片',
  `time` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片的时间历程',
  `simple` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片的简述',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片的详述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_brand_history
-- ----------------------------
INSERT INTO `t_brand_history` VALUES ('abc1', 1, 'p1', 't1', 's1', 'tt1');
INSERT INTO `t_brand_history` VALUES ('abc1', 2, 'p2', 't2', 's2', 'tt2');
INSERT INTO `t_brand_history` VALUES ('222', 3, 'p1', 't1', 's2', 'tt2');

-- ----------------------------
-- Table structure for t_brand_honor_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_brand_honor_pic`;
CREATE TABLE `t_brand_honor_pic`  (
  `projectId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目代号',
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '荣誉计数',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌荣誉展示的图片',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_brand_honor_pic
-- ----------------------------
INSERT INTO `t_brand_honor_pic` VALUES ('abc2', 3, 'p1');
INSERT INTO `t_brand_honor_pic` VALUES ('abc1', 6, 'p3');
INSERT INTO `t_brand_honor_pic` VALUES ('abc1', 7, 'p2');
INSERT INTO `t_brand_honor_pic` VALUES ('abc1', 8, 'D:\\Excellent-Room\\src\\main\\resources\\abc1\\pic\\life is strange.jpg');

-- ----------------------------
-- Table structure for t_brand_honor_text
-- ----------------------------
DROP TABLE IF EXISTS `t_brand_honor_text`;
CREATE TABLE `t_brand_honor_text`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_brand_honor_text
-- ----------------------------
INSERT INTO `t_brand_honor_text` VALUES (1, '111', 't1');
INSERT INTO `t_brand_honor_text` VALUES (2, 'abc1', 't2');
INSERT INTO `t_brand_honor_text` VALUES (3, 'abc1', 't3');

-- ----------------------------
-- Table structure for t_building_public_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_building_public_pic`;
CREATE TABLE `t_building_public_pic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publicPic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_building_public_pic
-- ----------------------------
INSERT INTO `t_building_public_pic` VALUES (1, 'abc1', 'p1', 'tt1');
INSERT INTO `t_building_public_pic` VALUES (2, 'abc1', 'p2', 'tt2');

-- ----------------------------
-- Table structure for t_building_surroundbeautifulpic
-- ----------------------------
DROP TABLE IF EXISTS `t_building_surroundbeautifulpic`;
CREATE TABLE `t_building_surroundbeautifulpic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `beautifulPic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_building_surroundbeautifulpic
-- ----------------------------
INSERT INTO `t_building_surroundbeautifulpic` VALUES (1, 'abc1', 'p1', 'tt1');
INSERT INTO `t_building_surroundbeautifulpic` VALUES (2, 'abc1', 'p2', 'tt2');

-- ----------------------------
-- Table structure for t_client_want
-- ----------------------------
DROP TABLE IF EXISTS `t_client_want`;
CREATE TABLE `t_client_want`  (
  `projectId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目代号',
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '计数',
  `tel` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户电话号码',
  `price` int(15) NOT NULL COMMENT '客户意向价位的代号',
  `type` int(15) NOT NULL COMMENT '客户的意向户型',
  PRIMARY KEY (`projectId`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_client_want
-- ----------------------------
INSERT INTO `t_client_want` VALUES ('abc1', 1, '111', 222, 333);

-- ----------------------------
-- Table structure for t_homepageicon
-- ----------------------------
DROP TABLE IF EXISTS `t_homepageicon`;
CREATE TABLE `t_homepageicon`  (
  `homePageIcon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `t_homePageIcon_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_homepageicon
-- ----------------------------
INSERT INTO `t_homepageicon` VALUES ('222', 1, 'abc1');

-- ----------------------------
-- Table structure for t_login
-- ----------------------------
DROP TABLE IF EXISTS `t_login`;
CREATE TABLE `t_login`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '计数',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_login
-- ----------------------------
INSERT INTO `t_login` VALUES (1, 'hsy', '123456');

-- ----------------------------
-- Table structure for t_project_information
-- ----------------------------
DROP TABLE IF EXISTS `t_project_information`;
CREATE TABLE `t_project_information`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '记录项目的个数',
  `projectId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目的代号',
  `projectName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目的logo',
  `developer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开发商',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `telephone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务热线',
  `QRcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '二维码',
  `QRcodeText` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '二维码描述',
  `province` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开发商所在省份',
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开发商所在城市',
  `guidePageBkground` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '引导页背景图片',
  `homePageBkground` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '首页背景图片',
  `homePageLogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '首页logo图片',
  `projectIntroduceBkground` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目介绍的背景图片',
  `projectIntroduceTitle` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目介绍的标题',
  `projectIntroduceText` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目介绍的文案',
  `brandCultureBkground` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '\"企业文化背景\"',
  `companyIntroduceText` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业简介文案',
  `companyBkground` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `companyIntroduceVideo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业简介视频',
  `buildingSurroundMap` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '周边平面地图',
  `companyIntroduceTitle` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业简介标题',
  `brandCulturePic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '企业文化图片',
  `brandHistoryBkground` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发展历程背景',
  `brandHonorBkground` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`projectId`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project_information
-- ----------------------------
INSERT INTO `t_project_information` VALUES (2, '111', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '15', '16', '17', '0', '18', '19', '20', '21', '22', '23');
INSERT INTO `t_project_information` VALUES (1, 'abc1', 'abc2', 'abc4', 'abc5', 'abc6', 'abc7', 'abc8', 'abc9', 'abc10', 'abc11', 'abc12', 'D:\\Excellent-Room\\src\\main\\resources\\abc1\\avatar.jpg', 'abc14', 'abc15', 'abc16', 'abc17', 'abc18', 'abc19', 'abc26', 'D:\\Excellent-Room\\src\\main\\resources\\abc1\\video\\avatar.jpg', 'abc21', 'abc22', 'abc23', 'abc24', 'abc25');

-- ----------------------------
-- Table structure for t_room_simple
-- ----------------------------
DROP TABLE IF EXISTS `t_room_simple`;
CREATE TABLE `t_room_simple`  (
  `projectId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目代号',
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '计数',
  `type` int(10) NOT NULL COMMENT '户型代号',
  `simplePic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '样板间展示图片',
  PRIMARY KEY (`projectId`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_room_simple
-- ----------------------------
INSERT INTO `t_room_simple` VALUES ('abc1', 1, 1, '222');

-- ----------------------------
-- Table structure for t_room_type
-- ----------------------------
DROP TABLE IF EXISTS `t_room_type`;
CREATE TABLE `t_room_type`  (
  `projectId` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目代号',
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '计数',
  `type` int(10) NOT NULL COMMENT '户型代号',
  `layout` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '户型图',
  `panorama` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '全景图',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_room_type
-- ----------------------------
INSERT INTO `t_room_type` VALUES ('abc1', 2, 2, '666', '333');

SET FOREIGN_KEY_CHECKS = 1;
