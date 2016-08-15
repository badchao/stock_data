<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>



	<div class="form-group">
		<label for="stockId" class="col-sm-4 control-label"><span class="required">*</span>stockId:</label>
		<div class="col-sm-4">
			<input name="stockId" id="stockId" value="${dwStock.stockId}" placeholder="stockId"  maxlength="20"  class="form-control" required='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="stockId"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="tdate" class="col-sm-4 control-label"><span class="required">*</span>tdate:</label>
		<div class="col-sm-4">
			<input name="tdate" id="tdate" value='<fmt:formatDate value="${dwStock.tdate}" pattern="yyyy-MM-dd"/>' class="form-control"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})"   maxlength="0" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="tdate"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="tdateType" class="col-sm-4 control-label"><span class="required">*</span>tdateType:</label>
		<div class="col-sm-4">
			<input name="tdateType" id="tdateType" value="${dwStock.tdateType}" placeholder="tdateType"  maxlength="50"  class="form-control" required='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="tdateType"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="pe" class="col-sm-4 control-label">pe:</label>
		<div class="col-sm-4">
			<input name="pe" id="pe" value="${dwStock.pe}" placeholder="pe"  maxlength="12"  class="form-control" number='true' min='0' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="pe"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="pb" class="col-sm-4 control-label">pb:</label>
		<div class="col-sm-4">
			<input name="pb" id="pb" value="${dwStock.pb}" placeholder="pb"  maxlength="12"  class="form-control" number='true' min='0' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="pb"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="reverce" class="col-sm-4 control-label">reverce:</label>
		<div class="col-sm-4">
			<input name="reverce" id="reverce" value="${dwStock.reverce}" placeholder="reverce"  maxlength="12"  class="form-control" number='true' min='0' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="reverce"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="companyValue" class="col-sm-4 control-label">companyValue:</label>
		<div class="col-sm-4">
			<input name="companyValue" id="companyValue" value="${dwStock.companyValue}" placeholder="companyValue"  maxlength="12"  class="form-control" number='true' min='0' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="companyValue"/></span>
		</div>
	 </div>
	 
		