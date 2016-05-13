//@sourceURL=stActivityWarehGrid.js
function stActivityWarehloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectStActivityWareh",
	}
	var search_selector = "#stActivityWarehSearch";
	var grid_selector = "#stActivityWarehTable";
	var pager_selector = "#stActivityWarehPager";

	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '仓库编码', '是否门店', '库存来源', '更新时间' ];

	var colModel = [ {
		name : 'warehId',
		index : 'warehId',
		width : 150,
		editable : false,
		editrules : {
			required : true
		}
	}, {
		name : 'isShop',
		index : 'isShop',
		width : 50,
		editable : false,
		sorttype : "string",
		search : true,
		formatter : "select",
		editoptions : {
			value : "1:是;0:否"
		},
		stype : "select",
		searchoptions : {
			searchhidden : true,
			value : "1:是;0:否",
			defaultValue : "1"
		},
	}, {
		name : 'dataSource',
		index : 'dataSource',
		width : 100,
		editable : false,
		sorttype : "string",
		search : true,
		formatter : "select",
		editoptions : {
			value : "OERP:老ERP;NERP:新ERP;VERP:门户"
		},
		stype : "select",
		searchoptions : {
			searchhidden : true,
			value : "OERP:老ERP;NERP:新ERP;VERP:门户",
			defaultValue : "OERP"
		}
	}, {
		name : 'updateTime',
		index : 'updateTime',
		width : 100,
		editable : false,
		search : false
	}, ];

	
	
	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		
		caption : "配发组织查询",
		rownumbers: true,
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

stActivityWarehloadData();
