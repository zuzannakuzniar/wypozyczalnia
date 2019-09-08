package com.sda.project.wypozyczalnia.api;

import com.sda.project.wypozyczalnia.dto.User;
import com.sda.project.wypozyczalnia.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/")
    public User addNewMessage(@RequestBody User user) {
        User savedUser = userService.addNewUser(user);
        return savedUser;
    }


}
