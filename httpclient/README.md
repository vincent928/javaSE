[原文章地址]
(https://www.jianshu.com/p/a44407f48321)
[TOC]
#### 1、HttpClient

1.1 向服务器发送请求
----------------------------

如果向服务器发送请求，需要创建一个`org.apache.http.client.HttpClient`
的实例，一般为`org.apache.http.impl.client.CloseableHttpClient`，
创建该对象的最简单方法是
```java
CloseableHttpClient client = HttpClients.createDefault();
```
HttpClients是负责创建CloseableHttpClient的工厂，现在我们用最简单的方法就是使用默认配置去创建实例，后面我们再讨论有参数定制需求的实例创建方法。我们可以通过打断点的方式看到这个默认的实例对象的
连接管理器 ：`org.apache.http.conn.HttpClientConnectionManager`、
请求配置 ：`org.apache.http.client.config.RequestConfig`
等配置的默认参数，这些都是后面需要了解的。
