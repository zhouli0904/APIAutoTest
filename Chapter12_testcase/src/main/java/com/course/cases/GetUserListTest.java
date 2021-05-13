package com.course.cases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import com.course.dao.GetUserListCaseMapper;
import com.course.model.User;
import com.course.model.getUserListCase;
import com.course.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GetUserListTest extends BaseCase{

    @Autowired
    GetUserListCaseMapper getUserListCaseMapper;

    @Test(dependsOnGroups = "loginTrue", description = "查询sex为1的用户")
    public void getUserListTest() throws IOException {
        // 拿到第一条case
        getUserListCase getUserListCase = getUserListCaseMapper.selectByPrimaryKey(1);

        // 发送请求，得到实际结果
        JSONObject json = new JSONObject();
        json.put("sex", 1);
        String result = RequestUtil.postMethod(TestConfig.getUserInfoUrl, json);
        List<User> userListResult = JSONObject.parseArray(result, User.class);
        System.out.println(userListResult);

        // 查询数据库，得到预期结果
        List<User> userSex = getUserListCaseMapper.getUserSex(getUserListCase.getSex());
        System.out.println(userSex);

        Assert.assertEquals(userListResult, userSex);

    }
}
