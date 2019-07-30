package com.bksuns.mybatis.generator.util;

import com.bksuns.mybatis.generator.convert.DateType;
import com.bksuns.mybatis.generator.convert.MySqlTypeConvert;
/**
 * <p>说明： 获奖java中需要的驼峰命名</P>
 * @version: v1.0
 * @author: wujp
 */
public class MySqlToJavaUtil {
	
	/**
     * <p>说明:获取java类名</p>
     * @param table  表名
     * @return String
     */
	public static String getClassName(String table) {
		table=changeToJavaFiled(table);
		StringBuilder sbuilder = new StringBuilder();
		char[] cs = table.toCharArray();
		cs[0] -= 32;
		sbuilder.append(String.valueOf(cs));
		return sbuilder.toString();
	}

	/**
	 * <p>说明:判断是否为空</p>
	 * @param obj
	 * @return boolean
	 */
	public static Boolean isNull(Object obj){
		if(obj==null||obj.toString().trim().equals("")){
			return true;
		}else{
			return false;
		}
	}

	/**
     * <p>说明:获取字段名，把"_"后面字母变大写</p>
     * @param field  字段名
     * @return String
     */
	public static String changeToJavaFiled(String field) {
		String[] fields = field.split("_");
		StringBuilder sbuilder = new StringBuilder(fields[0]);
		for (int i = 1; i < fields.length; i++) {
			char[] cs = fields[i].toCharArray();
			cs[0] -= 32;
			sbuilder.append(String.valueOf(cs));
		}
		return sbuilder.toString();
	}

	/**
     * <p>说明:把sql的数据类型转为java需要的类型</p>
     * @param sqlType  sql类型
     * @return String  java类型
     */
	public static String jdbcTypeToJavaType(String sqlType) {
		MySqlTypeConvert typeConvert= new MySqlTypeConvert();
		return typeConvert.processTypeConvert(DateType.ONLY_DATE, sqlType).getType();
	}
}
