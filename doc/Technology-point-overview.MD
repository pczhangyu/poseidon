#  <center> 选用技术概览 </center >

核心框架	Apache Spring Framework
视图框架	Apache Spring MVC
持久框架	Apache Mybatis, Hibernate
模板引擎	Apache FreeMarker
搜索引擎	Apache Elasticsearch
程序构建	Apache Maven
负载均衡、静态服务器	Apache Nginx
数据库	MySQL
缓存	Apache Redis
数据库连接池	阿里巴巴 Druid
日志处理	Apache Log4j
报表系统	xchart, ECharts
JSON处理	Google Gson
商家后台页面	Bootstrap、Html5
富文本编辑器	Summernote
日期控件	Datetimepicker
JS库	jQuery
图片延迟加载	jQuery.lazyload

Apache Tomcat
Tomcat 服务器是一个免费的开放源代码的 Web 应用服务器,属于轻量 级应用服务器,在中小型系统和并发访问用户不是很多的场合下被普遍使用,是 开发和调试 JSP 程序的首选。

Nginx
Nginx是一款轻量级的 Web 服务器/反向代理服务器 及电子邮件(IMAP/POP3)代理服务器,并在一个 BSD-like 协议下发行。其特点是占有内存少,并发能力强,事实 上 nginx 的并发能力确实在同类型的网页服务器中表现较好.中国大陆使用 nginx 网站用户有:苏宁易购、京东、 腾讯等。

Spring Framework
Spring Framework 框架是一个基于 IoC 和 AOP 的构架多层 J2EE 系统的 框架。它实现了很优雅的 MVC,对不同的数据访问技术提供了统一的 接口,采用 IoC 使得可以很容易的实现 bean 的装配,提供了简洁的 AOP 并据此实现 Transcation Management。

FreeMarker
FreeMarker 允许 Java Servlet 保持图形设计同应用程序逻辑的分离,这是 通过在模板中密封HTML完成的。模板用Servlet提供的数据动态地生成 HTML。模板语言是强大的直观的,编译器速度快,输出接近静态 HTML 页面的速度。

MyBatis
MyBatis 是支持普通 SQL查询,存储过程和高级映射的优秀持久层框架。 MyBatis 消除了几乎所有的 JDBC 代码和参数的手工设置以及结果集的检索。 MyBatis 使用简单的 XML 或注解用于配置和原始映射,将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java 对象)映射成数据库中的记录。

Redis
Redis 是一个 key-value 存储系统。它支持存储的 value 类型相对更多,包括 string(字符串)、list(链表)、set(集合)、zset(sorted set --有序集合)和 hash(哈希类型) 。这些数据类型都支持 push/pop、 add/remove 及取交集并集和差集及更丰富的操作,而且这些操作都是原子性的。
Redis 是一个高性能的 key-value 数据库。 redis 的出现,很大程度补偿 了 memcached 这类 key/value 存储的不足,在部 分场合可以对关系数据库起 到很好的补充作用。它提供了 Java,C/C++,C#,PHP,JavaScript,Perl, Object C,Python,Ruby,Erlang 等客户端,使用很方便。
Redis 支持主从同步。数据可以从主服务器向任意数量的从服务器上同步, 从服务器可以是关联其他从服务器的主服务器。这使得 Redis 可执行单层树复制。 存盘可以有意无意的对数据进行写操作。由于完全实现了发布/订阅机制,使得 从数据库在任何地方同步树时,可订阅一个频道并接收主服务器完整的消息发布 记录。同步对读取操作的可扩展性和数据冗余很有帮助。

Elasticsearch
ElasticSearch 是一个基于 Lucene 的搜索服务器。它提供了一个分布式多 用户能力的全文搜索引擎,基于 RESTful web 接口。Elasticsearch 是用 Java 开发的,并作为 Apache 许可条款下的开放源码发布,是第二流行的企业搜索引 擎。设计用于云计算中,能够达到实时搜索,稳定,可靠,快速,安装使用方便。 我们建立一个网站或应用程序,并要添加搜索功能,令我们受打击的是:搜索工 作是很难的。我们希望我们的搜索解决方案要快,我们希望有一个零配置和一个 完全免费的搜索模式,我们希望能够简单地使用 JSON 通过 HTTP 的索引数据, 我们希望我们的搜索服务器始终可用,我们希望能够一台开始并扩展到数百,我 们要实时搜索,我们要简单的多租户,我们希望建立一个云的解决方案。

MySQL 数据库
可以说这是企业网站 Linux 平台的首选自由数据库系统。它是一个跨平台数 据库系统,一个真正的多用户、多线程的 SQL 数据库系统,同时是具有客户机/ 服务器体系结构的分布式数据库管理系统。同时,也是 Linux 系统中使用最为简 单的数据库系统,安装简单、使用简单、管理也简单,且数据库系统的稳定性表 现也非常好。

React Native
React Native（简称RN）是Facebook于2015年4月开源的跨平台移动应用开发框架，是Facebook早先开源的UI框架 React 在原生移动应用平台的衍生产物，目前支持iOS和安卓两大平台。优势如下：
可以基于 React Native使用 JavaScript 编写应用逻辑，UI 则可以保持全是原生的。这样的话就没有必要就 Html5 的 UI 做出常见的妥协；
React 引入了一种与众不同的、略显激进但具备高可用性的方案来构建用户界面。长话短说，应用的 UI 简单通过一个基于应用目前状态的函数来表达。