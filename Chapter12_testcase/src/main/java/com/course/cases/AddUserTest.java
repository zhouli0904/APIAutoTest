package com.course.cases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.MyTestProperties;
import com.course.dao.AddUserCaseMapper;
import com.course.model.AddUserCase;
import com.course.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest extends BaseCase{

    @Autowired
    AddUserCaseMapper addUserCaseMapper;

    @Autowired
    MyTestProperties myTestProperties;

    @Test(dependsOnGroups = "loginTrue", description = "添加用户")
    public void addUserTest() throws IOException {
        AddUserCase addUserCase = addUserCaseMapper.selectByPrimaryKey(1);
        System.out.println(addUserCase);
        String url = myTestProperties.getAddUserUrl();

        // 发送请求，获取实际结果
        JSONObject json = new JSONObject();
        json.put("username", addUserCase.getUsername());
        json.put("password", addUserCase.getPassword());
        json.put("sex", addUserCase.getSex());
        json.put("age", addUserCase.getAge());
        json.put("isdelete", addUserCase.getIsdelete());
        json.put("permission", addUserCase.getPermission());
        String result = RequestUtil.postMethod(MyTestProperties.HTTP_CLIENT, url, json);

        // 查询插入到数据库的数据
        Assert.assertEquals(result, addUserCase.getExpected());

    }

}
