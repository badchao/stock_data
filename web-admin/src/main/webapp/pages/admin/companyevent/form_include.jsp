<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


	<input name="id" id="id" type="hidden" value="${companyEvent.id}"/>

	<div class="form-group">
		<label for="tdate" class="col-sm-4 control-label"><span class="required">*</span>日期:</label>
		<div class="col-sm-4">
			<input name="tdate" id="tdate" value='<fmt:formatDate value="${companyEvent.tdate}" pattern="yyyy-MM-dd"/>' class="form-control"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="tdate"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="companyName" class="col-sm-4 control-label"><span class="required">*</span>公司:</label>
		<div class="col-sm-4">
			<input name="companyName" id="companyName" value="${companyEvent.companyName}" placeholder="公司"  maxlength="255"  class="form-control" required='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="companyName"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="stockEvent" class="col-sm-4 control-label">事件内容:</label>
		<div class="col-sm-4">
			<input name="stockEvent" id="stockEvent" value="${companyEvent.stockEvent}" placeholder="事件内容"  maxlength="4000"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="stockEvent"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="relateCompany" class="col-sm-4 control-label">关联公司:</label>
		<div class="col-sm-4">
			<input name="relateCompany" id="relateCompany" value="${companyEvent.relateCompany}" placeholder="关联公司"  maxlength="2000"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="relateCompany"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="remarks" class="col-sm-4 control-label">备注:</label>
		<div class="col-sm-4">
			<input name="remarks" id="remarks" value="${companyEvent.remarks}" placeholder="备注"  maxlength="2000"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="remarks"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="attentionDate" class="col-sm-4 control-label">重新关注日期:</label>
		<div class="col-sm-4">
			<input name="attentionDate" id="attentionDate" value='<fmt:formatDate value="${companyEvent.attentionDate}" pattern="yyyy-MM-dd"/>' class="form-control"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="attentionDate"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="relateStock" class="col-sm-4 control-label">关联股票:</label>
		<div class="col-sm-4">
			<input name="relateStock" id="relateStock" value="${companyEvent.relateStock}" placeholder="关联股票"  maxlength="255"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="relateStock"/></span>
		</div>
	 </div>
	 
		