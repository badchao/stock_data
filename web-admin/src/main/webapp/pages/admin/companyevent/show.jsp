<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>CompanyEvent 信息</title>
</rapid:override>

<rapid:override name="content">
	<h2 id="title" class="text-center">查看 CompanyEvent</h2>
	
	<form:form modelAttribute="companyevent" cssClass="form-horizontal"  >
		
			<div class="form-group">
				<label class="col-sm-4 control-label">id:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${companyEvent.id}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">日期:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<fmt:formatDate value='${companyEvent.tdate}' pattern="yyyy-MM-dd"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">公司:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${companyEvent.companyName}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">事件内容:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${companyEvent.stockEvent}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">关联公司:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${companyEvent.relateCompany}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">备注:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${companyEvent.remarks}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">重新关注日期:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<fmt:formatDate value='${companyEvent.attentionDate}' pattern="yyyy-MM-dd"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">关联股票:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${companyEvent.relateStock}'/>
					</div>
				</div>
			</div>
		
			<div class="form-group">
				<div class="text-center">
					<a class="btn btn-default" href="${ctx}/admin/companyevent/index.do">返回列表</a>&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="后退" onclick="history.back();"/>
				</div>
			</div>

	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>