package com.course.utils;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

public class RequestUtil {

    public static String postMethod(HttpClient httpClient, String url, JSONObject json) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json.toString(), "utf-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("content-type" , "application/json");
        HttpResponse response = httpClient.execute(httpPost);
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }


    public static String postMethod(String url, JSONObject json) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json.toString(), "utf-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("content-type" , "application/json");
        HttpResponse response = new DefaultHttpClient().execute(httpPost);
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public static String getMethod(String url, Map<String, Object> map) throws IOException, URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(url);
        if(map !=null && !map.isEmpty()) {
            Set<String> set = map.keySet();
            for (String key : set) {
                uriBuilder.setParameter(key, map.get(key).toString());
            }
        }
        URI uri = uriBuilder.build();

        HttpGet httpGet = new HttpGet(uri);
        HttpResponse response = TestConfig.defaultHttpClient.execute(httpGet);
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }


}
