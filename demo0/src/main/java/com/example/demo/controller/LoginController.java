package com.example.demo.controller;

import com.example.demo.result.*;

import java.util.Objects;
import com.example.demo.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public result login(@RequestBody user requestUser) {
    // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getPassword();
        username = HtmlUtils.htmlEscape(username);
        System.out.println(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
         
            System.out.println("test");
            return new result(400,"success");
        } else {
            return new result(200,"failure");
        }
    }
}
