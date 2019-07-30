package com.bksuns.mybatis.generator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bksuns.mybatis.generator.entity.BasisInfo;
import com.bksuns.mybatis.generator.entity.PropertyInfo;
/**   
 * <p>说明：  链接数据库并获取表信息</P>
 * @version: v1.0.0
 * @author: wujp
 */
public class EntityInfoUtil {
	public static BasisInfo getInfo(BasisInfo bi) throws SQLException {
		List<PropertyInfo> columns= new ArrayList<PropertyInfo>();
		// 创建连接
		Connection con = null;
		PreparedStatement pstemt = null;
		//sql
		String sql="select column_name,data_type,column_comment from information_schema.columns where table_schema='"+bi.getDatabase()+"' and table_name='"+bi.getTable()+"'";
		try {
			con = DriverManager.getConnection(bi.getDbUrl(), bi.getDbName(), bi.getDbPassword());
			pstemt = con.prepareStatement(sql);
			ResultSet executeQuery = pstemt.executeQuery();
			while (executeQuery.next()) {
				String column = executeQuery.getString(1);
				String jdbcType = executeQuery.getString(2);
				String comment = executeQuery.getString(3);
				PropertyInfo ci=new PropertyInfo();
				ci.setColumn(column);
				if (jdbcType.equalsIgnoreCase("int")) {
					ci.setJdbcType("Integer");
				}else if (jdbcType.equalsIgnoreCase("datetime")) {
					ci.setJdbcType("timestamp");
				}else {
					ci.setJdbcType(jdbcType);
				}
				ci.setComment(comment);
				ci.setProperty(MySqlToJavaUtil.changeToJavaFiled(column));
				ci.setJavaType(MySqlToJavaUtil.jdbcTypeToJavaType(jdbcType));
				//设置注解类型
				if (column.equalsIgnoreCase("id")) {
					bi.setIdType(ci.getJavaType());
					bi.setIdJdbcType(ci.getJdbcType());
				}
				columns.add(ci);
			}
			bi.setCis(columns);
			return bi;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("自动生成实体类错误："+e.getMessage());
		} finally {
			pstemt.close();
			con.close();
		}
	}
}
