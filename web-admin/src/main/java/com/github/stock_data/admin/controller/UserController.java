/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */


package com.github.stock_data.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.rapid.common.beanutils.BeanUtils;
import com.github.rapid.common.exception.MessageException;
import com.github.rapid.common.web.scope.Flash;
import com.github.rapid.common.web.util.ServletUtil;
import com.github.rapid.common.util.CsvFileUtil;
import com.github.rapid.common.util.ValidationErrorsUtil;
import com.github.rapid.common.util.page.Page;
import com.github.rapid.common.util.CollectionUtil;

import java.util.*;

import com.github.stock_data.model.*;
import com.github.stock_data.dao.*;
import com.github.stock_data.service.*;
import com.github.stock_data.query.*;

/**
 * [User] 的Controller
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 *
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	private final String LIST_ACTION = "redirect:/admin/user/index.do?useSessionParam=true";
	
	private static String CREATED_SUCCESS = "创建成功";
	private static String UPDATE_SUCCESS = "更新成功";
	private static String DELETE_SUCCESS = "删除成功";
	
	/** 
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
	 **/
	public void setUserService(UserService service) {
		this.userService = service;
	}
	
	/** binder用于bean属性的设置 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	}
	   
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
	}
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,UserQuery query,HttpServletRequest request) {
		query = ServletUtil.tryGetFromSession(request,query);
		Assert.isTrue(query.getPageSize() <= 200,"query.pageSize too large");
		Page<User> page = this.userService.findPage(query);
		
		model.addAttribute("page",page);
		model.addAttribute("query",query);
		return "/admin/user/index";
	}
	
	/** 显示 */
	@RequestMapping
	public String show(ModelMap model,String account) throws Exception {
		User user = (User)userService.getById(account);
		model.addAttribute("user",user);
		return "/admin/user/show";
	}

	/** 进入新增 */
	@RequestMapping
	public String add(ModelMap model,User user) throws Exception {
		model.addAttribute("user",user);
		return "/admin/user/add";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(method=RequestMethod.POST)
	public String create(ModelMap model,User user,BindingResult errors) throws Exception {
		try {
			userService.create(user);
		}catch(ConstraintViolationException e) {
			ValidationErrorsUtil.convert(e, errors);
			return  "/admin/user/add";
		}catch(MessageException e) {
			Flash.current().error(e.getMessage());
			return  "/admin/user/add";
		}
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION;
	}
	
	/** 编辑 */
	@RequestMapping
	public String edit(ModelMap model,String account) throws Exception {
		User user = (User)userService.getById(account);
		model.addAttribute("user",user);
		return "/admin/user/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(method=RequestMethod.POST)
	public String update(ModelMap model,String account,User user,BindingResult errors) throws Exception {
		try {
			userService.update(user);
		}catch(ConstraintViolationException e) {
			ValidationErrorsUtil.convert(e, errors);
			return  "/admin/user/edit";
		}catch(MessageException e) {
			Flash.current().error(e.getMessage());
			return  "/admin/user/edit";
		}
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION;
	}
	
	/** 删除 */
	@RequestMapping
	public String delete(ModelMap model,String account) {
		userService.removeById(account);
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}
	
	
	/** 上传csv文件保存  */
	@RequestMapping(method=RequestMethod.POST)
	public String upload(@RequestParam("file")  CommonsMultipartFile file)  throws Exception {
		Assert.isTrue(file.getOriginalFilename().endsWith(".csv"),"只能上传.csv文件");
		
		int skipLines = 1;
		List<Map> maps = CsvFileUtil.readCsv2Maps(file.getInputStream(),"UTF-8","account,password,name,mobile,email,remarks,enabled",skipLines);
		List<User> items = CollectionUtil.toBeanList(maps,User.class);
		
		int successCount = 0;
		int errorCount = 0;
		for(User item : items) {
			try {
				userService.create(item);
				successCount++;
			}catch(Exception e) {
				errorCount++;
				logger.info("create_User_error",e);
			}
		}
		
		Flash.current().success("上传成功,创建成功条数:"+successCount+",失败条数:"+errorCount);
		return LIST_ACTION;
	}
	
	/**
	 * 生成HTML: <select></select> 标签，生成的标签配合 jsp:include标签一起使用
	 * 应用场景：表之前有外键关联，如主从表，用于生成主从select标签,用于form表单的输入
	 * 
	 * <jsp:include page="${ctx}/admin/user/htmlSelectTag.do?selected=someForeignKeyId"/>
	 * @param selectName select标签的name
	 */
	@RequestMapping
	public String htmlSelectTag(String selectName,String selected,ModelMap model) throws Exception {
		UserQuery query = new UserQuery();
		query.setPageSize(Integer.MAX_VALUE);
		Page<User> page = userService.findPage(query);
		model.put("itemList", page.getItemList());
		model.put("selected", selected);
		model.put("selectName", StringUtils.defaultIfEmpty(selectName,"userId"));
		return "/admin/user/htmlSelectTag";
	}

}

