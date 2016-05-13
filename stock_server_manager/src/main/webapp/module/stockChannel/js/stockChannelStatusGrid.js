function stockChannelStatusloadData() {
	
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectPageStockChannelStatus"
	};
	
	var grid_selector = "#stockChannelStatusTable";
	var pager_selector = "#stockChannelStatusPager";
	
	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '渠道编码', '商品6位编码', '上下售罄状态', '是否同步平台','创建时间','更新时间' ];

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
		name : 'sixProdId',
		index : 'sixProdId',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'saleStatus',
		index : 'saleStatus',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'isSync',
		index : 'isSync',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'createTime',
		index : 'createTime',
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
		caption : "渠道商品状态查询",
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

stockChannelStatusloadData();