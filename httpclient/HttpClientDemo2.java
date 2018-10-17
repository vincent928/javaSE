import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Author : moon
 * Date  : 2018/10/17 15:45
 * Description : Class for httpclient request without entity
 */
public class HttpClientDemo2 {

    public static void main(String[] agrs) {
        try {
            String url = "http://www.baidu.com";
            //使用默认配置创建httpclient的实例
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            //服务器返回状态码
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("response status code :: " + statusCode);
            //服务器返回内容
            String respStr = null;
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //内容编码
                //respStr = EntityUtils.toString(entity); 中文乱码
                respStr = EntityUtils.toString(entity, "utf-8");
            }
            System.out.println("response entity :: " + respStr);
            //释放资源
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
