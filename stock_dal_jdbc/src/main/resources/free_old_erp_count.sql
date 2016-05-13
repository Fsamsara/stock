SELECT 
				count(1)
			from 
				wareh_prod SWP
				LEFT JOIN ST_ACTIVITY_WAREH saw on saw.wareh_id = swp.wareh_id
				LEFT JOIN bf_org o on o.CODE=SWP.WAREH_ID
				LEFT JOIN UD_WAREH_PARAM UWP ON UWP.BF_ORG_ID=o.id
			 where  SAW.DATA_SOURCE='OERP'