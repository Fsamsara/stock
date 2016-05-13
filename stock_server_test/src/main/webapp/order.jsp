<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="jquery-1.11.2.js"></script>
<title>Inserttitle here</title>
</head>
<body>
	<script type="text/javascript">
		var arr_name = [ "channelCode", "secondOccFlag", "isFullCirculation","isPreOccupy",
				"businessId", "subOrderId", "osOrderId", "prodId",
				"occupyStock" ];

		function addItem() {
			var row = $("#id_table_tmp").html();
			$("#id_table").html($("#id_table").html() + row);
		}

		function sumitOcc() {
			var all_str = "[";
			$("#id_table").find("tr").each(
					function() {
						var inputs = $(this).find("input");
						if (!inputs || inputs.size() == 0) {
							return;
						}
						var sumstr = "{";
						for (var i = 0; i < inputs.length; i++) {
							var tmpValue = $(inputs[i]).val();
							if (tmpValue && tmpValue != '') {
								sumstr += "'" + arr_name[i] + "':'"
										+ $(inputs[i]).val() + "',";
							}
						}
						sumstr = sumstr.substring(0, sumstr.length - 1);
						sumstr += "}";
						all_str += sumstr + ",";
					});
			all_str = all_str.substring(0, all_str.length - 1);
			all_str += "]";

			$.post("mvc/occOrder?param=" + all_str, function(scope) {
				alert(scope)

			});
		}

		function sumitRess() {
			var all_str = "[";
			$("#id_table").find("tr").each(
					function() {
						var inputs = $(this).find("input");
						if (!inputs || inputs.size() == 0) {
							return;
						}
						var sumstr = "{";
						for (var i = 0; i < inputs.length; i++) {
							var tmpValue = $(inputs[i]).val();
							if (tmpValue && tmpValue != '') {
								sumstr += "'" + arr_name[i] + "':'"
										+ $(inputs[i]).val() + "',";
							}
						}
						sumstr = sumstr.substring(0, sumstr.length - 1);
						sumstr += "}";
						all_str += sumstr + ",";
					});
			all_str = all_str.substring(0, all_str.length - 1);
			all_str += "]";

			$.post("mvc/ressOrder?param=" + all_str, function(scope) {
				alert(scope);
			});
		}
		function del(e) {
			var arr = $(e).parent("tr");
			var item = $(arr[0]);
			item.remove();
		}
	</script>
	<button onclick="addItem()">添加</button>
	<button onclick="sumitOcc()">订单预占</button>
	<button onclick="sumitRess()">订单取消</button>
	<table id="id_table">
		<tr>
			<td>渠道编码</td>
			<td>是否第二次占用</td>
			<td>是否全流通</td>
			<td>是否预售</td>
			<td>外部交易号</td>
			<td>子单号</td>
			<td>os订单号</td>
			<td>商品id</td>
			<td>预占量</td>
			<td>删除</td>
		</tr>
		<tr>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<!-- <td><button onclick="del(this)">删除</button></td> -->
		</tr>
	</table>

	<table id="id_table_tmp" style="display: none">
		<tr>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
			<td><input value="" /></td>
		</tr>
	</table>
</body>
</html>