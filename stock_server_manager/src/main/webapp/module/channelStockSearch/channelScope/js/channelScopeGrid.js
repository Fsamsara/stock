function channelScopeLoadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		updateUrl : basePath + "/updateChannelScope",
		addUrl : basePath + "/addChannelScope",
		deleteUrl : basePath + "/deleteChannelScope",
		selectUrl : basePath + "/selectChannelScope",
		channelInfoSelectUrl : basePath + "/selectChannelInfo"
	}
	var search_selector = "#channelScopeSearch";
	var grid_selector = "#channelScopeTable";
	var pager_selector = "#channelScopePager";

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
	var colNames = [ '序列', '渠道编码', '渠道名称', '配发组织编码', '配发组织名称' ];

	var colModel = [
			{
				name : 'id',
				index : 'id',
				width : 60,
				sorttype : "string",
				editable : false,
				hidden : true,
				editoptions : {
					readonly : true
				},
				search : false
			},
			{
				name : 'channelCode',
				index : 'channelCode',
				width : 90,
				editable : true,
				sorttype : "string",
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
				name : 'warehId',
				index : 'warehId',
				width : 90,
				editable : true,
				sorttype : "string",
				editrules : {
					required : true
				}
			}, {
				name : 'warehName',
				index : 'warehName',
				width : 200,
				editable : true,
				search : false
			} ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		rowNum : -1,
		datatype : "local",
//		rowList : [ 1000000 ],
		caption : "渠道配发范围列表"
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
			refresh : true,
			refreshicon : 'fa-refresh green',
			view : true,
			viewicon : 'fa-search-plus grey'
		}
	});

};

channelScopeLoadData();