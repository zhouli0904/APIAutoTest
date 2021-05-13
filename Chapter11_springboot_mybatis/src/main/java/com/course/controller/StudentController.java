package com.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.course.dao.StudentMapper;
import com.course.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@Api(value = "/v1", description = "学生数据的增删查改接口")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/addStudent")
    @ApiOperation(value = "添加学生", notes = "hahhe", httpMethod = "POST")
    public Object add(@RequestBody Student student){
        studentMapper.insert(student);
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "添加成功");
        return json;
    }

    @GetMapping("getStudent")
    @ApiOperation(value = "根据id查询学生", notes = "xixixi", httpMethod = "GET")
    public Object selectStudent(@RequestParam(value = "id") Integer id){

        return studentMapper.selectByPrimaryKey(id);
    }
}
