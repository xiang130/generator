package org.mybatis.generator.test;

import org.mybatis.generator.entity.BasisInfo;
import org.mybatis.generator.entity.JsonResult;
import org.mybatis.generator.util.EntityInfoUtil;
import org.mybatis.generator.util.Generator;
import org.mybatis.generator.util.MySqlToJavaUtil;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 说明： 自动生成工具
 */
 class MyGenerator {


	public static void main(String[] args) {

		// 基础信息：项目名、作者、版本
		String PROJECT = "wallet-manage";
		String AUTHOR = "wujp";
		String VERSION = "V1.0";

		// 数据库连接信息：连接URL、用户名、秘密、数据库名
		String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
		String NAME = "root";
		String PASS = "root";
		String DATABASE = "test";

		//实体 dao service impl mapper 的相对位置
		String ENTITY_URL = "com.buybit.wm.entity";
		String DAO_URL = "com.buybit.wm.dao";
		String XML_URL = "com.buybit.wm.dao.impl";
		String SERVICE_URL = "com.buybit.wm.service";
		String SERVICE_IMPL_URL = SERVICE_URL+".impl";
		String CONTROLLER_URL = "com.buybit.wm.web";

		//将文件生成到的位置
		String path = "E:\\a_item_work\\wallet\\wallet-manage\\wallet-manage-web";

		// 类信息：类名、表名、类说明
		String CLASSNAME = "Emp1";
		String TABLE = "emp1";
		String CLASSCOMMENT = "生成测试";

		//是否生成 toString HashCode equals方法 默认不生成
		Boolean isOther = true;
		//是否生成具体业务 默认不生成
		Boolean business = true;

		String TIME = new SimpleDateFormat("YYYY-MM-dd").format(new Date());


		String AGILE = System.currentTimeMillis() + "";
		
		BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
				DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL);
		bi.setTable(TABLE);
		bi.setEntityName(MySqlToJavaUtil.isNull(CLASSNAME)?CLASSNAME:(MySqlToJavaUtil.getClassName(TABLE)));
		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
		bi.setEntityComment(CLASSCOMMENT);
		bi.setOther(isOther);
		bi.setBusiness(business);
		try {
			bi = EntityInfoUtil.getInfo(bi);
			// 生成文件存放位置
			String fileUrl = path + "\\src\\main\\java\\";
			StringBuilder str = new StringBuilder();
			JsonResult entity = Generator.createEntity(fileUrl, bi);
			JsonResult dao = Generator.createDao(fileUrl, bi);
			JsonResult daoImpl = Generator.createDaoImpl(fileUrl, bi);


			if (entity.getCode() != 1) {
				str.append(entity.getMessage());
			}
			if (dao.getCode() != 1) {
				str.append(dao.getMessage());
			}
			if (daoImpl.getCode() != 1){
				str.append(daoImpl.getMessage());
			}


			if(bi.getBusiness()){
				JsonResult service = Generator.createService(fileUrl, bi);
				JsonResult serviceImpl = Generator.createServiceImpl(fileUrl, bi);
				JsonResult controller = Generator.createController(fileUrl, bi);

				if(service.getCode()!=1) {
					str.append(service.getMessage());
				}
				if(serviceImpl.getCode()!=1) {
					str.append(serviceImpl.getMessage());
				}
				if(controller.getCode()!=1) {
					str.append(controller.getMessage());
				}
			}


			System.out.println(str.toString().trim().length()==0?"创建成功":"创建失败："+str.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
