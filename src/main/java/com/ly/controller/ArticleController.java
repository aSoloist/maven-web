package com.ly.controller;

import com.ly.model.Article;
import com.ly.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ly on 2017/10/18 23:36
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    ArticleService articleService;
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Article> getArticle() {
        return articleService.getAll();
    }
    
    @RequestMapping(value = "/getByUser", method = RequestMethod.GET)
    public List<Article> getByUser(@RequestParam(required = true) String u_id) {
        return articleService.getByUser(u_id);
    }
    
    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Article getById(@RequestParam(required = true) String id) {
        return articleService.getById(id);
    }
    
    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public Article saveArticle(@RequestBody Article article) {
        if (article.getAuthor() == null) {
            article.setAuthor(this.currentUser);
        }
        
        return articleService.saveArticle(article);
    }
}
