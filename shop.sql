CREATE TABLE `t_admin` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL  COMMENT '密码',
  `gmt_create` datetime DEFAULT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT '管理员';

CREATE TABLE `t_announcement` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT  COMMENT 'id',
  `content` varchar(255) DEFAULT NULL  COMMENT '内容',
  `is_deleted` tinyint DEFAULT 1 COMMENT '是否删除',
  `gmt_create` datetime DEFAULT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '公告';

CREATE TABLE `t_news` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id' ,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `is_deleted` tinyint DEFAULT 1 COMMENT '是否删除',
  `gmt_create` datetime DEFAULT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT '新闻';

CREATE TABLE `t_product` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) DEFAULT NULL COMMENT '商品标题',
  `code` varchar(255) DEFAULT NULL COMMENT '商品码',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `note` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `price` int(11) DEFAULT NULL COMMENT '价格',
  `stock` bigint(20) DEFAULT NULL COMMENT '库存',
  `is_deleted` tinyint DEFAULT 1 COMMENT '是否删除',
  `gmt_create` datetime DEFAULT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT '商品';

CREATE TABLE `t_producttype` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '类别名称',
  `is_deleted` tinyint DEFAULT 1 COMMENT '是否删除',
  `gmt_create` datetime DEFAULT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT '商品类别';

CREATE TABLE `t_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(255) DEFAULT NULL COMMENT '余额',
  `address` varchar(50) DEFAULT NULL COMMENT '收货地址',
  `password` varchar(14) NOT NULL COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `point` int(11) DEFAULT NULL COMMENT '积分值',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `tel_phone` varchar(11) DEFAULT NULL COMMENT '座机',
  `username` varchar(15) DEFAULT NULL COMMENT '用户名',
  `zip_code` varchar(6) DEFAULT NULL COMMENT '邮编',
  `is_deleted` tinyint DEFAULT 1 COMMENT '是否删除',
  `gmt_create` datetime DEFAULT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT '用户';

CREATE TABLE `t_useraddress` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `address` varchar(255) DEFAULT NULL  COMMENT '地址',
  `consignee` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(255) DEFAULT NULL  COMMENT '收货电话',
  `zipcode` varchar(255) DEFAULT NULL COMMENT '邮编',
  `user_id` bigint unsigned DEFAULT NULL COMMENT '用户id',
  `is_deleted` tinyint DEFAULT 1 COMMENT '是否删除',
  `gmt_create` datetime DEFAULT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '地址';

CREATE TABLE `t_order` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_number` varchar(255) DEFAULT NULL COMMENT 'id',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `user_id` bigint unsigned DEFAULT NULL  COMMENT '购买人id',
  `user_address` bigint unsigned DEFAULT NULL  COMMENT '收货地址',
  `is_deleted` tinyint DEFAULT 1 COMMENT '是否删除',
  `gmt_create` datetime DEFAULT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_address`) REFERENCES `t_useraddress` (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '订单';

CREATE TABLE `t_orderitem` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `order_id` bigint unsigned) DEFAULT NULL COMMENT '订单id',
  `product` bigint unsigned DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product`) REFERENCES `t_product` (`id`),
  FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '订单关联';