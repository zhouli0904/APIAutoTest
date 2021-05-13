package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test01() throws IOException {
        String result;
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse execute = httpClient.execute(httpGet);
//        result = EntityUtils.toString(execute.getEntity());
        int statusCode = execute.getStatusLine().getStatusCode();
        System.out.println(statusCode);
    }
}
