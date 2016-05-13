//@ sourceURL=shopRemailGrid.js
function shopRemailloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectShopRemail",
	}
	var search_selector = "#shopRemailSearch";
	var grid_selector = "#shopRemailTable";
	var pager_selector = "#shopRemailPager";

	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '序列', '门店编码', '商品编码', '货位编码', '未日结数量', '小票号', '更新时间' ];

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
		name : 'locId',
		index : 'locId',
		width : 50,
		editable : true,
		editrules : {
			required : true
		}
	}, {
		name : 'remailStock',
		index : 'remailStock',
		width : 100,
		editable : true,
		editrules : {
			required : true
		}
	}, {
		name : 'rllNum',
		index : 'rllNum',
		width : 100,
		editable : true,
		editrules : {
			required : true
		}
	}, {
		name : 'updateTime',
		index : 'updateTime',
		width : 100,
		editable : true,
		search : false
	},

	];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		datatype : "local",
		caption : "门店未日结小票查询",
		rownumbers: true,
	});

	// 重新设置表格的获取数据类型为JSON
	$(grid_selector).jqGrid('setGridParam', {
		datatype : 'json'
	});

	gridPager(grid_selector, pager_selector, {
		navbarOptions : {
			add : false,
			edit : false,
			del : false,
			view : false,
			refresh : false
		},
		selectAction : selectAction
	});

}

shopRemailloadData();
