<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>库存全量同步测试管理页面</title>
<script type="text/javascript" src="jquery-1.11.2.js">
	
</script>
</head>
<body>
	<script>
		function submit() {
			var data1 = document.getElementById("id_set_scope").value;
			if (!data1) {
				alert("请输入渠道配发范围");
				return;
			}

			var isclear = document.getElementById("id_checkbox").value
					|| "false";
			var b = "mvc/fullstock?scope=" + data1 + "&isClearMock=" + isclear;

			$.post(b, function(data) {

				alert(data);
			});
		};

		function clear111() {
			var b = "mvc/fullstock?isClearMock=true";
			$.post(b, function(data) {
				alert(data);
			});
		};

		function runall() {
			var time = new Date().getTime();
			var b = "mvc/runfull";
			$.post(b, function(begin) {
				return function(data) {
					alert(data + "耗时" + (new Date().getTime() - begin));
				}
			}(time));
			alert("正在执行请等待");
		}

		function initmock() {
			var b = "mvc/initmock";
			$.post(b, function(data) {
				alert(data);
			});
		}

		function showChannelScope() {
			var channel_code = document.getElementById("id_channel_code").value;
			if (!channel_code && channel_code.length < 1) {
				alert("请输入渠道号");
				return;
			}
			$.post("mvc/scope?channelCode=" + channel_code, function(scope) {
				scope = eval(scope);
				var allhtml = "<tr><td>渠道号：</td><td>仓店编号</td></tr>";
				for ( var ch in scope) {
					allhtml += "<tr><td>" + channel_code + "</td><td>"
							+ scope[ch] + "</td></tr>";
				}
				document.getElementById("id_table").innerHTML = allhtml;

			});
		}

		function showChannel() {
			$.post("mvc/channel", function(scope) {
				scope = eval(scope);
				var allhtml = "<tr><td>渠道号：</td></tr>";
				for ( var ch in scope) {
					allhtml += "<tr><td>" + scope[ch] + "</td></tr>";
				}
				document.getElementById("id_table").innerHTML = allhtml;

			});
		}
		
		function showUsefulChannelScope() {
			var channel_code = document.getElementById("id_channel_code").value;
			if (!channel_code && channel_code.length < 1) {
				alert("请输入渠道号");
				return;
			}
			$.post("mvc/useful?channelCode=" + channel_code, function(scope) {
				scope = eval(scope);
				var allhtml = "<tr><td>渠道号：</td><td>仓店编号</td></tr>";
				for ( var ch in scope) {
					allhtml += "<tr><td>" + channel_code + "</td><td>"
							+ scope[ch] + "</td></tr>";
				}
				document.getElementById("id_table").innerHTML = allhtml;

			});
		}
		function showCacheChannelScope() {
			var channel_code = document.getElementById("id_channel_code").value;
			if (!channel_code && channel_code.length < 1) {
				alert("请输入渠道号");
				return;
			}
			$.post("mvc/cachescope?channelCode=" + channel_code, function(scope) {
				scope = eval(scope);
				var allhtml = "<tr><td>渠道号：</td><td>仓店编号</td></tr>";
				for ( var ch in scope) {
					allhtml += "<tr><td>" + channel_code + "</td><td>"
							+ scope[ch] + "</td></tr>";
				}
				document.getElementById("id_table").innerHTML = allhtml;

			});
		}
	</script>

	<h1>全量同步</h1>
	<hr />
	<div>
		<div>
			渠道配发范围：({'渠道code':['仓库code','仓库code']})
			<div>
				<textarea rows="3" cols="30" id="id_set_scope"></textarea>
			</div>
			<div>
				是否覆盖mock数据：<input type="checkbox" id="id_checkbox" /> &nbsp;
				<button onclick="javascript:submit();">设置</button>
				&nbsp;
				<button onclick="javascript:clear111();">清空mock数据</button>
				<button onclick="javascript:initmock();">初始化mock</button>
				<button onclick="javascript:runall();">执行全量同步</button>
			</div>
			<br />
			<div>
				<input id="id_channel_code" size="10" />
				<button onclick="javascript:showChannelScope();">查看渠道和配发范围信息</button>
				<button onclick="javascript:showChannel();">查看渠道列表</button>
				<button onclick="javascript:showUsefulChannelScope();">查看渠道可用仓库</button>
				<button onclick="javascript:showCacheChannelScope();">查看配发范围缓存</button>

			</div>
			<div>
				<table id="id_table">
				</table>
			</div>
</body>
</html>