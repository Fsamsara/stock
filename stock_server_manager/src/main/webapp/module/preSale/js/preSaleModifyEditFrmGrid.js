//@ sourceURL=preSaleModifyEditFrmGrid.js
function preSaleModifyEditFrmloadData() {
	//传过来的预售调整主表数据
	var masterData=tabs.rowData;
	tabs.rowData=undefined;
	var l_relationId=""; //预售单号
	var l_examineStatus = "0"; //默认进度待审核
	
	//设置调整类型事件
	$('#modifyType').change(modifyTypeSelect_Change); 
	
	var basePath = "/" + ump.mvcContextPath;
	var modularPath = {
		updateUrl : basePath + "/updateStockPreSaleModifyDetail",
		addUrl : basePath + "/addStockPreSaleModifyDetail",
		deleteUrl : basePath + "/deleteStockPreSaleModifyDetail",
		selectUrl_01 : basePath + "/selectStockPreSaleModifyDetailVoList",
		selectUrl_02 : basePath + "/selectStockPreSaleModifyDetailVoList",
		fileUploadUrl : basePath + "/preSaleModifyDetailUpload"
	};
	
	var grid_selector = "#preSaleModifyEditFrmTable";
	var pager_selector = "#preSaleModifyEditFrmPager";
	
    var colNames_01 = [ 'id', 'relationId', '商品编码', '仓库编码', '开始时间', '结束时间', '预售数量', '调整后预售数量', '预售转预留状态', '预售转预留备注' ];
	var colModel_01 = [ { name : 'id', index : 'id', width : 10, hidden : true }, 
	    { name : 'relationId', index : 'relationId', width : 10, hidden : true, editable:true,
		  editoptions : {
			  dataInit : colEditoptionsRelationIdDataInit
		  } }, 
	    { name : 'prodId', index : 'prodId', width : 150, editable:true, 
	      editrules:{ required:true },
		  editoptions : {
			  dataInit : colEditoptionsDataInit
		  } }, 
	    { name : 'warehId', index : 'warehId', width : 120, editable:true, 
		  editrules:{ required:true },
		  editoptions : {
			  dataInit : colEditoptionsDataInit
		  } }, 
	    { name : 'startTime', index : 'startTime', width : 150, editable:true,
		  editoptions : {
				readonly : true
		  } }, 
		{ name : 'endTime', index : 'endTime', width : 150, editable:true,
		  editoptions : {
				readonly : true
		  } }, 
		{ name : 'prePrivateStock', index : 'prePrivateStock', width : 80, editable:true, 
		  editrules:{ required:true, integer:true },
		  editoptions : {
			readonly : true
		  }}, 
		{ name : 'prePrivateStockModify', index : 'prePrivateStockModify', width : 120, editable:true,
		  editrules:{ required:true, integer:true } },
		{
	      name : 'reservedStatus', index : 'reservedStatus', width : 150, editable:false,
	      formatter:formatterStatus
	    },{
	      name : 'reservedRemark', index : 'reservedRemark', width : 150, editable:false
	    }];
	
	var colNames_02 = [ 'id', 'relationId', '商品编码', '开始时间', '结束时间', '调整后结束日期', '预售转预留状态', '预售转预留备注' ];
	var colModel_02 = [ { name : 'id', index : 'id', width : 10, hidden : true },
	    { name : 'relationId', index : 'relationId', width : 10, hidden : true, editable:true,
		  editoptions : {
			  dataInit : colEditoptionsRelationIdDataInit
		  } }, 
	    { name : 'prodId', index : 'prodId', width : 150, editable:true,
		  editrules:{ required:true },
		  editoptions : {
			  dataInit : colEditoptionsDataInit
		  } }, 
	    { name : 'startTime', index : 'startTime', width : 150, editable:true,
		  editoptions : {
			readonly : true
		  } }, 
		{ name : 'endTime', index : 'endTime', width : 150, editable:true, 
	      editrules:{ required:true },
		  editoptions : {
			readonly : true
		  }}, 
		{ name : 'endTimeModify', index : 'endTimeModify', width : 150, editable:true, 
	      editrules:{ required:true },
		  editoptions : {
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
	         }
		}
    },{
    	name : 'reservedStatus', index : 'reservedStatus', width : 150, editable:false,
    	formatter:formatterStatus
    },{
    	name : 'reservedRemark', index : 'reservedRemark', width : 150, editable:false
    }];

	//setGrid(colNames_01, colModel_01);
    //setGridPager();
    
    //按钮的功能
    
	
	var isNewd = false;
	if(masterData==undefined) {
		isNewd = true;
	} else {
		setParentValue(masterData);
	}
	initControlReadOnly();
	
	$('#modifyType').trigger('change');
	
	function initControlReadOnly() {
		var m = $("#modifyType");
		var r = $("#relationId");
		r.attr("readonly",true);
		r.css("background-color","gainsboro");
		var n = $("#name");
		$("#preSaleModifyEditFrm_add").click(addData);
		if(l_examineStatus=="0") { //待审核
			m.removeAttr("disabled");
			m.css("background-color","");
			n.attr("readonly",false);
			n.css("background-color","");
			
			$("#preSaleModifyEditFrm_save").click(saveData);
			$("#preSaleModifyEditFrm_check").click(checkData);
			$("#preSaleModifyEditFrm_cancel").click(cancelData);
			$("#selectPreSale").click(popWindow);
			$("#selectPreSale").attr("readonly",false);
			$("#preSaleModifyEditFrm_save").attr("style","");
			$("#preSaleModifyEditFrm_check").attr("style","");
			$("#preSaleModifyEditFrm_cancel").attr("style","");
			$("#selectPreSale").attr("style","width:95px;color:black;");
		} else {
			m.attr("disabled","disabled");
			m.css("background-color","gainsboro");
			n.attr("readonly",true);
			n.css("background-color","gainsboro");
			
			$("#preSaleModifyEditFrm_save").unbind();
			$("#preSaleModifyEditFrm_check").unbind();
			$("#preSaleModifyEditFrm_cancel").unbind();
			$("#selectPreSale").unbind();
			$("#selectPreSale").attr("readonly",true);
			$("#preSaleModifyEditFrm_save").attr("style","background-color:gainsboro !important; border-color: gainsboro;");
			$("#preSaleModifyEditFrm_check").attr("style","background-color:gainsboro !important; border-color: gainsboro;");
			$("#preSaleModifyEditFrm_cancel").attr("style","background-color:gainsboro !important; border-color: gainsboro;");
			$("#selectPreSale").attr("style","width:95px;color:white;background-color:gainsboro !important; border-color: gainsboro;");
		}
	}
	
	/**
	 * 选择调整类型事件
	 */
	function modifyTypeSelect_Change() { 
		var param = "";
		if(masterData) {
			if(masterData.id){
			    param = "?relationId=" + masterData.id;
			}
		}
//		if(!isNewd) {
//			param = "?relationId=" + masterData.id;
//		}
		var modifyType=$("#modifyType").children('option:selected').val();//这就是selected的值 
		$(grid_selector).jqGrid('GridUnload');
		if(modifyType=="02") { //调整日期
			setGrid(colNames_02, colModel_02, modularPath.selectUrl_02 + param);
		} else { //调整数量
			setGrid(colNames_01, colModel_01, modularPath.selectUrl_01 + param);
		}
		setGridPager();
		
		if(!isNewd) {
			$(grid_selector).jqGrid('setGridParam',{datatype:'json'}).trigger("reloadGrid");
		} else {
		    $(grid_selector).jqGrid('setGridParam',{datatype:'json'});
		}
	}
	function setGrid(colNames, colModel, url) {
		grid(grid_selector, pager_selector, {
			url : url,
			datatype:"local",
			multiselect:true,
			colNames : colNames,
			colModel : colModel,
			rownumbers: true,
			caption : "",
		    height:screen.availHeight-500,
		    gridComplete: onGridComplete
		});
	}
	function setGridPager() {
		if(l_examineStatus=="0") { //待审核
			gridPager(grid_selector, pager_selector, {
				editAction : {
					url : modularPath.updateUrl,
					beforeShowForm : onBbeforeShowForm_Edit
				},
				addAction : {
					url : modularPath.addUrl,
					beforeShowForm : onBbeforeShowForm_Add
				},
				deleteAction : {
					url : modularPath.deleteUrl
				}
			});
			
			$(grid_selector).navButtonAdd(pager_selector, {
				caption: "",
				buttonicon: "fa-file-excel-o purple",
				onClickButton: function(){
					var masterId=$("#id").val();
					if(""==masterId || masterId==null || masterId==undefined) {
						callAlertDialog("添加明细之前,请先保存主表信息");
						return;
					}
					$("#impExcel").modal('show');
					param = "?relationId=" + masterId;
					impExcelData(modularPath.fileUploadUrl + param, "preSaleModifyEditFrm", grid_selector, "mvc/getDownFileTempLate");
				},
				position: "first",
				title: "导入Excel",
				cursor: "pointer"
			});
		} else {
			gridPager(grid_selector, pager_selector, {
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
		}
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
	
	function onGridComplete() {
		if(l_examineStatus=="0") { //待审核
			var rowNum = $(grid_selector).jqGrid('getGridParam','records');
			var m = $("#modifyType");
			var b = $("#selectPreSale");
			if(rowNum>0) {
				m.attr("disabled","disabled");
				m.css("background-color","gainsboro");
				
				b.unbind();
				b.attr("readonly",true);
				b.attr("style","width:95px;color:white;background-color:gainsboro !important; border-color: gainsboro;");
			} else {
				m.removeAttr("disabled");
				m.css("background-color","");
				
				b.click(popWindow);
				b.attr("readonly",false);
				b.attr("style","width:95px;color:black;");
			}
		}
	}
		
	/**
	 * 设置详细页面从父页面带过来的预售主表信息
	 */
	function setParentValue(parentData) {
		masterData=parentData;
		isNewd = parentData.id == undefined || parentData.id==null || parentData.id=="" || parentData.id=="0";
		$("#id").val(parentData.id);
		$("#name").val(parentData.name);
		$("#relationId").val(parentData.relationId);
		$("#channelCode").val(parentData.channelCode);
		l_relationId = parentData.relationId;
		var createBy = $("#createBy").val();
		if(createBy==undefined || createBy==null || createBy=="") {
			$("#createBy").val(parentData.createBy);
			if(parentData.createTime) {
				if(parentData.createTime.toString().length==13) {
				    $("#createTime").val(longTimeToFormatDateTime(parentData.createTime));
				} else {
					$("#createTime").val(parentData.createTime);
				}
			}
		}
		$("#updateBy").val(parentData.updateBy);
		if(parentData.updateTime) {
			if(parentData.updateTime.toString().length==13) {
			    $("#updateTime").val(longTimeToFormatDateTime(parentData.updateTime));
			} else {
				$("#updateTime").val(parentData.updateTime);
			}
		}

		var e = $("#modifyType").find("option[text="+parentData.modifyType+"]");
		e.attr("selected",true);
		
		var examineStatus = parentData.examineStatus;
		if(examineStatus == "0") {
			examineStatus = "待审批";
		} else if(examineStatus == "1") {
			examineStatus = "已审批";
		} else if(examineStatus == "2") {
			examineStatus = "已撤销";
		}
		if(examineStatus == "待审批") {
			l_examineStatus = "0";
		} else if (examineStatus == "已审批") {
			l_examineStatus = "1";
		} else if (examineStatus == "已撤销") {
			l_examineStatus = "2";
		}
		$("#examineStatus").val(examineStatus);
	}
	
	function addData() {
		isNewd = true;
		l_examineStatus = "0";
		masterData = undefined;
		jQuery(grid_selector).jqGrid("clearGridData");
		$("#id").val("");
		$("#name").val("");
		$("#relationId").val("");
		$("#channelCode").val("");
		$("#createBy").val("");
		$("#createTime").val("");
		$("#updateBy").val("");
		$("#updateTime").val("");
		$("#examineStatus").val("");
		initControlReadOnly();
		e = $("#modifyType").find("option[value='01']");
		e.attr("selected",true);
        
		$('#modifyType').trigger('change');
	}
	
    function onBbeforeShowForm_Add(e) {
    	var masterId=$("#id").val();
		if(""==masterId || masterId==null || masterId==undefined) {
			callAlertDialog("添加明细之前,请先保存主表信息");
			throw new error("添加明细之前,请先保存主表信息");
		}
    	var relationId=$("#relationId").val();
    	if(l_relationId!=relationId) {
    		callAlertDialog("预售单号发生过变更,请先保存主表信息");
			throw new error("预售单号发生过变更,请先保存主表信息");
    	}
		onBbeforeShowForm(e, true);
	}
	
	function onBbeforeShowForm_Edit(e) {
		onBbeforeShowForm(e, false);
	}
	
	function onBbeforeShowForm(e, isAdded) {
		var isReadOnlyed=!isAdded;
		var p=e.find("#prodId");
		if(p!=undefined){
			p.attr("readonly",isReadOnlyed);
			p.css("background-color",isReadOnlyed ? "gainsboro" : "");
		}
		w=e.find("#warehId");
		if(w!=undefined){
			w.attr("readonly",isReadOnlyed);
			w.css("background-color",isReadOnlyed ? "gainsboro" : "");
		}
		s=e.find("#prePrivateStock");
		if(s!=undefined){
			s.css("background-color","gainsboro");
		}
		st=e.find("#startTime");
		if(st!=undefined){
			st.css("background-color","gainsboro");
		}
		et=e.find("#endTime");
		if(et!=undefined){
			et.css("background-color","gainsboro");
		}
		
		var form = $(e[0]);
		form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
			.wrapInner('<div class="widget-header" />');
		style_edit_form(form);
	}
	
	function colEditoptionsRelationIdDataInit(ele) {
		$(ele).val($("#id").val());
	}
	
	function colEditoptionsDataInit(ele) {
		$(ele).change(function() {
			var s=$("#prePrivateStock");
			if(s!=undefined){
				s.val("");
			}
			var st=$("#startTime");
			if(st!=undefined){
				st.val("");
			}
			var et=$("#endTime");
			if(et!=undefined){
				et.val("");
			}
			
			
			var relationId = undefined;
			if(masterData) {
				relationId = masterData.relationId;
			}
			
			var prodId = undefined;
			var p = $("#prodId");
			if(p!=undefined) {
				prodId = p.val();
			}
						
			var warehId = undefined;
			var w = $("#warehId");
			if(w!=undefined) {
				warehId = w.val();
			}
			
			if(prodId=="") {
				return;
			}
			if(warehId=="") {
				return;
			}
			
			if(warehId == undefined || warehId == "undefined" || warehId == "null") {
				warehId = "";
			}
			
			var jsonData = "relationId="+relationId+"&prodId="+prodId+"&warehId="+warehId;
			
			$.ajax({  
			    url: basePath + '/selectStockPreSaleModifiedDetail',
			    type: "POST",                     
	            dataType: "html", 
			    data:jsonData,  
			    async:false, 
			    success:function(data){ 
				    if(data == "" || data == null || data == "null"){
				    	callAlertDialog("没有查询到数据");
				    } else {
				    	eval("data="+data);
				    	var s=$("#prePrivateStock");
						if(s!=undefined){
							s.val(data.prePrivateStock);
						}
						var st=$("#startTime");
						if(st!=undefined){
							st.val(longTimeToFormatDateTime(data.startTime));
						}
						var et=$("#endTime");
						if(et!=undefined){
							et.val(longTimeToFormatDateTime(data.endTime));
						}
				    }
			    },  
			    error:function(){}  
		    }); 
			
			var s="";
		});
	}
	
	//yyyy-MM-dd hh:mm:ss (1398250549490)
	function longTimeToFormatDateTime(longTime){
		var date = new Date(longTime);
		Y = date.getFullYear() + '-';
		M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		D = date.getDate() + ' ';
		h = date.getHours() + ':';
		m = date.getMinutes() + ':';
		s = date.getSeconds(); 
		return Y+M+D+h+m+s;
	}
	
	//1398250549490 (2014-04-23 18:55:49)
	function FormatDateTimeToLongTime(formatDateTime){
		var date = new Date(formatDateTime);
		return date.getTime();
	}
	
	function saveData() { //保存
		var master = {};
		master.id = $("#id").val();
		master.name = $("#name").val();
		if(master.name==undefined || master.name=="") {
			callAlertDialog("调整单名称不能为空");
		}
		master.relationId = $("#relationId").val();
		if(master.relationId==undefined || master.relationId=="") {
			callAlertDialog("预售单号不能为空");
		}
		master.channelCode = $("#channelCode").val();
		var e = $("#modifyType");
		master.modifyType = e.val();
		
		var paramObj = {};
		paramObj.master = master;
		var o = {};
		o.json = paramObj;
		var jsonData = JSON.stringify(paramObj);
	    $.ajax({  
		    url: basePath + '/saveStockPreSaleModify',
		    type: "POST",                     
            dataType: "html", 
		    data:"json="+jsonData,  
		    async:false, 
		    success:function(data){ 
			    eval("data="+data);
			    if(data.sucess){
			  	    setParentValue(data.master);
			  	    callAlertDialog("保存成功");
			  	    modifyTypeSelect_Change();
			    } else {
			    	callAlertDialog(data.msg);
			    }
		    },  
		    error:function(){}  
	    }); 
	}
	
	function checkData() {  //审批
		var master = {};
		master.id = $("#id").val();
		if(master.id==undefined || master.id=="") {
			callAlertDialog("调整单号不能为空");
		}
		master.name = $("#name").val();
		if(master.name==undefined || master.name=="") {
			callAlertDialog("调整单名称不能为空");
		}
		master.relationId = $("#relationId").val();
		if(master.relationId==undefined || master.relationId=="") {
			callAlertDialog("预售单号不能为空");
		}
		master.channelCode = $("#channelCode").val();
		var e = $("#modifyType");
		master.modifyType = e.val();
		
		var paramObj = {};
		paramObj.master = master;
		var o = {};
		o.json = paramObj;
		var jsonData = JSON.stringify(paramObj);
	    $.ajax({  
		    url: basePath + '/submitFlowStockPreSaleModify',
		    type: "POST",                     
            dataType: "html", 
		    data:"json="+jsonData,  
		    async:false, 
		    success:function(data){ 
			    eval("data="+data);
			    if(data.sucess){
			  	    setParentValue(data.master);
			  	    callAlertDialog("审批成功");
			  	    initControlReadOnly();
			  	    modifyTypeSelect_Change();
			    } else {
			    	callAlertDialog(data.msg);
			    }
		    },  
		    error:function(){}  
	    }); 
	}
	
	function cancelData() {  //撤单
		var master = {};
		master.id = $("#id").val();
		if(master.id==undefined || master.id=="") {
			callAlertDialog("调整单号不能为空");
		}
		master.name = $("#name").val();
		master.relationId = $("#relationId").val();
		master.channelCode = $("#channelCode").val();
		var e = $("#modifyType");
		master.modifyType = e.val();
		
		var paramObj = {};
		paramObj.master = master;
		var o = {};
		o.json = paramObj;
		var jsonData = JSON.stringify(paramObj);
	    $.ajax({  
		    url: basePath + '/cancelFlowStockPreSaleModify',
		    type: "POST",                     
            dataType: "html", 
		    data:"json="+jsonData,  
		    async:false, 
		    success:function(data){ 
			    eval("data="+data);
			    if(data.sucess){
			  	    setParentValue(data.master);
			  	    callAlertDialog("撤单成功");
			  	    initControlReadOnly();
			   	    modifyTypeSelect_Change();
			    } else {
			    	callAlertDialog(data.msg);
			    }
		    },  
		    error:function(){}  
	    }); 
	}
};

preSaleModifyEditFrmloadData();

function popWindow(){
	$("#popPreSale").modal('show');
}

function callPreSaleData(rowData){ //回调数据，设置预售单号、渠道编码的值
    if(rowData) {
		$("#relationId").val(rowData.id);
		$("#channelCode").val(rowData.channelCode);
    } else {
    	$("#relationId").val("");
		$("#channelCode").val("");
    }
}
