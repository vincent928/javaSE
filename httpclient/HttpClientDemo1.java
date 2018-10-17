/**
 * Author : moon
 * Date  : 2018/10/17 14:59
 * Description : Class for httpclient4.5.6 demo
 */

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * HttpClient的使用步骤：
 * 使用Apache的HttpClient发送GET和POST请求的步骤如下:
 * 1. 使用帮助类HttpClients创建CloseableHttpClient对象.
 * 2. 基于要发送的HTTP请求类型创建HttpGet或者HttpPost实例.
 * 3. 使用addHeader方法添加请求头部,诸如User-Agent, Accept-Encoding等参数.
 * 4. 对于POST请求,创建NameValuePair列表,并添加所有的表单参数.然后把它填充进HttpPost实体.
 * 5. 通过执行此HttpGet或者HttpPost请求获取CloseableHttpResponse实例
 * 6. 从此CloseableHttpResponse实例中获取状态码,错误信息,以及响应页面等等.
 * 7. 最后关闭HttpClient资源.
 */

public class HttpClientDemo1 {

    /**
     * 1. 创建HttpClient对象，HttpClients.createDefault()。
     *
     * 2. 创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象，HttpPost httpPost = new HttpPost(url)。
     *
     * 3. 如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HetpParams params)方法来添加请求参数；对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();valuePairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()))；httpPost.setEntity(formEntity)。
     *
     * 4. 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。
     *
     * 5. 调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。
     *
     * 6. 释放连接。无论执行方法是否成功，都必须释放连接
     */

    /**
     * GET请求
     *
     * @param url
     */
    public void doGet(String url) {
        try {
            //1、想象成创建浏览器的过程，提供HttpClient的工具
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //2、创建表单的过程，选择Get还是Post
            HttpGet httpGet = new HttpGet(url);
            //3、提交表单的过程
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                //4、业务处理
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * POST请求
     *
     * @param url
     */
    public void doPost(String url) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
                //业务处理
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
