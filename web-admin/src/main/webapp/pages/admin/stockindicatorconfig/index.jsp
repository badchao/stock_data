<%@page import="com.github.stock_data.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>StockIndicatorConfig 列表</title>
	
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
	<form id="queryForm" name="queryForm" method="get" action="${ctx}/admin/stockindicatorconfig/index.do">
	
	<div class="panel panel-default">
	
		<div class="panel-heading">StockIndicatorConfig 列表</div>
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
						<label for="indicatorName" class="control-label">指标名称</label>
						<input name="indicatorName" id="indicatorName" value="${query.indicatorName}" placeholder=""  class="form-control input-from-control"   maxlength="300"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="crawlUrl" class="control-label">爬取URL</label>
						<input name="crawlUrl" id="crawlUrl" value="${query.crawlUrl}" placeholder=""  class="form-control input-from-control"   maxlength="300"  class=""/>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="crawlScript" class="control-label">爬取脚本</label>
						<input name="crawlScript" id="crawlScript" value="${query.crawlScript}" placeholder=""  class="form-control input-from-control"   maxlength="4000"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="crawlCron" class="control-label">爬取Cron</label>
						<input name="crawlCron" id="crawlCron" value="${query.crawlCron}" placeholder=""  class="form-control input-from-control"   maxlength="300"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="calcExpr" class="control-label">计算表达式</label>
						<input name="calcExpr" id="calcExpr" value="${query.calcExpr}" placeholder=""  class="form-control input-from-control"   maxlength="4000"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="remarks" class="control-label">remarks</label>
						<input name="remarks" id="remarks" value="${query.remarks}" placeholder=""  class="form-control input-from-control"   maxlength="200"  class=""/>
					</div>
				</div>
			</div>

				
			<div style="margin-top:20px"  class="row text-left">
				<div class="col-sm-5">
					<a href="#" class="btn btn-primary btn-sm"  onclick="$(this).closest('form').action='${ctx}/admin/stockindicatorconfig/index.do'; $(this).closest('form').submit();return false;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/admin/stockindicatorconfig/add.do?stockId=${param.stockId}"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/pages/admin/stockindicatorconfig/upload.jsp?stockId=${param.stockId}"><span class="glyphicon glyphicon-import" aria-hidden="true"></span> 批量导入</a>
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
				<th sortColumn="indicator_name" >指标名称</th>
				<th sortColumn="crawl_url" >爬取URL</th>
				<th sortColumn="crawl_script" >爬取脚本</th>
				<th sortColumn="crawl_cron" >爬取Cron</th>
<!-- 				<th sortColumn="calc_expr" >计算表达式</th> -->
<!-- 				<th sortColumn="remarks" >remarks</th> -->
				<th>爬取时间</th>
				<th>爬取状态</th>
				<th>爬取日志</th>
				<th>操作</th>
			  </tr>
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.itemList}" var="row" varStatus="status">
		  	  
			  <tr>
				<td>${page.paginator.startRow + status.index}</td>
				
				<td><c:out value='${row.stockId}'/>&nbsp;</td>
				<td><c:out value='${row.indicatorId}'/>&nbsp;</td>
				<td><c:out value='${row.indicatorName}'/>&nbsp;</td>
				<td><c:out value='${row.crawlUrl}'/>&nbsp;</td>
				<td><c:out value='${row.crawlScript}'/>&nbsp;</td>
				<td><c:out value='${row.crawlCron}'/>&nbsp;</td>
<%-- 				<td><c:out value='${row.calcExpr}'/>&nbsp;</td> --%>
<%-- 				<td><c:out value='${row.remarks}'/>&nbsp;</td> --%>
				<td><fmt:formatDate value="${row.lastCrawlTime}" pattern="MM-dd HH:mm:ss"/> </td>
				<td class="bg-${row.crawlStatus}"><c:out value='${row.crawlStatus}'/>&nbsp;</td>
				<td><c:out value='${row.crawlLog}'/>&nbsp;</td>
				
				<td>
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/stockindicatorconfig/edit.do?stockId=${row.stockId}&indicatorId=${row.indicatorId}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改</a>&nbsp;&nbsp;
					<a class="btn btn-danger btn-xs" href="${ctx}/admin/stockindicatorconfig/delete.do?stockId=${row.stockId}&indicatorId=${row.indicatorId}" onclick="doRestDelete(this,'你确认删除?');return false;"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</a>
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

