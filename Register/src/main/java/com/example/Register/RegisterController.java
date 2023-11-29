package com.example.Register.controller;

import com.example.Register.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @PostMapping
    public String registerUser(@RequestBody User user) {
        // 在实际应用中，这里应该包含对用户信息的验证和存储逻辑
        // 简单起见，这里只是返回一个成功注册的消息
        return "User registered successfully!";
    }
}
