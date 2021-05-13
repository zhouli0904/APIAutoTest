package com.course.cases;


import com.alibaba.fastjson.JSONObject;
import com.course.config.MyTestProperties;
import com.course.config.TestConfig;
import com.course.dao.LoginCaseMapper;
import com.course.model.InterFaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.RequestUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest extends BaseCase {

    @Autowired
    LoginCaseMapper loginCaseMapper;

    @Autowired
    ConfigFile configFile;

    @Autowired
    MyTestProperties myTestProperties;



    @BeforeTest(groups = "loginTrue", description = "测试准备工作")
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterFaceName.LOGIN);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterFaceName.GETUSERINFO);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterFaceName.ADDUSER);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterFaceName.UPDATEUSERINFOURL);
        TestConfig.getAllUrl = ConfigFile.getUrl(InterFaceName.GETALL);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(groups = "loginTrue", description = "用户登录成功接口测试")
    public void testTrue() throws IOException {
        LoginCase loginCase = loginCaseMapper.selectByPrimaryKey(1);

        // 发送请求
        String loginUrl = myTestProperties.getLoginUrl();
        JSONObject json = new JSONObject();
        json.put("username", loginCase.getUsername());
        json.put("password", loginCase.getPassword());
        String result = RequestUtil.postMethod(MyTestProperties.HTTP_CLIENT, loginUrl, json);

        // 校验结果
        Assert.assertEquals(result, loginCase.getExpected());

//        MyTestProperties.HTTP_CLIENT.getCookieStore();

    }


    @Test(groups = "loginFalse", description = "用户登录失败接口测试")
    public void testFalse() throws IOException {
        LoginCase loginCase = loginCaseMapper.selectByPrimaryKey(2);
        System.out.println(loginCase);

        // 发送请求
        String loginUrl = myTestProperties.getLoginUrl();
        JSONObject json = new JSONObject();
        json.put("username", loginCase.getUsername());
        json.put("password", loginCase.getPassword());
        String result = RequestUtil.postMethod(loginUrl, json);

        // 校验结果
        Assert.assertEquals(result, loginCase.getExpected());
    }

}
