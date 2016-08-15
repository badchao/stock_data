<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>



	<div class="form-group">
		<label for="stockId" class="col-sm-4 control-label"><span class="required">*</span>股票ID:</label>
		<div class="col-sm-4">
			<input name="stockId" id="stockId" value="${stockIndicator.stockId}" placeholder="股票ID"  maxlength="30"  class="form-control" required='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="stockId"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="indicatorId" class="col-sm-4 control-label"><span class="required">*</span>指标ID:</label>
		<div class="col-sm-4">
			<input name="indicatorId" id="indicatorId" value="${stockIndicator.indicatorId}" placeholder="指标ID"  maxlength="30"  class="form-control" required='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="indicatorId"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="tdate" class="col-sm-4 control-label"><span class="required">*</span>日期:</label>
		<div class="col-sm-4">
			<input name="tdate" id="tdate" value='<fmt:formatDate value="${stockIndicator.tdate}" pattern="yyyy-MM-dd"/>' class="form-control"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})"   maxlength="0" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="tdate"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="tdateType" class="col-sm-4 control-label"><span class="required">*</span>日期类型:</label>
		<div class="col-sm-4">
			<input name="tdateType" id="tdateType" value="${stockIndicator.tdateType}" placeholder="日期类型"  maxlength="30"  class="form-control" required='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="tdateType"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="val" class="col-sm-4 control-label">爬取URL:</label>
		<div class="col-sm-4">
			<input name="val" id="val" value="${stockIndicator.val}" placeholder="爬取URL"  maxlength="12"  class="form-control" number='true' min='0' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="val"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="ext" class="col-sm-4 control-label">扩展字段:</label>
		<div class="col-sm-4">
			<input name="ext" id="ext" value="${stockIndicator.ext}" placeholder="扩展字段"  maxlength="500"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="ext"/></span>
		</div>
	 </div>
	 
		