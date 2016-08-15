<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>StockIndicatorConfig 信息</title>
</rapid:override>

<rapid:override name="content">
	<h2 id="title" class="text-center">查看 StockIndicatorConfig</h2>
	
	<form:form modelAttribute="stockindicatorconfig" cssClass="form-horizontal"  >
		
			<div class="form-group">
				<label class="col-sm-4 control-label">股票ID:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicatorConfig.stockId}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">指标ID:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicatorConfig.indicatorId}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">指标名称:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicatorConfig.indicatorName}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">爬取URL:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicatorConfig.crawlUrl}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">爬取脚本:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicatorConfig.crawlScript}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">爬取Cron:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicatorConfig.crawlCron}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">计算表达式:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicatorConfig.calcExpr}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">remarks:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicatorConfig.remarks}'/>
					</div>
				</div>
			</div>
		
			<div class="form-group">
				<div class="text-center">
					<a class="btn btn-default" href="${ctx}/admin/stockindicatorconfig/index.do">返回列表</a>&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="后退" onclick="history.back();"/>
				</div>
			</div>

	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>