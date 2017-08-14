package com.shsxt.crm.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.exception.ParamsException;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController{
	@ExceptionHandler(value=ParamsException.class)
	@ResponseBody
	public ResultInfo handlerParamException(ParamsException pe) {
		return failure(pe);
	}


}
