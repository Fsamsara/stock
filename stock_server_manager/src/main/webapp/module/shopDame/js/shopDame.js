function shopDameloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		updateUrl : basePath + "/updateShopDame",
		addUrl : basePath + "/addShopDame",
		deleteUrl : basePath + "/deleteShopDame",
		selectUrl : basePath + "/selectShopDame",
		fileUploadUrl : basePath + "/fileUploadShopDame",
	}
	var search_selector = "#shopDameSearch";
	var grid_selector = "#shopDameTable";
	var pager_selector = "#shopDamePager";

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
	var colNames = [ '序列', '门店编码', '商品编码', '污损值', '更新人', '更新时间', '创建时间' ];

	var colModel = [ {
		name : 'id',
		index : 'id',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : true,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'warehId',
		index : 'warehId',
		width : 150,
		editable : true,
		editrules : {
			required : true
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
		name : 'dameStock',
		index : 'dameStock',
		width : 100,
		editable : true,
		search : false
	}, {
		name : 'updateBy',
		index : 'updateBy',
		width : 100,
		editable : true,
		search : false
	}, {
		name : 'updateTime',
		index : 'updateTime',
		width : 100,
		editable : true,
		search : false
	}, {
		name : 'createTime',
		index : 'createTime',
		width : 100,
		editable : true,
		search : false
	} ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : true,
		datatype : "local",
		rownumbers : true,
		multiselect : false,
		caption : "门店污损值列表"
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
}

shopDameloadData();
