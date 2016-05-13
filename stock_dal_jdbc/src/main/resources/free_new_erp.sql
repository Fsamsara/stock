select * from (
		select ROWNUM as idx,tl.* from (
		select
		o.code as WAREH_CODE,
		p.prod_num as SKU,
		saw.is_shop as IS_SHOP,
		SWP.stk_on_hand as STK_ON_HAND,
		  NVL(SWP.QTY_COMMITTED,0) AS COMMITTED_NUM,
					UWP.ONLINE_SAFEQTY_TYPE AS SAFEQTY_TYPE,
					UWP.SAFETY_STOCK AS SAFETY_STOCK,
					UWP.USED_MA AS USED_MA,
					NVL(SWP.STK_ON_HAND, 0) - (CASE WHEN NVL(SWP.QTY_COMMITTED,0) < 0 THEN 0 ELSE NVL(SWP.QTY_COMMITTED,0) END) 			
				                 - (CASE WHEN NVL(SWP.QTY_ON_LOCK,0) < 0 THEN 0 ELSE NVL(SWP.QTY_ON_LOCK,0) END)
				                 - (CASE WHEN NVL(SWP.LOCKED_QTY,0) < 0 THEN 0 ELSE NVL(SWP.LOCKED_QTY,0) END)
				                 - (CASE WHEN NVL(SWP.B2B_LOCKED_QTY,0) < 0 THEN 0 ELSE NVL(SWP.B2B_LOCKED_QTY,0) END) AS FREE_NUM
				from sf_wareh_prod SWP
				LEFT join bf_product p on SWP.bf_product_id=p.id
				LEFT join bf_org o on o.id=SWP.bf_org_id
				LEFT join ST_ACTIVITY_WAREH saw on saw.wareh_id=o.code
				LEFT join UD_WAREH_PARAM UWP ON UWP.BF_ORG_ID=SWP.BF_ORG_ID
		where saw.data_source='NERP' ) tl  where ROWNUM<=${end}) tt where tt.idx>${begin}