package com.course.cases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.MyTestProperties;
import com.course.dao.GetAllCaseMapper;
import com.course.model.GetAllCase;
import com.course.model.User;
import com.course.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllTest extends BaseCase{

    @Autowired
    GetAllCaseMapper getAllCaseMapper;

    @Autowired
    MyTestProperties myTestProperties;

    @Test(dependsOnGroups = "loginTrue", description = "传入合法的pageNo和PageSize")
    public void getAllTest() throws IOException, URISyntaxException {
        GetAllCase getAllCase = getAllCaseMapper.selectByPrimaryKey(1);
        System.out.println(getAllCase);
        String url = myTestProperties.getGetAllUrl();

        // 发送请求
        Map<String, Object> map = new HashMap<>();
        map.put("pageNo", getAllCase.getPageno());
        map.put("pageSize", getAllCase.getPagesize());
        String result = RequestUtil.getMethod(url, map);
        System.out.println(result);
        List<User> users = JSONObject.parseArray(result, User.class);

        // 实际结果

        Assert.assertEquals(users.size(), getAllCase.getPagesize().intValue());
    }
}
