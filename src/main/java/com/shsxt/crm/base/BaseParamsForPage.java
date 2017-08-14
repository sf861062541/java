package com.shsxt.crm.base;

import org.apache.commons.lang3.StringUtils;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shsxt.crm.constant.Constant;

import lombok.Data;

@Data
public class BaseParamsForPage {
	private Integer page;
	private Integer rows;
	private String sort; // 排序
	
	public PageBounds installPageBounds(){
		if(page==null){
			this.page=Constant.PAGE;
		}
		if(rows==null){
			this.rows=Constant.ROWS;
		}
		if(StringUtils.isBlank(sort)){
			this.sort=Constant.SORT;//desc
		}
		return new PageBounds(page,rows,Order.formString(sort));
	}
}
