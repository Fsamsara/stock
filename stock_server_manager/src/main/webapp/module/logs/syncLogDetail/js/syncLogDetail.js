function syncLogDetailloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectSyncLogDetail",
		channelInfoSelectUrl : basePath + "/selectChannelInfo"
	}
	var search_selector = "#syncLogDetailSearch";
	var grid_selector = "#syncLogDetailTable";
	var pager_selector = "#syncLogDetailPager";

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
	var colNames = [ '渠道编码', '渠道名称', '商品编码', '推送库存', '推送来源', '推送时间', '开始时间',
			'结束时间' ];

	var colModel = [
			{
				name : 'channelCode',
				index : 'channelCode',
				width : 60,
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
				stype : "select",
				searchoptions : {
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
				width : 90,
				editable : true,
				sorttype : "string",
				searchrules : {
					required : true
				},
				editrules : {
					required : true
				}
			}, {
				name : 'stock',
				index : 'stock',
				width : 100,
				editable : true,
				search : false
			}, {
				name : 'orderSource',
				index : 'orderSource',
				width : 100,
				editable : true,
				search : false
			}, {
				name : 'updateTime',
				index : 'updateTime',
				formatter : "datetime",
				width : 90,
				editable : false,
				search : false,
				searchoptions : {
					dataInit : function(elem) {
						$(elem).datetimepicker({
							format : 'yyyy-mm-dd hh:ii:ss',
							language : 'zh-CN',
							weekStart : 1,
							todayBtn : 1,
							autoclose : 1,
							todayHighlight : 1,
							startView : 2,
							minView : 2,
							forceParse : 0,
							showMeridian : 1
						});
					}
				}
			}, {
				name : 'startTime',
				index : 'startTime',
				formatter : "datetime",
				width : 90,
				editable : false,
				hidden : true,
				search : true,
				searchrules : {
					required : true
				},
				searchoptions : {
					dataInit : function(elem) {
						$(elem).datetimepicker({
							format : 'yyyy-mm-dd hh:ii:ss',
							language : 'zh-CN',
							weekStart : 1,
							todayBtn : 1,
							autoclose : 1,
							todayHighlight : 1,
							startView : 2,
							minView : 2,
							forceParse : 0,
							showMeridian : 1
						});
					},
					searchhidden : true
				}
			}, {
				name : 'endTime',
				index : 'endTime',
				formatter : "datetime",
				width : 90,
				editable : false,
				search : true,
				hidden : true,
				searchrules : {
					required : true
				},
				searchoptions : {
					dataInit : function(elem) {
						$(elem).datetimepicker({
							format : 'yyyy-mm-dd hh:ii:ss',
							language : 'zh-CN',
							weekStart : 1,
							todayBtn : 1,
							autoclose : 1,
							todayHighlight : 1,
							startView : 2,
							minView : 2,
							forceParse : 0,
							showMeridian : 1
						});
					},
					searchhidden : true
				}
			} ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		datatype : "local",
		rownumbers : true,
		caption : "同步日志信息列表"
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

syncLogDetailloadData();
