package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

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
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();
            System.out.println("cookieName:" + cookieName + " ;cookieValue=" + cookieValue);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
//        String testurl = url + bundle.getString("test.get.with.cookies.uri");
//        HttpGet httpGet = new HttpGet(testurl);
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        httpClient.setCookieStore(this.cookieStore);
//        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//        int statusCode = httpResponse.getStatusLine().getStatusCode();
//        System.out.println(statusCode);
//
//        if (statusCode == 200){
//            String result = EntityUtils.toString(httpResponse.getEntity());
//            System.out.println(result);
//        }


    }
}
