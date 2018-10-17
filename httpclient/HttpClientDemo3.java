import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : moon
 * Date  : 2018/10/17 17:20
 * Description : Class for httpclient request with entity
 */
public class HttpClientDemo3 {

    public static void main(String[] agrs) {
        try {
            //表单地址
            String url = "";
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);

            /**
             * 设置参数，常用的有StringEntity,UrlEncodedFormEntity,MultipartEntity
             * 具体查看org.apache.http.entity包
             */
            List<NameValuePair> params = new ArrayList();
            //表单参数设置
            params.add(new BasicNameValuePair("username", ""));
            params.add(new BasicNameValuePair("password", ""));
            UrlEncodedFormEntity e = new UrlEncodedFormEntity(params, "utf-8");
            post.setEntity(e);

            CloseableHttpResponse response = httpClient.execute(post);

            //服务器返回码
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("response status code :: " + statusCode);

            //服务器返回内容
            String respStr = null;
            HttpEntity entity = response.getEntity();
            if (entity!=null){
                respStr = EntityUtils.toString(entity,"utf-8");
            }
            System.out.println("response entity :: " + respStr);
            //释放资源
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
