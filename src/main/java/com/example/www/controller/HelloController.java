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

}
