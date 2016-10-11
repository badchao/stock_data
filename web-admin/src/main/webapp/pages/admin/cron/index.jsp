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
	
		<div class="panel-heading">Method 列表</div>
		<div class="panel-body">
				
			<div style="margin-top:20px"  class="row text-left">
				<div class="col-sm-5">
					<a href="#" class="btn btn-primary btn-sm"  onclick="$(this).closest('form').action='${ctx}/admin/cron/index.do'; $(this).closest('form').submit();return false;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="panel panel-default table-responsive">
		
		<table class="table table-hover scrolltable sortable">
		  <thead>
			  <tr>
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="stock_id" >方法</th>
				<th>操作</th>
			  </tr>
		  </thead>
		  <tbody>
		  	  <c:forEach items="${methods}" var="row" varStatus="status">
		  	  
			  <tr>
				<td>${row.declaringClass.simpleName}.${row.name}()</td>
				<td>
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/cron/exec.do?clazz=${row.declaringClass.name}&method=${row.name}"><span class="glyphicon glyphicon-play" aria-hidden="true"></span> 执行</a>&nbsp;&nbsp;
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		
	</div>
	
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>

