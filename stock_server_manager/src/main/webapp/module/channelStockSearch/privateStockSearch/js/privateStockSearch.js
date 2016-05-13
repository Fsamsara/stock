//@ sourceURL=privateStockSearch.js
function privateStockLoadData() {

	var basePath = "/" + ump.mvcContextPath;
	var grid_selector = "#privateStockTable";
	var pager_selector = "#privateStockPager";

	var modularPath = {
		selectUrl : basePath + "/selectPrivateStock"
	};

	var selectAction = {
		url : modularPath.selectUrl
	};

	var colNames = [ '预留组织', '商品编码','仓库编码','预留类型','预留量','已分配锁定量','预分配锁定量','最终预留量'];

	var colModel = [{
		name : 'channelCode',
		index : 'channelCode',
		width : 120,
		sorttype : "string",
		editable : false,
		searchrules:{required:true}
	}, {
		name : 'prodId',
		index : 'prodId',
		width : 130,
		sorttype : "string",
		editable : false
	},{
		name : 'warehId',
		index : 'warehId',
		width : 120,
		editable : true,
		sorttype : "string"
	},  {
		name : 'reservedType',
		index : 'reservedType',
		width : 180,
		editable : true,
		sorttype : "string",
		search : false
	},{
		name : 'srcReservedStock',
		index : 'srcReservedStock',
		width : 110,
		editable : true,
		search : false
	} ,{
		name : 'allocatedQty',
		index : 'allocatedQty',
		width : 110,
		editable : true,
		search : false
	},{
		name : 'lockedQty',
		index : 'lockedQty',
		width : 110,
		editable : true,
		search : false
	},{
		name : 'reservedStock',
		index : 'reservedStock',
		width : 110,
		editable : true
	}];

	grid(grid_selector, pager_selector, {
		rownumbers: true,
		multiselect : false,
		datatype:"local",
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		caption : "独占预留查询"
	});

	//重新设置表格的获取数据类型为JSON
	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});

	gridPager(grid_selector, pager_selector, {
		navbarOptions: {add: false, edit:false,del:false,view:false,refresh:false},
		selectAction : selectAction
	});
}
//进入页面后加载主表信息
privateStockLoadData();



