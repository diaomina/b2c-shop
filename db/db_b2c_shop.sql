/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云@39.108.5.98
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 39.108.5.98:3306
 Source Schema         : db_b2c_shop

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : 65001

 Date: 20/02/2020 21:08:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_ad
-- ----------------------------
DROP TABLE IF EXISTS `t_ad`;
CREATE TABLE `t_ad`  (
  `ad_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '广告id，主键，自增1',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广告图像地址',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广告描述',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广告链接',
  `state` tinyint(4) NULL DEFAULT 2 COMMENT '状态，1开启 2关闭',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_state` tinyint(4) NULL DEFAULT 2 COMMENT '删除状态 1 已删除 2 未删除',
  `admin_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`ad_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_ad
-- ----------------------------
INSERT INTO `t_ad` VALUES (1, '/static/upload/91a5222f2a854173a552234ec406ff34.jpg', '性能超强，就选我！！！！', '/goodsAction/goGoodsDetail?goodsId=12', 1, '2020-02-11 19:27:17', '2020-02-19 14:58:22', 2, 1);
INSERT INTO `t_ad` VALUES (2, '/static/upload/387e2ec461884fcab219676a116ad95f.jpg', '地表最强！！！！', '/goodsAction/goGoodsDetail?goodsId=11', 1, '2020-02-11 20:35:43', '2020-02-19 14:59:24', 2, 1);
INSERT INTO `t_ad` VALUES (3, '/static/upload/85fb6380cbdd4f999f6d384b5cc8c29a.jpg', '我是最好的！', '/goodsAction/goGoodsDetail?goodsId=13', 1, '2020-02-11 22:46:45', '2020-02-19 14:59:12', 2, 1);

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理账号名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码(md5 随机码)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_state` tinyint(4) NULL DEFAULT 2 COMMENT '删除状态 1 已删除 2 未删除',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', '558554b68bd781c7006d3b7f7a5b0d48', '2020-01-15 21:11:06', '2020-01-15 21:11:08', 2);

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `is_buy` tinyint(4) NULL DEFAULT 2 COMMENT '是否购买标志：1 已购买 2 未购买',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 105 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车表' ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES (78, 23, 25, 1, 1, '2009-05-04 01:09:13', '2009-05-04 01:09:13');
INSERT INTO `t_cart` VALUES (79, 23, 25, 3, 1, '2009-05-04 01:09:14', '2009-05-04 01:09:14');
INSERT INTO `t_cart` VALUES (80, 23, 26, 1, 1, '2009-05-04 01:09:19', '2009-05-04 01:09:19');
INSERT INTO `t_cart` VALUES (81, 23, 26, 1, 1, '2009-05-04 01:10:11', '2009-05-04 01:10:11');
INSERT INTO `t_cart` VALUES (82, 23, 26, 1, 1, '2020-02-14 23:48:14', '2020-02-14 23:48:14');
INSERT INTO `t_cart` VALUES (83, 23, 26, 4, 1, '2020-02-15 16:56:27', '2020-02-15 17:05:34');
INSERT INTO `t_cart` VALUES (84, 23, 25, 1, 1, '2020-02-15 17:05:41', '2020-02-15 17:05:41');
INSERT INTO `t_cart` VALUES (85, 23, 25, 1, 1, '2020-02-15 17:05:41', '2020-02-15 17:05:41');
INSERT INTO `t_cart` VALUES (86, 23, 25, 1, 1, '2020-02-15 17:05:41', '2020-02-15 17:05:41');
INSERT INTO `t_cart` VALUES (87, 23, 25, 1, 1, '2020-02-15 17:05:41', '2020-02-15 17:05:41');
INSERT INTO `t_cart` VALUES (88, 23, 25, 1, 1, '2020-02-15 17:05:41', '2020-02-15 17:05:41');
INSERT INTO `t_cart` VALUES (89, 23, 25, 1, 1, '2020-02-15 17:05:41', '2020-02-15 17:05:41');
INSERT INTO `t_cart` VALUES (90, 23, 25, 1, 1, '2020-02-15 17:05:42', '2020-02-15 17:05:42');
INSERT INTO `t_cart` VALUES (91, 23, 25, 2, 1, '2020-02-15 17:05:43', '2020-02-15 17:05:43');
INSERT INTO `t_cart` VALUES (92, 23, 25, 2, 1, '2020-02-15 17:05:43', '2020-02-15 17:05:43');
INSERT INTO `t_cart` VALUES (93, 23, 25, 2, 1, '2020-02-15 17:05:43', '2020-02-15 17:05:43');
INSERT INTO `t_cart` VALUES (94, 23, 25, 3, 1, '2020-02-15 17:05:44', '2020-02-15 17:05:44');
INSERT INTO `t_cart` VALUES (95, 23, 26, 1, 1, '2020-02-16 20:57:56', '2020-02-16 20:57:56');
INSERT INTO `t_cart` VALUES (96, 23, 26, 1, 1, '2020-02-16 20:57:56', '2020-02-16 20:57:56');
INSERT INTO `t_cart` VALUES (97, 23, 26, 1, 1, '2020-02-16 20:57:57', '2020-02-16 20:57:57');
INSERT INTO `t_cart` VALUES (98, 23, 26, 1, 1, '2020-02-16 21:05:13', '2020-02-16 21:05:13');
INSERT INTO `t_cart` VALUES (99, 23, 25, 1, 1, '2020-02-17 20:21:28', '2020-02-17 20:36:44');
INSERT INTO `t_cart` VALUES (100, 23, 25, 1, 1, '2020-02-17 20:21:28', '2020-02-17 20:21:28');
INSERT INTO `t_cart` VALUES (101, 23, 25, 2, 1, '2020-02-17 20:21:30', '2020-02-17 20:21:30');
INSERT INTO `t_cart` VALUES (102, 23, 25, 2, 1, '2020-02-17 20:21:30', '2020-02-17 20:21:30');
INSERT INTO `t_cart` VALUES (103, 23, 25, 2, 1, '2020-02-17 20:21:31', '2020-02-17 20:21:31');
INSERT INTO `t_cart` VALUES (104, 23, 26, 1, 1, '2020-02-18 17:31:07', '2020-02-18 17:31:07');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '所属类别id',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `price` int(11) NULL DEFAULT NULL COMMENT '商品单价（以分为单位）',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '库存数量',
  `del_state` tinyint(4) NULL DEFAULT 2 COMMENT '删除 1是 2否',
  `simple_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简要描述',
  `is_marketable` tinyint(4) NULL DEFAULT 0 COMMENT '上架标志 1 已上架 0 未上架',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `admin_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `version` bigint(20) NULL DEFAULT 1 COMMENT '版本号',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 227 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (25, 50, '华为nova5', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 88888, 79996, 2, '128g 翡翠绿', 1, '2009-05-04 01:06:00', '2020-02-19 14:56:12', 1, 2);
INSERT INTO `t_goods` VALUES (26, 50, 'iphone11', '/static/upload/c17874b303674ebab9aeb58812381532.jpg', 100000, 793, 2, '64g 银色', 1, '2009-05-04 01:07:55', '2020-02-19 14:57:25', 1, 7);
INSERT INTO `t_goods` VALUES (27, 50, '华为Mate1', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:43', '2020-02-15 17:55:43', 1, 1);
INSERT INTO `t_goods` VALUES (28, 50, '华为Mate2', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (29, 50, '华为Mate3', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (30, 50, '华为Mate4', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (31, 50, '华为Mate5', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (32, 50, '华为Mate6', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (33, 50, '华为Mate7', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (34, 50, '华为Mate8', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (35, 50, '华为Mate9', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (36, 50, '华为Mate10', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (37, 50, '华为Mate11', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (38, 50, '华为Mate12', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (39, 50, '华为Mate13', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (40, 50, '华为Mate14', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (41, 50, '华为Mate15', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (42, 50, '华为Mate16', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (43, 50, '华为Mate17', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (44, 50, '华为Mate18', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:49', '2020-02-15 17:55:49', 1, 1);
INSERT INTO `t_goods` VALUES (45, 50, '华为Mate19', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (46, 50, '华为Mate20', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (47, 50, '华为Mate21', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (48, 50, '华为Mate22', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (49, 50, '华为Mate23', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (50, 50, '华为Mate24', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (51, 50, '华为Mate25', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (52, 50, '华为Mate26', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (53, 50, '华为Mate27', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (54, 50, '华为Mate28', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (55, 50, '华为Mate29', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (56, 50, '华为Mate30', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (57, 50, '华为Mate31', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (58, 50, '华为Mate32', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (59, 50, '华为Mate33', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (60, 50, '华为Mate34', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (61, 50, '华为Mate35', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (62, 50, '华为Mate36', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (63, 50, '华为Mate37', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (64, 50, '华为Mate38', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (65, 50, '华为Mate39', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (66, 50, '华为Mate40', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:50', '2020-02-15 17:55:50', 1, 1);
INSERT INTO `t_goods` VALUES (67, 50, '华为Mate41', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (68, 50, '华为Mate42', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (69, 50, '华为Mate43', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (70, 50, '华为Mate44', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (71, 50, '华为Mate45', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (72, 50, '华为Mate46', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (73, 50, '华为Mate47', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (74, 50, '华为Mate48', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (75, 50, '华为Mate49', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (76, 50, '华为Mate50', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (77, 50, '华为Mate51', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (78, 50, '华为Mate52', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (79, 50, '华为Mate53', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (80, 50, '华为Mate54', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (81, 50, '华为Mate55', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (82, 50, '华为Mate56', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (83, 50, '华为Mate57', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (84, 50, '华为Mate58', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (85, 50, '华为Mate59', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (86, 50, '华为Mate60', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (87, 50, '华为Mate61', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (88, 50, '华为Mate62', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:51', '2020-02-15 17:55:51', 1, 1);
INSERT INTO `t_goods` VALUES (89, 50, '华为Mate63', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (90, 50, '华为Mate64', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (91, 50, '华为Mate65', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (92, 50, '华为Mate66', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (93, 50, '华为Mate67', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (94, 50, '华为Mate68', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (95, 50, '华为Mate69', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (96, 50, '华为Mate70', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (97, 50, '华为Mate71', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (98, 50, '华为Mate72', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (99, 50, '华为Mate73', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (100, 50, '华为Mate74', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (101, 50, '华为Mate75', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (102, 50, '华为Mate76', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (103, 50, '华为Mate77', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (104, 50, '华为Mate78', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (105, 50, '华为Mate79', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (106, 50, '华为Mate80', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (107, 50, '华为Mate81', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (108, 50, '华为Mate82', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (109, 50, '华为Mate83', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (110, 50, '华为Mate84', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (111, 50, '华为Mate85', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:52', '2020-02-15 17:55:52', 1, 1);
INSERT INTO `t_goods` VALUES (112, 50, '华为Mate86', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (113, 50, '华为Mate87', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (114, 50, '华为Mate88', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (115, 50, '华为Mate89', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (116, 50, '华为Mate90', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (117, 50, '华为Mate91', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (118, 50, '华为Mate92', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (119, 50, '华为Mate93', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (120, 50, '华为Mate94', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (121, 50, '华为Mate95', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (122, 50, '华为Mate96', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (123, 50, '华为Mate97', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (124, 50, '华为Mate98', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (125, 50, '华为Mate99', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (126, 50, '华为Mate100', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-15 17:55:53', '2020-02-15 17:55:53', 1, 1);
INSERT INTO `t_goods` VALUES (127, 50, '华为Mate1', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:29', '2020-02-16 20:56:29', 1, 1);
INSERT INTO `t_goods` VALUES (128, 50, '华为Mate2', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (129, 50, '华为Mate3', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (130, 50, '华为Mate4', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (131, 50, '华为Mate5', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (132, 50, '华为Mate6', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (133, 50, '华为Mate7', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (134, 50, '华为Mate8', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (135, 50, '华为Mate9', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (136, 50, '华为Mate10', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (137, 50, '华为Mate11', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (138, 50, '华为Mate12', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (139, 50, '华为Mate13', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (140, 50, '华为Mate14', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (141, 50, '华为Mate15', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (142, 50, '华为Mate16', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (143, 50, '华为Mate17', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (144, 50, '华为Mate18', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (145, 50, '华为Mate19', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (146, 50, '华为Mate20', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (147, 50, '华为Mate21', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (148, 50, '华为Mate22', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (149, 50, '华为Mate23', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (150, 50, '华为Mate24', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:35', '2020-02-16 20:56:35', 1, 1);
INSERT INTO `t_goods` VALUES (151, 50, '华为Mate25', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (152, 50, '华为Mate26', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (153, 50, '华为Mate27', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (154, 50, '华为Mate28', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (155, 50, '华为Mate29', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (156, 50, '华为Mate30', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (157, 50, '华为Mate31', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (158, 50, '华为Mate32', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (159, 50, '华为Mate33', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (160, 50, '华为Mate34', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (161, 50, '华为Mate35', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (162, 50, '华为Mate36', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (163, 50, '华为Mate37', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (164, 50, '华为Mate38', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (165, 50, '华为Mate39', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (166, 50, '华为Mate40', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (167, 50, '华为Mate41', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (168, 50, '华为Mate42', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (169, 50, '华为Mate43', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (170, 50, '华为Mate44', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (171, 50, '华为Mate45', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:36', '2020-02-16 20:56:36', 1, 1);
INSERT INTO `t_goods` VALUES (172, 50, '华为Mate46', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (173, 50, '华为Mate47', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (174, 50, '华为Mate48', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (175, 50, '华为Mate49', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (176, 50, '华为Mate50', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (177, 50, '华为Mate51', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (178, 50, '华为Mate52', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (179, 50, '华为Mate53', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (180, 50, '华为Mate54', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (181, 50, '华为Mate55', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (182, 50, '华为Mate56', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (183, 50, '华为Mate57', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (184, 50, '华为Mate58', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (185, 50, '华为Mate59', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (186, 50, '华为Mate60', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (187, 50, '华为Mate61', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (188, 50, '华为Mate62', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (189, 50, '华为Mate63', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (190, 50, '华为Mate64', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (191, 50, '华为Mate65', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:37', '2020-02-16 20:56:37', 1, 1);
INSERT INTO `t_goods` VALUES (192, 50, '华为Mate66', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (193, 50, '华为Mate67', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (194, 50, '华为Mate68', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (195, 50, '华为Mate69', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (196, 50, '华为Mate70', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (197, 50, '华为Mate71', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (198, 50, '华为Mate72', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (199, 50, '华为Mate73', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (200, 50, '华为Mate74', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (201, 50, '华为Mate75', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (202, 50, '华为Mate76', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (203, 50, '华为Mate77', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (204, 50, '华为Mate78', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (205, 50, '华为Mate79', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (206, 50, '华为Mate80', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (207, 50, '华为Mate81', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (208, 50, '华为Mate82', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (209, 50, '华为Mate83', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (210, 50, '华为Mate84', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (211, 50, '华为Mate85', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:38', '2020-02-16 20:56:38', 1, 1);
INSERT INTO `t_goods` VALUES (212, 50, '华为Mate86', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (213, 50, '华为Mate87', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (214, 50, '华为Mate88', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (215, 50, '华为Mate89', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (216, 50, '华为Mate90', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (217, 50, '华为Mate91', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (218, 50, '华为Mate92', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (219, 50, '华为Mate93', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (220, 50, '华为Mate94', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (221, 50, '华为Mate95', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (222, 50, '华为Mate96', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (223, 50, '华为Mate97', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (224, 50, '华为Mate98', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (225, 50, '华为Mate99', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);
INSERT INTO `t_goods` VALUES (226, 50, '华为Mate100', '/static/upload/b8c82862a66242118f8b722893eef25c.jpg', 399900, 500, 2, '64g 绿色', 1, '2020-02-16 20:56:39', '2020-02-16 20:56:39', 1, 1);

-- ----------------------------
-- Table structure for t_goods_category
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_category`;
CREATE TABLE `t_goods_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品种类id',
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '父种类id 为零表示顶层种类',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品种类名称',
  `state` tinyint(4) NULL DEFAULT 2 COMMENT '状态 1.启用 2.未启用 3 已删除',
  `simple_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简要描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `admin_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 92 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品种类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods_category
-- ----------------------------
INSERT INTO `t_goods_category` VALUES (15, 0, '百货', 1, '各种货物。', '2020-01-28 18:49:20', '2020-02-11 23:14:39', 1);
INSERT INTO `t_goods_category` VALUES (16, 0, '生鲜', 1, '生鲜是指未经烹调、制作等深加工过程，只做必要保鲜和简单整理上架而出售的初级产品，以及面包、熟食等现场加工品类的商品的统称。', '2020-01-28 18:49:33', '2020-02-11 23:15:06', 1);
INSERT INTO `t_goods_category` VALUES (17, 0, '食品', 1, '食品，指各种供人食用或者饮用的成品和原料以及按照传统既是食品又是中药材的物品，但是不包括以治疗为目的的物品。', '2020-01-28 18:49:44', '2020-02-11 23:15:31', 1);
INSERT INTO `t_goods_category` VALUES (18, 0, '数码', 1, '数码产品一般指的是MP3、U盘，智能手机，数码照相机/摄像机/扫描仪等可以通过数字和编码进行操作并且可以与电脑连接的机器。', '2020-01-28 18:49:51', '2020-02-11 23:16:47', 1);
INSERT INTO `t_goods_category` VALUES (19, 0, '男装', 1, '男装，是指男性穿于身体起保护和装饰作用的服饰制品。包括上装和下装，男装会根据季节和个人的需求有不同的款式和作用。', '2020-01-28 18:50:06', '2020-02-11 23:17:09', 1);
INSERT INTO `t_goods_category` VALUES (20, 0, '女装', 1, '女士穿着的衣物统称为女装。', '2020-01-28 18:50:12', '2020-02-11 23:17:47', 1);
INSERT INTO `t_goods_category` VALUES (21, 0, '洗护', 1, '洗护用品是家庭日常生活护理必备用品,包括洗发露、沐浴露、洗手液、手工皂等。', '2020-01-28 18:50:41', '2020-02-11 23:18:41', 1);
INSERT INTO `t_goods_category` VALUES (22, 0, '母婴', 1, '母婴用品是指为孕产期女性与0-3岁婴儿这两类特殊相关联群体提供的专业健康产品。', '2020-01-28 18:50:49', '2020-02-11 23:19:04', 1);
INSERT INTO `t_goods_category` VALUES (23, 0, '美妆', 1, '是指以涂抹、喷洒或者其他类似方法，散布于人体表面的任何部位，如皮肤、毛发、指趾甲、唇齿等，以达到清洁、保养、美容、修饰和改变外观，或者修正人体气味，保持良好状态为目的的化学工业品或精细化工产品。', '2020-01-28 18:50:57', '2020-02-11 23:21:22', 1);
INSERT INTO `t_goods_category` VALUES (24, 0, '家装', 1, '家装，家庭住宅装修装饰的简称。狭义的家装：指室内装饰，是从美化的角度来考虑的，以使室内的空间更美观；广义的家装：包括室内空间的装修。', '2020-01-28 18:51:13', '2020-02-11 23:23:03', 1);
INSERT INTO `t_goods_category` VALUES (25, 0, '电器', 1, '电器（electrical appliance）泛指所有用电的器具，从专业角度上来讲，主要指用于对电路进行接通、分断，对电路参数进行变换，以实现对电路或用电设备的控制、调节、切换、检测和保护等作用的电工装置、设备和元件；从普通民众的角度来讲，主要是指家庭常用的一些为生活提供便利的用电设备，如电视机、空调、冰箱、洗衣机、各种小家电等等。', '2020-01-28 18:51:19', '2020-02-11 23:23:42', 1);
INSERT INTO `t_goods_category` VALUES (26, 15, '居家用品', 1, '', '2020-01-28 18:53:04', '2020-01-28 18:53:04', 1);
INSERT INTO `t_goods_category` VALUES (27, 15, '文具教具', 1, '', '2020-01-28 18:53:18', '2020-01-28 18:53:18', 1);
INSERT INTO `t_goods_category` VALUES (28, 15, '清洁工具', 1, '', '2020-01-28 18:53:31', '2020-01-28 18:53:31', 1);
INSERT INTO `t_goods_category` VALUES (29, 15, '餐饮用具', 1, '', '2020-01-28 18:53:45', '2020-01-28 18:53:45', 1);
INSERT INTO `t_goods_category` VALUES (30, 15, '窗帘布艺', 1, '', '2020-01-28 18:54:02', '2020-01-28 18:54:02', 1);
INSERT INTO `t_goods_category` VALUES (31, 15, '绿植宠物', 1, '', '2020-01-28 18:54:18', '2020-01-28 18:54:18', 1);
INSERT INTO `t_goods_category` VALUES (32, 15, '厨房用品', 1, '', '2020-01-28 18:54:29', '2020-01-28 18:54:29', 1);
INSERT INTO `t_goods_category` VALUES (33, 15, '收纳整理', 1, '', '2020-01-28 18:54:42', '2020-01-28 18:54:42', 1);
INSERT INTO `t_goods_category` VALUES (34, 16, '美味蔬菜', 1, '', '2020-01-28 18:55:10', '2020-01-28 18:55:10', 1);
INSERT INTO `t_goods_category` VALUES (35, 16, '新鲜水果', 1, '', '2020-01-28 18:55:18', '2020-01-28 18:55:18', 1);
INSERT INTO `t_goods_category` VALUES (36, 16, '锅物料理', 1, '', '2020-01-28 18:55:36', '2020-01-28 18:55:36', 1);
INSERT INTO `t_goods_category` VALUES (37, 16, '海鲜水产', 1, '', '2020-01-28 18:55:51', '2020-01-28 18:55:51', 1);
INSERT INTO `t_goods_category` VALUES (38, 16, '新鲜肉类', 1, '', '2020-01-28 18:56:02', '2020-01-28 18:56:02', 1);
INSERT INTO `t_goods_category` VALUES (39, 16, '禽蛋', 1, '', '2020-01-28 18:56:14', '2020-01-28 18:56:14', 1);
INSERT INTO `t_goods_category` VALUES (40, 17, '礼品礼包', 1, '', '2020-01-28 19:08:33', '2020-01-28 19:08:33', 1);
INSERT INTO `t_goods_category` VALUES (41, 17, '方便速食', 1, '', '2020-01-28 19:08:56', '2020-01-28 19:08:56', 1);
INSERT INTO `t_goods_category` VALUES (42, 17, '零食', 1, '', '2020-01-28 19:09:09', '2020-01-28 19:09:09', 1);
INSERT INTO `t_goods_category` VALUES (43, 17, '名酒', 1, '', '2020-01-28 19:09:21', '2020-01-28 19:09:21', 1);
INSERT INTO `t_goods_category` VALUES (44, 17, '粮油调味', 1, '', '2020-01-28 19:09:34', '2020-01-28 19:09:34', 1);
INSERT INTO `t_goods_category` VALUES (45, 17, '冲饮', 1, '', '2020-01-28 19:09:50', '2020-01-28 19:09:50', 1);
INSERT INTO `t_goods_category` VALUES (46, 17, '乳饮', 1, '', '2020-01-28 19:10:05', '2020-01-28 19:10:05', 1);
INSERT INTO `t_goods_category` VALUES (47, 17, '茶', 1, '', '2020-01-28 19:10:15', '2020-01-28 19:10:15', 1);
INSERT INTO `t_goods_category` VALUES (48, 17, '烘培原料', 1, '', '2020-01-28 19:10:29', '2020-01-28 19:10:29', 1);
INSERT INTO `t_goods_category` VALUES (49, 18, '电脑笔记本', 1, '', '2020-01-28 19:10:51', '2020-01-28 19:10:51', 1);
INSERT INTO `t_goods_category` VALUES (50, 18, '手机', 1, '', '2020-01-28 19:11:02', '2020-01-28 19:11:02', 1);
INSERT INTO `t_goods_category` VALUES (51, 18, '影音娱乐', 1, '', '2020-01-28 19:11:14', '2020-01-28 19:11:14', 1);
INSERT INTO `t_goods_category` VALUES (52, 18, '数码配件', 1, '', '2020-01-28 19:11:24', '2020-01-28 19:11:24', 1);
INSERT INTO `t_goods_category` VALUES (53, 18, '智能设备', 1, '', '2020-01-28 19:11:35', '2020-01-28 19:11:35', 1);
INSERT INTO `t_goods_category` VALUES (54, 18, '商务办公', 1, '', '2020-01-28 19:11:46', '2020-01-28 19:11:46', 1);
INSERT INTO `t_goods_category` VALUES (55, 18, '摄影摄像', 1, '', '2020-01-28 19:12:02', '2020-01-28 19:12:02', 1);
INSERT INTO `t_goods_category` VALUES (56, 18, '网络产品', 1, '', '2020-01-28 19:12:16', '2020-01-28 19:12:16', 1);
INSERT INTO `t_goods_category` VALUES (57, 19, '上装', 1, '', '2020-01-28 19:12:35', '2020-01-28 19:12:35', 1);
INSERT INTO `t_goods_category` VALUES (58, 19, '裤子', 1, '', '2020-01-28 19:12:45', '2020-01-28 19:12:45', 1);
INSERT INTO `t_goods_category` VALUES (59, 19, '正装套装', 1, '', '2020-01-28 19:13:02', '2020-01-28 19:13:02', 1);
INSERT INTO `t_goods_category` VALUES (60, 20, '外套', 1, '', '2020-01-28 19:13:37', '2020-01-28 19:13:37', 1);
INSERT INTO `t_goods_category` VALUES (61, 20, '女裙', 1, '', '2020-01-28 19:13:48', '2020-01-28 19:13:48', 1);
INSERT INTO `t_goods_category` VALUES (62, 20, '女裤', 1, '', '2020-01-28 19:13:58', '2020-01-28 19:13:58', 1);
INSERT INTO `t_goods_category` VALUES (63, 20, '套装', 1, '', '2020-01-28 19:14:08', '2020-01-28 19:14:08', 1);
INSERT INTO `t_goods_category` VALUES (64, 19, '男鞋', 1, '', '2020-01-28 19:14:22', '2020-01-28 19:14:22', 1);
INSERT INTO `t_goods_category` VALUES (65, 20, '女鞋', 1, '', '2020-01-28 19:14:31', '2020-01-28 19:14:31', 1);
INSERT INTO `t_goods_category` VALUES (66, 21, '家用清洁', 1, '', '2020-01-28 19:14:49', '2020-01-28 19:14:49', 1);
INSERT INTO `t_goods_category` VALUES (67, 21, '洗浴用品', 1, '', '2020-01-28 19:15:00', '2020-01-28 19:15:00', 1);
INSERT INTO `t_goods_category` VALUES (68, 21, '毛发护理', 1, '', '2020-01-28 19:15:11', '2020-01-28 19:15:11', 1);
INSERT INTO `t_goods_category` VALUES (69, 21, '纸品湿巾', 1, '', '2020-01-28 19:15:29', '2020-01-28 19:15:29', 1);
INSERT INTO `t_goods_category` VALUES (70, 21, '女性护理', 1, '', '2020-01-28 19:15:40', '2020-01-28 19:15:40', 1);
INSERT INTO `t_goods_category` VALUES (71, 22, '儿童玩具', 1, '', '2020-01-28 19:15:56', '2020-01-28 19:15:56', 1);
INSERT INTO `t_goods_category` VALUES (72, 22, '童装', 1, '', '2020-01-28 19:16:06', '2020-01-28 19:16:06', 1);
INSERT INTO `t_goods_category` VALUES (73, 22, '潮玩动漫', 1, '', '2020-01-28 19:16:19', '2020-01-28 19:16:19', 1);
INSERT INTO `t_goods_category` VALUES (74, 22, '哺乳喂养', 1, '', '2020-01-28 19:16:36', '2020-01-28 19:16:36', 1);
INSERT INTO `t_goods_category` VALUES (75, 22, '童鞋', 1, '', '2020-01-28 19:16:45', '2020-01-28 19:16:45', 1);
INSERT INTO `t_goods_category` VALUES (76, 22, '宝宝出行', 1, '', '2020-01-28 19:16:57', '2020-01-28 19:16:57', 1);
INSERT INTO `t_goods_category` VALUES (77, 22, '婴儿装', 1, '', '2020-01-28 19:17:06', '2020-01-28 19:17:06', 1);
INSERT INTO `t_goods_category` VALUES (78, 22, '孕产妇穿搭', 1, '', '2020-01-28 19:17:23', '2020-01-28 19:17:23', 1);
INSERT INTO `t_goods_category` VALUES (79, 22, '孕产妇用品', 1, '', '2020-01-28 19:17:39', '2020-01-28 19:17:39', 1);
INSERT INTO `t_goods_category` VALUES (80, 22, '奶粉营养', 1, '', '2020-01-28 19:17:51', '2020-01-28 19:17:51', 1);
INSERT INTO `t_goods_category` VALUES (81, 23, '彩妆', 1, '', '2020-01-28 19:18:21', '2020-01-28 19:18:21', 1);
INSERT INTO `t_goods_category` VALUES (82, 23, '护肤', 1, '', '2020-01-28 19:18:29', '2020-01-28 19:18:29', 1);
INSERT INTO `t_goods_category` VALUES (83, 23, '美容美体', 1, '', '2020-01-28 19:18:41', '2020-01-28 19:18:41', 1);
INSERT INTO `t_goods_category` VALUES (84, 24, '住宅家具', 1, '', '2020-01-28 19:18:57', '2020-01-28 19:18:57', 1);
INSERT INTO `t_goods_category` VALUES (85, 24, '灯具五金', 1, '', '2020-01-28 19:19:16', '2020-01-28 19:19:16', 1);
INSERT INTO `t_goods_category` VALUES (86, 24, '厨房卫浴', 1, '', '2020-01-28 19:19:29', '2020-01-28 19:19:29', 1);
INSERT INTO `t_goods_category` VALUES (87, 24, '安防五金', 1, '', '2020-01-28 19:19:42', '2020-01-28 19:19:42', 1);
INSERT INTO `t_goods_category` VALUES (88, 24, '家装建材', 1, '', '2020-01-28 19:20:05', '2020-01-28 19:20:05', 1);
INSERT INTO `t_goods_category` VALUES (89, 25, '生活电器', 1, '', '2020-01-28 19:20:24', '2020-01-28 19:20:24', 1);
INSERT INTO `t_goods_category` VALUES (90, 25, '个护电器', 1, '', '2020-01-28 19:20:37', '2020-01-28 19:20:37', 1);
INSERT INTO `t_goods_category` VALUES (91, 25, '大家电', 1, '', '2020-01-28 19:20:46', '2020-01-28 19:20:46', 1);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `total_amount` int(11) NULL DEFAULT NULL COMMENT '订单总金额(以分为单位)',
  `receive_id` int(11) NULL DEFAULT NULL COMMENT '收货id',
  `send_time` datetime NULL DEFAULT NULL COMMENT '发货时间',
  `logistics_state` tinyint(4) NULL DEFAULT 1 COMMENT '配送状态 1 待配送 2  已配送 3 已确认收货',
  `del_state` tinyint(4) NULL DEFAULT 2 COMMENT '删除 1是 2否',
  `pay_state` tinyint(4) NULL DEFAULT 1 COMMENT '支付状态 1.未付款 2 已付款',
  `create_time` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (62, '2009050401094948E812831C8D4FD19F267DA4017DB40A02926887', 23, 455552, 9, '2009-05-04 01:11:30', 3, 2, 2, '2009-05-04 01:09:49', '2009-05-04 01:11:38');
INSERT INTO `t_order` VALUES (63, '200905040110176D661C9A761546C3A50159334484549862557091', 23, 100000, 10, '2020-02-15 16:36:37', 2, 2, 2, '2009-05-04 01:10:17', '2020-02-15 16:36:37');
INSERT INTO `t_order` VALUES (64, '2020021411482103E3E79B7F33465D80BE58028FA3CA0839612246', 23, 100000, 9, NULL, 1, 2, 2, '2020-02-14 23:48:21', '2020-02-14 23:48:31');
INSERT INTO `t_order` VALUES (65, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 23, 1822207, 9, NULL, 1, 1, 1, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order` VALUES (66, '20200216085815F10FF94C4368432D96721B98D25BAD0308406592', 23, 300000, 9, NULL, 1, 2, 2, '2020-02-16 20:58:15', '2020-02-16 20:58:21');
INSERT INTO `t_order` VALUES (67, '20200216090534152BCAF882B94316BF57860BC00484BF19609754', 23, 100000, 9, NULL, 1, 2, 2, '2020-02-16 21:05:34', '2020-02-16 21:06:03');
INSERT INTO `t_order` VALUES (68, '20200218053853CB5925B276D54DDEB480753098ACADBA06630918', 23, 811104, 9, NULL, 1, 2, 1, '2020-02-18 17:38:53', '2020-02-18 17:38:53');

-- ----------------------------
-- Table structure for t_order_child
-- ----------------------------
DROP TABLE IF EXISTS `t_order_child`;
CREATE TABLE `t_order_child`  (
  `order_child_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '子订单id',
  `order_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_child_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 115 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '子订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_child
-- ----------------------------
INSERT INTO `t_order_child` VALUES (88, '2009050401094948E812831C8D4FD19F267DA4017DB40A02926887', 25, 1, '2009-05-04 01:09:49', '2009-05-04 01:09:49');
INSERT INTO `t_order_child` VALUES (89, '2009050401094948E812831C8D4FD19F267DA4017DB40A02926887', 25, 3, '2009-05-04 01:09:49', '2009-05-04 01:09:49');
INSERT INTO `t_order_child` VALUES (90, '2009050401094948E812831C8D4FD19F267DA4017DB40A02926887', 26, 1, '2009-05-04 01:09:49', '2009-05-04 01:09:49');
INSERT INTO `t_order_child` VALUES (91, '200905040110176D661C9A761546C3A50159334484549862557091', 26, 1, '2009-05-04 01:10:17', '2009-05-04 01:10:17');
INSERT INTO `t_order_child` VALUES (92, '2020021411482103E3E79B7F33465D80BE58028FA3CA0839612246', 26, 1, '2020-02-14 23:48:21', '2020-02-14 23:48:21');
INSERT INTO `t_order_child` VALUES (93, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 26, 4, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (94, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 1, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (95, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 1, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (96, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 1, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (97, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 1, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (98, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 1, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (99, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 1, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (100, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 1, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (101, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 2, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (102, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 2, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (103, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 2, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (104, '20200215050611DF87BC5B2F734F1983B7A33D8A1BD41F46773356', 25, 3, '2020-02-15 17:06:11', '2020-02-15 17:06:11');
INSERT INTO `t_order_child` VALUES (105, '20200216085815F10FF94C4368432D96721B98D25BAD0308406592', 26, 1, '2020-02-16 20:58:15', '2020-02-16 20:58:15');
INSERT INTO `t_order_child` VALUES (106, '20200216085815F10FF94C4368432D96721B98D25BAD0308406592', 26, 1, '2020-02-16 20:58:15', '2020-02-16 20:58:15');
INSERT INTO `t_order_child` VALUES (107, '20200216085815F10FF94C4368432D96721B98D25BAD0308406592', 26, 1, '2020-02-16 20:58:15', '2020-02-16 20:58:15');
INSERT INTO `t_order_child` VALUES (108, '20200216090534152BCAF882B94316BF57860BC00484BF19609754', 26, 1, '2020-02-16 21:05:34', '2020-02-16 21:05:34');
INSERT INTO `t_order_child` VALUES (109, '20200218053853CB5925B276D54DDEB480753098ACADBA06630918', 25, 1, '2020-02-18 17:38:53', '2020-02-18 17:38:53');
INSERT INTO `t_order_child` VALUES (110, '20200218053853CB5925B276D54DDEB480753098ACADBA06630918', 25, 1, '2020-02-18 17:38:53', '2020-02-18 17:38:53');
INSERT INTO `t_order_child` VALUES (111, '20200218053853CB5925B276D54DDEB480753098ACADBA06630918', 25, 2, '2020-02-18 17:38:53', '2020-02-18 17:38:53');
INSERT INTO `t_order_child` VALUES (112, '20200218053853CB5925B276D54DDEB480753098ACADBA06630918', 25, 2, '2020-02-18 17:38:53', '2020-02-18 17:38:53');
INSERT INTO `t_order_child` VALUES (113, '20200218053853CB5925B276D54DDEB480753098ACADBA06630918', 25, 2, '2020-02-18 17:38:53', '2020-02-18 17:38:53');
INSERT INTO `t_order_child` VALUES (114, '20200218053853CB5925B276D54DDEB480753098ACADBA06630918', 26, 1, '2020-02-18 17:38:53', '2020-02-18 17:38:53');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码(md5 随机码)',
  `user_amount` int(11) NULL DEFAULT 0 COMMENT '账户余额(以分为单位)',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册地址：省',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册地址：城市',
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册地址：县/区',
  `create_time` datetime NULL DEFAULT NULL COMMENT '用户录入时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `state` tinyint(4) NULL DEFAULT 1 COMMENT '状态 1 已启用 0 未启用',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (23, 'user', '558554b68bd781c7006d3b7f7a5b0d48', 12035047, '男', '15879270992', '上海市', '上海市', '杨浦区', '2020-01-13 03:31:16', '2009-05-04 01:09:26', 1);
INSERT INTO `t_user` VALUES (24, 'test', '558554b68bd781c7006d3b7f7a5b0d48', 0, '男', '15879270992', '上海市', '上海市', '杨浦区', '2020-01-13 03:33:35', '2020-01-16 14:44:37', 1);
INSERT INTO `t_user` VALUES (26, 'trt', '558554b68bd781c7006d3b7f7a5b0d48', 0, '女', '15879270992', '重庆市', '重庆市', '大渡口区', '2020-01-13 17:26:18', '2020-01-16 16:33:58', 1);
INSERT INTO `t_user` VALUES (27, 'ljy', '4b532ae9526459a770cff9115cc6baf3', 0, '男', '15879270992', '江西省', '九江市', '武宁县', '2020-01-29 20:08:58', '2020-02-15 17:03:13', 1);

-- ----------------------------
-- Table structure for t_user_receive
-- ----------------------------
DROP TABLE IF EXISTS `t_user_receive`;
CREATE TABLE `t_user_receive`  (
  `receive_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人电话',
  `receive_province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址：省',
  `receive_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址：城市',
  `receive_county` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址：县/区',
  `receive_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址：详细地址',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '最后更新时间',
  `isDefault` tinyint(4) NULL DEFAULT 0 COMMENT '默认收货地址标志 0 否 1 是',
  `del_state` tinyint(4) NULL DEFAULT 2 COMMENT '删除状态 1 已删除 2 未删除',
  PRIMARY KEY (`receive_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2589674 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收货表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_receive
-- ----------------------------
INSERT INTO `t_user_receive` VALUES (9, 23, '李哥', '15797923168', '河北省', '唐山市', '丰南区', '阳光小区100栋3单元901室', '2020-02-02 19:56:23', '2020-02-03 15:33:28', 1, 2);
INSERT INTO `t_user_receive` VALUES (10, 23, '李白', '15797923168', '黑龙江省', '伊春市', '五营区', '阳光小区100栋3单元901室', '2020-02-02 20:03:43', '2020-02-10 15:30:31', 0, 2);

SET FOREIGN_KEY_CHECKS = 1;
