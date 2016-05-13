//@ sourceURL=preSaleModify.js
function preSaleModifyloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
//		updateUrl : basePath + "/updateShopDame",
//		addUrl : basePath + "/addShopDame",
//		deleteUrl : basePath + "/deleteShopDame",
		selectUrl : basePath + "/selectStockPreSaleModifyList"
	}
	var search_selector = "#preSaleModifySearch";
	var grid_selector = "#preSaleModifyTable";
	var pager_selector = "#preSaleModifyPager";

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		datatype:"local",
		multiselect:false,
		colNames : [ 'id', '预售调整名称', '预售调整单号', '渠道编码', '调整类型', '进度', '创建人', '创建时间', '最后修改人', '最后修改时间' ],
		colModel : [ {
			name : 'id',
			index : 'id',
			width : 10,
			hidden : true
		}, {
			name : 'name',
			index : 'name',
			width : 150,
			editable : true,
			editrules : {
				required : true
			},

		}, {
			name : 'relationId',
			index : 'relationId',
			width : 150

		}, {
			name : 'channelCode',
			index : 'channelCode',
			width : 150,
			editable : true,
			editrules : {
				required : true
			},

		}, {
			name : 'modifyType',
			index : 'modifyType',
			width : 120,
			formatter: function (cellvalue, options, rowObject) {
				    var value="调整结束日期";
				    if(cellvalue=="01"){
				    	value="调整预售数量";
				    }
                    return value; 
                }
		}, {
			name : 'examineStatus',
			index : 'examineStatus',
			width : 120,
			formatter: function (cellvalue, options, rowObject) {
			    var value="待审批";
			    if (cellvalue=="1") {
			    	value="已审批";
			    } else if (cellvalue=="2") {
			    	value="已撤销";
			    }
                return value; 
            }
		}, {
			name : 'createBy',
			index : 'createBy',
			width : 120,
			editable : true,
			sorttype : "string",
			editrules : {
				required : true
			}
		}, {
			name : 'createTime',
			index : 'createTime',
			width : 200,
			editable : true,
			//formatter:'date',
			//formatoptions:{srcformat: 'u', newformat: 'Y-m-d H:i:s'},
			editrules : {
				required : true
			}
		}, {
			name : 'updateBy',
			index : 'updateBy',
			width : 120,
			editable : true,
			sorttype : "string",
			editrules : {
				required : true
			}
		}, {
			name : 'updateTime',
			index : 'updateTime',
			width : 200,
			editable : true,
			//formatter:'date',
			//formatoptions:{srcformat: 'u', newformat: 'Y-m-d H:i:s'},
            editrules : {
				required : true
			}
		} ],
		rownumbers: true,
		ondblClickRow: ondblClickRow,
		caption : "预售调整单查询"
	});
	gridPager(grid_selector, pager_selector, {
		editAction : {
			url : modularPath.updateUrl
		},
		addAction : {
			url : modularPath.addUrl
		},
		deleteAction : {
			url : modularPath.deleteUrl
		},
		navbarOptions : {
			edit : false,
			editicon : 'fa-pencil blue',
			add : false,
			addicon : 'fa-plus-circle purple',
			del : false,
			delicon : 'fa-trash-o red',
			search : true,
			searchicon : 'fa-search orange',
			refresh : true,
			refreshicon : 'fa-refresh green',
			view : true,
			viewicon : 'fa-search-plus grey'
		}
	});
	
	$(grid_selector).navButtonAdd(pager_selector, {
		caption: "",
		buttonicon: "fa-plus-circle purple",
		onClickButton: addNewPreSale,
		position: "first",
		title: "新增预售调整记录",
		cursor: "pointer"
	});
	
    /**
	 * 点击预售主表添加按钮的时候弹出页面
	 */
	function addNewPreSale(){
		var testTab={id: "M_601090_1", url: "module/preSale/preSaleModifyEditFrm.html", menuName: "预售调整单", icon: "fa fa-tasks", children: Array[0]};
		tabs.rowData=undefined;
		tabs.add(testTab);
		tabs.layout();
	}
	
	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});
	
	/**
	 * 双击行事件
	 */
	function ondblClickRow(rowid,iRow,iCol,e){
		var rowData = $(grid_selector).jqGrid('getRowData', rowid);
		var testTab={id: "M_601090_1", url: "module/preSale/preSaleModifyEditFrm.html", menuName: "预售调整单", icon: "fa fa-tasks", children: Array[0]};
		tabs.rowData=rowData;
		tabs.add(testTab);
		tabs.layout();
	}
};

preSaleModifyloadData();


