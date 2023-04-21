package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
