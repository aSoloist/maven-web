package com.ly.controller;

import com.ly.model.User;
import com.ly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ly on 2017/10/8 18:13
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(String username, String password) {
        return userService.getUser(username, password);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public User register(@RequestParam(required = true) String username,
                         @RequestParam(required = true) String password,
                         @RequestParam(required = false) String email) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);

        if (email != null) {
            user.setEmail(email);
        }

        return userService.register(user);
    }
}
