package com.bksuns.mybatis.generator.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.bksuns.mybatis.generator.entity.BasisInfo;
import com.bksuns.mybatis.generator.entity.JsonResult;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * <p>说明：  创建文件</P>
 * @version: v1.0
 * @author: wujp
 */
public class FreemarkerUtil {
	 
	public static JsonResult createFile(BasisInfo dataModel, String templateName, String filePath) {
		JsonResult result=new JsonResult();
		FileWriter out = null;
		String fileName=dataModel.getEntityName()+messageStr(templateName);
		try {
			// 通过FreeMarker的Confuguration读取相应的模板文件
	        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
	        // 设置模板路径
	        configuration.setClassForTemplateLoading(FreemarkerUtil.class, "/freemarker/ftl");
	        // 设置默认字体
	        configuration.setDefaultEncoding("utf-8");
	        // 获取模板
			Template template = configuration.getTemplate(templateName);
			File file = new File(filePath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if(!file.exists()) {
                file.createNewFile();
            }else {
				file.delete();
				file.createNewFile();
            }
			
			//设置输出流
            out = new FileWriter(file);
            //模板输出静态文件
            template.process(dataModel, out);
            result.setCode(1);
        	result.setMessage("创建"+fileName+"成功");
        	return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		result.setCode(-1);
    	result.setMessage("创建"+fileName+"失败");
    	return result;
	}
	
	public static String messageStr(String name) {
		if (name.equals("entity.ftl")) {
			name=".java";
		} else if(name.equals("dao.ftl")){
			name="Dao.java";
		} else if(name.equals("mapper.ftl")){
			name="Dao.xml";
		} else if(name.equals("service.ftl")){
			name="Service.java";
		} else if(name.equals("serviceImpl.ftl")){
			name="ServiceImpl.java";
		} else if(name.equals("controller.ftl")){
			name="Controller.java";
		} 
		return name;
	}
}
