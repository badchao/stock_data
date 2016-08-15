<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


	<div class="form-group">
		<label for="stockId" class="col-sm-4 control-label">股票ID:</label>
		<div class="col-sm-4">
			<input name="stockId" id="stockId" value="${stock.stockId}" placeholder="股票ID"  maxlength="30"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="stockId"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="stockCode" class="col-sm-4 control-label">股票代码:</label>
		<div class="col-sm-4">
			<input name="stockCode" id="stockCode" value="${stock.stockCode}" placeholder="股票代码"  maxlength="30"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="stockCode"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="stockName" class="col-sm-4 control-label">股票名称:</label>
		<div class="col-sm-4">
			<input name="stockName" id="stockName" value="${stock.stockName}" placeholder="股票名称"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="stockName"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="market" class="col-sm-4 control-label">股票市场:</label>
		<div class="col-sm-4">
			<input name="market" id="market" value="${stock.market}" placeholder="股票市场"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="market"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="zone" class="col-sm-4 control-label">股票区域:</label>
		<div class="col-sm-4">
			<input name="zone" id="zone" value="${stock.zone}" placeholder="股票区域"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="zone"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="remarks" class="col-sm-4 control-label">股票备注:</label>
		<div class="col-sm-4">
			<input name="remarks" id="remarks" value="${stock.remarks}" placeholder="股票备注"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="remarks"/></span>
		</div>
	 </div>
	 
		