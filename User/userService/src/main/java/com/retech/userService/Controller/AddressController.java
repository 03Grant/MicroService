package com.retech.userService.Controller;

import com.retech.userService.Model.Address;
import com.retech.userService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final UserService userService;

    @Autowired
    public AddressController(UserService userService) {
        this.userService = userService;
    }

    // 插入一个用户地址
    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody Address address) {
        boolean isAdded = userService.addAddress(address);
        if (isAdded) {
            return ResponseEntity.ok("Address added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add address");
        }
    }

    // 查询用户的所有地址
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Address>> getAddressByUserId(@PathVariable("userId") String userId) {
        List<Address> addresses = userService.getAddressesByUserId(userId);
        if (addresses != null && !addresses.isEmpty()) {
            return ResponseEntity.ok(addresses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
