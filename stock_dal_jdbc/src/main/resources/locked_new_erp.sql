select * from (
			 select ROWNUM as idx,tl.* from (
			 SELECT 
			 	BO.CODE WAREH_CODE, 
			 	P.PROD_NUM AS SKU, 
			 	SUM(T.LOCKED_QTY) AS LOCK_NUM
			 FROM BF_PRODUCT P,  
			    	BF_ORG BO, 
			    	SF_WAREH_LOCKED_LST T,
			    	ST_ACTIVITY_WAREH saw
			   WHERE 
			   		P.ID = T.PROD_ID
			     AND T.BF_ORG_ID = BO.ID
			     AND saw.wareh_id = BO.CODE
			     AND saw.DATA_SOURCE = 'NERP'
			     AND T.LOCKED_TYPE IN
			         (SELECT UCSD.UD_LOCKED_TYPE
			            FROM UD_CHANNLE_STOCK_SCOPE UCS
			           INNER JOIN UD_CHANNLE_STOCK_SCOPE_DTL UCSD
			              ON UCSD.UD_CW_ID = UCS.ID
			           WHERE UCS.CHANNLE_SORCE = 'ONLINE'
			             AND UCSD.STATUS = '1'
			             AND UCSD.IS_SYNC_OS = '1'
			             AND (UCSD.ISMONOPOLIZE = 0 or UCSD.ISMONOPOLIZE is null)
			 		)
			   GROUP BY BO.CODE, P.PROD_NUM
   			) tl where ROWNUM<=${end}) tt where tt.idx>${begin}