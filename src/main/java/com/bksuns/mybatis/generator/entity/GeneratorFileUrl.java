package com.bksuns.mybatis.generator.entity;

import java.io.Serializable;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 自动生成文件路径</P>
 * @version: v1.0.0
 * @author: wujp
 */

public class GeneratorFileUrl implements Serializable{
	private static final long serialVersionUID = 123125L;

	private String entityUrl;
	 
	private String daoUrl;
	 
	private String mapperUrl;
	 
	private String serviceUrl;
	 
	private String serviceImplUrl;
	 
	private String controllerUrl;

	public String getEntityUrl() {
		return entityUrl;
	}

	public void setEntityUrl(String entityUrl) {
		this.entityUrl = entityUrl;
	}

	public String getDaoUrl() {
		return daoUrl;
	}

	public void setDaoUrl(String daoUrl) {
		this.daoUrl = daoUrl;
	}

	public String getMapperUrl() {
		return mapperUrl;
	}

	public void setMapperUrl(String mapperUrl) {
		this.mapperUrl = mapperUrl;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getServiceImplUrl() {
		return serviceImplUrl;
	}

	public void setServiceImplUrl(String serviceImplUrl) {
		this.serviceImplUrl = serviceImplUrl;
	}

	public String getControllerUrl() {
		return controllerUrl;
	}

	public void setControllerUrl(String controllerUrl) {
		this.controllerUrl = controllerUrl;
	}
}
