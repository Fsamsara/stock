DROP TABLE tmp_stock_wareh_prod ;
CREATE TABLE `tmp_stock_wareh_prod` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '非业务主键',
  `wareh_id` varchar(30) NOT NULL COMMENT '仓|店ID',
  `prod_id` varchar(11) NOT NULL COMMENT '商品11位码',
  `stk_on_hand` int(11) DEFAULT NULL COMMENT '实际库存量',
  `qty_committed` int(11) DEFAULT NULL COMMENT ' 已分配量',
  `free_share_stock` int(11) DEFAULT NULL COMMENT '自由量',
  `lock_stock` int(11) DEFAULT NULL COMMENT '锁定共享量',
  `safe_stock` int(11) DEFAULT NULL COMMENT '线上安全库存',
  `is_shop` int(4) NOT NULL DEFAULT '0' COMMENT '是否是门店(0否,1是,默认为0)',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8