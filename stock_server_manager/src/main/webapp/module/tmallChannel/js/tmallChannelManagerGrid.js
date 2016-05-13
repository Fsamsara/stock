//@ sourceURL=tmallChannelManagerGrid.js
function tmallChannelManagerloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectTmallChannelManager"
	};
	//var search_selector = "#tmallChannelManagerSearch";
	var grid_selector = "#tmallChannelManagerTable";
	var pager_selector = "#tmallChannelManagerPager";

	var selectAction = {
		url : modularPath.selectUrl
	};

	var colNames = ['序列号', '同步单号', '同步名称', '渠道编码', '渠道名称', '当前进度', '创建时间', '创建人', '更新时间', '更新人'];

	var colModel = [{
		name : 'id',
		index : 'id',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden : true,
		search : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'incrementId',
		index : 'incrementId',
		width : 180,
		sorttype : "string",
		editable : false,
		editoptions : {
			readonly : true
		}
	}, {
		name : 'incrementName',
		index : 'incrementName',
		width : 180,
		editable : true,
		sorttype : "string",
		editrules : {
			required : true
		}
	}, {
		name : 'channelCode',
		index : 'channelCode',
		width : 180,
		editable : true,
		sorttype : "string",
		editrules : {
			required : true
		}
	}, {
		name : 'channelName',
		index : 'channelName',
		width : 180,
		editable : false,
		sorttype : "string",
		search : false,
		editrules : {
			required : true
		}
	}, {
		name : 'iStatus',
		index : 'iStatus',
		width : 150,
		editable : false,
		formatter:formatterStatus
	}, {
		name : 'createTime',
		index : 'createTime',
		width : 220,
		editable : false,
		search : false
	}, {
		name : 'createBy',
		index : 'createBy',
		width : 180,
		editable : false,
		search : false
	}, {
		name : 'updateTime',
		index : 'updateTime',
		width : 220,
		editable : false,
		search : false
	}, {
		name : 'updateBy',
		index : 'updateBy',
		width : 180,
		editable : false,
		search : false
	}];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		caption : "天猫库存同步录入",
		datatype:"local",
		rownumbers: true,
		multiselect : false,
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
	function formatterStatus(cellvalue) {
		if (cellvalue == 1) {
			return '已审核';
		} else if (cellvalue == 0) {
			return '待审核';
		} else if (cellvalue == 2) {
			return '已撤销';
		}
	}

	/**
	 * 双击行事件
	 */
	function ondblClickRow(rowid, iRow, iCol, e) {
		var rowData = $(grid_selector).jqGrid('getRowData', rowid);
		tabs.add({
			id : "tmallChannelManager_detail",
			menuName : "天猫库存同步录入明细",
			url : "module/tmallChannel/tmallChannelManagerDetail.html"
		});
		tabs.data = rowData;
		tabs.layout();
	}

	$(grid_selector).navButtonAdd(pager_selector, {
		caption: "",
		buttonicon: "fa-plus-circle purple",
		onClickButton: addNewPreSale,
		position: "first",
		title: "新增天猫库存同步记录",
		cursor: "pointer"
	});

	/**
	 * 点击预售主表添加按钮的时候弹出页面
	 */
	function addNewPreSale(){
		tabs.add({
			id: "tmallChannelManager_detail",
			menuName: "天猫库存同步录入明细",
			url: "module/tmallChannel/tmallChannelManagerDetail.html"
		});
		tabs.layout();
	}
}
//进入页面后加载主表信息
tmallChannelManagerloadData();



