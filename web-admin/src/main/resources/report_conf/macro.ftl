<#include "/custom_macro.ftl"/>

<#function filter things name value>
    <#local result = []>
    <#list things as thing>
        <#if thing[name] == value >
            <#local result = result + [thing]>
        </#if>
    </#list>
    <#return result>
</#function>

<#function filterStartsWith things name value>
    <#local result = []>
    <#list things as thing>
        <#if thing[name]?starts_with(value) >
            <#local result = result + [thing]>
        </#if>
    </#list>
    <#return result>
</#function>

<#macro renderParamsBoxHeader>
		<div class="panel-heading">
			<div id="queryPanel" class="panel-title">
				${report.title!} 
				<div id="beforeN30Div" class="pull-right div-space" style="display:none;">
					<input type="button" class="btn btn-primary btn-sm" value="${report.getMessage('最近30天')}" onclick="getBeforeDay(-30);this.form.submit();">
				</div>					
				<div id="beforeN7Div" class="pull-right div-space" style="display:none;">
					<input type="button" class="btn btn-primary btn-sm" value="${report.getMessage('最近7天')}" onclick="getBeforeDay(-7);this.form.submit();">
				</div>
				<div id="nextDateDiv" class="pull-right div-space">
					<input type="button" class="btn btn-primary btn-sm" value="${report.getMessage('后一天')}" onclick="scrollStartDateEndDate(1);this.form.submit();">
				</div>
				<div id="preDateDiv" class="pull-right div-space">
					<input type="button" class="btn btn-primary btn-sm" value="${report.getMessage('前一天')}" onclick="scrollStartDateEndDate(-1);this.form.submit();">
				</div>
				<div id="queryDiv" class="pull-right div-space">
					<input type="button" class="btn btn-primary btn-sm" onclick="this.form.submit();" value="${report.getMessage('查询')}">
				</div>
			</div>
			<script type="text/javascript">
			 //前N天
			  Date.prototype.format = function(fmt)
			  {
				    var o = {
				      "M+" : this.getMonth()+1,                 //月份
				      "d+" : this.getDate(),                    //日
				      "h+" : this.getHours(),                   //小时
				      "m+" : this.getMinutes(),                 //分
				      "s+" : this.getSeconds(),                 //秒
				      "q+" : Math.floor((this.getMonth()+3)/3), //季度
				      "S"  : this.getMilliseconds()             //毫秒
				    };
				    if(/(y+)/.test(fmt))
				      fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
				    for(var k in o)
				      if(new RegExp("("+ k +")").test(fmt))
				    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
				    return fmt;
			  }
			  
			  function getDate(day){
				      var edate=new Date( new Date().getTime()  + (day*24*60*60*1000) ).format("yyyy-MM-dd");
				      return edate;
			  }
			
			 /* 
			   将String类型解析为Date类型. 
			   parseDate('2006-1-1') return new Date(2006,0,1) 
			   parseDate(' 2006-1-1 ') return new Date(2006,0,1) 
			   parseDate('2006-1-1 15:14:16') return new Date(2006,0,1,15,14,16) 
			   parseDate(' 2006-1-1 15:14:16 ') return new Date(2006,0,1,15,14,16); 
			   parseDate('2006-1-1 15:14:16.254') return new Date(2006,0,1,15,14,16,254) 
			   parseDate(' 2006-1-1 15:14:16.254 ') return new Date(2006,0,1,15,14,16,254) 
			   parseDate('不正确的格式') retrun null 
			 */  
			 function parseDate(str){  
				   if(typeof str == 'string'){  
				     var results = str.split("-");
				     if(results && results.length>=3)  {
				      return new Date(parseFloat(results[0]),parseFloat(results[1]) - 1,parseFloat(results[2]));   
				     }
				   }  
				   throw new Error("cannot parse str for date:"+str);  
			 }
			 
			  /**
			   *函数功能 :前N天
			   */
			 function getBeforeDay(days){
					 if(document.getElementById('startDate')!=null){
				     	document.getElementById('startDate').value = getDate(days);
					 }
				     if(document.getElementById('endDate')!=null){
				     	document.getElementById('endDate').value = getDate(-1);
					 }
			   }
			  
			   /**
			    * 函数功能 :startDate,endDate滚动n天, n可以为正负数
			    */
			   function scrollStartDateEndDate(ndays){
				   scrollDateById(ndays,'startDate');
				   scrollDateById(ndays,'endDate');
				   scrollDateById(ndays,'realTime');
			   }
			   
			   /**
			   * 函数功能 :日期滚动n天, n可以为正负数
			   */
			   function scrollDateById(ndays,elementId) {
			   	   var dateElement = document.getElementById(elementId);
				   if(dateElement != null){
				      var oldDate = parseDate(dateElement.value);
				      var newDateNum = oldDate.getTime() + ndays * ( 24 * 3600 * 1000);
				      var newDateString = new Date(newDateNum).format("yyyy-MM-dd");
				      document.getElementById(elementId).value = newDateString;
				   }
			   }
			   
			   $(document).ready(function(){
			   		if( document.getElementById("startDate") && document.getElementById("endDate") ) {
			   			$('#beforeN30Div').show();
			   			$('#beforeN7Div').show();
			   		}
			   })
   			</script>	
		</div>   				
