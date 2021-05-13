package com.course.cases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import com.course.dao.UpdateUserInfoCaseMapper;
import com.course.dao.UserMapper;
import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
import com.course.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest extends BaseCase{

    @Autowired
    UpdateUserInfoCaseMapper updateUserInfoCaseMapper;
    @Autowired
    UserMapper userMapper;

    @Test(dependsOnGroups = "loginTrue", description = "更改用户信息")
    public void updateUserInfoTest() throws IOException {
        UpdateUserInfoCase updateUserInfoCase = updateUserInfoCaseMapper.selectByPrimaryKey(1);
        System.out.println(updateUserInfoCase);

        // 发送请求，更新数据
        JSONObject json = new JSONObject();
        json.put("id", updateUserInfoCase.getUserid());
        json.put("username", updateUserInfoCase.getUsername());
        String result = RequestUtil.postMethod(TestConfig.updateUserInfoUrl, json);

        // 查询数据库，获取实际结果
        User user = userMapper.selectByPrimaryKey(updateUserInfoCase.getUserid());
        String aclUsername = user.getUsername();

        Assert.assertEquals(aclUsername, updateUserInfoCase.getUsername());
    }
    
    @Test(dependsOnGroups = "loginTrue", description = "删除用户信息")
    public void deleteUserInfoTest() throws IOException {
        UpdateUserInfoCase updateUserInfoCase = updateUserInfoCaseMapper.selectByPrimaryKey(2);
        System.out.println(updateUserInfoCase);

        // 发送请求，删除数据
        JSONObject json = new JSONObject();
        json.put("id", updateUserInfoCase.getUserid());
        json.put("isdelete", updateUserInfoCase.getIsdelete());
        RequestUtil.postMethod(TestConfig.updateUserInfoUrl, json);

        // 查询数据库，获取实际结果
        User user = userMapper.selectByPrimaryKey(updateUserInfoCase.getUserid());
        Integer isdelete = user.getIsdelete();
        Assert.assertEquals(isdelete, updateUserInfoCase.getIsdelete());

    }
}
