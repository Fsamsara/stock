function warehFreeloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/qryWarehFreeShareStock"
	}
	var search_selector = "#warehFreeSearch";
	var grid_selector = "#warehFreeTable";
	var pager_selector = "#warehFreePager";

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		datatype:"local",
		multiselect:false,
		colNames : [ '仓库编码', '商品编码', '自由量', ' 实际库存量', ' 已分配量', ' 线上安全库存', ' 锁定共享量', ' WMS正数锁定量' ],
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
			width : 150,
			editable : true,
			sorttype : "string",
			editrules : {
				required : true
			}
		}, {
			name : 'finalFreeShareStock',
			index : 'finalFreeShareStock',
			width : 150,
			editable : true,
			search : false
		}, {
			name : 'stkOnHand',
			index : 'stkOnHand',
			width : 150,
			editable : true,
			search : false
		}, {
			name : 'qtyCommitted',
			index : 'qtyCommitted',
			width : 150,
			editable : true,
			search : false
		}, {
			name : 'onlineSafeStock',
			index : 'onlineSafeStock',
			width : 150,
			editable : true,
			search : false
		}, {
			name : 'lockStock',
			index : 'lockStock',
			width : 150,
			editable : true,
			search : false
		}, {
			name : 'wmsStock',
			index : 'wmsStock',
			width : 150,
			editable : true,
			search : false
		} ],
		rownumbers: true,
		caption : "仓库自由量查询"
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

warehFreeloadData();