</#macro>

<#macro renderParams paramDefs>
	<div class="panel panel-default">
		<@renderParamsBoxHeader/>
		
		<#list filter(paramDefs,'hidden',true) as paramDef>
			<@renderParam paramDef/>
		</#list>
			
		<table border="0" class="table  table-condensed">
			<tr style="magin-bottom:5px;">
				<td>
					<#list filter(paramDefs,'hidden',false)?chunk(3) as paramDefRow>
							<div class="row col-xs-12" style="margin-top:3px;margin-bottom:3px;">
							<#list paramDefRow as paramDef>
								<div class="col-xs-4"><@renderParam paramDef/></div>
							</#list>
							</div>
					</#list>
				</td>
			</tr>
		</table>
	</div>
</#macro>

<#macro renderParam paramDef>
	<#assign paramValue = paramDef.stringValue!>
	
	<#if paramDef.hidden>
		<input type="hidden" id="${paramDef.id}" name="${paramDef.id}" value="${paramValue}" />
	<#else>
		
		<div class="input-group">
		<#if paramDef.label??>
		<div class="input-group-addon">${paramDef.label}</div>
		</#if>
		
		<#if paramDef.displayType == 'select'>
				<select class="form-control input-from-control multiple-select-from" id="${paramDef.id}" name="${paramDef.id}" placeholder="${paramDef.label}" onchange="this.form.submit();" <#if paramDef.readonly>disabled="disabled"</#if> >
					<#list paramDef.dataList as row>
						<#assign valueInterpret = row[paramDef.valueExpr]>
						<#assign labelInterpret = row[paramDef.labelExpr]!row[paramDef.valueExpr]>
						<option <#if paramValue?string == valueInterpret?string >selected="selected"</#if> value="${valueInterpret}">${labelInterpret}</option> 
					</#list>
				</select>
				<script>
				        $("#${paramDef.id}").multipleSelect({
				            filter: true,
				            single: true,
				            onOpen: function() {
						    	resetParentIframe();
						    },
						    onClose: function() {
						    	resetParentIframe();
						    },
						    onBlur : function() {
						    	resetParentIframe();
						    }
				        });
				</script>
		<#elseif paramDef.displayType == 'radio'>
			<div class="btn-group" data-toggle="buttons-radio" style="width:${paramDef.dataList?size * 40}px">
				<input type="hidden"  id="${paramDef.id}" name="${paramDef.id}" value="${paramValue}" />
				<#list paramDef.dataList as row>
					<#assign valueInterpret = row[paramDef.valueExpr]>
					<#assign labelInterpret = row[paramDef.labelExpr]>
				   <button type="button" class="btn btn-primary btn-sm  <#if paramValue?string == valueInterpret?string >active</#if>" name="${paramDef.id}" id="radio_${paramDef.id}" value="${valueInterpret}" onclick="$('#${paramDef.id}').val(this.value); this.form.submit();">${labelInterpret}</button>
				</#list>	
			</div>									
		<#elseif paramDef.displayType == 'radio'>
				<#list paramDef.dataList as row>
					<#assign valueInterpret = row[paramDef.valueExpr]>
					<#assign labelInterpret = row[paramDef.labelExpr]>
					<input  class="form-control input-from-control" name="${paramDef.id}" type="${paramDef.displayType}" <#if paramValue?string == valueInterpret?string >checked='checked'</#if> value="${valueInterpret}" onclick="this.form.submit();">${labelInterpret}</input>
				</#list>
		<#elseif paramDef.displayType == 'checkbox'>
				<#list paramDef.dataList as row>
					<#assign valueInterpret = row[paramDef.valueExpr]>
					<#assign labelInterpret = row[paramDef.labelExpr]>
					<#assign checked>
						<#compress>
						<#if paramValue?is_string>
							<#if paramValue?string == valueInterpret?string>checked='checked'</#if>
						<#else> 
							<#if paramValue?seq_contains(valueInterpret)>checked='checked'</#if> 
						</#if>
						</#compress>
					</#assign>
					<input  class="form-control input-from-control" name="${paramDef.id}" type="${paramDef.displayType}" value="${valueInterpret}" ${checked}  >${labelInterpret}</input>
				</#list>
		<#elseif paramDef.displayType == 'multiple-select'>
				<#-- 提交一个空值，避免multiple-select不提交值，导致无法覆盖服务端的cookie值的问题 -->
				<input type="hidden"  name="${paramDef.id}"/>
				<select class="form-control input-from-control multiple-select-from" id="${paramDef.id}" name="${paramDef.id}" multiple="multiple">
					<#list paramDef.dataList as row>
						<#assign valueInterpret = row[paramDef.valueExpr]>
						<#assign labelInterpret = row[paramDef.labelExpr]>
						<#assign selected>
							<#compress>
							<#if paramValue?is_string>
								<#if paramValue?string == valueInterpret?string>selected='selected'</#if>
							<#else> 
								<#if paramValue?seq_contains(valueInterpret)>selected='selected'</#if> 
							</#if>
							</#compress>
						</#assign>
						<option value="${valueInterpret}" ${selected}>${labelInterpret}</option>
					</#list>		
				</select>
				<script>

				<#assign language = session.getAttribute("language") />
				
				<#if language == 'zh'>
					<#assign 全选 = '全选' />
					<#assign 已选全部 = '已选全部' />
				<#elseif language == 'en'>
					<#assign 全选 = 'select all' />
					<#assign 已选全部 = 'select all' />
				<#elseif language == 'vi'>
					<#assign 全选 = 'Chọn hết ' />
					<#assign 已选全部 = 'Tất cả các lựa chọn' />
				</#if>	
								
				        $("#${paramDef.id}").multipleSelect({
				            filter: true,
				            selectAllText: "${全选}",
				            allSelected:   "${已选全部}",
        					countSelected: "已选 # 个",
				            onOpen: function() {
						    	resetParentIframe();
						    },
						    onClose: function() {
						    	resetParentIframe();
						    },
						    onBlur : function() {
						    	resetParentIframe();
						    }
				        });
				</script>
		<#elseif paramDef.displayType == 'date'>
		
				<#assign language = session.getAttribute("language") />
				
				<#if language == 'zh'>
					<input class="form-control input-from-control" id="${paramDef.id}" name="${paramDef.id}" type="text" value="${paramValue}" title="${paramDef.help!}" placeholder="${paramDef.label}" onfocus="WdatePicker({isShowWeek:true})" onchange="this.form.submit();">
				<#elseif language == 'en'>
					<input class="form-control input-from-control" id="${paramDef.id}" name="${paramDef.id}" type="text" value="${paramValue}" title="${paramDef.help!}" placeholder="${paramDef.label}" onfocus="WdatePicker({isShowWeek:true,lang:'en'})" onchange="this.form.submit();">
				<#elseif language == 'vi'>
					<input class="form-control input-from-control" id="${paramDef.id}" name="${paramDef.id}" type="text" value="${paramValue}" title="${paramDef.help!}" placeholder="${paramDef.label}" onfocus="WdatePicker({isShowWeek:true,lang:'en'})" onchange="this.form.submit();">				
				</#if>	
				
		<#else>
				<input class="form-control input-from-control" name="${paramDef.id}" type="${paramDef.displayType}" value="${paramValue}" title="${paramDef.help!}" placeholder="${paramDef.label}" onchange="this.form.submit();" <#if paramDef.readonly>readonly="readonly"</#if>>
		</#if>
		
		
		</div>
     </#if>		
