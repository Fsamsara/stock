//@ sourceURL=popPreSaleGrid.js
function popPreSaleloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectPreSale?status=1"
	};
	var search_selector = "#popPreSaleSearch";
	var grid_selector = "#popPreSaleTable";
	var pager_selector = "#popPreSalePager";

	var selectAction = {
		url : modularPath.selectUrl
	};

	var colNames = [ '预售单号', '渠道','预售名称','创建时间','创建人'];

	var colModel = [{
		name : 'id',
		index : 'id',
		width : 180,
		sorttype : "string",
		editable : false,
		editoptions : {
			readonly : true
		}
	},{
		name : 'channelCode',
		index : 'channelCode',
		width : 180,
		editable : true,
		sorttype : "string",
		editrules : {
			required : true
		}
	},  {
		name : 'name',
		index : 'name',
		width : 250,
		editable : true,
		sorttype : "string",
		editrules : {
			required : true
		}
	},{
		name : 'createTime',
		index : 'createTime',
		width : 220,
		editable : true,
		search : false
	},{
		name : 'createBy',
		index : 'createBy',
		width : 180,
		editable : true,
		search : false
	}];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		caption : "预售查询",
		height: 260,
	    width: 570,
	    multiselect: false,
		ondblClickRow: ondblClickRow,
		onSelectRow: function(ids) { //单击选择行  
            //alert(ids);
        }
	});

	gridPager(grid_selector, pager_selector, {
		navbarOptions: {add: false, edit:false,del:false,view:false},
		selectAction : selectAction
	});
	
	$(window).resize(function(){
		$(grid_selector).setGridWidth(570);
		$(grid_selector).setGridHeight(260);
    });
	
	/**
	 * 根据返回值代码，对应名称
	 */
	function formatterStatus(cellvalue){
		if(cellvalue==1){
			return '已审核';
		}else{
			return '待审核';
		}
	}

	/**
	 * 双击行事件
	 */
	function ondblClickRow(rowid,iRow,iCol,e){
//		var rowData = $(grid_selector).jqGrid('getRowData', rowid);
//		alert(rowData.name);
		$("#popPreSaleOk").trigger("click");
	}

}
//进入页面后加载主表信息
popPreSaleloadData();

function returnPopWindow() {
	var rowId = $('#popPreSaleTable').jqGrid('getGridParam', 'selrow');
	var rowData = $('#popPreSaleTable').jqGrid('getRowData', rowId);
	if(rowData){
		callPreSaleData(rowData); //回调数据，设置预售单号、渠道编码的值
		$("#popPreSaleCloseWindow").trigger("click");
	} else {
        alert("没有选择到值,请选择数据");
	}
}
