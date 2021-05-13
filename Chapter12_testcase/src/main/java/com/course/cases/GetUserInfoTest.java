package com.course.cases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.MyTestProperties;
import com.course.dao.GetUserInfoCaseMapper;
import com.course.dao.UserMapper;
import com.course.model.User;
import com.course.model.getUserInfoCase;
import com.course.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GetUserInfoTest extends BaseCase{

    @Autowired
    GetUserInfoCaseMapper getUserInfoCaseMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    MyTestProperties myTestProperties;

    @Test(dependsOnGroups = "loginTrue", description = "获取userId为1的用户信息")
    public void getUserInfoTest() throws IOException {
        getUserInfoCase getUserInfoCase = getUserInfoCaseMapper.selectByPrimaryKey(1);
        System.out.println(getUserInfoCase);

        String url = myTestProperties.getGetUserInfoUrl();

        // 发送请求
        JSONObject json = new JSONObject();
        json.put("id" , getUserInfoCase.getUserid());
        // 实际结果
        String result = RequestUtil.postMethod(MyTestProperties.HTTP_CLIENT, url, json);
        List<User> userListResult = JSONObject.parseArray(result, User.class);

        // 预期结果：拿到getUserInfoCase中的userId 直接从数据库查到userList
        User user = new User();
        user.setId(getUserInfoCase.getUserid());
        List<User> userInfoList = userMapper.getUserInfoList(user);

        // 校验结果
        Assert.assertEquals(userListResult, userInfoList);

    }


}
