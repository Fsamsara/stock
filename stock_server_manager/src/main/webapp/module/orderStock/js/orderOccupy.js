function orderOccupyloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectOrderOccupy",
		channelInfoSelectUrl : basePath + "/selectChannelInfo"
	}
	var search_selector = "#orderOccupySearch";
	var grid_selector = "#orderOccupyTable";
	var pager_selector = "#orderOccupyPager";

	var editAction = {
		url : modularPath.updateUrl
	};
	var addAction = {
		url : modularPath.addUrl
	};
	var deleteAction = {
		url : modularPath.deleteUrl
	};
	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '渠道编码', '渠道名称', '商品编码', '外部交易号', 'OS订单号', '子单号', '预占独占总量',
			'预占共享总量', '预占店群总量', '释放标识', '关联渠道', '更新时间' ];

	var colModel = [
			{
				name : 'channelCode',
				index : 'channelCode',
				width : 100,
				sorttype : "string",
				editable : false,
				searchrules : {
					required : true
				},
				editrules : {
					required : true
				}
			},
			{
				name : 'channelName',
				index : 'channelCode',
				width : 150,
				editable : true,
				edittype : "select",
				editrules : {
					required : true
				},
				hidden : true,
				search : true,
				stype : "select",
				searchoptions : {
					searchhidden : true,
					dataInit : function(elem) {
						$
								.ajax({
									type : "GET",
									async : false,
									url : modularPath.channelInfoSelectUrl,
									dataType : "json",
									success : function(data) {
										var options = '<option value="">--- 请选择 ---</option>';
										$.each(data.message.content, function(
												index, val) {
											if (typeof val === "object") {
												options += '<option value="'
														+ val.channelCode
														+ '">'
														+ val.channelName
														+ '</option>';
											}
										});
										$(elem).html(options);
									}
								});
					}
				},
				editrules : {
					required : true
				}
			}, {
				name : 'prodId',
				index : 'prodId',
				width : 100,
				editable : true,
				sorttype : "string",
				searchrules : {
					required : true
				},
				editrules : {
					required : true
				}
			}, {
				name : 'businessId',
				index : 'businessId',
				width : 100,
				editable : false
			}, {
				name : 'osOrderId',
				index : 'osOrderId',
				width : 100,
				editable : true
			}, {
				name : 'subOrderId',
				index : 'subOrderId',
				width : 100,
				editable : true
			}, {
				name : 'orderPrivateStock',
				index : 'orderPrivateStock',
				width : 100,
				editable : true,
				search : false
			}, {
				name : 'orderShareStock',
				index : 'orderShareStock',
				width : 100,
				editable : true,
				search : false
			}, {
				name : 'orderShopGroupStock',
				index : 'orderShopGroupStock',
				width : 100,
				editable : true,
				search : false
			}, {
				name : 'lazyStatus',
				index : 'lazyStatus',
				width : 100,
				editable : true,
				search : false
			}, {
				name : 'relationChannel',
				index : 'relationChannel',
				width : 100,
				editable : true,
				search : true
			}, {
				name : 'updateTime',
				index : 'updateTime',
				formatter : "datetime",
				width : 90,
				editable : false,
				search : false
			} ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		datatype : "local",
		multiselect : false,
		rownumbers : true,
		caption : "订单预占信息列表"
	});

	$(grid_selector).jqGrid('setGridParam', {
		datatype : 'json'
	});

	gridPager(grid_selector, pager_selector, {
		editAction : editAction,
		addAction : addAction,
		deleteAction : deleteAction,
		selectAction : selectAction,
		navbarOptions : {
			edit : false,
			editicon : 'fa-pencil blue',
			add : false,
			addicon : 'fa-plus-circle purple',
			del : false,
			delicon : 'fa-trash-o red',
			search : true,
			searchicon : 'fa-search orange',
			refresh : false,
			refreshicon : 'fa-refresh green',
			view : false,
			viewicon : 'fa-search-plus grey'
		}
	});
}

orderOccupyloadData();
