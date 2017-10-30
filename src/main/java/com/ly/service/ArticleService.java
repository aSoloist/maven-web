package com.ly.service;

import com.ly.dao.ArticleDao;
import com.ly.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ly on 2017/10/20 17:00
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    
    public List<Article> getAll() {
        return articleDao.getArticle();
    }
    
    public List<Article> getByUser(String u_id) {
        return articleDao.getArticleByUser(u_id);
    }
    
    public Article getById(String id) {
        return articleDao.getArticleByUser(id).get(0);
    }
    
    public Article saveArticle(Article article) {
        articleDao.insertArticle(article);
        return article;
    }
}
