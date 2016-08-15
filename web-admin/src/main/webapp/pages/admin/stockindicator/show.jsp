<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>StockIndicator 信息</title>
</rapid:override>

<rapid:override name="content">
	<h2 id="title" class="text-center">查看 StockIndicator</h2>
	
	<form:form modelAttribute="stockindicator" cssClass="form-horizontal"  >
		
			<div class="form-group">
				<label class="col-sm-4 control-label">股票ID:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicator.stockId}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">指标ID:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicator.indicatorId}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">日期:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<fmt:formatDate value='${stockIndicator.tdate}' pattern="yyyy-MM-dd"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">日期类型:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicator.tdateType}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">爬取URL:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicator.val}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">扩展字段:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stockIndicator.ext}'/>
					</div>
				</div>
			</div>
		
			<div class="form-group">
				<div class="text-center">
					<a class="btn btn-default" href="${ctx}/admin/stockindicator/index.do">返回列表</a>&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="后退" onclick="history.back();"/>
				</div>
			</div>

	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>