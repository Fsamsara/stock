DROP TABLE stock_wareh_prod ;
CREATE TABLE `stock_wareh_prod` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '非业务主键',
  `wareh_id` varchar(30) NOT NULL COMMENT '仓|店编码',
  `six_prod_id` varchar(6) NOT NULL COMMENT '商品6位码',
  `eight_prod_id` varchar(8) NOT NULL COMMENT ' 商品8位码',
  `prod_id` varchar(11) NOT NULL COMMENT '商品11位码',
  `stk_on_hand` int(11) DEFAULT NULL COMMENT ' 实际库存量',
  `qty_committed` int(11) DEFAULT NULL COMMENT ' 已分配量',
  `free_share_stock` int(11) DEFAULT NULL COMMENT ' 自由量',
  `final_free_share_stock` int(11) DEFAULT NULL COMMENT '最终自由量共享',
  `online_safe_stock` int(11) DEFAULT NULL COMMENT ' 线上安全库存',
  `shop_remail` int(11) DEFAULT NULL COMMENT '门店未日结',
  `shop_dame` int(11) DEFAULT NULL COMMENT '门店污损值',
  `lock_stock` int(11) DEFAULT NULL COMMENT ' 锁定共享量',
  `wms_stock` int(11) DEFAULT NULL COMMENT ' WMS正数锁定量',
  `is_shop` tinyint(4) DEFAULT '0' COMMENT '是否是门店(0否1是)',
  `update_time` datetime NOT NULL COMMENT ' 更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
