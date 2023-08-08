package com.example.webdemo.controllers;

import com.example.webdemo.data.User;
import com.example.webdemo.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class MyController {

    private LoginService loginService;

    @PostMapping("/login")
    public String doLogin(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {
        Optional<User> user = loginService.login(login, password);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "success";
        } else {
            model.addAttribute("message", login);
            return "fail";
        }
    }
}
/*
http://berkut.mk.ua:8888
 */