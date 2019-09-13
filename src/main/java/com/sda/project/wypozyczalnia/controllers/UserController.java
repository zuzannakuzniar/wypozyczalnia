package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.User;
import com.sda.project.wypozyczalnia.services.UserService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User addNewUser(@RequestBody User userForm) {
        User savedUser = userService.addNewUser(userForm);
        return savedUser;
    }

    @GetMapping("/findAll")
    public List<User> getAllUsers(@RequestParam(name = "name", required = false) String name) {
        if (!StringUtils.isEmpty(name)) {
            return userService.getUserByName(name);
        }
        return userService.getAllUsers();
    }

    @GetMapping("/find/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User userForm) {
        return userService.updateUserById(id, userForm);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }

}