咱们之前用的那个mybatis 生成单表增删改工具的完善了一下，
之前只能生成实体和dao,现在可以多生成service 和 Controller 并把其中臃肿部分去掉了，
增加了写 模板化注释，模板化接口数据返回,
就是没有界面（源码版：这样的话就比较灵活，如果不符合业务，可自行修改模板），
用的时候需要把这个项目当下来，改下配置就可以使用了

模板各个文件模板，不符合业务，可自行修改模板
freemarker.ftl

使用是在下面的运行类中修改配置即可
com.bksuns.mybatis.generator.test.MyGenerator

