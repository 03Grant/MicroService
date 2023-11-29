package com.retech.userService.Controller;

import com.retech.userService.DTO.LogInfo;
import com.retech.userService.Model.User;
import com.retech.userService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> loginUser(@RequestBody LogInfo logInfo) {
        User user = userService.checkUser(logInfo);
        if (user != null) {
            // 登录成功
            return ResponseEntity.ok("Login successful");
        } else {
            // 登录失败
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}

