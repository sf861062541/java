package com.shsxt.crm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.dao.SaleChanceDao;
import com.shsxt.crm.dto.SaleChanceParams;
import com.shsxt.crm.util.AssertUtil;
import com.shsxt.crm.vo.SaleChance;

@Service
public class SaleChanceService {
	@Resource
	private SaleChanceDao saleChanceDao;

	public Map<String, Object> query(SaleChanceParams scp) {
		List<SaleChance> list = saleChanceDao.querySaleChanceForPage(scp,scp.installPageBounds());
		PageList<SaleChance> pageList=(PageList<SaleChance>) list;
		Paginator paginator = pageList.getPaginator();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("rows", pageList);
		map.put("total",paginator.getTotalCount());
		return map;
	}

	public void add(SaleChance saleChance) {
		addOrUpdateParamsCheck(saleChance);
		//分配
		if(StringUtils.isBlank(saleChance.getAssignMan())){
			saleChance.setState(0);
		}else{
			saleChance.setState(1);
			saleChance.setAssignTime(new Date());
		}
		saleChance.setIsValid(1);
		saleChance.setCreateDate(new Date());
		saleChance.setUpdateDate(new Date());
		int count = saleChanceDao.insertSaleChance(saleChance);
		AssertUtil.isTrue(count<1, Constant.ERROR_MESSAGE);
	}

	public void update(SaleChance saleChance) {
		addOrUpdateParamsCheck(saleChance);
		AssertUtil.isTrue(saleChance.getId()==null, Constant.CUSTOMER_NULL);
		SaleChance tempSaleChance = saleChanceDao.querySaleChanceById(saleChance.getId());
		AssertUtil.isTrue(tempSaleChance==null,Constant.CUSTOMER_NO_EXISTS);
		//分配
		if(StringUtils.isBlank(saleChance.getAssignMan())){
			saleChance.setState(0);
		}else{
			saleChance.setState(1);
			saleChance.setAssignTime(new Date());
		}
		saleChance.setIsValid(1);
		saleChance.setUpdateDate(new Date());
		int count = saleChanceDao.updateSaleChance(saleChance);
		AssertUtil.isTrue(count<1, Constant.ERROR_MESSAGE);
	}

	public void delete(String ids) {
		AssertUtil.isTrue(StringUtils.isBlank(ids), Constant.CUSTOMER_NULL);
		int count = saleChanceDao.deleteSaleChance(ids);
		AssertUtil.isTrue(count<1, Constant.ERROR_MESSAGE);
	}
	
	private void addOrUpdateParamsCheck(SaleChance saleChance){
		AssertUtil.isTrue(saleChance.getCustomerId()==null||StringUtils.isBlank(saleChance.getCustomerName()), 
				Constant.CUSTOMER_NAME_NULL);
		AssertUtil.isTrue(saleChance.getCgjl()==null, Constant.CGJL_NULL);
	}
}
