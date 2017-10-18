package com.ly.controller;

import com.ly.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ly on 2017/10/18 23:36
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public User getArticle() {
        return this.currentUser;
    }
}
