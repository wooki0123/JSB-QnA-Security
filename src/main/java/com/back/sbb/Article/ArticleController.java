package com.back.sbb.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList = articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping("/article/create")
    public String create() {
        return "article_form";
    }
    @PostMapping("/article/create")
    public String articleCreate(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content) {
        this.articleService.create(title, content);
        return "redirect:/article/list";
    }
}
