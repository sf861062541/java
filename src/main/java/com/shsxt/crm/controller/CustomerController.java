package com.shsxt.crm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.dto.CustomerDto;
import com.shsxt.crm.service.CustomerService;

@RequestMapping("customer")
@Controller
public class CustomerController extends BaseController{
	
	
	@Resource
	private CustomerService customerService;
	
	@RequestMapping("queryCustomerNames")
	@ResponseBody
	public List<CustomerDto> queryCustomerNames(){
		return customerService.queryCustomerNames();
	}
}
