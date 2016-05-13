select count(1) from(
			SELECT 
				1
			  FROM WAREH_LOCKED_LST WL,
			   	   ST_ACTIVITY_WAREH saw
			 WHERE
				 saw.wareh_id=WL.WAREH_ID
				 and  saw.data_source='OERP'
				  and 
				  LOCKED_TYPE IN
				       (SELECT UCSD.UD_LOCKED_TYPE
				          FROM UD_CHANNLE_STOCK_SCOPE UCS
				         INNER JOIN UD_CHANNLE_STOCK_SCOPE_DTL UCSD
				            ON UCSD.UD_CW_ID = UCS.ID
				         WHERE UCS.CHANNLE_SORCE = 'ONLINE'
				           AND UCSD.STATUS = '1'
				           AND UCSD.IS_SYNC_OS = '1'
				           AND (UCSD.ISMONOPOLIZE = 0 or UCSD.ISMONOPOLIZE is null))
				 GROUP BY WL.WAREH_ID, WL.PROD_ID)t