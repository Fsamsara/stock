function shopFreeloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/qryShopFreeShareStock"
	}
	var search_selector = "#shopFreeSearch";
	var grid_selector = "#shopFreeTable";
	var pager_selector = "#shopFreePager";

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		datatype:"local",
		multiselect:false,
		colNames : [ '门店编码', '商品编码', '自由量', ' 实际库存量', ' 已分配量', ' 线上安全库存', ' 门店未日结', ' 门店污损值' ],
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
			name : 'shopRemail',
			index : 'shopRemail',
			width : 150,
			editable : true,
			search : false
		}, {
			name : 'shopDame',
			index : 'shopDame',
			width : 150,
			editable : true,
			search : false
		} ],
		rownumbers: true,
		caption : "门店自由量查询"
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

shopFreeloadData();