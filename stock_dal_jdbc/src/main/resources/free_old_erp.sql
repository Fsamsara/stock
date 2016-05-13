select * from (
		 select ROWNUM as idx,tl.* from (
			SELECT 
				SWP.wareh_id as WAREH_CODE, 
				SWP.prod_id as SKU, 
				SWP.stk_on_hand as STK_ON_HAND,
				saw.is_shop as IS_SHOP,
				NVL(SWP.QTY_COMMITTED,0)  AS COMMITTED_NUM,
					UWP.ONLINE_SAFEQTY_TYPE AS SAFEQTY_TYPE,
					UWP.SAFETY_STOCK AS SAFETY_STOCK,
					UWP.USED_MA AS USED_MA,
					(NVL(SWP.STK_ON_HAND, 0)
					 - (CASE WHEN NVL(SWP.QTY_COMMITTED, 0) < 0 THEN 0 ELSE NVL(SWP.QTY_COMMITTED, 0) END)
					 - (CASE WHEN NVL(SWP.LOCKED_QTY, 0) < 0 THEN 0 ELSE NVL(SWP.LOCKED_QTY, 0) END)
					 - (CASE WHEN NVL(SWP.QTY_FUC_COMM, 0) < 0 THEN 0 ELSE NVL(SWP.QTY_FUC_COMM, 0) END)
					 - (CASE WHEN NVL(SWP.QTY_CUR_COMM, 0) < 0 THEN 0 ELSE NVL(SWP.QTY_CUR_COMM, 0) END)
					 - (CASE WHEN NVL(SWP.BGR_STK, 0) < 0 THEN 0 ELSE NVL(SWP.BGR_STK, 0) END)) AS FREE_NUM
			from
				wareh_prod SWP 
				LEFT JOIN ST_ACTIVITY_WAREH saw on saw.wareh_id = swp.wareh_id
				LEFT JOIN bf_org o on o.CODE=SWP.WAREH_ID
				LEFT JOIN UD_WAREH_PARAM UWP ON UWP.BF_ORG_ID=o.id
			 where  SAW.DATA_SOURCE='OERP'
		 ) tl where ROWNUM<=${end}) tt where tt.idx>${begin}