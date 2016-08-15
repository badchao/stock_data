<%@page import="com.github.stock_data.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>Stock 列表</title>
	
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
	<form id="queryForm" name="queryForm" method="get" action="${ctx}/admin/stock/index.do">
	
	<div class="panel panel-default">
	
		<div class="panel-heading">Stock 列表</div>
		<div class="panel-body">
			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="stockCode" class="control-label">股票代码</label>
						<input name="stockCode" id="stockCode" value="${query.stockCode}" placeholder=""  class="form-control input-from-control"   maxlength="30"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="stockName" class="control-label">股票名称</label>
						<input name="stockName" id="stockName" value="${query.stockName}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="market" class="control-label">股票市场</label>
						<input name="market" id="market" value="${query.market}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="zone" class="control-label">股票区域</label>
						<input name="zone" id="zone" value="${query.zone}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="remarks" class="control-label">股票备注</label>
						<input name="remarks" id="remarks" value="${query.remarks}" placeholder=""  class="form-control input-from-control"   maxlength="50"  class=""/>
					</div>
				</div>
			</div>

				
			<div style="margin-top:20px"  class="row text-left">
				<div class="col-sm-5">
					<a href="#" class="btn btn-primary btn-sm"  onclick="$(this).closest('form').action='${ctx}/admin/stock/index.do'; $(this).closest('form').submit();return false;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/admin/stock/add.do"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/pages/admin/stock/upload.jsp"><span class="glyphicon glyphicon-import" aria-hidden="true"></span> 批量导入</a>
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
				<th sortColumn="stock_id" >股票ID</th>
				<th sortColumn="stock_code" >股票代码</th>
				<th sortColumn="stock_name" >股票名称</th>
				<th sortColumn="market" >股票市场</th>
				<th sortColumn="zone" >股票区域</th>
				<th sortColumn="remarks" >股票备注</th>
				<th>操作</th>
			  </tr>
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.itemList}" var="row" varStatus="status">
		  	  
			  <tr>
				<td>${page.paginator.startRow + status.index}</td>
				
				<td><c:out value='${row.stockId}'/>&nbsp;</td>
				<td><c:out value='${row.stockCode}'/>&nbsp;</td>
				<td><c:out value='${row.stockName}'/>&nbsp;</td>
				<td><c:out value='${row.market}'/>&nbsp;</td>
				<td><c:out value='${row.zone}'/>&nbsp;</td>
				<td><c:out value='${row.remarks}'/>&nbsp;</td>
				 
				<td>
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/stockindicatorconfig/index.do?stockId=${row.stockId}">配置指标</a>&nbsp;&nbsp;
					<a class="btn btn-primary btn-xs" href="${ctx}/ReportEngine/report?reportPath=stock/report&stockId=${row.stockId}">查看数据</a>&nbsp;&nbsp;
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/stock/show.do?stockId=${row.stockId}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 查看</a>&nbsp;&nbsp;
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/stock/edit.do?stockId=${row.stockId}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改</a>&nbsp;&nbsp;
					<a class="btn btn-danger btn-xs" href="${ctx}/admin/stock/delete.do?stockId=${row.stockId}" onclick="doRestDelete(this,'你确认删除?');return false;"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</a>
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

