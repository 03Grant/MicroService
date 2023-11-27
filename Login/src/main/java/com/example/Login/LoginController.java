package com.example.Login.controller;

import com.example.Login.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @PostMapping
    public String loginUser(@RequestBody User user) {
        // 在实际应用中，这里应该包含对用户信息的验证逻辑
        // 简单起见，这里只是返回一个成功登录的消息
        return "User logged in successfully!";
    }
}
