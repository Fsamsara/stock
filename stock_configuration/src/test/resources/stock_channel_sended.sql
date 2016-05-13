CREATE TABLE `stock_channel_sended` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '非业务ID',
  `prod_id` varchar(11) NOT NULL COMMENT '商品码',
  `channel_code` varchar(30) NOT NULL COMMENT ' 渠道编码',
  `stock_sended` int(11) NOT NULL COMMENT ' 最终推送库存',
  `status` varchar(30) DEFAULT NULL COMMENT '推送状态',
  `acc_time` datetime NOT NULL COMMENT '平台接受时间（渠道回写）',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
