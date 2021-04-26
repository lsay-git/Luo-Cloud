package org.luo.system.user.controller;

import org.luo.system.user.entity.User;
import org.luo.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.save(user);
        System.err.println(user.getId());
    }

}