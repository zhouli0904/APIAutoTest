package com.course.controller;


import com.course.dao.UserMapper;
import com.course.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/v1")
@Api(value = "/v1", description = "用户管理系统接口")
public class UserManager {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    @ApiOperation(value = "登录接口", httpMethod = "POST")
    public boolean login(HttpServletResponse response, @RequestBody User user){
        int i = userMapper.userLogin(user.getUsername(), user.getPassword());
        if (i == 1){
            response.addCookie(new Cookie("login", "true"));
            log.info("登录的用户是：" + user.getUsername());
            return true;
        }
        log.info("登录失败");
        return false;
    }

    @PostMapping("/getUserInfo")
    @ApiOperation(value = "查询用户(列表)接口", httpMethod = "POST")
    public List<User> getUserInfoList(HttpServletRequest request, @RequestBody User user){
        boolean flag = verifyCookies(request);
        if (flag){
            List<User> userInfoList = userMapper.getUserInfoList(user);
            log.info("getUserInfo 获取到的用户数量是：" + userInfoList.size());
            return userInfoList;
        }else {
            return null;
        }
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户接口", httpMethod = "POST")
    public Boolean addUser(HttpServletRequest request, @RequestBody User user){
        if (verifyCookies(request)){
            int i = userMapper.insert(user);
            log.info("添加的用户数量是：" + i);
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/updateUserInfo")
    @ApiOperation(value = "更新(删除)用户接口", httpMethod = "POST")
    public int upDateUserInfo(HttpServletRequest request, @RequestBody User user){
        if (verifyCookies(request)){
            int i = userMapper.updateByPrimaryKeySelective(user);
            log.info("更新的用户信息条数：" + i);
            return i;
        }else {
            return 0;
        }

    }

    @GetMapping("getAll")
    @ApiOperation(value = "查询所有用户信息", httpMethod = "GET")
    public Object getAll(@RequestParam Integer pageNo,
                         @RequestParam Integer pageSize){
        if (pageNo == null || pageNo <= 0){
            pageNo = 1;
        }
        if (pageSize == null || pageSize <= 0 || pageSize > 100){
            pageSize = 10;
        }
        int start = (pageNo - 1)*pageSize;
        return userMapper.selectAll(start, pageSize);
    }


    private boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return true;
            }
        }

        return false;
    }


}
