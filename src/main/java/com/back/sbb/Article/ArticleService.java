package com.back.sbb.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public void create(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreatedDate(LocalDateTime.now());
        articleRepository.save(article);
    }

    public void modify(int id, String title, String content) {
        Article article = getArticle(id);
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);
    }

    public Article getArticle(Integer id) {
        Optional<Article> opArticle = this.articleRepository.findById(id);
        if(opArticle.isPresent()) {
            return opArticle.get();
        }

        System.out.println("게시글이 존재하지 않습니다.");
        return null;
    }

    public void delete(int id) {
        articleRepository.deleteById(id);
    }
}
