package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestConfig {

    public static String loginUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;
    public static String updateUserInfoUrl;
    public static String getAllUrl;

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore cookieStore;
}
