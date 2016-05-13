//@ sourceURL=shopQueryStockGrid.js
function shopQueryStockloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectShopQueryStock",
	}
	var search_selector = "#shopQueryStockSearch";
	var grid_selector = "#shopQueryStockTable";
	var pager_selector = "#shopQueryStockPager";

	
	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [  '门店编码', '商品编码', '实际库存' ];

	var colModel = [ {
		name : 'warehId',
		index : 'warehId',
		width : 150,
		editable : true,
		editrules : {
			required : true
		},
		searchrules:{required:true}
	}, {
		name : 'prodId',
		index : 'prodId',
		width : 90,
		editable : true,
		sorttype : "string",
		editrules : {
			required : true
		},
		searchrules:{required:true}
	}, {
		name : 'stock',
		index : 'stock',
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
		caption : "门店实际库存查询",
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

shopQueryStockloadData();
