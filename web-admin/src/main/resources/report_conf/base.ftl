<#include "/macro.ftl"/>

<!-- 父模板，用于其它报表继承 -->

<!DOCTYPE html>
<html lang="en">
<head>
	<@renderHtmlHead/>
	
	<script>
		//百度统计
		var _hmt = _hmt || [];
		(function() {
		  var hm = document.createElement("script");
		  hm.src = "//hm.baidu.com/hm.js?e61de9e67a556cfbbdb00710dfb94bf5";
		  var s = document.getElementsByTagName("script")[0]; 
		  s.parentNode.insertBefore(hm, s);
		})();
	</script>
</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<body>
	<@block name="html">
		
		<div class="report-query">
			<form id="queryForm" action="${ctx}/ReportEngine/report" method="post">
				<input id="reportPath" name="reportPath" value="${reportPath}" type="hidden"/>
				<input id="ctx" value="${ctx}" type="hidden"/>
				<@renderParams report.params/>
			</form>
		</div>
		
		<@block name="body">
			<div class="panel panel-default">
				<@renderBoxHeader "图形" kpis />
				<@renderTabs report.charts/>
			</div>
			
			<div class="panel panel-default">
				<@renderBoxHeader "明细数据" kpis />
				<@renderTabs report.tables/>
			</div>
		</@block>
	</@block>  
</body>
</html>