</#macro>

<#macro renderChart chart>
		<div id="${chart.id}" style="width:99%;">
		</div>
		<script type="text/javascript">
			$(function () {
				var jsonStr = ${report.getElementById('${chart.id}').toJson()};
				highchartsUtil.chart("${chart.id}",jsonStr); 
		    });
		</script> 
</#macro>

<#macro renderTable table showTitle=true>
	<#if showTitle>
	<div class="panel-heading">
		<span class="pull-left"><b>${report.getMessage('数据记录数')}:</b>${table.dataList?size} <span class="filter-table">&nbsp;&nbsp;&nbsp; <b>Filter:</b> <input id="table_filter_input_${table.id}" type="search" placeholder="search this table" name=""></span></span>&nbsp;&nbsp;&nbsp;
		<div class="pull-right">
			<a title="下载表格数据" href="${ctx}/ReportEngine/download?table=${table.id}&reportPath=${reportPath}"><span class="glyphicon glyphicon-save" style="font-size: 18px" aria-hidden="true"></span></a>
			&nbsp;&nbsp;
			<a title="调整表格" href="#" onclick="return false;" id='dynamic_show_table_columns_${table.id}'><span class="glyphicon glyphicon-th" style="font-size: 18px" aria-hidden="true"></span></a>
		</div>
		
	</div>
	</#if>
	
	<table id="${table.id}" class="table table-hover scrolltable sortable ${table.cssClass!}" style="${table.cssStyle!}">
		<thead>
			<tr>
			<#list table.columns as col>
				<th class='${col.cssClass!}' style='${col.cssStyle!};<#if col.hidden>display:none</#if>'  >${col.label}</th>
			</#list>
			</tr>
		</thead>
		
		<#if table.query??>
			<#local sum = table.query.autoSumResult! /> 
			<#local avg = table.query.autoAvgResult! /> 
		<#else>
			<#local sum = context[table.refDataList + 'Sum']! /> 
			<#local avg = context[table.refDataList + 'Avg']! /> 
		</#if>
		
		<tbody>
			<#list table.dataList as row>
				<tr>
				<#list table.columns as col>
 					<td  class='center ${col.cssClass!}' style='${col.cssStyle!};<#if col.hidden>display:none</#if>'   ><#local rowValue = col.value?interpret><@rowValue /></td>
				</#list>
				</tr>
			</#list>
		</tbody>
		
		<tfoot>
		<#if table.showSum>
			<@renderTableAggr table sum '合计值' false/>
			<@renderTableAggr table avg '平均值' true/>
		</#if>
		</tfoot>
	</table>
	
	<script type="text/javascript">
		$(document).ready(function () {
			tableSmartFloat("${table.id}",1); //设置固定表头
			tableRowspan("#${table.id}",1); //自动rowspan表的第一列
			$('#${table.id}').filterTable({inputSelector:'#table_filter_input_${table.id}'}); // apply filterTable to all tables on this page
			tableDynamicShowColumns('${table.id}','dynamic_show_table_columns_${table.id}','${reportPath}');
		});
	</script> 
	
	<#if table.pageable>
		<@renderPagination table.paginator/>
	</#if>
	
