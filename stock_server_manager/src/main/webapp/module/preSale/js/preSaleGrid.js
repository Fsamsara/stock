//@ sourceURL=preSaleGrid.js
function preSaleloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectPreSale"
	};
	var search_selector = "#preSaleSearch";
	var grid_selector = "#preSaleTable";
	var pager_selector = "#preSalePager";

	var selectAction = {
		url : modularPath.selectUrl
	};

	var colNames = [ '序列','预售单号', '渠道','预售名称','审核状态','更新时间','更新人','创建时间','创建人'];

	var colModel = [{
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
		name : 'examineStatus',
		index : 'examineStatus',
		width : 150,
		editable : true,
		search : false,
		formatter:formatterStatus
	} ,{
		name : 'updateTime',
		index : 'updateTime',
		width : 220,
		editable : true,
		search : false
	},{
		name : 'updateBy',
		index : 'updateBy',
		width : 180,
		editable : true,
		search : false
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
		datatype:"local",
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		rownumbers: true,
		caption : "预售查询",
		ondblClickRow: ondblClickRow
	});

	//重新设置表格的获取数据类型为JSON
	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});

	gridPager(grid_selector, pager_selector, {
		navbarOptions: {add: false, edit:false,del:false,view:false},
		selectAction : selectAction
	});

	/**
	 * 根据返回值代码，对应名称
	 */
	function formatterStatus(cellvalue){
		if(cellvalue==1){
			return '已审核'
		}else if(cellvalue==0){
			return '待审核'
		}else if(cellvalue==2){
			return '已撤销'
		}
	}

	/**
	 * 双击行事件
	 */
	function ondblClickRow(rowid,iRow,iCol,e){
		var rowData = $(grid_selector).jqGrid('getRowData', rowid);
		tabs.add({
			id: "pre_detail",
			menuName: "预售明细",
			url: "module/preSale/preSaleDetail.html"
		});
		tabs.data = rowData;
		tabs.layout();
	}

	$(grid_selector).navButtonAdd(pager_selector, {
		caption: "",
		buttonicon: "fa-plus-circle purple",
		onClickButton: addNewPreSale,
		position: "first",
		title: "新增预售记录",
		cursor: "pointer"
	});

	/**
	 * 点击预售主表添加按钮的时候弹出页面
	 */
	function addNewPreSale(){
		tabs.add({
			id: "pre_detail",
			menuName: "预售明细",
			url: "module/preSale/preSaleDetail.html"
		});
		tabs.layout();
	}
}
//进入页面后加载主表信息
preSaleloadData();



