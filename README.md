将mybatis生成单表的增删改工具的完善了一下

之前只生成实体和Dao,现在增加了生成Service和Controller.并优化部分代码?

增加了Swaggwe代码，模板化接口数据返回

模板各个文件模板，不符合业务，可自行修改模板 freemarker.ftl

使用时在下面的运行类中修改配置即可
org.mybatis.generator.test.MyGenerator

像模板其中的 分页类，JsonResult 的路径，使用时需要改为自己的路径，否则生成的话路径还需要自己在整改，
	

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
		String path = "E:\\manage";

		// 类信息：类名、表名、类说明
		String CLASSNAME = "Emp1";
		String TABLE = "emp1";
		String CLASSCOMMENT = "生成测试";

		//是否生成 toString HashCode equals方法 默认不生成
		Boolean isOther = true;
		//是否生成具体业务 默认不生成
		Boolean business = true;
```
