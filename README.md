咱们之前用的那个mybatis 生成单表增删改工具的完善了一下，
之前只能生成实体和dao,现在可以多生成service 和 Controller 并把其中臃肿部分去掉了，
增加了写 模板化注释，模板化接口数据返回,
就是没有界面（源码版：这样的话就比较灵活，如果不符合业务，可自行修改模板），
用的时候需要把这个项目当下来，改下配置就可以使用了

模板各个文件模板，不符合业务，可自行修改模板
freemarker.ftl

使用是在下面的运行类中修改配置即可
com.bksuns.mybatis.generator.test.MyGenerator

``` java
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
```