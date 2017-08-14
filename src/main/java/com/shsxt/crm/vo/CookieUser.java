package com.shsxt.crm.vo;

import lombok.Data;


@Data
public class CookieUser {
	private String id;//加密后的id
	private String userName;
	private String trueName;
}
