将mybatis生成单表的增删改工具的完善了一下

之前只生成实体和Dao,现在增加了生成Service和Controller.并优化部分代码?

增加了Swaggwe代码，模板化接口数据返回

模板各个文件模板，不符合业务，可自行修改模板 freemarker.ftl

使用时在下面的运行类中修改配置即可
com.bksuns.mybatis.generator.test.MyGenerator

``` java
		// 基础信息：项目名、作者、版本
		String PROJECT = "**-manage";
		String AUTHOR = "xiang";
		String VERSION = "V1.0";

		// 数据库连接信息：连接URL、用户名、秘密、数据库名
		String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
		String NAME = "root";
		String PASS = "root";
		String DATABASE = "test";

		//实体 dao service impl mapper 的相对位置
		String ENTITY_URL = "com.manage.entity";
		String DAO_URL = "com.manage.dao";
		String XML_URL = "com.manage.dao.impl";
		String SERVICE_URL = "com.manage.service";
		String SERVICE_IMPL_URL = SERVICE_URL+".impl";
		String CONTROLLER_URL = "com.manage.web";

		//将文件生成到的位置
		String path = "E:\\manage";

		// 类信息：类名、表名、类说明
		String CLASSNAME = "Emp1";
		String TABLE = "emp1";
		String CLASSCOMMENT = "生成测试";
```
