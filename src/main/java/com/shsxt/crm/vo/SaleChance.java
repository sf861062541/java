package com.shsxt.crm.vo;

import java.util.Date;

import com.shsxt.crm.base.BaseVo;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class SaleChance extends BaseVo{
	private String chanceSource;
	private Integer customerId;
	private String customerName;
	private Integer cgjl;
	private String overview;
	private String linkMan;
	private String linkPhone;
	private String description;
	private String createMan;
	private String assignMan;
	private Date assignTime;
	private Integer state;
	private Integer devResult;
}
