package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j // 로깅을 위한 골뱅이  ( 어노테이션)
public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해놓 객체를 가져다 자동 연결!
    private ArticleRepository aritcleRepository; // 객체를 만든적없는데  = new ArticleRE~~~() 를해줘야
    @GetMapping("/articles/new")              //  Autowired 쓰면 그런거 안해줘도됨
    public String newArticleForm(){

        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticles(ArticleForm form){
        log.info(form.toString());

//        System.out.println(form.toString()); - > 로깅 기능으로 대체 (서버에서 일어나는일 블랙박스)

        //1. Dto를 Entity 로 변환
        Article article = form.toEntity();
        log.info(article.toString());

        //2. Repository에게 Entity를 DB안에 저장하게 함
        Article saved = aritcleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = "+ id);
        // 1: id로 데이터를 가져옴
        // 값이 없으면 null을 반환해라
        Article articleEntity = aritcleRepository.findById(id).orElse(null);

        // 2: 가져온 데이터를 모델에 등록!
        model.addAttribute("article",articleEntity); // article이라는 이름으로 article엔티티를 등록


        // 3: 보여줄 페이지를 설정!
        return "articles/show";

    }
    @GetMapping("/articles")
    public  String index(Model model) {
        // 1: 모든 Article을 가져온다!
        List<Article> articleEntityList = aritcleRepository.findAll();
        // 2: 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList",articleEntityList);
        // 3: 뷰 페이지를 설정!

        return "articles/index";
    }

}
