package com.astasko.pdp.app.user.controller;

import com.astasko.pdp.domain.model.User;
import com.astasko.pdp.service.api.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    User getUser(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping("add")
    Long createUser(@RequestBody User user) {
        return userService.add(user);
    }

    @DeleteMapping("{id}")
    void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("update")
    void updateUser(@RequestBody User user) {
        userService.update(user);
    }
}
