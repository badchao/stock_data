<%@page import="com.github.stock_data.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>DwStock 列表</title>
	
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
	<form id="queryForm" name="queryForm" method="get" action="${ctx}/admin/dwstock/index.do">
	
	<div class="panel panel-default">
	
		<div class="panel-heading">DwStock 列表</div>
		<div class="panel-body">
			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="stockId" class="control-label">stockId</label>
						<input name="stockId" id="stockId" value="${query.stockId}" placeholder=""  class="form-control input-from-control"   maxlength="20"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tdateBegin" class="control-label">开始tdate</label>
						<input name="tdateBegin" id="tdateBegin" value="<fmt:formatDate value='${query.tdateBegin}' pattern='yyyy-MM-dd'/>"  placeholder="开始时间"   class="form-control input-from-control"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"   />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tdateEnd" class="control-label">结束tdate</label>
						<input name="tdateEnd" id="tdateEnd" value="<fmt:formatDate value='${query.tdateEnd}' pattern='yyyy-MM-dd'/>" placeholder="结束时间" class="form-control input-from-control"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"    />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tdateType" class="control-label">tdateType</label>
						<input name="tdateType" id="tdateType" value="${query.tdateType}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="pe" class="control-label">pe</label>
						<input name="pe" id="pe" value="${query.pe}" placeholder=""  class="form-control input-from-control"   maxlength="12"  class="validate-number "/>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="pb" class="control-label">pb</label>
						<input name="pb" id="pb" value="${query.pb}" placeholder=""  class="form-control input-from-control"   maxlength="12"  class="validate-number "/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="reverce" class="control-label">reverce</label>
						<input name="reverce" id="reverce" value="${query.reverce}" placeholder=""  class="form-control input-from-control"   maxlength="12"  class="validate-number "/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="companyValue" class="control-label">companyValue</label>
						<input name="companyValue" id="companyValue" value="${query.companyValue}" placeholder=""  class="form-control input-from-control"   maxlength="12"  class="validate-number "/>
					</div>
				</div>
			</div>

				
			<div style="margin-top:20px"  class="row text-left">
				<div class="col-sm-5">
					<a href="#" class="btn btn-primary btn-sm"  onclick="$(this).closest('form').action='${ctx}/admin/dwstock/index.do'; $(this).closest('form').submit();return false;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/admin/dwstock/add.do"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/pages/admin/dwstock/upload.jsp"><span class="glyphicon glyphicon-import" aria-hidden="true"></span> 批量导入</a>
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
				<th sortColumn="stock_id" >stockId</th>
				<th sortColumn="tdate" >tdate</th>
				<th sortColumn="tdate_type" >tdateType</th>
				<th sortColumn="pe" >pe</th>
				<th sortColumn="pb" >pb</th>
				<th sortColumn="reverce" >reverce</th>
				<th sortColumn="company_value" >companyValue</th>
				<th>操作</th>
			  </tr>
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.itemList}" var="row" varStatus="status">
		  	  
			  <tr>
				<td>${page.paginator.startRow + status.index}</td>
				
				<td><c:out value='${row.stockId}'/>&nbsp;</td>
				<td><fmt:formatDate value='${row.tdate}' pattern='yyyy-MM-dd'/>&nbsp;</td>
				<td><c:out value='${row.tdateType}'/>&nbsp;</td>
				<td><c:out value='${row.pe}'/>&nbsp;</td>
				<td><c:out value='${row.pb}'/>&nbsp;</td>
				<td><c:out value='${row.reverce}'/>&nbsp;</td>
				<td><c:out value='${row.companyValue}'/>&nbsp;</td>
				
				<td>
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/dwstock/show.do?stockId=${row.stockId}&tdate=${row.tdate}&tdateType=${row.tdateType}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 查看</a>&nbsp;&nbsp;
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/dwstock/edit.do?stockId=${row.stockId}&tdate=${row.tdate}&tdateType=${row.tdateType}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改</a>&nbsp;&nbsp;
					<a class="btn btn-danger btn-xs" href="${ctx}/admin/dwstock/delete.do?stockId=${row.stockId}&tdate=${row.tdate}&tdateType=${row.tdateType}" onclick="doRestDelete(this,'你确认删除?');return false;"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</a>
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

