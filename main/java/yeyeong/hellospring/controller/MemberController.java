package yeyeong.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import yeyeong.hellospring.domain.Member;
import yeyeong.hellospring.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;

    // 생성자 주입
    @Autowired // 스프링이 13번째줄 멤버 서비스를 연결시켜줌
    public MemberController(MemberService memberService) { // 인식못함(순수한 자바 클래스)
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}
