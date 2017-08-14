package com.shsxt.crm.dto;

import com.shsxt.crm.base.BaseParamsForPage;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SaleChanceParams extends BaseParamsForPage{
	
	private String customerName;
	private String overview; 
	private String createMan;
	private Integer state; // 0=未分配 1=已分配
	
	
}
