package com.zjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        if (StringUtils.hasText(username) && "123123".equals(password)) {
            session.setAttribute("loginInfo", username);
            return "redirect:/main.html";
        }
        else {
            //告诉用户登录失败
            model.addAttribute("msg", "用户名或者密码错误");
            return "index";
        }
    }
}
