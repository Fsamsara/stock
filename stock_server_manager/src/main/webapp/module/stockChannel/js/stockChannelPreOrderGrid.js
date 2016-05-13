function stockChannelPreOrderloadData() {
	
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectStockChannelPreOrders"
	};
	
	var grid_selector = "#stockChannelPreOrderTable";
	var pager_selector = "#stockChannelPreOrderPager";
	
	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '渠道编码', '商品编码', '最终推送库存', '推送状态','更新人','平台接收时间','更新时间' ];

	var colModel = [ {
		name : 'channelCode',
		index : 'channelCode',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'prodId',
		index : 'prodId',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'stockSended',
		index : 'stockSended',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : false,
		search : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'status',
		index : 'status',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : false,
		search : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'updateBy',
		index : 'updateBy',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : false,
		search : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'accTime',
		index : 'accTime',
		width : 90,
		sorttype : "string",
		editable : false,
		hidden : false,
		search : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'updateTime',
		index : 'updateTime',
		width : 90,
		sorttype : "string",
		editable : false,
		hidden : false,
		search : false,
		editoptions : {
			readonly : true
		}
	} ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		caption : "渠道预售库存列表",
		datatype:"local",
		rownumbers: true,
		multiselect : false
	});
	gridPager(grid_selector, pager_selector, {
		navbarOptions : {
			edit : false,
			editicon : 'fa-pencil blue',
			add : false,
			addicon : 'fa-plus-circle purple',
			del : false,
			delicon : 'fa-trash-o red',
			search : true,
			searchicon : 'fa-search orange',
			refresh : true,
			refreshicon : 'fa-refresh green',
			view : false,
			viewicon : 'fa-search-plus grey'
		},
		selectAction : selectAction
	});
};

stockChannelPreOrderloadData();