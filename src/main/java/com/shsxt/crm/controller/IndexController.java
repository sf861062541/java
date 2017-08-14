package com.shsxt.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.util.CookieUtil;

@Controller
public class IndexController extends BaseController {
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("main")
	public String main(Model model,HttpServletRequest request){
		String userName = CookieUtil.getCookieValue(request, "userName");
		String trueName = CookieUtil.getCookieValue(request, "trueName");
		model.addAttribute("userName", userName);
		model.addAttribute("trueName", trueName);
		return "main";
	}
}
