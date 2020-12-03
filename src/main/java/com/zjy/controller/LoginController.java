package com.zjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (StringUtils.hasText(username) && "123123".equals(password)) return "dashboard";
        else {
            //告诉用户登录失败
            model.addAttribute("msg", "用户名或者密码错误");
            return "index";
        }
    }
}
