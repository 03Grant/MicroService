package com.example.ca;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/users")
public class CaApplication {

    private final Map<Long, List<String>> userAddresses = new HashMap<>();
    private long userIdCounter = 1;

    public static void main(String[] args) {
        SpringApplication.run(CaApplication.class, args);

        // 模拟添加地址
        CaApplication userManagementApi = new CaApplication();

        Long userId = userManagementApi.generateUserId();
        String address1 = "同济大学";
        String address2 = "清华大学";

        // 添加两个地址
        userManagementApi.addAddress(userId, address1);
        userManagementApi.addAddress(userId, address2);

        // 获取用户的地址
        List<String> userAddresses = userManagementApi.getUserAddresses(userId);

        // 打印用户的地址
        System.out.println("User Addresses for User ID " + userId + ": " + userAddresses);
    }

    @PostMapping("/{userId}/addresses")
    public void addAddress(@PathVariable Long userId, @RequestBody String address) {
        // 创建用户收货地址
        if (!userAddresses.containsKey(userId)) {
            userAddresses.put(userId, new ArrayList<>());
        }
        userAddresses.get(userId).add(address);
    }

    @GetMapping("/{userId}/addresses")
    public List<String> getUserAddresses(@PathVariable Long userId) {
        // 获取用户所有收货地址
        return userAddresses.getOrDefault(userId, new ArrayList<>());
    }

    public class UserAddressResponse {
        private Long userId;
        private List<String> addresses;

        // Constructors, getter, and setter methods

        public UserAddressResponse(Long userId, List<String> addresses) {
            this.userId = userId;
            this.addresses = addresses;
        }

    }

    public Long generateUserId() {
        // 模拟生成用户ID
        return userIdCounter++;
    }
}

@Configuration
class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
