//@ sourceURL=shopSafeGrid.js
function shopSafeloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectShopSafe",
	}
	var search_selector = "#shopSafeSearch";
	var grid_selector = "#shopSafeTable";
	var pager_selector = "#shopSafePager";

	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '序列', '门店编码', '商品编码', '安全库存', '更新时间' ];

	var colModel = [ {
		name : 'id',
		index : 'id',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : true,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'warehId',
		index : 'warehId',
		width : 150,
		editable : true,
		editrules : {
			required : true
		}
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
		width : 100,
		editable : true,
		search : false
	}, {
		name : 'updateTime',
		index : 'updateTime',
		width : 100,
		editable : true,
		search : false
	}, ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		datatype : "local",
		caption : "门店安全库存明细",
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

shopSafeloadData();
