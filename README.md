# B2C网上购物系统 

觉得对你有帮助的话请作者喝杯咖啡趴~Thanks♪(･ω･)ﾉ

![微信收款码](https://cdn.jsdelivr.net/gh/diaomina/project-images@master/%E6%94%B6%E6%AC%BE%E7%A0%81/wx.jpg)

## 一、开发环境

JDK1.8、MySQL5.6、Tomcat8、IDEA2019、Maven3.6、Git

## 二、使用技术

​	前端：thymyleaf 、html、css、js、jquery、layer、bootstrap

​	后端：SpringBoot、Mybatis

## 三、项目介绍

​	本系统采用B/S架构开发，实现了一个网上购物的平台，追寻现代潮流为消费者提供便捷，改善消费者购物体验。采用了MVC的模式，整个系统分为表现层、业务层、数据访问层，其中model与mapper由Mybatis逆向工程自动生成，通过SpringBoot的Ioc功能将service的实现类注入到控制器中，用户通过游览器发起请求将数据传输到控制器，前后端交互采用Ajax+JSON的方式。系统分为前台与后台，前台主要针对消费者使用，后台管理员进行使用。主要模块如下：

​	前台：登录注册模块、商品查询模块、购物车模块、我的订单模块、支付模块、用户中心模块、用户权限管理模块；

​	后台：管理员登录模块、订单管理模块、商品管理模块、用户管理模块、广告管理模块、管理员权限管理模块；

演示地址（服务器没有做安全，请不要恶意攻击）：

​	a. 前台首页：http://www.b2c-shop.diaomina.xyz/goodsAction/goIndex  

​	b. 管理员登录： http://www.b2c-shop.diaomina.xyz/adminAction/goLogin  

用户账户：user	123456

管理员账户：admin	123456

## 四、运行教程

1.导入项目

​	（1）将项目克隆至本地

```
git clone https://github.com/diaomina/b2c-shop.git
```

​	（2）导入idea或者eclipse等（本人使用的是idea开发，如果需要导入eclipse请自行在网上查找教程）

本项目为maven项目，请参考教程： https://blog.csdn.net/wd2014610/article/details/79637935?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task 



当然也可以在idea等工具上采用Git直接拉取本项目，方法可以百度

2.创建数据库

​		创建数据库 --> 数据库名称：db_b2c_shop

​								  字符编码：utf8mb4

​								  排序规则：utf8_general_ci

​		将 b2c-shop\db目录下的db_b2c_shop.sql文件导入，生成表和数据。

3.环境配置

​	（1）修改开发环境工程文件：b2c-shop\src\main\resources\application-dev.properties

​					输入自己的配置信息(数据库用户名、密码，tomcat端口号等)

​	（2）该项目采用maven，所以需要包含maven环境，并且将所需的依赖完整正确的下载。		

4.运行项目

​	（1）运行启动类 --> b2c-shop\src\main\java\com\soft\b2cshop\B2cShopApplication.java

​	（2）打开游览器在地址栏输入访问地址：

​	前台首页：http://localhost:8081/goodsAction/goIndex

​	管理员登录： http://localhost:8081/adminAction/goLogin 

