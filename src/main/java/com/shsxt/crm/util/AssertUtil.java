package com.shsxt.crm.util;

import com.shsxt.crm.exception.ParamsException;

/**
 * 
 * @author lp
 * 对结果进行断言
 */
public class AssertUtil {
	
	public static void isTrue(Boolean flag,String msg){
		if(flag){
			throw new ParamsException(msg);
		}
		
	}
	
	public static void  isTrue(Boolean flag,Integer errorCode,String msg) {
		if(flag){
			throw new ParamsException(errorCode, msg);
		}
	}
	
	public static void  isTrue(Boolean flag,Integer errorCode) {
		if(flag){
			throw new ParamsException(errorCode);
		}
	}
}
