package com.shsxt.crm.base;

import lombok.Data;

@Data
public class ResultInfo {
	private Integer code;
	private String msg;
	private Object result;
	
	public ResultInfo() {
	}

	public ResultInfo(String msg) {
		super();
		this.msg = msg;
	}



	public ResultInfo(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public ResultInfo(Integer code, String msg, Object result) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
	}
}
