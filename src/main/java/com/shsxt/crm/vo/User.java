package com.shsxt.crm.vo;

import java.util.Date;

import lombok.Data;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Data
public class User {
	private Integer id;
	private String userName;
	private String password;
	private String trueName;
	private String email;
	private String phone;
	private Integer isValid;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date createDate;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date updateDate;
}
