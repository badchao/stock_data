<#include "/beta_macro.ftl"/>

<#assign tipId=0 />
<#macro renderHtmlHead>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>${report.tiele!}</title>
		
		<!--
		<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
    	<link href="${ctx}/css/bootstrap-theme.css"  rel="stylesheet" />
    	-->
    	<link href="${ctx}/css/bootstrap-cerulean.min.css" rel="stylesheet"  media="screen"/>
    	
		<script src="${ctx}/js/jquery.min.js"></script>
		<script src="${ctx}/js/jquery.cookie.js"></script>
		<script src="${ctx}/js/bootstrap.min.js"></script>
		
		<!--
		<script src="${ctx}/js/bootstrap-tooltip.js"></script>
		<script src="${ctx}/js/bootstrap-popover.js"></script>
		-->
		<script src="${ctx}/js/bootstrap-tab.js"></script>
		
		<!-- bootstrap-sortable -->
    	<script src="${ctx}/js/bootstrap-sortable.js"></script>
		<link href="${ctx}/css/bootstrap-sortable.css" rel="stylesheet">
		
		<script src="${ctx}/js/jquery.filtertable/jquery.filtertable.min.js"></script>
		
		<script src="${ctx}/js/tablefix/tablefix.js?version=2016-04-13"></script>
		<script src="${ctx}/js/tablemerge/tablemerge.js"></script>
		<script src="${ctx}/js/table_dynamic_show_columns/table_dynamic_show_columns.js"></script>
		
		<!-- multiple-select -->
		<link href="${ctx}/js/multiple-select/multiple-select.css" rel="stylesheet"/>
		<script src="${ctx}/js/multiple-select/jquery.multiple.select.js"></script>
		
		<!-- highcharts -->
		<script src="${ctx}/js/highcharts/highcharts.js"></script>
	    <script src="${ctx}/js/highcharts/modules/exporting.js"></script>
	    <script src="${ctx}/js/highcharts/highchartsUtil.js"></script>
	    
	    <!-- my97 date picker -->
   		<script src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
   		
   		<script src="${ctx}/js/comPeriods/comPeriods.js"></script>
   		
   		<script src="${ctx}/js/jquery.i18n.properties-min-1.0.9.js"></script>
   		
	    <!-- 日常使用函数 -->
   		<script src="${ctx}/js/function.js"></script>
   		
   		<link href="${ctx}/css/portal.css" rel="stylesheet" />
   		<link href="${ctx}/css/global.css" rel="stylesheet" />


	    <style type="text/css">
			.div-space {
				margin-left: 15px;
				margin-right: 15px;
			}
			#queryPanel {
				height : 28px;
			}
			.multiple-select-from {
				padding:0px;
				border:0px;
			}
			.input-from-control {
				height: 32px;
			    line-height: 1;
			}
	    </style>
	
	    <@block name="head"></@block>  
</#macro>

<#macro renderKpiPopoverDesc kpis regexKpis mergeKpi=true>
	<#if mergeKpi>
		<#assign mergedKpis = regexKpis + kpis />
	<#else>
		<#assign mergedKpis = kpis />
	</#if>
</#macro>

<#macro renderDownloadButton>
		<#if report.tables?? && report.tables?size &gt; 0 >
			<div class="box-icon">
				<form action="${ctx}/ReportEngine/download" >
					<input type="hidden" name="reportPath" value="${reportPath}"/>
					<select id="downloadSelect" name="table">
							<#list report.tables as table>
								<option value="${table.id}">${table.title}</option>
							</#list>
					</select>
					<input type="submit" value="下载"></input>
				</form>
			</div>
		</#if>
</#macro>

<#macro renderBoxHeader title kpis=[] showDownloadUrl=false mergeKpi=true>
		<div class="panel-heading">
			${report.getMessage(title)!}
			<#if showDownloadUrl>
				<@renderDownloadButton/>
			</#if>
			<@renderKpiPopoverDesc kpis report.getKpis() mergeKpi/>
		</div>
	<#assign tipId=tipId+1 />
</#macro>

<#-- 渲染tabs, 参数示例: tabs : ['chart1','chart2','chart3'] -->
<#macro renderTabs tabs>
	<div class="tabbable">
	
		<ul class="nav nav-tabs">
			<#list tabs as tab>
				<#assign tabTitle = report.getElementById(tab).title/>
				<#assign tabId = report.getElementById(tab).id/>
				<li <#if tab_index=0> class="active" </#if> ><a href="#tab_${tabId}" data-toggle="tab">${tabTitle}</a></li>
			</#list>
			 
		</ul>
		
		<div class="tab-content">
			<#list tabs as tab>
				<#assign tabId = report.getElementById(tab).id/>
				<div class="table-responsive tab-pane <#if tab_index=0> active </#if>" id="tab_${tabId}">
					<@renderObject tab/>
				</div>						
			</#list>				
		</div>
		
	</div>
</#macro>




