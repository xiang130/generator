package com.bksuns.mybatis.generator.convert;

/**   
* Copyright: Copyright (c) 2019 
* 
* <p>说明: 该类的功能描述</p>
* @version: v1.0.0
* @author: wujp
*/
public interface ITypeConvert {
	/**
     * <p>说明:执行类型转换</p>
     * @param dateType 	时间类型
     * @param fieldType 字段类型
     * @return ignore
     */
    IColumnType processTypeConvert(DateType dateType , String fieldType);
}
