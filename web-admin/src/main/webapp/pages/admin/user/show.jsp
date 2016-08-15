<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>User 信息</title>
</rapid:override>

<rapid:override name="content">
	<h2 id="title" class="text-center">查看 User</h2>
	
	<form:form modelAttribute="user" cssClass="form-horizontal"  >
		
			<div class="form-group">
				<label class="col-sm-4 control-label">account:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${user.account}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">password:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${user.password}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">name:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${user.name}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">mobile:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${user.mobile}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">email:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${user.email}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">remarks:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${user.remarks}'/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">enabled:</label>	
				<div class="col-sm-4">
					<div class="form-control">
						<c:out value='${user.enabled}'/>
					</div>
				</div>
			</div>
		
			<div class="form-group">
				<div class="text-center">
					<a class="btn btn-default" href="${ctx}/admin/user/index.do">返回列表</a>&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="后退" onclick="history.back();"/>
				</div>
			</div>

	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>