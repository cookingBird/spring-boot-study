package com.example.www.controller;

import com.example.www.jdbc.HelloJDBC;
import com.example.www.jdbc.User;
import com.example.www.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return "hello world";
    }

    @GetMapping("/login")
    @ResponseBody
    public Response getUser(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "password", required = false) String password
    ) throws SQLException {
        Assert.state(StringUtils.isNotBlank(userName), "用户名不能为空！");
        Assert.state(StringUtils.isNotBlank(password), "密码不能为空！");
        Response response = new Response();
        User user = HelloJDBC.getUser(userName, password);
        if (user == null) {
            response.failure("用户不存在");
        } else {
            response.success(user);
        }
        return response;
    }
}
