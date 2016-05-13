//@ sourceURL=stockCommonConfig.js
function stockCommonConfigloadData() {

	var basePath = "/" + ump.mvcContextPath;
	var grid_selector = "#stockCommonConfigTable";
	var pager_selector = "#stockCommonConfigPager";

	var modularPath = {
		selectUrl : basePath + "/selectStockCommonConfig",
        deleteUrl : basePath + "/deleteStockCommonConfig",
        addUrl : basePath + "/addStockCommonConfig",
        editUrl : basePath + "/editStockCommonConfig"
	};

	var colNames = [  'ID','配置类型', '配置名称','配置组', '配置值', '创建时间','创建人'];

	var colModel = [{
        name : 'id',
        index : 'id',
        width : 10,
        sorttype : "string",
        editable : false,
        hidden: true
    },{
		name : 'configType',
		index : 'configType',
		width : 60,
		sorttype : "string",
		editable : false,
		hidden: true
	}, {
		name : 'configName',
		index : 'configName',
		width : 110,
		sorttype : "string",
		editable : true,
		search : true
	},{
		name : 'configGroup',
		index : 'configGroup',
		width : 110,
		editable : true,
		search : true
	},{
		name : 'configValue',
		index : 'configValue',
		width : 400,
		editable : true,
		search : false,
		formatter: formatterConfigValue
	},{
		name : 'createTime',
		index : 'createTime',
		width : 120,
		editable : false,
		search : false
	},{
		name : 'createBy',
		index : 'createBy',
		width : 80,
		editable : false,
		search : false
	}];

	grid(grid_selector, pager_selector, {
		datatype:"local",
		url : modularPath.selectUrl,
		colNames : colNames,
		colModel : colModel,
		caption : "配置信息查询"
	});

	//重新设置表格的获取数据类型为JSON
	$(grid_selector).jqGrid('setGridParam',{datatype:'json'});

	gridPager(grid_selector, pager_selector, {
		navbarOptions: {add: true, edit:true,del:true,view:true,refresh:false},
		selectAction : {url : modularPath.selectUrl},
        deleteAction: {url: modularPath.deleteUrl},
        editAction: {url: modularPath.editUrl},
        addAction: {url: modularPath.addUrl}
	});
}

/**
 * 解码
 */
function formatterConfigValue(cellvalue){
	return decodeURI(cellvalue)
}
//进入页面后加载主表信息
stockCommonConfigloadData();



