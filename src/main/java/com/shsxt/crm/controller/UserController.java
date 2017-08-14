package com.shsxt.crm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.vo.CookieUser;
import com.shsxt.crm.vo.User;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{
	@Resource
	private UserService userService;
	
	@RequestMapping("login")
	@ResponseBody
	public ResultInfo login(User user){
		ResultInfo resultInfo=null;
		CookieUser cookieUser = userService.login(user);
		resultInfo = success(cookieUser);
		return resultInfo;
	}
	
	@RequestMapping("queryManagerTrueNames")
	@ResponseBody
	public List<UserDto> queryManagerTrueNames(){
		return userService.queryManagerTrueNames();
	}
}
