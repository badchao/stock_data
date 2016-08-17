package com.github.stock_data.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.rapid.common.web.scope.Flash;
import com.github.stock_data.common.web.util.LoginUtil;
import com.github.stock_data.common.web.util.WebLoginUser;
import com.github.stock_data.model.User;
import com.github.stock_data.service.UserService;

@Controller
@RequestMapping("/admin/login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String login(String username,String password,HttpServletRequest request) {
		User user = userService.getById(username);
		Assert.notNull(user,"not found user by username");
		if(user.getPassword().equals(LoginUtil.getMd5Password(password))){
			WebLoginUser loginUser = new WebLoginUser();
			loginUser.setUsername(user.getAccount());
			LoginUtil.setLoginUser(request, loginUser);
			return "redirect:/";
		}else {
			Flash.current().error("login error,incorrect username or password");
			return "redirect:/login.jsp";
		}
		
	}
	
	@RequestMapping
    public String logout(HttpServletRequest request) {
		request.getSession(true).invalidate();
		Flash.current().success("logout success");
		return "redirect:/login.jsp";
	}
	
}
