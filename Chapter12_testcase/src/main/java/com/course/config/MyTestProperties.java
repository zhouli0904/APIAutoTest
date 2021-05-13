package com.course.config;

import lombok.Data;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "my.test")
public class MyTestProperties {

    public static final DefaultHttpClient HTTP_CLIENT = new DefaultHttpClient();

    private String loginUrl;

    private String getAllUrl;

    private String addUserUrl;

    private String getUserInfoUrl;

    public static DefaultHttpClient getHttpClient() {
        return HTTP_CLIENT;
    }
}
