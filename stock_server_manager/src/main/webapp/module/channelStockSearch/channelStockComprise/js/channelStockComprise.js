//@ sourceURL=channelStockCompriseSearch.js
function channelStockCompriseDataLoad() {

	var basePath = "/" + ump.mvcContextPath;
	var grid_selector = "#channelStockCompriseTable";
	var pager_selector = "#channelStockComprisePager";

	var modularPath = {
		selectUrl : basePath + "/selectChannelStockComprise"
	};

	var selectAction = {
		url : modularPath.selectUrl
	};

	var colNames = [ '渠道编码','渠道名称','仓库编码', '商品编码','自由量', '锁定量','预留量','店群预留量'];

	var colModel = [{
		name : 'channelCode',
		index : 'channelCode',
		width : 100,
		sorttype : "string",
		editable : false,
		searchrules:{required:true}
	}, {
		name : 'channelName',
		index : 'channelName',
		width : 250,
		sorttype : "string",
		editable : false,
		search:false
	}, {
		name : 'warehId',
		index : 'warehId',
		width : 100,
		sorttype : "string",
		editable : false,
		search:false
	},{
		name : 'prodId',
		index : 'prodId',
		width : 100,
		sorttype : "string",
		editable : false,
		searchrules:{required:true}
	},{
		name : 'finalFreeStock',
		index : 'finalFreeStock',
		width : 80,
		editable : false,
		search : false
	},{
		name : 'lockStock',
		index : 'lockStock',
		width : 80,
		editable : false,
		search : false
	},{
		name : 'privateStock',
		index : 'privateStock',
		width : 80,
		editable : false,
		search : false
	},{
		name : 'shopGroupStock',
		index : 'shopGroupStock',
		width : 80,
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
		caption : "渠道库存分部情况",
	});

	//重新设置表格的获取数据类型为JSON
	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});

	gridPager(grid_selector, pager_selector, {
		navbarOptions: {add: false, edit:false,del:false,view:false,refresh:false},
		selectAction : selectAction
	});

}
//进入页面后加载主表信息
channelStockCompriseDataLoad();



