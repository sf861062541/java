package com.shsxt.crm.model;

import lombok.Data;

@Data
public class MessageModel {
	private Integer CODE=200;
	private String MSG="操作成功";
	private Object result;
}
