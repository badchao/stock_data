<#include '/macro.ftl'/>
<script src="${ctx}/js/jquery.min.js?version=2.1.1"></script>
<input type="hidden" id="ctx" value="">
<form id="queryForm" action="${ctx}/ReportEngine/frameset" method="post">
	<input id="reportPath" name="reportPath" value="${reportPath}" type="hidden"/>
	<input id="ctx" value="${ctx}" type="hidden"/>
	<@renderParams report.params/>
</form>
