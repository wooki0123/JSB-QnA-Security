package com.back.sbb;

import com.back.sbb.Article.Article;
import com.back.sbb.Article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SbbTest01ApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testJpa() {
        Article a1 = new Article();
        a1.setTitle("게시글 1");
        a1.setContent("게시글내용 1");
        a1.setCreatedDate(LocalDateTime.now());
        articleRepository.save(a1);

        Article a2 = new Article();
        a2.setTitle("게시글 2");
        a2.setContent("게시글내용 2");
        a2.setCreatedDate(LocalDateTime.now());
        articleRepository.save(a2);
    }

}
