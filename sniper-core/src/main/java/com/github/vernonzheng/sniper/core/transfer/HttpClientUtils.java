package com.github.vernonzheng.sniper.core.transfer;

import com.sun.deploy.net.HttpResponse;

import java.io.IOException;

/**
 * Created by vernonzheng on 18/7/8.
 */
public class HttpClientUtils {

    public String get() {
        CloseableHttpClient httpCilent2 = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)   //设置连接超时时间
                .setConnectionRequestTimeout(5000) // 设置请求超时时间
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)//默认允许自动重定向
                .build();
        HttpGet httpGet2 = new HttpGet("http://www.baidu.com");
        httpGet2.setConfig(requestConfig);
        String srtResult = "";
        try

        {
            HttpResponse httpResponse = httpCilent2.execute(httpGet2);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                srtResult = EntityUtils.toString(httpResponse.getEntity());//获得返回的结果
                System.out.println(srtResult);
            } else if (httpResponse.getStatusLine().getStatusCode() == 400) {
                //..........
            } else if (httpResponse.getStatusLine().getStatusCode() == 500) {
                //.............
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpCilent2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
