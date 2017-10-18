package com.ly.controller;

import com.ly.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ly on 2017/10/18 23:24
 */
public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected User currentUser;
    protected String currentUserId;
    
    @ModelAttribute
    private void getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                currentUser = user;
                currentUserId = user.getId();
            }
        }
    }
}
