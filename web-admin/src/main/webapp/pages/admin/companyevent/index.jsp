<%@page import="com.github.stock_data.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title>CompanyEvent 列表</title>
	
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
	<form id="queryForm" name="queryForm" method="get" action="${ctx}/admin/companyevent/index.do">
	
	<div class="panel panel-default">
	
		<div class="panel-heading">CompanyEvent 列表</div>
		<div class="panel-body">
			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tdateBegin" class="control-label">开始日期</label>
						<input name="tdateBegin" id="tdateBegin" value="<fmt:formatDate value='${query.tdateBegin}' pattern='yyyy-MM-dd'/>"  placeholder="开始时间"   class="form-control input-from-control"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"   />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tdateEnd" class="control-label">结束日期</label>
						<input name="tdateEnd" id="tdateEnd" value="<fmt:formatDate value='${query.tdateEnd}' pattern='yyyy-MM-dd'/>" placeholder="结束时间" class="form-control input-from-control"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"    />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="companyName" class="control-label">公司</label>
						<input name="companyName" id="companyName" value="${query.companyName}" placeholder=""  class="form-control input-from-control"   maxlength="255"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="stockEvent" class="control-label">事件内容</label>
						<input name="stockEvent" id="stockEvent" value="${query.stockEvent}" placeholder=""  class="form-control input-from-control"   maxlength="4000"  class=""/>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="relateCompany" class="control-label">关联公司</label>
						<input name="relateCompany" id="relateCompany" value="${query.relateCompany}" placeholder=""  class="form-control input-from-control"   maxlength="2000"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="remarks" class="control-label">备注</label>
						<input name="remarks" id="remarks" value="${query.remarks}" placeholder=""  class="form-control input-from-control"   maxlength="2000"  class=""/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="attentionDateBegin" class="control-label">开始重新关注日期</label>
						<input name="attentionDateBegin" id="attentionDateBegin" value="<fmt:formatDate value='${query.attentionDateBegin}' pattern='yyyy-MM-dd'/>"  placeholder="开始时间"   class="form-control input-from-control"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"   />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="attentionDateEnd" class="control-label">结束重新关注日期</label>
						<input name="attentionDateEnd" id="attentionDateEnd" value="<fmt:formatDate value='${query.attentionDateEnd}' pattern='yyyy-MM-dd'/>" placeholder="结束时间" class="form-control input-from-control"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"    />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="relateStock" class="control-label">关联股票</label>
						<input name="relateStock" id="relateStock" value="${query.relateStock}" placeholder=""  class="form-control input-from-control"   maxlength="255"  class=""/>
					</div>
				</div>
			</div>

				
			<div style="margin-top:20px"  class="row text-left">
				<div class="col-sm-5">
					<a href="#" class="btn btn-primary btn-sm"  onclick="$(this).closest('form').action='${ctx}/admin/companyevent/index.do'; $(this).closest('form').submit();return false;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/admin/companyevent/add.do"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增</a>
					<a class="btn btn-primary btn-sm" href="${ctx}/pages/admin/companyevent/upload.jsp"><span class="glyphicon glyphicon-import" aria-hidden="true"></span> 批量导入</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="panel panel-default table-responsive">
		
		<table class="table table-hover scrolltable sortable">
		  <thead>
			  <tr>
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
<!-- 				<th sortColumn="id" >id</th> -->
				<th sortColumn="tdate" >日期</th>
				<th sortColumn="company_name" >公司</th>
				<th sortColumn="stock_event" >事件内容</th>
				<th sortColumn="relate_company" >关联公司</th>
				<th sortColumn="relate_stock" >关联股票</th>
				<th sortColumn="remarks" >备注</th>
				<th sortColumn="attention_date" >重新关注日期</th>
				<th sortColumn="attention_days" >重新关注天数</th>
				<th>操作</th>
			  </tr>
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.itemList}" var="row" varStatus="status">
		  	  
			  <tr>
				
<%-- 				<td><c:out value='${row.id}'/>&nbsp;</td> --%>
				<td><fmt:formatDate value='${row.tdate}' pattern='yyyy-MM-dd'/>&nbsp;</td>
				<td><c:out value='${row.companyName}'/>&nbsp;</td>
				<td><c:out value='${row.stockEvent}'/>&nbsp;</td>
				<td><c:out value='${row.relateCompany}'/>&nbsp;</td>
				<td><c:out value='${row.relateStock}'/>&nbsp;</td>
				<td><c:out value='${row.remarks}'/>&nbsp;</td>
				<td><fmt:formatDate value='${row.attentionDate}' pattern='yyyy-MM-dd'/>&nbsp;</td>
				<td><span class="${row.attentionDays < 30 && row.attentionDays > 0 ? 'label label-danger' : '' }">${row.attentionDays}</span></td>
				
				<td>
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/companyevent/show.do?id=${row.id}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 查看</a>&nbsp;&nbsp;
					<a class="btn btn-primary btn-xs" href="${ctx}/admin/companyevent/edit.do?id=${row.id}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改</a>&nbsp;&nbsp;
					<a class="btn btn-danger btn-xs" href="${ctx}/admin/companyevent/delete.do?id=${row.id}" onclick="doRestDelete(this,'你确认删除?');return false;"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</a>
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

