<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>



	<div class="form-group">
		<label for="stockId" class="col-sm-4 control-label"><span class="required">*</span>股票ID:</label>
		<div class="col-sm-4">
			<input name="stockId" id="stockId" value="${stockIndicatorConfig.stockId}" placeholder="股票ID"  maxlength="30"  class="form-control" required='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="stockId"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="indicatorId" class="col-sm-4 control-label"><span class="required">*</span>指标ID:</label>
		<div class="col-sm-4">
			<input name="indicatorId" id="indicatorId" value="${stockIndicatorConfig.indicatorId}" placeholder="指标ID"  maxlength="30"  class="form-control" required='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="indicatorId"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="indicatorName" class="col-sm-4 control-label">指标名称:</label>
		<div class="col-sm-4">
			<input name="indicatorName" id="indicatorName" value="${stockIndicatorConfig.indicatorName}" placeholder="指标名称"  maxlength="300"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="indicatorName"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="calcExpr" class="col-sm-4 control-label">计算表达式:</label>
		<div class="col-sm-4">
			<input name="calcExpr" id="calcExpr" value="${stockIndicatorConfig.calcExpr}" placeholder="计算表达式"  maxlength="4000"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="calcExpr"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="remarks" class="col-sm-4 control-label">remarks:</label>
		<div class="col-sm-4">
			<input name="remarks" id="remarks" value="${stockIndicatorConfig.remarks}" placeholder="remarks"  maxlength="200"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="remarks"/></span>
		</div>
	 </div>

	<div class="form-group">
		<label for="crawlUrl" class="col-sm-4 control-label">爬取URL:</label>
		<div class="col-sm-4">
			<input name="crawlUrl" id="crawlUrl" value="${stockIndicatorConfig.crawlUrl}" placeholder="爬取URL"  maxlength="300"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="crawlUrl"/></span>
		</div>
	 </div>

	<div class="form-group">
		<label for="crawlCron" class="col-sm-4 control-label">爬取Cron:</label>
		<div class="col-sm-4">
			<input name="crawlCron" id="crawlCron" value="${stockIndicatorConfig.crawlCron}" placeholder="爬取Cron"  maxlength="300"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="crawlCron"/></span>
		</div>
	 </div>
	 	 
	<div class="form-group">
		<label for="crawlScript" class="col-sm-4 control-label">爬取脚本:</label>
		<div class="col-sm-4">
<%-- 			<input name="crawlScript" id="crawlScript" value="${stockIndicatorConfig.crawlScript}" placeholder="爬取脚本"  maxlength="4000"  class="form-control" /> --%>
			<textarea name="crawlScript" id="crawlScript" rows="12" cols="79"  class="form-control" maxlength="4000">${stockIndicatorConfig.crawlScript}</textarea>
			<span class="help-block">变量引用,如果是json,可引用变量名为:json,plainJson,如果是html,可以引用的变量为: doc</span>
			<span class="error"><form:errors path="crawlScript"/></span>
		</div>
	 </div>
	 	 
	<div class="form-group center-block block-center text-center ">
		<div class="col-sm-12">
			<button onclick="evalCrawlScript(); return false;" class="btn btn-success">测试脚本</button>
		</div>
	 </div>		
	 
	 <div id="evalCrawlScriptResult" class="row text-center">
	 
	 </div>
	 
	 <script type="text/javascript">
	 	function evalCrawlScript() {
	 		var formData = $("#inputForm").serialize();
	 		$.get("${ctx}/admin/stockindicatorconfig/evalCrawlScript.do?"+formData,{},function(data){
		 		$("#evalCrawlScriptResult").html(data);
		 	});
	 	}
	 </script>