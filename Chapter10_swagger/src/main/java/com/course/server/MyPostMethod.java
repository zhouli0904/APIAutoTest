package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/v1")
@Api(value = "/v1", description="这是我的测试post接口")
public class MyPostMethod {

    private static Cookie cookie;

    @PostMapping("/login")
    @ApiOperation(value = "登录接口", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String name,
                        @RequestParam(value = "password", required = true) String pwd){
        if (name.equals("admin") && pwd.equals("123456")){
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你，登录成功";
        }

        return "用户名或密码错误";
    }

    @PostMapping("/getUserList")
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u){
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("login") &&
                    c.getValue().equals("true") &&
                    u.getUserName().equals("admin") &&
                    u.getPassWord().equals("123456")){
                User user = new User();
                user.setName("zhouli");
                user.setAge("28");
                return user.toString();
            }
        }

        return "传入的参数不合法";
    }
}
