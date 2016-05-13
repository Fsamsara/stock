//@ sourceURL=tmallChannelManagerDetailGrid.js
var basePath = "/" + ump.mvcContextPath;
function tmallChannelManagerDetailloadData() {
    parentData = tabs.data;
    //给子页面赋值从父页面带过来的主表信息
    if (!!parentData) {
        setParentValue(parentData);
    }
    var modularPath = {
        updateUrl: basePath + "/updateTmallChannelManagerDetail",
        addUrl: basePath + "/addTmallChannelManagerDetail",
        deleteUrl: basePath + "/deleteTmallChannelManagerDetail",
        selectUrl: basePath + "/selectTmallChannelManagerDetail",
        fileUploadUrl: basePath + "/tmallChannelManagerDetailUpload"
        //checkUrl: basePath + "/submitFlowStockTmallChannelManager"
    };
//    var search_selector = "#tmallChannelManagerDetailSearch";
    var grid_selector = "#tmallChannelManagerDetailTable";
    var pager_selector = "#tmallChannelManagerDetailPager";

    var colNames = ['序列号', '同步单号', '商品编码', '同步数量', '执行状态', '备注'];

    var colModel = [{
        name: 'serialId',
        index: 'serialId',
        width: 200,
        sorttype: "string",
        editable: true,
        hidden: true
    }, {
        name: 'reletionId',
        index: 'reletionId',
        width: 200,
        sorttype: "string",
        editable: true,
        hidden: true,
        editrules: {
            required: true
        },
        editoptions: {
            dataInit: setRelationIdValue
        }
    }, {
        name: 'prodId',
        index: 'prodId',
        width: 200,
        editable: true,
        sorttype: "string",
        editrules: {
            required: true
        },
        editoptions: {
            dataInit: getExistDetail
        }
    }, {
        name: 'stock',
        index: 'stock',
        width: 200,
        editable: true,
        search: false,
        editrules: {
            required: true
        }
	}, {
		name : 'exeStatus',
		index : 'exeStatus',
		width : 200,
		editable : false,
		formatter : formatterStatus
	}, {
		name : 'note',
		index : 'note',
		width : 200,
		editable : true,
		hidden: false
    }];
    //判断是否从父页面进入
    {
        var incrementId;
        if (!parentData) {
        	incrementId = "-1";
        } else {
        	incrementId = parentData.incrementId;
        }
    }
    grid(grid_selector, pager_selector, {
        url: modularPath.selectUrl + "?reletionId=" + incrementId,
        colNames: colNames,
        colModel: colModel,
        caption: "",
        height: document.documentElement.clientHeight - 479,
        width: document.documentElement.clientWidth - 295
    });

    var editAction = {
        beforeShowForm: oprationCheck,
        url: modularPath.updateUrl
    };

    var addAction = {
        beforeShowForm: addDetailCheck,
        url: modularPath.addUrl,
        afterComplete: function (response, postData, form) {
            //同时新增主表和明细表数据后，不自动刷新页面，所以写这么一堆。。。。
            $(grid_selector).trigger("reloadGrid");
            var isSuccess = response.responseJSON != undefined ? response.responseJSON.status
                : "error";
            var msgObj = response.responseJSON.message;
//            var msg = msgObj;
            $.each(postData, function (key, value) {
                if (key != "oper") {
                    $(form).find("#" + key).val(value);
                }
            });
            // 异常的统一处理
            if (isSuccess == "error") {
                callAlertDialog(msgObj);
            }

            if (response.responseJSON.status == "success") {
                callInfoDialog("添加记录成功！");
                $(form).parents(".ui-widget").find(
                    ".ui-jqdialog-titlebar-close").click();
            }
        }
    };
    var deleteAction = {
        beforeShowForm: deleteDetailCheck,
        url: modularPath.deleteUrl
    };
    var selectAction = {
        url: modularPath.selectUrl
    };
    gridPager(grid_selector, pager_selector, {
        editAction: editAction,
        addAction: addAction,
        deleteAction: deleteAction,
        selectAction: selectAction
    });

    $(grid_selector).navButtonAdd(pager_selector, {
        caption: "",
        buttonicon: "fa-file-excel-o purple",
        onClickButton: uploadFile,
        position: "first",
        title: "导入Excel",
        cursor: "pointer"
    });

    /**
     * 设置主表RelationId
     */
    function setRelationIdValue(elem) {
        $(elem).val(vm.incrementId.val());
    }
    
    /**
     * 设置主表ID
     */
    function setIdValue(elem) {
        $(elem).val(vm.id.val());
    }

    /**
     * 获取已存在记录的信息
     */
    function getExistDetail(elem) {
        $(elem).change(function () {
            var basePath = "/" + ump.mvcContextPath;
            url = basePath + "/isExistTmallChannelManagerDetail?reletionId=" + vm.incrementId.val() + "&prodId=" + $(elem).val();
            $.get(url, getExistDetailCallBack);
        });
    }

    /**
     * 若是sku和仓库已经存在的记录，则将数据库中的stock值填写
     */
    function setPrivateStock(elem) {
        $(elem).change(function () {
            if (!!content) {
                for (var i = 0; i < content.length; i++) {
                    if ($("#warehId").val() == content[i].warehId) {
                        $("#prePrivateStock").val(content[i].prePrivateStock);
                    }
                }
            }
        });
    }

    /**
     * 文件上传
     */
    function uploadFile() {
        oprationCheck();
        $("#impExcel").modal('show');
        impExcelData(modularPath.fileUploadUrl + "?reletionId=" + vm.incrementId.val(), 'tmallChannelManagerDetail', grid_selector);
    }

}

