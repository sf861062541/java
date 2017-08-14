package com.shsxt.crm.exception;

import com.shsxt.crm.constant.Constant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ParamsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code=Constant.ERROR_CODE;
	private String msg=Constant.ERROR_MESSAGE;
	
	public ParamsException(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public ParamsException() {
	}

	public ParamsException(String msg) {
		super();
		this.msg = msg;
	}

	public ParamsException(Integer code) {
		super();
		this.code = code;
	}
	
}
