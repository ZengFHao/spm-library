/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 19/01/2023 14:41:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `account_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `account_type` int NOT NULL DEFAULT 2,
  PRIMARY KEY (`account_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` (`account_name`, `account_password`, `account_type`) VALUES ('hahahehe', 'jaskdl;g', 2), ('manager1', '656565', 1), ('manager2', 'asdf', 1), ('root', 'sdgf', 2), ('spread111', '021015zcbzcb', 2), ('spreadzhao', 'asasdg', 2), ('zengfanhao', 'zfhzfh', 1), ('zhaozhao', 'zcbzcbzcb', 2);
COMMIT;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `book_isbn` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `book_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `book_author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `book_publisher` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `book_summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `book_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
   COMMENT 'Cover is stored in another tomcat, we store it\'s filename here.',
  `book_price` float(10, 2) NULL DEFAULT 0.00,
  `book_stock` int UNSIGNED NULL DEFAULT NULL,
  `book_category_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `fk_category_name`(`book_category_name` ASC) USING BTREE,
  CONSTRAINT `fk_category_name` FOREIGN KEY (`book_category_name`) REFERENCES `category` (`category_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
BEGIN;
INSERT INTO `book` (`book_id`, `book_isbn`, `book_name`, `book_author`, `book_publisher`, `book_summary`, `book_cover`, `book_price`, `book_stock`, `book_category_name`) VALUES (1, '978-12345', 'test', 'spread', 'spread', 'haha', 'test.jpg', 2.22, 29, 'math'), (2, '978-43213', 'alsotest', 'zhao', 'haha', 'hehe', 'also.png', 100.00, 998, 'urban novel'), (3, '978-23129', 'haha', 'asudgf', 'asklgdf;', 'uududu', 'hehe.png', 11.11, 33, 'math'), (4, '978-237372', 'hometown', 'zengfanhao', 'asdf', 'my hometown book', 'hometown.png', 78.45, 456, 'urban novel'), (6, '978-99999', '9999', 'hone', NULL, NULL, NULL, 0.00, 0, NULL), (7, '978-99998', NULL, NULL, NULL, NULL, NULL, 78.45, 0, NULL), (8, '978-35685', NULL, NULL, NULL, NULL, NULL, 0.00, 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `borrow_id` int NOT NULL,
  `borrow_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `borrow_book_id` int NOT NULL,
  `borrow_duration` int NOT NULL,
  `borrow_is_over_time` tinyint NOT NULL DEFAULT 0,
  `borrow_fine` float NULL DEFAULT NULL,
  `borrow_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`borrow_id`) USING BTREE,
  INDEX `fk_borrow_account`(`borrow_account` ASC) USING BTREE,
  CONSTRAINT `fk_borrow_account` FOREIGN KEY (`borrow_account`) REFERENCES `account` (`account_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of borrow
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_parent_id` int NULL DEFAULT 0,
  `category_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `category_isdeepest` tinyint UNSIGNED NOT NULL DEFAULT 1,
  PRIMARY KEY (`category_id`) USING BTREE,
  INDEX `category_name`(`category_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` (`category_id`, `category_parent_id`, `category_name`, `category_isdeepest`) VALUES (10, 0, 'novel', 0), (11, 10, 'urban novel', 1), (12, 0, 'teaching material', 1), (13, 12, 'math', 1), (14, 0, 'reference book', 0), (15, 14, 'encyclopedia', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
