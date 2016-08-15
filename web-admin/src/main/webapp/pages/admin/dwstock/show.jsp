<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>DwStock 信息</title>
</rapid:override>

<rapid:override name="content">
	<h2 id="title" class="text-center">查看 DwStock</h2>
	
	<form:form modelAttribute="dwstock" cssClass="form-horizontal"  >
		
			<div class="form-group">
				<label class="col-sm-4 control-label">stockId:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${dwStock.stockId}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">tdate:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<fmt:formatDate value='${dwStock.tdate}' pattern="yyyy-MM-dd"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">tdateType:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${dwStock.tdateType}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">pe:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${dwStock.pe}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">pb:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${dwStock.pb}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">reverce:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${dwStock.reverce}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">companyValue:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${dwStock.companyValue}'/>
					</div>
				</div>
			</div>
		
			<div class="form-group">
				<div class="text-center">
					<a class="btn btn-default" href="${ctx}/admin/dwstock/index.do">返回列表</a>&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="后退" onclick="history.back();"/>
				</div>
			</div>

	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>