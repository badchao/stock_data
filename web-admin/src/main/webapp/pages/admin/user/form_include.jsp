<%@page import="com.github.stock_data.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


	<div class="form-group">
		<label for="account" class="col-sm-4 control-label">account:</label>
		<div class="col-sm-4">
			<input name="account" id="account" value="${user.account}" placeholder="account"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="account"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="password" class="col-sm-4 control-label">password:</label>
		<div class="col-sm-4">
			<input name="password" id="password" type="password" value="${user.password}" placeholder="password"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="password"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="name" class="col-sm-4 control-label">name:</label>
		<div class="col-sm-4">
			<input name="name" id="name" value="${user.name}" placeholder="name"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="name"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="mobile" class="col-sm-4 control-label">mobile:</label>
		<div class="col-sm-4">
			<input name="mobile" id="mobile" value="${user.mobile}" placeholder="mobile"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="mobile"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="email" class="col-sm-4 control-label">email:</label>
		<div class="col-sm-4">
			<input name="email" id="email" value="${user.email}" placeholder="email"  maxlength="50"  class="form-control" email='true' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="email"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="remarks" class="col-sm-4 control-label">remarks:</label>
		<div class="col-sm-4">
			<input name="remarks" id="remarks" value="${user.remarks}" placeholder="remarks"  maxlength="50"  class="form-control" />
			<span class="help-block"></span>
			<span class="error"><form:errors path="remarks"/></span>
		</div>
	 </div>
	 
	<div class="form-group">
		<label for="enabled" class="col-sm-4 control-label">enabled:</label>
		<div class="col-sm-4">
			<input name="enabled" id="enabled" value="${user.enabled}" placeholder="enabled"  maxlength="3"  class="form-control" digits='true' min='0' />
			<span class="help-block"></span>
			<span class="error"><form:errors path="enabled"/></span>
		</div>
	 </div>
	 
		