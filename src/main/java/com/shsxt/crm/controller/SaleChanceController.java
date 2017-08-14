package com.shsxt.crm.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.dto.SaleChanceParams;
import com.shsxt.crm.service.SaleChanceService;
import com.shsxt.crm.util.CookieUtil;
import com.shsxt.crm.vo.SaleChance;

@Controller
@RequestMapping("saleChance")
public class SaleChanceController extends BaseController{
	@Resource
	private SaleChanceService saleChanceService;
	
	@RequestMapping("index")
	public String index(){
		return "sale_chance";
	}
	
	@RequestMapping("query")
	@ResponseBody
	public Map<String, Object> query(SaleChanceParams scp){
		return saleChanceService.query(scp);
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultInfo add(SaleChance saleChance,HttpServletRequest request){
		ResultInfo resultInfo = null;
		saleChance.setCreateMan(CookieUtil.getCookieValue(request, "userName"));
		saleChanceService.add(saleChance);
		resultInfo=success();
		return resultInfo;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultInfo update(SaleChance saleChance){
		ResultInfo resultInfo = null;
		saleChanceService.update(saleChance);
		resultInfo=success();
		return resultInfo;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(String ids){
		ResultInfo resultInfo = null;
		saleChanceService.delete(ids);
		resultInfo=success();
		return resultInfo;
	}
}
