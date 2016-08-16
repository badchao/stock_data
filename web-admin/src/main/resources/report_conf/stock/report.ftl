<#include "/macro.ftl"/>

<@override name="body">
	<div class="panel panel-default">
		<@renderBoxHeader "图形" kpis />
		<@renderTabs report.charts/>
	</div>
	
	<div class="panel panel-default">
		<@renderBoxHeader "明细数据" kpis />
		<@renderTabs report.tables/>
	</div>
	
</@override>

<#include "/base.ftl"/>

