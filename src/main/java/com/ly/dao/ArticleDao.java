package com.ly.dao;

import com.ly.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ly on 2017/10/18 23:43
 */
@Repository
public interface ArticleDao {
    public List<Article> getArticle();
    
    public List<Article> getArticleByUser(String u_id);
    
    public List<Article> getArticleById(String id);
    
    public void insertArticle(Article article);
}