/**
 * 新增按钮
 */
function add() {
    tabs.add({
        id: "tmallChannelManager_detail",
        menuName: "天猫库存同步录入明细查询",
        url: "module/tmallChannel/tmallChannelManagerDetail.html"
    });
    tabs.layout();
}

/**
 * 保存
 */
function save() {
    var id = vm.incrementId.val();
    var channelCode = vm.channelCode.val();
    var name = encodeURIComponent(vm.incrementName.val());
    var paramMap = {id: id, channelCode: channelCode, name: name};
    var jsonParam = JSON.stringify(paramMap);
    var updtUrl = basePath + "/updateTmallChannelManager";
    console.log(updtUrl);
    $.post(
        updtUrl,
        //参数使用json格式数据：{a:'value1',b:'value2'}
        jsonParam,
        updateTmallChannelManagerCallBack,
        // 默认返回字符串，设置值等于json则返回json数据
        'json'
    );
}

/**
 * 审核
 */
function check() {
    var master = {};
    master.id = vm.incrementId.val();
    if (master.id == undefined || master.id == "") {
        callAlertDialog("同步单号不能为空");
    }
    master.name = vm.incrementName.val();
    if (master.name == undefined || master.name == "") {
        callAlertDialog("同步名称不能为空");
    }
    master.channelCode = vm.channelCode.val();

    var paramObj = {};
    paramObj.master = master;
    var o = {};
    o.json = paramObj;
    var jsonData = JSON.stringify(paramObj);
    $.ajax({
        url: "/" + ump.mvcContextPath + "/submitFlowStockTmallChannelManager",
        type: "POST",
        dataType: "html",
        data: "json=" + jsonData,
        async: false,
        success: function (data) {
            eval("data=" + data);
            if (data.sucess) {
                setParentValue(data.master);
                callInfoDialog("审批成功");
                //initControlReadOnly();
                //modifyTypeSelect_Change();
            } else {
                callAlertDialog(data.msg);
            }
        },
        error: function () {
        }
    });
}


/**
 * 撤销按钮
 */
function cancel() {
    var master = {};
    master.id = vm.incrementId.val();
    master.name = vm.incrementName.val();
    master.channelCode = vm.channelCode.val();
    var paramObj = {};
    paramObj.master = master;
    var o = {};
    o.json = paramObj;
    var jsonData = JSON.stringify(paramObj);
    $.ajax({
        url: basePath + '/cancelFlowStockTmallChannelManager',
        type: "POST",
        dataType: "html",
        data: "json=" + jsonData,
        async: false,
        success: function (data) {
            eval("data=" + data);
            if (data.sucess) {
                setParentValue(data.master);
                callInfoDialog("撤单成功");
                initControlReadOnly();
                modifyTypeSelect_Change();
            } else {
                callAlertDialog(data.msg);
            }
        },
        error: function () {
        }
    });
}

/**
 * 设置详细页面从父页面带过来的同步主表信息
 */
