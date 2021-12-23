/*
 Navicat Premium Data Transfer

 Source Server         : mysql_root
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : sotacy

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 23/12/2021 12:45:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员手机号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '13202182025', '2a22b6034a1efb2f4d87a4e13ba36798', '2021-12-23 11:03:52', '2021-12-23 11:03:52');

-- ----------------------------
-- Table structure for blank_question
-- ----------------------------
DROP TABLE IF EXISTS `blank_question`;
CREATE TABLE `blank_question`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '填空题id',
  `subject` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '填空题题目',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blank_question
-- ----------------------------

-- ----------------------------
-- Table structure for blank_question_item
-- ----------------------------
DROP TABLE IF EXISTS `blank_question_item`;
CREATE TABLE `blank_question_item`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '填空题答案项id',
  `order` tinyint UNSIGNED NOT NULL COMMENT '填空题答案项次序（1,2,3...）',
  `content` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '填空题答案',
  `blank_question_id` int UNSIGNED NOT NULL COMMENT '填空题答案',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bqi&blank_question_id`(`blank_question_id`) USING BTREE,
  CONSTRAINT `bqi&blank_question_id` FOREIGN KEY (`blank_question_id`) REFERENCES `blank_question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blank_question_item
-- ----------------------------

-- ----------------------------
-- Table structure for certificate
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '证书id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '证书名字',
  `describe` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '证书描述',
  `icon_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '证书图标',
  `course_id` int UNSIGNED NOT NULL COMMENT '证书id',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of certificate
-- ----------------------------

-- ----------------------------
-- Table structure for choice_question
-- ----------------------------
DROP TABLE IF EXISTS `choice_question`;
CREATE TABLE `choice_question`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '选择题id',
  `subject` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '选择题题目',
  `answer_option_id` int UNSIGNED NULL DEFAULT NULL COMMENT '选择题答案id',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of choice_question
-- ----------------------------

-- ----------------------------
-- Table structure for choice_question_option
-- ----------------------------
DROP TABLE IF EXISTS `choice_question_option`;
CREATE TABLE `choice_question_option`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '选择题选项id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '选项内容',
  `choice_question_id` int UNSIGNED NULL DEFAULT NULL COMMENT '选项所属问题id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cqo&choice_question`(`choice_question_id`) USING BTREE,
  CONSTRAINT `cqo&choice_question` FOREIGN KEY (`choice_question_id`) REFERENCES `choice_question` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of choice_question_option
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程表id',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名字',
  `describe` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '课程描述',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for course_unit
-- ----------------------------
DROP TABLE IF EXISTS `course_unit`;
CREATE TABLE `course_unit`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程单元id',
  `order` tinyint NOT NULL COMMENT '课程单元次序 (1,2,3...)',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程单元标题',
  `describe` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '课程单元描述',
  `course_id` int UNSIGNED NOT NULL COMMENT '单元所属课程id',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cu&course_id`(`course_id`) USING BTREE,
  CONSTRAINT `cu&course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_unit
-- ----------------------------

-- ----------------------------
-- Table structure for course_unit$blank_question
-- ----------------------------
DROP TABLE IF EXISTS `course_unit$blank_question`;
CREATE TABLE `course_unit$blank_question`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程单元和填空题关联表',
  `course_unit_id` int UNSIGNED NOT NULL COMMENT '课程单元id',
  `blank_question_id` int UNSIGNED NOT NULL COMMENT '填空题id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cubq&course_unit_id`(`course_unit_id`) USING BTREE,
  INDEX `cubq&blank_question_id`(`blank_question_id`) USING BTREE,
  CONSTRAINT `cubq&blank_question_id` FOREIGN KEY (`blank_question_id`) REFERENCES `blank_question` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `cubq&course_unit_id` FOREIGN KEY (`course_unit_id`) REFERENCES `course_unit` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_unit$blank_question
-- ----------------------------

-- ----------------------------
-- Table structure for course_unit$choice_question
-- ----------------------------
DROP TABLE IF EXISTS `course_unit$choice_question`;
CREATE TABLE `course_unit$choice_question`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程单元表和选择题关联表',
  `course_unit_id` int UNSIGNED NOT NULL COMMENT '课程单元id',
  `choice_question_id` int UNSIGNED NOT NULL COMMENT '选择题id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cucq&course_unit_id`(`course_unit_id`) USING BTREE,
  INDEX `cucq&choice_question_id`(`choice_question_id`) USING BTREE,
  CONSTRAINT `cucq&choice_question_id` FOREIGN KEY (`choice_question_id`) REFERENCES `choice_question` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `cucq&course_unit_id` FOREIGN KEY (`course_unit_id`) REFERENCES `course_unit` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_unit$choice_question
-- ----------------------------

-- ----------------------------
-- Table structure for course_unit$judgment_question
-- ----------------------------
DROP TABLE IF EXISTS `course_unit$judgment_question`;
CREATE TABLE `course_unit$judgment_question`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程单元和判断题关联表id',
  `course_unit_id` int UNSIGNED NOT NULL COMMENT '课程单元id',
  `judgment_id` int UNSIGNED NOT NULL COMMENT '判断题id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cujq&course_unit_id`(`course_unit_id`) USING BTREE,
  INDEX `cujq&judgment_question_id`(`judgment_id`) USING BTREE,
  CONSTRAINT `cujq&course_unit_id` FOREIGN KEY (`course_unit_id`) REFERENCES `course_unit` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `cujq&judgment_question_id` FOREIGN KEY (`judgment_id`) REFERENCES `judgment_question` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_unit$judgment_question
-- ----------------------------

-- ----------------------------
-- Table structure for judgment_question
-- ----------------------------
DROP TABLE IF EXISTS `judgment_question`;
CREATE TABLE `judgment_question`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '判断题id',
  `subject` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '判断题题目',
  `answer` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '判断题答案（0：错， 1：对）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of judgment_question
-- ----------------------------

-- ----------------------------
-- Table structure for learning_status
-- ----------------------------
DROP TABLE IF EXISTS `learning_status`;
CREATE TABLE `learning_status`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学习状态表id',
  `user_id` int UNSIGNED NOT NULL COMMENT '用户id',
  `course_id` int UNSIGNED NOT NULL COMMENT '课程id                        ',
  `course_unit_id` int UNSIGNED NOT NULL COMMENT '单元id',
  `vedio_status` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '视频学习状态（0: 未看完, 1: 已看完）',
  `vedio_rate` float NOT NULL DEFAULT 0 COMMENT '视频学习进度',
  `test_status` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '测试完成状态（0: 未测试, 1: 已测试）',
  `test_score` float NOT NULL DEFAULT 0 COMMENT '测试得分',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls&user_id`(`user_id`) USING BTREE,
  INDEX `ls&course_id`(`course_id`) USING BTREE,
  INDEX `ls&course_unit_id`(`course_unit_id`) USING BTREE,
  CONSTRAINT `ls&course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `ls&course_unit_id` FOREIGN KEY (`course_unit_id`) REFERENCES `course_unit` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `ls&user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of learning_status
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户手机号',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_certificate
-- ----------------------------
DROP TABLE IF EXISTS `user_certificate`;
CREATE TABLE `user_certificate`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户证书表id',
  `user_id` int UNSIGNED NOT NULL COMMENT '用户id',
  `certificate_id` int UNSIGNED NOT NULL COMMENT '证书id',
  `status` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '用户获取证书状态（0: 未获取, 1: 已获取）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `cerificate_id`(`certificate_id`) USING BTREE,
  CONSTRAINT `cerificate_id` FOREIGN KEY (`certificate_id`) REFERENCES `certificate` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_certificate
-- ----------------------------

-- ----------------------------
-- Table structure for user_learning_course
-- ----------------------------
DROP TABLE IF EXISTS `user_learning_course`;
CREATE TABLE `user_learning_course`  (
  `id` int NOT NULL COMMENT '用户学习课程id',
  `user_id` int UNSIGNED NOT NULL COMMENT '用户id',
  `course_id` int UNSIGNED NOT NULL COMMENT '课程id',
  `learning_state` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '学习状态（0：学习中， 1：学习完）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ulc&user`(`user_id`) USING BTREE,
  INDEX `ulc&course`(`course_id`) USING BTREE,
  CONSTRAINT `ulc&course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `ulc&user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_learning_course
-- ----------------------------

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `course_unit_id` int UNSIGNED NOT NULL COMMENT '视频所属单元id',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频地址',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频名字',
  `describe` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '视频描述',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `v&course_unit_id`(`course_unit_id`) USING BTREE,
  CONSTRAINT `v&course_unit_id` FOREIGN KEY (`course_unit_id`) REFERENCES `course_unit` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
