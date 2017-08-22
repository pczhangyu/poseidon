--用户管理相关表

--账户表
CREATE TABLE `b2c_account` (
  `account_id` varchar(31) NOT NULL COMMENT '用户id',
  `username` varchar(127) NOT NULL COMMENT '用户账户',
  `password` varchar(127) NOT NULL COMMENT '用户密码',
  `account_level` tinyint(11) NOT NULL COMMENT '用户昵称',
  `create_time` bigint(30) NOT NULL COMMENT '创建时间',
  `account_type` varchar(255) NOT NULL COMMENT '用户账户类型',
  `disabled` enum('false','true') NOT NULL DEFAULT 'false' COMMENT '是否失效',
  PRIMARY KEY (`account_id`),
  KEY `b2c_account_type` (`account_type`) USING BTREE COMMENT '账户类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--账户登录记录
CREATE TABLE `b2c_login_record` (
  `id` varchar(31) NOT NULL COMMENT '记录id',
  `account_id` varchar(31) NOT NULL COMMENT '登陆账户id',
  `account_type` tinyint(11) NOT NULL COMMENT '账户类型',
  `username` varchar(127) NOT NULL COMMENT '用户账户',
  `login_time` bigint(30) NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`),
  KEY `b2c_login_record_account_id` (`account_id`) USING BTREE COMMENT '账户id',
  KEY `b2c_login_record_account_type` (`account_type`) USING BTREE COMMENT '账户类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--用户信息
CREATE TABLE `b2c_member` (
  `member_id` varchar(31) NOT NULL COMMENT '用户id',
  `nick_name` varchar(127) NOT NULL COMMENT '昵称',
  `mobile` varchar(127) NOT NULL COMMENT '电话',
  `real_name` varchar(127) NOT NULL COMMENT '真实姓名',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件地址',
  `id_card` varchar(127) DEFAULT NULL COMMENT '身份证',
  `gender` enum('male','female') DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





