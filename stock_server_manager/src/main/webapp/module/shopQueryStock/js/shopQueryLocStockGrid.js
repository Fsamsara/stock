//@ sourceURL=shopQueryLocStockGrid.js
function shopQueryLocStockloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectShopQueryLocStock",
	}
	var search_selector = "#shopQueryLocStockSearch";
	var grid_selector = "#shopQueryLocStockTable";
	var pager_selector = "#shopQueryLocStockPager";

	
	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [  '门店编码', '货位编码', '商品编码', '实际库存' ];

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
		name : 'locId',
		index : 'locId',
		width : 150,
		editable : true,
		editrules : {
			required : true
		}
	},{
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
		datatype:"local",
		multiselect:false,
		rownumbers: true,
		colNames : colNames,
		colModel : colModel,
		caption : "门店货位库存查询"
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

	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});
}

shopQueryLocStockloadData();
