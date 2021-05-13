package com.course.httpclient.cookies;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private CookieStore cookieStore;
    private ResourceBundle bundle;
    private String url;

    @BeforeTest
    public void beforetest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String testurl = url + bundle.getString("getCookies.uri");

        HttpGet httpGet = new HttpGet(testurl);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        //        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = httpClient.execute(httpGet);
        result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(result);

        this.cookieStore = httpClient.getCookieStore();
//        List<Cookie> cookies = cookieStore.getCookies();
//        for (Cookie cookie : cookies) {
//            String cookieName = cookie.getName();
//            String cookieValue = cookie.getValue();
//            System.out.println("cookieName:" + cookieName + " ;cookieValue=" + cookieValue);
//        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostCookies() throws IOException {
        String testurl = this.url + bundle.getString("test.post.with.cookies.uri");
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(testurl);

        // 设置参数
        JSONObject json = new JSONObject();
        json.put("name", "huhansan");
        json.put("age", "18");
        StringEntity entity = new StringEntity(json.toString(), "utf-8");
        httpPost.setEntity(entity);

        // 设置头信息
        httpPost.setHeader("content-type", "application/json");

        // 设置cookies
        httpClient.setCookieStore(this.cookieStore);

        // 执行请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        // 处理结果
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(result);

        JSONObject parsejson = (JSONObject) JSONObject.parse(result);

        String success = (String) parsejson.get("huhansan");
        String status = (String) parsejson.get("status");

        Assert.assertEquals(success, "success");
        Assert.assertEquals(status, "1");


    }
}
