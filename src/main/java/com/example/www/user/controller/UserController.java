package com.example.www.user.controller;

import com.example.www.jdbc.HelloJDBC;
import com.example.www.jdbc.User;
import com.example.www.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * @author Administrator
 */
@RestController
public class UserController {
    @GetMapping("/login")
    @ResponseBody
    public Response getUser(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "password", required = false) String password
    ) throws SQLException {
        Assert.isTrue(StringUtils.isNotBlank(userName), "用户名不能为空！");
        Assert.isTrue(StringUtils.isNotBlank(password), "密码不能为空！");
        User user = HelloJDBC.getUser(userName, password);
        if (user == null) {
            return Response.failure("用户不存在");
        } else {
            return Response.success(user);
        }
    }
}
