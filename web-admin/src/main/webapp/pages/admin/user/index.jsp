<%@page import="com.github.stock_data.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>User 列表</title>
	
	<script src="${ctx}/js/rest.js" ></script>
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',${page.paginator.page},${page.paginator.pageSize},'${pageRequest.sortColumns}');
		});
	</script>
</rapid:override>


<rapid:override name="content">
	<form id="queryForm" name="queryForm" method="get" action="${ctx}/admin/user/index.do">
	
	<div class="panel panel-default">
	
		<div class="panel-heading">User 列表</div>
		<div class="panel-body">
			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="password" class="control-label">password</label>
						<input name="password" id="password" value="${query.password}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="name" class="control-label">name</label>
						<input name="name" id="name" value="${query.name}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="mobile" class="control-label">mobile</label>
						<input name="mobile" id="mobile" value="${query.mobile}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="email" class="control-label">email</label>
						<input name="email" id="email" value="${query.email}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class="validate-email "/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="remarks" class="control-label">remarks</label>
						<input name="remarks" id="remarks" value="${query.remarks}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="enabled" class="control-label">enabled</label>
						<input name="enabled" id="enabled" value="${query.enabled}" placeholder=""  class="form-control input-from-control"   maxlength="3"  class="validate-integer max-value-2147483647"/>
					</div>
				</div>
			</div>

				
			<div style="margin-top:20px"  class="row text-left">
				<div class="col-sm-5">
					<a href="#" class="btn btn-primary btn-sm"  onclick="$(this).closest('form').action='${ctx}/admin/user/index.do'; $(this).closest('form').submit();return false;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/admin/user/add.do"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/pages/admin/user/upload.jsp"><span class="glyphicon glyphicon-import" aria-hidden="true"></span> 批量导入</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="panel panel-default table-responsive">
		
		<table class="table table-hover scrolltable sortable">
		  <thead>
			  <tr>
				<th style="width:1px;"> </th>
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="account" >account</th>
				<th sortColumn="name" >name</th>
				<th sortColumn="mobile" >mobile</th>
				<th sortColumn="email" >email</th>
				<th sortColumn="remarks" >remarks</th>
				<th sortColumn="enabled" >enabled</th>
				<th>操作</th>
			  </tr>
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.itemList}" var="row" varStatus="status">
		  	  
			  <tr>
				<td>${page.paginator.startRow + status.index}</td>
				
				<td><c:out value='${row.account}'/>&nbsp;</td>
				<td><c:out value='${row.name}'/>&nbsp;</td>
				<td><c:out value='${row.mobile}'/>&nbsp;</td>
				<td><c:out value='${row.email}'/>&nbsp;</td>
				<td><c:out value='${row.remarks}'/>&nbsp;</td>
				<td><c:out value='${row.enabled}'/>&nbsp;</td>
				
				<td>
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/user/show.do?account=${row.account}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 查看</a>&nbsp;&nbsp;
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/user/edit.do?account=${row.account}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改</a>&nbsp;&nbsp;
					<a class="btn btn-danger btn-xs" href="${ctx}/admin/user/delete.do?account=${row.account}" onclick="doRestDelete(this,'你确认删除?');return false;"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar paginator="${page.paginator}">
		</simpletable:pageToolbar>
		
	</div>
	
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>

