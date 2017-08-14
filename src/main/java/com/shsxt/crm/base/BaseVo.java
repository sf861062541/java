package com.shsxt.crm.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class BaseVo {
	private Integer id;
	private Integer isValid;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createDate;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date updateDate;
}
