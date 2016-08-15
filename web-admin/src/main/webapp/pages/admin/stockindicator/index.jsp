<%@page import="com.github.stock_data.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>StockIndicator 列表</title>
	
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
	<form id="queryForm" name="queryForm" method="get" action="${ctx}/admin/stockindicator/index.do">
	
	<div class="panel panel-default">
	
		<div class="panel-heading">StockIndicator 列表</div>
		<div class="panel-body">
			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="stockId" class="control-label">股票ID</label>
						<input name="stockId" id="stockId" value="${query.stockId}" placeholder=""  class="form-control input-from-control"   maxlength="30"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="indicatorId" class="control-label">指标ID</label>
						<input name="indicatorId" id="indicatorId" value="${query.indicatorId}" placeholder=""  class="form-control input-from-control"   maxlength="30"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tdateBegin" class="control-label">开始日期</label>
						<input name="tdateBegin" id="tdateBegin" value="<fmt:formatDate value='${query.tdateBegin}' pattern='yyyy-MM-dd'/>"  placeholder="开始时间"   class="form-control input-from-control"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"   />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tdateEnd" class="control-label">结束日期</label>
						<input name="tdateEnd" id="tdateEnd" value="<fmt:formatDate value='${query.tdateEnd}' pattern='yyyy-MM-dd'/>" placeholder="结束时间" class="form-control input-from-control"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"    />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tdateType" class="control-label">日期类型</label>
						<input name="tdateType" id="tdateType" value="${query.tdateType}" placeholder=""  class="form-control input-from-control"   maxlength="30"  class=""/>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="val" class="control-label">爬取URL</label>
						<input name="val" id="val" value="${query.val}" placeholder=""  class="form-control input-from-control"   maxlength="12"  class="validate-number "/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="ext" class="control-label">扩展字段</label>
						<input name="ext" id="ext" value="${query.ext}" placeholder=""  class="form-control input-from-control"   maxlength="500"  class=""/>
					</div>
				</div>
			</div>

				
			<div style="margin-top:20px"  class="row text-left">
				<div class="col-sm-5">
					<a href="#" class="btn btn-primary btn-sm"  onclick="$(this).closest('form').action='${ctx}/admin/stockindicator/index.do'; $(this).closest('form').submit();return false;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/admin/stockindicator/add.do"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/pages/admin/stockindicator/upload.jsp"><span class="glyphicon glyphicon-import" aria-hidden="true"></span> 批量导入</a>
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
				<th sortColumn="indicator_id" >指标ID</th>
				<th sortColumn="tdate" >日期</th>
				<th sortColumn="tdate_type" >日期类型</th>
				<th sortColumn="val" >爬取URL</th>
				<th sortColumn="ext" >扩展字段</th>
				<th>操作</th>
			  </tr>
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.itemList}" var="row" varStatus="status">
		  	  
			  <tr>
				<td>${page.paginator.startRow + status.index}</td>
				
				<td><c:out value='${row.stockId}'/>&nbsp;</td>
				<td><c:out value='${row.indicatorId}'/>&nbsp;</td>
				<td><fmt:formatDate value='${row.tdate}' pattern='yyyy-MM-dd'/>&nbsp;</td>
				<td><c:out value='${row.tdateType}'/>&nbsp;</td>
				<td><c:out value='${row.val}'/>&nbsp;</td>
				<td><c:out value='${row.ext}'/>&nbsp;</td>
				
				<td>
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/stockindicator/show.do?stockId=${row.stockId}&indicatorId=${row.indicatorId}&tdate=${row.tdate}&tdateType=${row.tdateType}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 查看</a>&nbsp;&nbsp;
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/stockindicator/edit.do?stockId=${row.stockId}&indicatorId=${row.indicatorId}&tdate=${row.tdate}&tdateType=${row.tdateType}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改</a>&nbsp;&nbsp;
					<a class="btn btn-danger btn-xs" href="${ctx}/admin/stockindicator/delete.do?stockId=${row.stockId}&indicatorId=${row.indicatorId}&tdate=${row.tdate}&tdateType=${row.tdateType}" onclick="doRestDelete(this,'你确认删除?');return false;"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</a>
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

