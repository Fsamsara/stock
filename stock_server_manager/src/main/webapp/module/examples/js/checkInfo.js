(function($){
    $.fn.checkInfo = function(params){
        /**
         * userIDCell 用户ID列
         * userCell 用户名列
         * th 表格列名称
         * data 表格内容
         * tableWidth 表格宽度
         * tableListText 选择列表头部标题
         * tableListResultText 当前选择列表标题
         * tableList 选择列表选择器
         * tableListResult 当前选择列表选择器
         * userID 用户ID选择器
         * user 用户名选择器
         * pop 弹出框ID选择器
         */
        var defaults = {
            userIDCell          : "1",
            userCell            : "3",
            th                  : ["用户ID","时间","姓名"],
            data                : [["1005","08:01","李天"],["1001","08:01","李天"],["1004","09:01","张三"],["1006","07:01","王五"]],
            tableWidth          : "100%",
            tableListText       : "选择列表",
            tableListResultText : "当前选择列表",
            tableList           : "#tableList",
            tableListResult     : "#tableListResult",
            userID              : "#userID",
            user                : "#user",
            pop                 : "#pop"
        };  
        var opts = $.extend(defaults, params);
        
        $(this).click(function(){
            //显示模态框
            $(opts.pop).modal('show');

            var html = "<div class='menu-header'>"+ opts.tableListText +"</div>";
				if(opts.data.length > 8){
            		html += "<div style='width:346px; height:392px; overflow:auto;'>";
            	}
				if(opts.th.length > 3){
					opts.tableWidth = (opts.th.length*101+30)+"px";
				}
                html += "<table style='width:"+ opts.tableWidth +"' class='mh-table table table-striped table-bordered'>";
                html += "<tr style='background:#f9f9f9;'>";
                html += "<td width='30' align='center'><input type='checkbox' class='searchCheckbox' /></td>";
            for(var i = 0; i < opts.th.length; i++){
                html += "<td>" + opts.th[i]+ "</td>";
            }
            html += "</tr>";
            $(tableListResult).html(html);
            $(tableListResult).find(".menu-header").text(opts.tableListResultText);
            
            var arr = opts.data;
            arr.sort(function(x,y){
                return x[0] - y[0];
            });

            html += "<tbody>";
            for(i = 0; i < arr.length; i++){
                html += "<tr>";
                html += "<td width='30' align='center'><input type='checkbox' name='cb' /></td>";
                for(var j = 0; j < arr[i].length; j++)
                {
                    html += "<td>" + arr[i][j] +"</td>";
                }
                html +="</tr>";
            }
            html += "</tbody>";
            $(opts.tableList).html(html);
        });        

        //全选
        var all_checked = false;
        $(document).on('click',':checkbox',function(){
            var table = $(this).parents("table");
            if($(this).attr("class") === "searchCheckbox") {
                table.find(":checkbox").prop("checked", !all_checked);
                all_checked = !all_checked;
            }
            else {
                table.find(":checkbox[class!=searchCheckbox]").each(function (i) {
                    if(!$(this).is(":checked")) {
                        table.find(".searchCheckbox").prop("checked", false);
                        all_checked = false;
                        return false;
                    }
                    table.find(".searchCheckbox").prop("checked", true);
                    all_checked = true;
                });
            }
        });

        //添加
        $(document).on('click','#addReference',function(){
            var html ="";
                html += "<tbody>";
            $(tableList).find("tr:gt(0) input:checkbox:checked").each(function() {
                html += "<tr>" + $(this).parent().parent().html() + "</tr>";                
            });
            html += "</tbody>";
            $(tableListResult).find("table tr:gt(0)").remove();
            $(tableListResult).find("table").append(html);
        });       

        //移除
        $(document).on('click','#removeReference',function(){
            $(tableListResult).find("tr:gt(0) input:checkbox:checked").each(function() {
                $(this).parent().parent().remove();                
            });
            if($(tableListResult).find("tr:gt(0) input:checkbox:checked").length == 0){
                $(tableListResult).find(".searchCheckbox").attr("checked",false);
            }
        });

        //保存
        $(document).on('click','#saveReference',function(){
            var array = $(tableListResult).find("input[type=checkbox]:gt(0)").map(function(){          
                return { 
                    "cell1": $.trim($(this).closest("tr").find("td:eq("+ opts.userIDCell +")").text()), 
                    "cell2": $.trim($(this).closest("tr").find("td:eq("+ opts.userCell +")").text()) 
                };
            }).get();

            $.each(array, function (i, d) {
                if($(opts.userID).val().indexOf(d.cell1+",") <0){
                    $(opts.userID).val($(opts.userID).val() + d.cell1 +",");
                    $(opts.user).val($(opts.user).val() + d.cell2 +",");
                }
            });

            //隐藏模态框
            $(opts.pop).modal('hide');
        });
    };
})(jQuery);