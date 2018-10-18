[原文章地址](https://www.jianshu.com/p/a44407f48321)
============================

#### 1、HttpClient

1.1 创建httpclient实例对象
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

1.2 构造请求方法(Demo1)
---------------------------
构造请求方法
```java
HttpPost post = new HttpPost(url); //post请求
HttpGet get = new HttpGet(url); //get请求
```
表示我们希望用那种交互方法与服务器交互，HttpClient为每种交互方法都提供了一个类：HttpGet,HttpHead, HttpPost, HttpPut, HttpDelete, HttpTrace, 还有 HttpOptions。

1.3 提交请求(Demo2)
---------------------------
向服务器提交请求
```java
CloseableHttpResponse response = client.execute(post);
```
很明显CloseableHttpResponse就是用来处理返回数据的实体，通过它我们可以拿到返回的状态码、返回实体等等我们需要的东西。

1.4 EntityUtils工具类(Demo3)
-----------------------------
EntityUtils是官方提供一个处理返回实体的工具类，toString方法负责将返回实体转换为字符串，官方是不太建议使用这个类的，除非返回数据的服务器绝对可信和返回的内容长度是有限的。官方建议是自己使用HttpEntity.getContent()或者HttpEntity.writeTo(OutputStream)，需要提醒的是记得关闭底层资源。
```java
EntityUtils.consume(entity);
```
```java
InputStream instream = entity.getContent();
if(instream != null) {
    instream.close();
}
```

1.5 HttpClient设置(Demo4)
----------------------------
如果自己制定HttpClient客户端，需要使用`HttpClients.custom()`，然后调用各种Set方法，一般建议使用`HttpClients.custom().setDefaultRequestConfig()`,其中`org.apache.http.client.config.RequestConfig`类提供了很多可定制的参数，我们可以根据自己的需要进行相关配置。有几个参数需要设置
```
    /**
    * 请求参数设置
    * connectionRequestTimeout:
    * 从连接池中获取连接的超时时间，超过该时间未拿到可用连接,会抛出错误
    * org.apache.http.conn.ConnectionPoolTimeoutException: 
    *    Timeout waiting for connection from pool
    *
    * connectTimeout:
    * 连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
    *
    * socketTimeout:
    * 服务器返回数据(response)的时间，超出该时间抛出read timeout
    */
```
HttpClientsz在我们没有指定连接工厂时，默认使用的是连接池工厂`org.apache.http.impl.conn.PoolingHttpClientConnectionManager.PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory>)`,所以我们需要配置一下从连接池获取连接池的超时时间.
以上3个配置参数未设置的话，默认为-1，即无限时间，从而造成阻塞。



















