package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleServiceTest {
    @Autowired ArticleService articleService;
    @Test
    void index() {

        // 예상

        // 실제
        List<Article> articles = articleService.index();
        // 비교
    }
}