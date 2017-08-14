package com.shsxt.crm.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.exception.ParamsException;

public class BaseController {
	@ModelAttribute
	public void preMethod(Model model,HttpServletRequest request){
		String path = request.getContextPath();
		model.addAttribute("ctx", path);
	}
	
	public ResultInfo failure(Integer code,String msg){
		return new ResultInfo(code, msg);
	}
	
	public ResultInfo failure(ParamsException pe){
		return failure(pe.getCode(), pe.getMsg());
	}
	
	public ResultInfo success(Object object){
		return new ResultInfo(Constant.SUCCESS_CODE, Constant.SUCCESS_MESSAGE, object);
	}
	
	public ResultInfo success(){
		return new ResultInfo(Constant.SUCCESS_CODE, Constant.SUCCESS_MESSAGE);
	}
}
