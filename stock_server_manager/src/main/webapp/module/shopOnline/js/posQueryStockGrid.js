//@ sourceURL=posQueryStockGrid.js
function posQueryStockloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectPosQueryStock",
	}
	var search_selector = "#posQueryStockSearch";
	var grid_selector = "#posQueryStockTable";
	var pager_selector = "#posQueryStockPager";

	
	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [  '渠道来源', '渠道编码', '省份', '城市', '地区', '过滤仓', '组织类型', '组织编码', '商品编码', '可用库存' ];

	var colModel = [ {
		name : 'channelSource',
		index : 'channelSource',
		width : 1,
		hidden:true,
		searchoptions : {searchhidden : true, value:"ONLINE:线上;OFFLINE:线下", defaultValue : "ONLINE"},
		search : true,
		stype : 'select'
	}, {
		name : 'channelCode',
		index : 'channelCode',
		width : 1,
		hidden : true,
		searchoptions : {searchhidden : true},
		search : true,
		searchrules:{required:true}
	}, {
		name : 'province',
		index : 'province',
		width : 1,
		hidden : true,
		searchoptions : {searchhidden : true},
		search : true
	}, {
		name : 'city',
		index : 'city',
		width : 1,
		hidden : true,
		searchoptions : {searchhidden : true},
		search : true
	}, {
		name : 'district',
		index : 'district',
		width : 1,
		hidden : true,
		searchoptions : {searchhidden : true},
		search : true
	}, {
		name : 'extWarehShop',
		index : 'extWarehShop',
		width : 1,
		hidden : true,
		searchoptions : {searchhidden : true},
		search : true
	}, {
		name : 'warehShopType',
		index : 'warehShopType',
		width : 150,
		editable : true,
		editrules : {
			required : true
		},
		search : false
	}, {
		name : 'warehShopId',
		index : 'warehShopId',
		width : 150,
		editable : true,
		editrules : {
			required : true
		},
		search : false
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
		name : 'usefulStock',
		index : 'usefulStock',
		width : 100,
		editable : true,
		search : false,
		sorttype:"float", 
		formatter:"number", 
		summaryType:'sum'
	},
	];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		datatype:"local",
		rownumbers: true,
		multiselect:false,
		colNames : colNames,
		colModel : colModel,
		footerrow:true,             //加这个标识
		caption : "POS全流通库存查询",
		gridComplete : function (){
			$(".ui-paging-info",pager_selector).html("");
			$("#posQueryStockPager_center .ui-pg-table",pager_selector).html("");
			
			var rowNum=parseInt($(this).getGridParam("records"),10);
            if(rowNum>0){
                $(".ui-jqgrid-sdiv").show();
                var usefulStocksum=$(this).getCol("usefulStock",false,"sum");//"总可用库存:"+
                $(this).footerData("set",{"usefulStock":usefulStocksum}); //将合计值显示出来
            }else{
                $(".ui-jqgrid-sdiv").hide();
            }
		}
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

posQueryStockloadData();
