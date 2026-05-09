package com.back.sbb.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/join")
    public String join() {
        return "member_join";
    }

    @PostMapping("/member/join")
    public String join(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String passwordConfirm,
            @RequestParam String nickname,
            Model model
    ) {
        if (!password.equals(passwordConfirm)) {
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "member_join";
        }
        memberService.join(username, password, nickname);
        return "redirect:/member/login";
    }

    @GetMapping("/member/login")
    public String login() {
        return "member_login";
    }
}
