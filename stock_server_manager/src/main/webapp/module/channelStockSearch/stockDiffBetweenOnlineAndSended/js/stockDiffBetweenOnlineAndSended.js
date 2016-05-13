//@ sourceURL=productOnSaleSearch.js
function productOnSaleLoadData() {

	var basePath = "/" + ump.mvcContextPath;
	var grid_selector = "#stockDiffBetweenOnlineAndSendedTable";
	var pager_selector = "#stockDiffBetweenOnlineAndSendedPager";

	var modularPath = {
		selectUrl : basePath + "/selectStockDiffBetweenOnlineAndSended"
	};

	var selectAction = {
		url : modularPath.selectUrl
	};

	var colNames = [ '渠道编码', '商品编码','线上库存', '本地库存'];

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
		editable : false,
		search : false
	},{
		name : 'onlineStock',
		index : 'onlineStock',
		width : 110,
		editable : false,
		search : false
	},{
		name : 'finalFreeStock',
		index : 'finalFreeStock',
		width : 110,
		editable : false,
		search : false
	}];

	grid(grid_selector, pager_selector, {
		//rownumbers: true,
		multiselect : false,
		datatype:"local",
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		caption : "渠道库存与推送库存差异查询",
		rowNum : 100000000,
		rowList : [],
		gridComplete : function (){
			var recodeNumTitle = $(".ui-paging-info",pager_selector).html();
			$(".ui-paging-info",pager_selector).html("");
		}
	});

	//重新设置表格的获取数据类型为JSON
	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});

	gridPager(grid_selector, pager_selector, {
		navbarOptions: {add: false, edit:false,del:false,view:false,refresh:false},
		selectAction : selectAction
	});

}
//进入页面后加载主表信息
productOnSaleLoadData();



