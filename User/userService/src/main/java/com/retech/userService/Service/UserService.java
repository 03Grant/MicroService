package com.retech.userService.Service;

import com.retech.userService.Model.User;
import com.retech.userService.DTO.LogInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User checkUser(LogInfo loginfo);

}
