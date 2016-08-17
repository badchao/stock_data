package com.github.stock_data.admin.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.rapid.common.web.scope.Flash;
import com.github.stock_data.query.StockQuery;

@Controller
@RequestMapping("/admin/cron")
public class CronController implements ApplicationContextAware {
	ApplicationContext applicationContext;
	@RequestMapping
	public String index(ModelMap model,StockQuery query,HttpServletRequest request) {
		List<Method> methods = getAllMethodByAnnotation(applicationContext,Scheduled.class);
		model.put("methods", methods);
		return "/admin/cron/index";
	}
/*
	private <T extends Annotation> List<Method> getAllMethodByAnnotation(Class<T> annotation) {
		List<Method> methods = new ArrayList<Method>();
		
		for(String beanName : applicationContext.getBeanDefinitionNames()) {
			Object bean = getBeanIgnoreError(applicationContext,beanName);
			if(bean == null) continue;
			
			System.out.println("beanName:"+beanName);
			for(Method m : bean.getClass().getDeclaredMethods()) {
				T[] annotations = m.getAnnotationsByType(annotation);
//				System.out.println(m+" : " + StringUtils.join(m.getAnnotations(),","));
				if(ArrayUtils.isNotEmpty(annotations)) {
					methods.add(m);
				}
			}

		}
		return methods;
	}
	*/
	
	public static <T extends Annotation> List<Method> getAllMethodByAnnotation(ApplicationContext context,Class<T> annotation) {
		if(context == null) return Collections.EMPTY_LIST;
		
		List<Method> methods = new ArrayList<Method>();
		
		for(String beanName : context.getBeanDefinitionNames()) {
			Object bean = getBeanIgnoreError(context,beanName);
			if(bean == null) continue;
			
//			System.out.println("beanName:"+beanName);
			for(Method m : bean.getClass().getDeclaredMethods()) {
				T[] annotations = m.getAnnotationsByType(annotation);
//				System.out.println(m+" : " + StringUtils.join(m.getAnnotations(),","));
				if(ArrayUtils.isNotEmpty(annotations)) {
					methods.add(m);
				}
			}

		}
		
		methods.addAll(getAllMethodByAnnotation(context.getParent(),annotation));
		return methods;
	}

	private static Object getBeanIgnoreError(ApplicationContext context,String beanName) {
		try{
			Object bean = context.getBean(beanName);
			return bean;
		}catch(Exception e) {
			return null;
		}
	}
	
	private static Object getObjectByMethod(ApplicationContext context,Method targetMethod) {
		if(context == null) return null;
		
		List<Method> methods = new ArrayList<Method>();
		for(String beanName : context.getBeanDefinitionNames()) {
			Object bean = getBeanIgnoreError(context,beanName);
			if(bean == null) {
				continue;
			}
			
			for(Method m : bean.getClass().getDeclaredMethods()) {
				if(targetMethod.equals(m)) {
					return bean;
				}
			}
		}
		
		return getObjectByMethod(context.getParent(),targetMethod);
	}
	
	/** 显示 */
	@RequestMapping
	public String exec(ModelMap model,String clazz,String method,HttpServletRequest request) throws Exception {
		List<Method> methods = getAllMethodByAnnotation(applicationContext,Scheduled.class);
		for(Method m : methods) {
			if(m.getDeclaringClass().getName().equals(clazz) && m.getName().equals(method)){
				Object bean = getObjectByMethod(applicationContext,m);
				if(bean == null) {
					throw new RuntimeException("not found bean by method:"+m);
				}
				m.invoke(bean);
				Flash.current().success("method:["+m+"] exec success,timestamp:"+System.currentTimeMillis());
			}
		}
		return "redirect:"+request.getHeader("Referer");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
