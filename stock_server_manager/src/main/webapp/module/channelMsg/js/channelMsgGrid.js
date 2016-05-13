//@sourceURL=stActivityWarehGrid.js
function channelMsgloadData() {
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		selectUrl : basePath + "/selectChannelMsg",
	}
	var search_selector = "#channelMsgSearch";
	var grid_selector = "#channelMsgTable";
	var pager_selector = "#channelMsgPager";

	var selectAction = {
		url : modularPath.selectUrl
	};
	var colNames = [ '渠道编码', '渠道名称' ];

	var colModel = [ {
		name : 'channelCode',
		index : 'channelCode',
		width : 100,
		editable : true,
		editrules : {
			required : true
		}
	}, {
		name : 'channelName',
		index : 'channelName',
		width : 150,
		editable : true,
		search : false
	}, ];

	grid(grid_selector, pager_selector, {
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		multiselect : false,
		
		caption : "配发组织查询",
		rownumbers: true,
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

channelMsgloadData();
