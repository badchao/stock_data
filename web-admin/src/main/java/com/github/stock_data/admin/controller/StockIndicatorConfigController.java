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
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.github.stock_data.common.util.JsonUtil;
import com.github.stock_data.dao.*;
import com.github.stock_data.service.*;
import com.github.stock_data.service.impl.StockIndicatorCrawler;
import com.github.stock_data.query.*;

/**
 * [StockIndicatorConfig] 的Controller
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 *
 */
@Controller
@RequestMapping("/admin/stockindicatorconfig")
public class StockIndicatorConfigController {

	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private static Logger logger = LoggerFactory.getLogger(StockIndicatorConfigController.class);
	
	private StockIndicatorConfigService stockIndicatorConfigService;
	
	private final String LIST_ACTION = "redirect:/admin/stockindicatorconfig/index.do?useSessionParam=true";
	
	private static String CREATED_SUCCESS = "创建成功";
	private static String UPDATE_SUCCESS = "更新成功";
	private static String DELETE_SUCCESS = "删除成功";
	
	/** 
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
	 **/
	public void setStockIndicatorConfigService(StockIndicatorConfigService service) {
		this.stockIndicatorConfigService = service;
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
	public String index(ModelMap model,StockIndicatorConfigQuery query,HttpServletRequest request) {
		query = ServletUtil.tryGetFromSession(request,query);
		Assert.isTrue(query.getPageSize() <= 200,"query.pageSize too large");
		Page<StockIndicatorConfig> page = this.stockIndicatorConfigService.findPage(query);
		
		model.addAttribute("page",page);
		model.addAttribute("query",query);
		return "/admin/stockindicatorconfig/index";
	}
	
	/** 显示 */
	@RequestMapping
	public String show(ModelMap model,String stockId, String indicatorId) throws Exception {
		StockIndicatorConfig stockIndicatorConfig = (StockIndicatorConfig)stockIndicatorConfigService.getById(stockId,indicatorId);
		model.addAttribute("stockIndicatorConfig",stockIndicatorConfig);
		return "/admin/stockindicatorconfig/show";
	}

	/** 进入新增 */
	@RequestMapping
	public String add(ModelMap model,StockIndicatorConfig stockIndicatorConfig) throws Exception {
		model.addAttribute("stockIndicatorConfig",stockIndicatorConfig);
		return "/admin/stockindicatorconfig/add";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(method=RequestMethod.POST)
	public String create(ModelMap model,StockIndicatorConfig stockIndicatorConfig,BindingResult errors) throws Exception {
		try {
			stockIndicatorConfigService.create(stockIndicatorConfig);
		}catch(ConstraintViolationException e) {
			ValidationErrorsUtil.convert(e, errors);
			return  "/admin/stockindicatorconfig/add";
		}catch(MessageException e) {
			Flash.current().error(e.getMessage());
			return  "/admin/stockindicatorconfig/add";
		}
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION+"?stockId="+stockIndicatorConfig.getStockId();
	}
	
	/** 编辑 */
	@RequestMapping
	public String edit(ModelMap model,String stockId, String indicatorId) throws Exception {
		StockIndicatorConfig stockIndicatorConfig = (StockIndicatorConfig)stockIndicatorConfigService.getById(stockId,indicatorId);
		model.addAttribute("stockIndicatorConfig",stockIndicatorConfig);
		return "/admin/stockindicatorconfig/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(method=RequestMethod.POST)
	public String update(ModelMap model,String stockId, String indicatorId,StockIndicatorConfig stockIndicatorConfig,BindingResult errors) throws Exception {
		try {
			stockIndicatorConfigService.update(stockIndicatorConfig);
		}catch(ConstraintViolationException e) {
			ValidationErrorsUtil.convert(e, errors);
			return  "/admin/stockindicatorconfig/edit";
		}catch(MessageException e) {
			Flash.current().error(e.getMessage());
			return  "/admin/stockindicatorconfig/edit";
		}
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION+"&stockId="+stockIndicatorConfig.getStockId();
	}
	
	/** 删除 */
	@RequestMapping
	public String delete(ModelMap model,String stockId, String indicatorId) {
		stockIndicatorConfigService.removeById(stockId,indicatorId);
		
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION+"&stockId="+stockId;
	}
	
	
	/** 上传csv文件保存  */
	@RequestMapping(method=RequestMethod.POST)
	public String upload(@RequestParam("file")  CommonsMultipartFile file)  throws Exception {
		Assert.isTrue(file.getOriginalFilename().endsWith(".csv"),"只能上传.csv文件");
		
		int skipLines = 1;
		List<Map> maps = CsvFileUtil.readCsv2Maps(file.getInputStream(),"UTF-8","stockId,indicatorId,indicatorName,crawlUrl,crawlScript,crawlCron,calcExpr,remarks",skipLines);
		List<StockIndicatorConfig> items = CollectionUtil.toBeanList(maps,StockIndicatorConfig.class);
		
		int successCount = 0;
		int errorCount = 0;
		for(StockIndicatorConfig item : items) {
			try {
				stockIndicatorConfigService.create(item);
				successCount++;
			}catch(Exception e) {
				errorCount++;
				logger.info("create_StockIndicatorConfig_error",e);
			}
		}
		
		Flash.current().success("上传成功,创建成功条数:"+successCount+",失败条数:"+errorCount);
		return LIST_ACTION;
	}
	
	/**
	 * 生成HTML: <select></select> 标签，生成的标签配合 jsp:include标签一起使用
	 * 应用场景：表之前有外键关联，如主从表，用于生成主从select标签,用于form表单的输入
	 * 
	 * <jsp:include page="${ctx}/admin/stockindicatorconfig/htmlSelectTag.do?selected=someForeignKeyId"/>
	 * @param selectName select标签的name
	 */
	@RequestMapping
	public String htmlSelectTag(String selectName,String selected,ModelMap model) throws Exception {
		StockIndicatorConfigQuery query = new StockIndicatorConfigQuery();
		query.setPageSize(Integer.MAX_VALUE);
		Page<StockIndicatorConfig> page = stockIndicatorConfigService.findPage(query);
		model.put("itemList", page.getItemList());
		model.put("selected", selected);
		model.put("selectName", StringUtils.defaultIfEmpty(selectName,"stockIndicatorConfigId"));
		return "/admin/stockindicatorconfig/htmlSelectTag";
	}

	@RequestMapping
	@ResponseBody
	public String evalCrawlScript(ModelMap model,StockIndicatorConfig config) throws Exception {
		StockIndicatorCrawler c = new StockIndicatorCrawler();
		try {
			Object result = c.evalCrawlScript(config);
			return JsonUtil.toJson(result);
		}catch(Exception e) {
			e.printStackTrace();
			return "error:"+e.getMessage();
		}
	}
	
}

