spring+h2+powermock
==========================

什么是powermock
-------------
powerMock测试解决的是隔离外部接口对自己项目的影响,比如项目依赖别的项目的接口，或者数据库，powerMock可以自由操作这些依赖，防止外部对自己的影响，让我们做好自己的事情就好。

在 Java 领域已经有如此多的 Mock 框架，比如 EasyMock，JMock，Mockito
为什么还要有 PowerMock 的存在，上述三个已经有重复发明轮子的嫌疑，为什么还要大
家去使用 PowerMock 呢？
其实 PowerMock 并不是重发发明轮子，他的出现只是为了解决上述三种框架根本没
有办法完成的工作，比如 Mock 一个 Static 方法等等，更多的将 PowerMock 理解为对现
有 Mock 框架的扩展和进一步封装是比较贴切的。

我采用的是 Junit+PowerMock+Mockito 这样的组合来进行测试的。

什么是H2
-------------
就是内存数据库，一个jar包就可以使用了，支持mysql.用了它，真实环境的mysql就可以不用了

环境搭建
-------------

* 加测试的jar包，包括，spring-test,junit,dbjunit,powermock,spring-test-dbjunit,h2,具体看项目中的pom

* 构建spring的测试环境，主要是spring.h2db.xml,h2.properties配置文件，在spring.h2db.xml中需要建表的sql.

* 创建BaseTest,这里主要是初始化spring，还有powerMock(在setUp里).


具体的使用
-------------------
具体的使用在项目中，说一下注意的地方：

* 建表语句要删除了一些mysql中特有的东西，比如innodb，编码格式等。否则初始化会报错
  
* powermock文件夹下是根据PowerMock.pdf写的。一共有十种使用情况。我把有些地方换成了注解的形式

* service文件夹是我根据我在工作中遇到的几种情况，其中主要是和spring整合，解决了多层调用mock的问题

* controller文件夹是对controller层的mock,不用启动tomcat

* 根目录下的sql文件夹是项目中用到的sql,doc文件夹下是Power.pdf,建议照着pdf去看代码