</#macro>

<#macro renderTableAggr table sum title displayPercentValue=false>
		<tr>
		<#local row = sum! /> 
		<#list table.columns as col>
			<#if col_index = 0>
				<td class="center"><b>${report.getMessage(title)!}</b></td>
			<#else>
				<#if col.value?contains("href")>
					<td class='center ${col.cssClass!}' style='${col.cssStyle!};<#if col.hidden>display:none</#if>'></td>
				<#else>
					<td class='center ${col.cssClass!}' style='${col.cssStyle!};<#if col.hidden>display:none</#if>'><b>
					<#attempt>
						<#local rowValue = col.value?interpret>
						<#local rowDisplayValue><@rowValue /></#local>
						<#if displayPercentValue>
							${rowDisplayValue}
						<#else>
							<#if rowDisplayValue?contains("%")><#else>${rowDisplayValue}</#if>
						</#if>
						<#recover>
					</#attempt></b></td>
				</#if>
			</#if>
		</#list>
		</tr>
</#macro>

<#macro renderPagination paginator> 
	<div class="pagination pagination-centered">
		<ul>
			<#if !paginator.firstPage>
			<li><a href="${ctx}${request.requestURI}?page=1&${request.queryString?replace("page=","")}">First</a></li>
			</#if>
			<#if paginator.hasPrePage>
			<li><a href="${ctx}${request.requestURI}?page=${paginator.prePage}&${request.queryString?replace("page=","")}">Prev</a></li>
			</#if>
			
			<#list paginator.slider(5) as pageNum>
			<li <#if paginator.page == pageNum>class="active"</#if> ><a href="${ctx}${request.requestURI}?page=${pageNum}&${request.queryString?replace("page=","")}">${pageNum}</a></li>
			</#list>
			<#if paginator.hasNextPage>
			<li><a href="${ctx}${request.requestURI}?page=${paginator.nextPage}&${request.queryString?replace("page=","")}">Next</a></li>
			</#if>
			<#if !paginator.lastPage>
			<li><a href="${ctx}${request.requestURI}?page=${paginator.totalPages}&${request.queryString?replace("page=","")}">Last</a></li>
			</#if>
		</ul>
	</div>
</#macro>


<#macro renderObject id>
	<#assign obj = report.getElementById(id)/>
	<#if obj.class.simpleName = 'Chart'>
		<@renderChart obj/>
	<#elseif obj.class.simpleName = 'Table'>
		<@renderTable obj/>
	<#else>
		render error,unknow object type for render,id:${id},object class: ${item.class.simpleName},support renderObject is [Chart,Table]
	</#if>
</#macro>

<#macro renderTables tables>
	<#list tables as table>
		<@renderTable report.getElementById(table) />
	</#list>
</#macro>

<#macro renderCharts charts>
	<#list charts as chart>
		<@renderChart report.getElementById("${chart}") />
	</#list>
</#macro>

