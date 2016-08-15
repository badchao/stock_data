<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>Stock 信息</title>
</rapid:override>

<rapid:override name="content">
	<h2 id="title" class="text-center">查看 Stock</h2>
	
	<form:form modelAttribute="stock" cssClass="form-horizontal"  >
		
			<div class="form-group">
				<label class="col-sm-4 control-label">股票ID:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stock.stockId}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">股票代码:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stock.stockCode}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">股票名称:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stock.stockName}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">股票市场:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stock.market}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">股票区域:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stock.zone}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">股票备注:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${stock.remarks}'/>
					</div>
				</div>
			</div>
		
			<div class="form-group">
				<div class="text-center">
					<a class="btn btn-default" href="${ctx}/admin/stock/index.do">返回列表</a>&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="后退" onclick="history.back();"/>
				</div>
			</div>

	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>