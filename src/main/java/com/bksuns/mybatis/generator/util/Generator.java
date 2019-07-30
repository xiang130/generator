package com.bksuns.mybatis.generator.util;

import java.util.List;

import com.bksuns.mybatis.generator.entity.BasisInfo;
import com.bksuns.mybatis.generator.entity.JsonResult;
import com.bksuns.mybatis.generator.entity.PropertyInfo;

/**
 * <p>说明：  获取文件路径调用创建文件</P>
 * @version: v1.0
 * @author: wujp
 */
public class Generator {
	//路径信息

	public static final String ENTITY="entity";
	public static final String DAO="dao";
	public static final String DAO_IMPL="daoImpl";
	public static final String SERVICE="service";
	public static final String SERVICE_IMPL="serviceImpl";
	public static final String CONTROLLER="controller";


	/**
	 * 创建实体类
	 */
	public static JsonResult createEntity(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getEntityUrl(), bi.getEntityName(), ENTITY);
		return FreemarkerUtil.createFile(bi, "entity.ftl", fileUrl);
	}

	/**
	 * 创建DAO
	 */
	public static JsonResult createDao(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getDaoUrl(), bi.getEntityName(), DAO);
		return FreemarkerUtil.createFile(bi, "dao.ftl", fileUrl);
	}

	/**
	 * 创建mapper配置文件
	 */
	public static JsonResult createDaoImpl(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getMapperUrl(), bi.getEntityName(), DAO_IMPL);
		List<PropertyInfo> list=bi.getCis();
		String agile="";
		for (PropertyInfo propertyInfo : list) {
			agile=agile+propertyInfo.getColumn()+", ";
		}
		agile=agile.substring(0, agile.length()-2);
		bi.setAgile(agile);
		return FreemarkerUtil.createFile(bi, "mapper.ftl", fileUrl);
	}

	/**
	 * 创建SERVICE
	 */
	public static JsonResult createService(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getServiceUrl(), bi.getEntityName(), SERVICE);
		return FreemarkerUtil.createFile(bi, "service.ftl", fileUrl);
	}

	/**
	 * 创建SERVICE_IMPL
	 */
	public static JsonResult createServiceImpl(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getServiceImplUrl(), bi.getEntityName(), SERVICE_IMPL);
		return FreemarkerUtil.createFile(bi, "serviceImpl.ftl", fileUrl);
	}

	/**
	 * 创建CONTROLLER
	 */
	public static JsonResult createController(String url,BasisInfo bi) {
		String fileUrl= getGeneratorFileUrl(url, bi.getControllerUrl(), bi.getEntityName(), CONTROLLER);
		return FreemarkerUtil.createFile(bi, "controller.ftl", fileUrl);
	}

	/**
	 * 生成文件
	 */
	public static String getGeneratorFileUrl(String url,String packageUrl,String entityName, String type){
		if (type.equals("entity")) {
			return url+pageToUrl(packageUrl)+entityName+".java";
		}else if(type.equals("dao")) {
			return url+pageToUrl(packageUrl)+entityName+"Dao.java";
		}else if(type.equals("daoImpl")) {
			return url+pageToUrl(packageUrl)+entityName+"Dao.xml";
		}else if(type.equals("service")) {
			return url+pageToUrl(packageUrl)+entityName+"Service.java";
		}else if(type.equals("serviceImpl")) {
			return url+pageToUrl(packageUrl)+entityName+"ServiceImpl.java";
		}else if(type.equals("controller")) {
			return url+pageToUrl(packageUrl)+entityName+"Controller.java";
		}
		return null;
	}
	
	public static String pageToUrl(String url) {
		return url.replace(".", "/")+"/";
	}
}
