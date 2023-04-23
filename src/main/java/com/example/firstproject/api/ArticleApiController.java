package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }
    @GetMapping("/api/articles/{id}")
    public Article index(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto){
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto,
                          @PathVariable Long id) {
        // 1 : 수정용 엔티티 생성
        Article article = dto.toEntity();

        // 2 : 대상 엔티티를 조회
        Article target = articleRepository.findById(id).orElse(null);

        // 3 : 잘못된 요청 처리 ( 대상이 없거나 , id 가 다른경우 )
        if ( target == null || id != article.getId()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 4 : 업데이틑 및 정상 응답
        target.patch(article);
        Article update = articleRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        // 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 잘못된 요청 처리
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 대상 삭제
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
