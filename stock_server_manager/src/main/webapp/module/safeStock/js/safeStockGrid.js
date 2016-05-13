function safeStockloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/querySafeStock"
	}
	var search_selector = "#safeStockSearch";
	var grid_selector = "#safeStockTable";
	var pager_selector = "#safeStockPager";

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		datatype:"local",
		rownumbers: true,
		multiselect:false,
		colNames : [ '仓库编码', '商品编码', '安全库存值' ],
		colModel : [ {
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
			}
		}, {
			name : 'safeStock',
			index : 'safeStock',
			width : 250,
			editable : true,
			search : false
		} ],
		caption : "仓库安全库存"
	});
	gridPager(grid_selector, pager_selector, {
		navbarOptions : {
			add : false,
			edit : false,
			del : false,
			view : false,
			refresh : false
		}
	});
	
	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});
};

safeStockloadData();