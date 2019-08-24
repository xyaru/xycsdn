package cn.jerio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by Franky on 2018/08/01.
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return"/login";
    }

    @GetMapping("/login-error")
    public String loginError(){
        return "/login-error";
    }
}
