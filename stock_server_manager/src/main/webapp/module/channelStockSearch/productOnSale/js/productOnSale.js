//@ sourceURL=productOnSaleSearch.js
function productOnSaleLoadData() {

	var basePath = "/" + ump.mvcContextPath;
	var grid_selector = "#productOnSaleTable";
	var pager_selector = "#productOnSalePager";

	var modularPath = {
		selectUrl : basePath + "/selectProductOnSale"
	};

	var selectAction = {
		url : modularPath.selectUrl
	};

	var colNames = [ '渠道编码', '商品编码'];

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
	}];

	grid(grid_selector, pager_selector, {
		rownumbers: true,
		multiselect : false,
		datatype:"local",
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		caption : "在售商品清单查询",
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



