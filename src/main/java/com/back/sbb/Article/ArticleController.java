package com.back.sbb.Article;

import com.back.sbb.Member.Member;
import com.back.sbb.Member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final MemberService memberService;

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
    public String articleCreate(@RequestParam String title, @RequestParam String content, Principal principal) {
        Member author = memberService.getMember(principal.getName());
        this.articleService.create(title, content, author);
        return "redirect:/article/list";
    }

    @GetMapping("/article/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    @GetMapping("/article/modify/{id}")
    public String modifyForm(@PathVariable int id, Model model, Principal principal) {
        Article article = articleService.getArticle(id);
        if (article.getAuthor() != null && !article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "수정 권한이 없습니다.");
        }
        model.addAttribute("article", article);
        return "article_modify";
    }

    @PostMapping("/article/modify/{id}")
    public String modify(@PathVariable int id, String title, String content, Principal principal) {
        Article article = articleService.getArticle(id);
        if (article.getAuthor() != null && !article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "수정 권한이 없습니다.");
        }
        articleService.modify(id, title, content);
        return "redirect:/article/detail/" + id;
    }

    @PostMapping("/article/delete/{id}")
    public String delete(@PathVariable int id, Principal principal) {
        Article article = articleService.getArticle(id);
        if (article.getAuthor() != null && !article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "삭제 권한이 없습니다.");
        }
        articleService.delete(id);
        return "redirect:/article/list";
    }
}
