//@ sourceURL=shopDamageChangeLogsSearch.js
function shopDamageChangeLogsLoadData() {

	var basePath = "/" + ump.mvcContextPath;
	var grid_selector = "#shopDamageChangeLogsTable";
	var pager_selector = "#shopDamageChangeLogsPager";

	var modularPath = {
		selectUrl : basePath + "/selectShopDamageChangeLogs"
	};

	var selectAction = {
		url : modularPath.selectUrl
	};

	var colNames = [ '仓库编码', '商品编码','污损值', '操作类型','更新人','更新时间','创建人','创建时间'];

	var colModel = [{
		name : 'warehId',
		index : 'warehId',
		width : 100,
		sorttype : "string",
		editable : false,
		searchrules:{required:true}
	}, {
		name : 'prodId',
		index : 'prodId',
		width : 100,
		sorttype : "string",
		editable : false
	},{
		name : 'cellDameStock',
		index : 'cellDameStock',
		width : 80,
		editable : false,
		search : false
	},{
		name : 'dameStockOrderType',
		index : 'dameStockOrderType',
		width : 80,
		editable : false,
		search : false
	},{
		name : 'updateBy',
		index : 'updateBy',
		width : 110,
		editable : false,
		search : false
	},{
		name : 'updateTime',
		index : 'updateTime',
		width : 140,
		editable : false,
		search : false
	},{
		name : 'createBy',
		index : 'createBy',
		width : 110,
		editable : false,
		search : false
	},{
		name : 'createTime',
		index : 'createTime',
		width : 140,
		editable : false,
		search : false
	}];

	grid(grid_selector, pager_selector, {
		rownumbers: true,
		multiselect : false,
		datatype:"local",
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		caption : "门店污次少洗维护日志"
	});

	//重新设置表格的获取数据类型为JSON
	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});

	gridPager(grid_selector, pager_selector, {
		navbarOptions: {add: false, edit:false,del:false,view:false,refresh:false},
		selectAction : selectAction
	});

}
//进入页面后加载主表信息
shopDamageChangeLogsLoadData();



