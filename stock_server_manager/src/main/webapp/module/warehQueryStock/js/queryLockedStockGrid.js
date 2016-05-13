//@ sourceURL=queryLockedStockGrid.js
function queryLockedStockloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectQueryLockedStock",
	}
	var search_selector = "#queryLockedStockSearch";
	var grid_selector = "#queryLockedStockTable";
	var pager_selector = "#queryLockedStockPager";

	
	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [  '仓库编码', '预留类型', '商品编码', '锁定量' ];

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
		name : 'reservedType',
		index : 'reservedType',
		width : 150,
		editable : true,
		editrules : {
			required : true
		},
		searchrules:{required:true}
	},{
		name : 'prodId',
		index : 'prodId',
		width : 90,
		editable : true,
		sorttype : "string",
		editrules : {
			required : true
		}
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
		caption : "仓库锁定库存查询"
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

queryLockedStockloadData();