function setParentValue(parentData) {
	vm.incrementId.val(parentData.incrementId);
	vm.incrementName.val(parentData.incrementName);
	vm.channelCode.val(parentData.channelCode);
	var iStatus;
	if (parentData.iStatus == '1') {
		iStatus = "已审核";
	} else if (parentData.iStatus == '2') {
		iStatus = "已撤销";
	} else if (parentData.iStatus == '0') {
		iStatus = "待审核";
	} else {
		iStatus = parentData.iStatus;
	}
	vm.iStatus.val(iStatus);
	if (iStatus == '已审核' || iStatus == '已撤销') {
		// 设置页面上的input框和按钮的状态
		configurationPage();
	}
	delete tabs.data;
}

/**
 * 添加明细记录
 */
function addDetailCheck(e) {
    var channelCode = vm.channelCode.val();
    var incrementName = vm.incrementName.val();
    var status = vm.iStatus.val();
    if (!channelCode || !incrementName) {
        callAlertDialog("请填写【同步名称】和【渠道编码】再新增同步明细！");
        throw "Err";
    } else if (status == "已审核" || status == "已撤销") {
        oprationCheck();
    } else if (!vm.incrementId.val()) {
        addTmallChannelManager(channelCode, incrementName);
    }
    var form = $(e[0]);
    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
        .wrapInner('<div class="widget-header" />');
    style_edit_form(form);
}

/**
 * 删除明细检查
 */
function deleteDetailCheck(e) {
    oprationCheck();
    //样式调整
    var form = $(e[0]);
    if (form.data('styled'))  return false;
    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
    style_delete_form(form);
    form.data('styled', true);
}

/**
 * 修改记录检查
 */
function oprationCheck() {
    var status = vm.iStatus.val();
    if (status == "已审核" || status == "已撤销") {
        callAlertDialog("您不能对【已审核】或者【已撤销】的同步单进行此操作！");
        throw "Err";
    }
}
/**
 * 添加主表信息
 */
function addTmallChannelManager(channelCode, incrementName) {
    var basePath = "/" + ump.mvcContextPath;
    addUrl = basePath + "/addTmallChannelManager";
    var paramMap = {channelCode: channelCode, name: incrementName};
    $.post(addUrl, paramMap, addTmallChannelManagerCallBack, "json");
}

/**
 * 添加主表信息回调函数
 */
function addTmallChannelManagerCallBack(msg) {
    vm.incrementId.val(msg);
    vm.iStatus.val("待审核");
    //获得返回的reletionId后给添加自子记录赋值
    $("#reletionId").val(vm.incrementId.val());
    tabs.add({
        id: "tmallChannelManager_detail",
        menuName: "天猫库存同步录入明细",
        url: "module/tmallChannel/tmallChannelManagerDetail.html"
    });
    tabs.data = {"id": msg, "incrementName": vm.incrementName.val(), "channelCode": vm.channelCode.val(), iStatus: vm.iStatus.val()};
    tabs.layout();
}

/**
 * 更新主表信息回调函数
 */
function updateTmallChannelManagerCallBack(data) {
    // 这里是请求发送成功后的回调函数。
    // msg是返回的数据，数据类型在type参数里定义！
    if (data.status == "success") {
        callInfoDialog(data.message);
    } else {
        callAlertDialog(data.message);
    }
}

/**
 * 获取存在的明细信息
 */
function getExistDetailCallBack(msg) {
    var obj = JSON.parse(msg);
    content = obj.message.content;
//    console.log(obj);
    if (content.length != 0) {
        $("#stock").val(content[0].stock);
        $("#serialId").val(content[0].id);
        $("#note").val(content[0].note);
    }
}

/**
 * 设置input框和按钮的状态
 */
function configurationPage() {
    vm.channelCode.attr('readOnly', 'true');
    vm.channelCode.css({width: "300px", background: "gainsboro"});
    vm.incrementName.attr('readOnly', 'true');
    vm.incrementName.css({width: "300px", background: "gainsboro"});
    bt.save.attr('disabled', 'disabled');
    bt.check.attr('disabled', 'disabled');
    bt.cancel.attr('disabled', 'disabled');
}

/**
 * 根据返回值代码，对应名称
 */
function formatterStatus(cellvalue){
    if(cellvalue==0){
        return '未执行';
    }else if(cellvalue==1){
        return '执行成功';
    }else if(cellvalue==2){
        return '执行失败';
    }
}

//全局参数
var content;
var vm = {}, bt = {};
vm.incrementId = $("#incrementId");
vm.iStatus = $("#iStatus");
vm.incrementName = $("#incrementName");
vm.channelCode = $("#channelCode");
bt.save = $("#bt_save");
bt.check = $("#bt_check");
bt.cancel = $("#bt_cancel");
tmallChannelManagerDetailloadData();
