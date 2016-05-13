CREATE TABLE `stock_channel_prod_sub` (
  `id` int(11) NOT NULL COMMENT ' 非业务id',
  `channel_code` varchar(30) NOT NULL COMMENT ' 渠道编码',
  `six_prod_id` varchar(6) DEFAULT NULL COMMENT '商品6位码',
  `eight_prod_id` varchar(8) DEFAULT NULL COMMENT ' 商品8位码',
  `prod_id` varchar(11) DEFAULT NULL COMMENT '商品11位码',
  `order_private_total_stock` int(11) DEFAULT NULL COMMENT '实物独占预占量总量',
  `order_share_total_stock` int(11) DEFAULT NULL COMMENT ' 实物共享预占量总量',
  `pre_private_stock` int(11) DEFAULT NULL COMMENT '     预售量',
  `pre_order_total_stock` int(11) DEFAULT NULL COMMENT ' 预售预占量总量',
  `is_pre` tinyint(4) DEFAULT '0' COMMENT '是否预售(0否，1是)',
  `update_time` datetime NOT NULL COMMENT ' 更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
