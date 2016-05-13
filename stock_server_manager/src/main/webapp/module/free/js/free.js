/*
 * 
 * 
<div>
	门店编码<br /> <input type="text" id="warehId1"
		onkeydown="doSearch1(arguments[0]||event)" />
</div>
<div>
	商品编码(支持多个,用逗号分开)<br> <input type="text" id="prodId1"
		onkeydown="doSearch1(arguments[0]||event)" />
	<button onclick="gridReload1()" id="submitButton1"
		style="margin-left: 30px;">查询</button>
</div>
<br />
<!-- <div id="jqgrid"> -->
<!--     <table id="shopDame-grid-table"></table> -->
<!--     <div id="shopDame-grid-pager"></div> -->
<!-- </div> -->
<table id="jqgrid1"></table>
<div id="pagerb1"></div>
<script src="module/free/js/shopfree.js" ></script>
 * 
 * */

//@ sourceURL=free.js
$(function(){
  pageInit1();
});
function pageInit1(){
  jQuery("#jqgrid1").jqGrid({
    datatype : "local",
    height : 255,
    colNames : [ '门店编码', '商品11位码', '自由量' ],
    colModel : [ 
                 {name : 'warehId', index : 'warehId', width : 150, editable : false, sorttype : "string"}, 
                 {name : 'prodId', index : 'prodId', width : 150, editable : false},
                 {name : 'freeShareStock', index : 'freeShareStock', width : 250, editable : false} 
               ],
    //rowNum : 12,
    mtype : "GET",
    pager : jQuery('#pagerb1'),
    pgbuttons : false,
    pgtext : false,
    pginput : false,
    //sortname : 'prodId',
    //viewrecords : true,
    //sortorder : "asc",
    caption : "门店自由量查询",
    rownumbers: true,
    autowidth : true
  });
}
var timeoutHnd;
var flAuto = false;
function doSearch1(ev) {
  if (!flAuto)
    return;
  if (timeoutHnd)
    clearTimeout(timeoutHnd);
    timeoutHnd = setTimeout(gridReload, 500);
}
function gridReload1() {
  var warehId = jQuery("#warehId1").val()||"";
  if(warehId==null || warehId==""){
	  alert("门店编码不能为空");
	  return;
  }
  var prodId = jQuery("#prodId1").val()||"";
  if(prodId==null || prodId==""){
	  alert("商品编码不能为空");
	  return;
  }
  var skuList = prodId.split(",");
  var paramObj = {};  
  paramObj.warehId = warehId;  
  paramObj.skuList = skuList;
  var jsonData = JSON.stringify(paramObj);
  
  $.ajax({  
	  type:'get',  
	  url:'/' + ump.contextPath + '/qryFreeShareStock?json='+jsonData,  
	  data:{},  
	  cache:false,  
	  dataType:'json',  
	  success:function(data){  
		  if(data.sucessed){
			  loadingData1(data.qryFreeShareStockVoList);
		  } else {
			  alert(data.msg);
		  }
	  },  
	  error:function(){}  
  }); 
}
function loadingData1(data) {
  jQuery("#jqgrid1").jqGrid("clearGridData");
  for ( var i = 0; i <= data.length; i++){
	jQuery("#jqgrid1").jqGrid('addRowData', i + 1, data[i]);
  }
}
function enableAutosubmit1(state) {
  flAuto = state;
  jQuery("#submitButton1").attr("disabled", state);
}
var style=$("#prodId1").attr("style");
var ws="width:"+($(window).width()*0.75-100)+"px;";
if(style!=undefined){
  ws=style+ws;
}
$("#prodId1").attr("style",ws);
$("#jqgrid1").setGridWidth($(window).width()*0.75);
$(window).bind('resize', function() {
	$("#jqgrid1").setGridWidth($(window).width()*0.75);
	//$("#jqgrid1").setGridHeight($(window).height()*0.68);
});