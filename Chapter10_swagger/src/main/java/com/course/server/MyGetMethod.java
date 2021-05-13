package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
@Api(value = "/", description = "这是我全部的get接口文档")
public class MyGetMethod {

    @GetMapping("/getCookies")
    @ApiOperation(value = "通过这个方法可以获取cookies", httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        /*
        HttpServletResponse :装返回信息
        HttpServletRequest :装请求信息
         */
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);

        return "获取Cookies成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */

    @GetMapping("/get/with/cookies")
    @ApiOperation(value = "要求客户端携带cookies访问", httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return "你必须携带cookies才能访问";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") &&
            cookie.getValue().equals("true")){
                return "这是一个需要携带cookies信息才能访问的get请求";
            }
        }

        return "你必须携带cookies才能访问";
    }

    /**
     * get请求携带参数才能访问
     * ip:port/get/with/param?key=value
     */
    @GetMapping("get/with/param")
    @ApiOperation(value = "get请求携带参数才能访问一", httpMethod = "GET")
    public Map<String, Integer> getWithParam(@RequestParam Integer start,
                                             @RequestParam Integer end){
        Map<String, Integer> map = new HashMap<>();
        map.put("卫衣", 100);
        map.put("面包", 10);
        map.put("鞋", 30);
        return map;
    }

    /**
     * get请求携带参数才能访问
     * ip:port/get/with/param/start/end
     */
    @GetMapping("get/with/param/{start}/{end}")
    @ApiOperation(value = "get请求携带参数才能访问二", httpMethod = "GET")
    public Map<String, Integer> getWithParamPath(@PathVariable Integer start,
                                                 @PathVariable Integer end){
        Map<String, Integer> map = new HashMap<>();
        map.put("卫衣", 100);
        map.put("面包", 10);
        map.put("鞋", 30);
        map.put("牛奶", 10);
        return map;
    }

}
