//@ sourceURL=stockBizLogDtlGrid.js
function stockBizLogDtlloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectStockBizLogDtl",
		channelInfoSelectUrl : basePath + "/selectChannelInfo"
	}
	var search_selector = "#stockBizLogDtlSearch";
	var grid_selector = "#stockBizLogDtlTable";
	var pager_selector = "#stockBizLogDtlPager";

	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '序列', '服务名', '类名', '方法名', '内容', '渠道编码', '渠道名称', '仓库编码',
			'商品编码', 'IP地址', '更新时间', '创建时间', '日志时间' ];

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
				}
			},
			{
				name : 'servicename',
				index : 'servicename',
				width : 150,
				editable : true,
				editrules : {
					required : true
				}
			},
			{
				name : 'classname',
				index : 'classname',
				width : 90,
				editable : true,
				sorttype : "string",
				editrules : {
					required : true
				}
			},
			{
				name : 'methodname',
				index : 'methodname',
				width : 100,
				editable : true,
				search : false
			},
			{
				name : 'content',
				index : 'content',
				width : 100,
				editable : true,
				search : false
			},
			{
				name : 'channelcode',
				index : 'channelcode',
				width : 100,
				editable : true,
				search : false
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
				name : 'warehid',
				index : 'warehid',
				width : 100,
				editable : true,
				editrules : {
					required : true
				}
			}, {
				name : 'prodid',
				index : 'prodid',
				width : 100,
				editable : true,
				editrules : {
					required : true
				}
			}, {
				name : 'ip',
				index : 'ip',
				width : 100,
				editable : true,
				search : false
			}, {
				name : 'updateTime',
				index : 'updateTime',
				formatter : "datetime",
				width : 90,
				editable : false,
				editrules : {
					required : true
				},
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
				name : 'createtime',
				index : 'createtime',
				formatter : "datetime",
				width : 90,
				editable : true,
				editrules : {
					required : true
				},
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
				name : 'logtime',
				index : 'logtime',
				formatter : "datetime",
				width : 90,
				editable : true,
				editrules : {
					required : true
				},
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

			}, ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		datatype : "local",
		caption : "业务日志",
		rownumbers : true,
	});

	// 重新设置表格的获取数据类型为JSON
	$(grid_selector).jqGrid('setGridParam', {
		datatype : 'json'
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

stockBizLogDtlloadData();
