//@ sourceURL=preSaleDetailGrid.js
var basePath = "/" + ump.mvcContextPath;
function preSaleDetailloadData() {
    parentData = tabs.data;
    //给子页面赋值从父页面带过来的主表信息
    if (!!parentData) {
        setParentValue(parentData);
    }
    var modularPath = {
        updateUrl: basePath + "/updatePreSaleDetail",
        addUrl: basePath + "/addPreSaleDetail",
        deleteUrl: basePath + "/deletePreSaleDetail",
        selectUrl: basePath + "/selectPreSaleDetail",
        fileUploadUrl: basePath + "/preSaleDetailUpload"
        //checkUrl: basePath + "/submitFlowStockPreSale"
    };
    var search_selector = "#preSaleDetailSearch";
    var grid_selector = "#preSaleDetailTable";
    var pager_selector = "#preSaleDetailPager";

    var colNames = ['序列', '预售单号', '商品编码', '仓库编码', '预售数量', '开始时间', '结束时间', '最后更新时间', '最后更新人', '预售转预留状态', '预售转预留备注'];

    var colModel = [{
        name: 'id',
        index: 'id',
        width: 60,
        sorttype: "string",
        editable: false,
        hidden: true,
        editoptions: {
            readonly: true
        }
    }, {
        name: 'relationId',
        index: 'relationId',
        width: 60,
        sorttype: "string",
        editable: true,
        hidden: true,
        editoptions: {
            dataInit: setRelationIdValue
        }
    }, {
        name: 'prodId',
        index: 'prodId',
        width: 140,
        editable: true,
        sorttype: "string",
        editrules: {
            required: true
        },
        editoptions: {
            dataInit: getExistDetail
        }
    }, {
        name: 'warehId',
        index: 'warehId',
        width: 130,
        editable: true,
        search: false,
        editrules: {
            required: true
        },
        editoptions: {
            dataInit: setPrivateStock
        }
    }, {
        name: 'prePrivateStock',
        index: 'prePrivateStock',
        width: 100,
        editable: true,
        search: false,
        editrules: {
            required: true
        }
    }, {
        name: 'startTime',
        index: 'startTime',
        width: 200,
        editable: true,
        sorttype: "string",
        editrules: {
            required: true
        },
        editoptions: {
            dataInit: function (elem) {
                $(elem).datetimepicker({
                    format: 'yyyy-mm-dd hh:ii:ss',
                    language: 'zh-CN',
                    weekStart: 1,
                    todayBtn: 1,
                    autoclose: 1,
                    todayHighlight: 1,
                    startView: 2,
                    minView: 2,
                    forceParse: 0,
                    showMeridian: 1
                });
            }
        }
    }, {
        name: 'endTime',
        index: 'endTime',
        width: 200,
        editable: true,
        search: false,
        editrules: {
            required: true
        },
        editoptions: {
            dataInit: function (elem) {
                $(elem).datetimepicker({
                    format: 'yyyy-mm-dd hh:ii:ss',
                    language: 'zh-CN',
                    weekStart: 1,
                    todayBtn: 1,
                    autoclose: 1,
                    todayHighlight: 1,
                    startView: 2,
                    minView: 2,
                    forceParse: 0,
                    showMeridian: 1
                });
            }
        }
    }, {
        name: 'updateTime',
        index: 'updateTime',
        width: 200,
        editable: false,
        search: false
    }, {
        name: 'updateBy',
        index: 'updateBy',
        width: 150,
        editable: false,
        search: false
    }, {
        name: 'reservedStatus', index: 'reservedStatus', width: 150, editable: false,
        formatter: formatterStatus
    }, {
        name: 'reservedRemark', index: 'reservedRemark', width: 150, editable: false
    }];
    //判断是否从父页面进入
    {
        var preId;
        if (!parentData) {
            preId = "-1";
        } else {
            preId = parentData.id
        }
    }
    grid(grid_selector, pager_selector, {
        url: modularPath.selectUrl + "?relationId=" + preId,
        colNames: colNames,
        colModel: colModel,
        caption: "",
        height: screen.availHeight - 580
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
            var msg = msgObj;
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
     * 设置主表ID
     */
    function setRelationIdValue(elem) {
        $(elem).val(vm.preSaleCode.val())
    }

    /**
     * 获取已存在记录的信息
     */
    function getExistDetail(elem) {
        $(elem).change(function () {
            var basePath = "/" + ump.mvcContextPath;
            url = basePath + "/getExistPreSaleDetail?relationId=" + vm.preSaleCode.val() + "&&prodId=" + $(elem).val();
            $.get(url, getExistDetailCallBack);
        })
    }

    /**
     * 若是sku和仓库已经存在的记录，则将数据库中的stock值填写
     */
    function setPrivateStock(elem) {
        $(elem).change(function () {
            if (!!content) {
                for (var i = 0; i < content.length; i++) {
                    if ($("#warehId").val() == content[i].warehId) {
                        $("#prePrivateStock").val(content[i].prePrivateStock)
                    }
                }
            }
        })
    }

    /**
     * 文件上传
     */
    function uploadFile() {
        var preChannel = vm.preChannel.val();
        var preName = vm.preName.val();
        var status = vm.status.val();
        if (!preChannel || !preName) {
            callAlertDialog("请填写【预售渠道】和【预售名称】");
            throw "Err"
        } else if (status == "已审核" || status == "已撤销") {
            oprationCheck();
        } else if (!vm.preSaleCode.val()) {
            addPreSale(preChannel, preName);
        }
        $("#impExcel").modal('show');
        impExcelData(modularPath.fileUploadUrl + "?relationId=" + vm.preSaleCode.val(), 'preSaleDetail', grid_selector);
    }

}

/**
 * 新增按钮
 */
function add() {
    tabs.add({
        id: "pre_detail",
        menuName: "预售明细查询",
        url: "module/preSale/preSaleDetail.html"
    });
    tabs.layout();
}

/**
 * 保存
 */
function save() {
    var id = vm.preSaleCode.val();
    var channelCode = vm.preChannel.val();
    var name = encodeURIComponent(vm.preName.val());
    var paramMap = {id: id, channelCode: channelCode, name: name};
    var jsonParam = JSON.stringify(paramMap)
    var updtUrl = basePath + "/updatePreSale";
    console.log(updtUrl);
    $.post(
        updtUrl,
        //参数使用json格式数据：{a:'value1',b:'value2'}
        jsonParam,
        updtPreSaleCallBack,
        // 默认返回字符串，设置值等于json则返回json数据
        'json'
    )
}

/**
 * 审核
 */
function check() {
    var master = {};
    master.id = vm.preSaleCode.val();
    if (master.id == undefined || master.id == "") {
        callAlertDialog("预售单号不能为空");
    }
    master.name = vm.preName.val();
    if (master.name == undefined || master.name == "") {
        callAlertDialog("预售名称不能为空");
    }
    master.channelCode = vm.preChannel.val();

    var paramObj = {};
    paramObj.master = master;
    var o = {};
    o.json = paramObj;
    var jsonData = JSON.stringify(paramObj);
    $.ajax({
        url: "/" + ump.mvcContextPath + "/submitFlowStockPreSale",
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
    master.id = vm.preSaleCode.val();
    master.name = vm.preName.val();
    master.channelCode = vm.preChannel.val();
    var paramObj = {};
    paramObj.master = master;
    var o = {};
    o.json = paramObj;
    var jsonData = JSON.stringify(paramObj);
    $.ajax({
        url: basePath + '/cancelFlowStockPreSale',
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
 * 设置详细页面从父页面带过来的预售主表信息
 */
function setParentValue(parentData) {
    vm.preSaleCode.val(parentData.id);
    vm.preName.val(parentData.name);
    vm.preChannel.val(parentData.channelCode);
    var status;
    if (parentData.examineStatus == '1') {
        status = "已审核"
    } else if (parentData.examineStatus == '2') {
        status = "已撤销"
    } else if (parentData.examineStatus == '0') {
        status = "待审核"
    } else {
        status = parentData.examineStatus
    }
    vm.status.val(status);
    if (status == '已审核' || status == '已撤销') {
        //设置页面上的input框和按钮的状态
        configurationPage();
    }
    delete tabs.data;
}

/**
 * 添加明细记录
 */
function addDetailCheck(e) {
    var preChannel = vm.preChannel.val();
    var preName = vm.preName.val();
    var status = vm.status.val();
    if (!preChannel || !preName) {
        callAlertDialog("请填写【预售渠道】和【预售名称】再新增预售明细！");
        throw "Err"
    } else if (status == "已审核" || status == "已撤销") {
        oprationCheck();
    } else if (!vm.preSaleCode.val()) {
        addPreSale(preChannel, preName)
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
    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
    style_delete_form(form);
    form.data('styled', true);
}

/**
 * 修改记录检查
 */
function oprationCheck() {
    var status = vm.status.val();
    if (status == "已审核" || status == "已撤销") {
        callAlertDialog("您不能对【已审核】或者【已撤销】的预售单进行此操作！");
        throw "Err"
    }
}
/**
 * 添加主表信息
 */
function addPreSale(preChannel, preName) {
    var basePath = "/" + ump.mvcContextPath;
    addUrl = basePath + "/addPreSale";
    var paramMap = {channelCode: preChannel, name: preName};
    //$.post(addUrl, paramMap, addPreSaleCallBack, "json");
    //这里必须同步
    $.ajax({
        type : "post",
        url : addUrl,
        data : paramMap,
        async : false,
        success :addPreSaleCallBack,
        dataType:'json'
    });
}

/**
 * 添加主表信息回调函数
 */
function addPreSaleCallBack(msg) {
    vm.preSaleCode.val(msg);
    vm.status.val("待审核");
    //获得返回的relationId后给添加自子记录赋值
    $("#relationId").val(vm.preSaleCode.val());
    tabs.add({
        id: "pre_detail",
        menuName: "预售明细",
        url: "module/preSale/preSaleDetail.html"
    });
    tabs.data = {"id": msg, "name": vm.preName.val(), "channelCode": vm.preChannel.val(), examineStatus: vm.status.val()};
    tabs.layout();
}

/**
 * 更新主表信息回调函数
 */
function updtPreSaleCallBack(data) {
    // 这里是请求发送成功后的回调函数。
    // msg是返回的数据，数据类型在type参数里定义！
    if (data.status == "success") {
        callInfoDialog(data.message)
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
    console.log(obj);
    if (content.length != 0) {
        $("#startTime").val(content[0].startTime);
        $("#endTime").val(content[0].endTime);
    }
}

/**
 * 设置input框和按钮的状态
 */
function configurationPage() {
    vm.preChannel.attr('readOnly', 'true');
    vm.preChannel.css({width: "300px", background: "gainsboro"});
    vm.preName.attr('readOnly', 'true');
    vm.preName.css({width: "300px", background: "gainsboro"});
    bt.save.attr('disabled', 'disabled');
    bt.check.attr('disabled', 'disabled');
    bt.cancel.attr('disabled', 'disabled');
}

/**
 * 根据返回值代码，对应名称 预售转预留状态(空和0:未开始  1:执行成功  2:执行失败)
 */
function formatterStatus(cellvalue){
    if(cellvalue==0){
        return '未开始';
    }else if(cellvalue==1){
        return '执行成功';
    }else if(cellvalue==2){
        return '执行失败';
    }
}

//全局参数
var content;
var vm = {}, bt = {};
vm.preSaleCode = $("#preSaleCode");
vm.status = $("#status");
vm.preName = $("#preName");
vm.preChannel = $("#preChannel");
bt.save = $("#bt_save");
bt.check = $("#bt_check");
bt.cancel = $("#bt_cancel");
preSaleDetailloadData();
