/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云-youyou 数据库
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : rds8a08c30s41zzv710xo.mysql.rds.aliyuncs.com:3306
 Source Schema         : youyou

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 18/08/2017 13:00:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for approve_type
-- ----------------------------
CREATE TABLE `approve_type` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `name` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '审批结果',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='审批结果类型表';

-- ----------------------------
-- Records of approve_type
-- ----------------------------
BEGIN;
INSERT INTO `approve_type` VALUES ('1010', '未提交资料');
INSERT INTO `approve_type` VALUES ('0000', '通过');
INSERT INTO `approve_type` VALUES ('1000', '未通过');
INSERT INTO `approve_type` VALUES ('1011', '提交资料不全');
INSERT INTO `approve_type` VALUES ('1020', '资料不符');
COMMIT;

-- ----------------------------
-- Table structure for business_log
-- ----------------------------
CREATE TABLE `business_log` (
  `id` varchar(40) CHARACTER SET utf8 NOT NULL,
  `operator` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `clazz` varchar(255) CHARACTER SET utf8 NOT NULL,
  `method` varchar(255) CHARACTER SET utf8 NOT NULL,
  `method_description` varchar(255) CHARACTER SET utf8 NOT NULL,
  `success` tinyint(4) NOT NULL COMMENT '方法是否成功运行',
  `exception_string` text COLLATE utf8_bin COMMENT '方法运行出错，抛出的exception堆栈转换成的string',
  `args` text CHARACTER SET utf8 NOT NULL,
  `remote_ip` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `client_os` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `client_browser` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `browser_version` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `client_device_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='业务方法调用日志';

-- ----------------------------
-- Table structure for living_type
-- ----------------------------
CREATE TABLE `living_type` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '主键 ID',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '居住类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of living_type
-- ----------------------------
BEGIN;
INSERT INTO `living_type` VALUES ('0001', '自住');
INSERT INTO `living_type` VALUES ('0020', '租赁');
COMMIT;

-- ----------------------------
-- Table structure for parking_info
-- ----------------------------
CREATE TABLE `parking_info` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '主键 ID',
  `building_no` varchar(4) COLLATE utf8_bin NOT NULL COMMENT '楼号',
  `room_no` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '房间号',
  `property_cert` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '房产证编号',
  `property_cert_register_at` date DEFAULT NULL COMMENT '房产证办理日期',
  `property_owner` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋所属人',
  `property_owner_cid` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋所有人身份证号',
  `driving_license_no` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '行驶证号',
  `driving_license_register_at` date DEFAULT NULL COMMENT '行驶证登记日期',
  `driving_license_owner` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '行驶证所有人',
  `car_no` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '车牌号',
  `parking_no` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '停车位号',
  `parking_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '停车位类型',
  `living_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '居住类型',
  `comment` text COLLATE utf8_bin COMMENT '备注',
  `approve_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '审批结果',
  `register_date` date NOT NULL COMMENT '车位资料登记时间',
  `created_by` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '录入人员',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `updated_by` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `living_type_fk` (`living_type`),
  KEY `parking_type_fk` (`parking_type`),
  KEY `approve_type_fk` (`approve_type`) USING BTREE,
  CONSTRAINT `approve_type_fk` FOREIGN KEY (`approve_type`) REFERENCES `approve_type` (`id`),
  CONSTRAINT `living_type_fk` FOREIGN KEY (`living_type`) REFERENCES `living_type` (`id`),
  CONSTRAINT `parking_type_fk` FOREIGN KEY (`parking_type`) REFERENCES `parking_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for parking_type
-- ----------------------------
CREATE TABLE `parking_type` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '主键 id',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '停车位类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of parking_type
-- ----------------------------
BEGIN;
INSERT INTO `parking_type` VALUES ('0010', '小区地下');
INSERT INTO `parking_type` VALUES ('0011', '小区地面');
INSERT INTO `parking_type` VALUES ('0020', '街坊路');
INSERT INTO `parking_type` VALUES ('0030', '康师傅地下');
COMMIT;


CREATE TABLE `user` (
  `name` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `passwd` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
