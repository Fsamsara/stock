function shopOnlineLoadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		updateUrl : basePath + "/updateShopOnline",
		addUrl : basePath + "/addShopOnline",
		deleteUrl : basePath + "/deleteShopOnline",
		selectUrl : basePath + "/selectShopOnline",
	}
	var search_selector = "#shopOnlineSearch";
	var grid_selector = "#shopOnlineTable";
	var pager_selector = "#shopOnlinePager";

	var editAction = {
		url : modularPath.updateUrl
	};
	var addAction = {
		url : modularPath.addUrl
	};
	var deleteAction = {
		url : modularPath.deleteUrl
	};
	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '序列', '商品编码', '可用库存总量', '门店编码' ];

	var colModel = [ {
		name : 'id',
		index : 'id',
		width : 10,
		sorttype : "string",
		editable : false,
		hidden : true,
		search : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'prodId',
		index : 'prodId',
		width : 90,
		editable : true,
		sorttype : "string",
		editrules : {
			required : true
		}
	}, {
		name : 'onlineStock',
		index : 'onlineStock',
		width : 200,
		editable : true,
		search : false,
		editrules : {
			required : true
		}
	}, {
		name : 'warehId',
		index : 'warehId',
		width : 200,
		editable : true,
		hidden : true,
		search : true,
		editrules : {
			required : true
		},
		searchoptions : {
			searchhidden : true
		}
	} ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		datatype : "local",
		rownumbers : true,
		caption : "门店线上库存列表"
	});

	$(grid_selector).jqGrid('setGridParam', {
		datatype : 'json'
	});

	gridPager(grid_selector, pager_selector, {
		editAction : editAction,
		addAction : addAction,
		deleteAction : deleteAction,
		selectAction : selectAction,
		navbarOptions : {
			edit : false,
			editicon : 'fa-pencil blue',
			add : false,
			addicon : 'fa-plus-circle purple',
			del : false,
			delicon : 'fa-trash-o red',
			search : true,
			searchicon : 'fa-search orange',
			refresh : false,
			refreshicon : 'fa-refresh green',
			view : false,
			viewicon : 'fa-search-plus grey'
		}
	});

};

shopOnlineLoadData();