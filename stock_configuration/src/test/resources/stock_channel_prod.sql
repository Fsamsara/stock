CREATE TABLE `stock_channel_prod` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '非业务主键',
  `channel_code` varchar(30) NOT NULL COMMENT ' 渠道编码',
  `prod_id` varchar(11) DEFAULT NULL COMMENT '11位码',
  `private_stock` int(11) DEFAULT '0' COMMENT '实物预留独占',
  `final_free_stock` int(11) DEFAULT '0' COMMENT '最终自由量共享',
  `lock_stock` int(11) DEFAULT '0' COMMENT '锁定共享量',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
