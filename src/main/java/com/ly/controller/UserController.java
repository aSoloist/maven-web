package com.ly.controller;

import com.ly.annotation.LoginNotRequired;
import com.ly.model.User;
import com.ly.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ly on 2017/10/8 18:13
 */
@RestController
@ResponseBody
@RequestMapping("/users")
@LoginNotRequired
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public User Login(HttpServletRequest request) {
        String username = StringUtils.trimToEmpty(request.getParameter("username"));
        String password = StringUtils.trimToEmpty(request.getParameter("password"));
        
        User user = userService.getUser(username, password);
        
        if (user == null) {
            throw new RuntimeException("用户不存在");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            return user;
        }
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
