select
		count(1)
		from sf_wareh_prod SWP
				inner join bf_product p on SWP.bf_product_id=p.id
				LEFT join bf_org o on o.id=SWP.bf_org_id
				LEFT join ST_ACTIVITY_WAREH saw on saw.wareh_id=o.code
				LEFT join UD_WAREH_PARAM UWP ON UWP.BF_ORG_ID=SWP.BF_ORG_ID
				where 
					saw.data_source='NERP' 