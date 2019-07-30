package com.bksuns.mybatis.generator.entity;

import java.io.Serializable;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 返回结果json对象</P>
 * @version: v1.0.0
 * @author: wujp
 */

public class JsonResult implements Serializable{
	
	private static final long serialVersionUID = 123126L;
	
	private Integer code;
	
	private String message;
	
	private Object data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
