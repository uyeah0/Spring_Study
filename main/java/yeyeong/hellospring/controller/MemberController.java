package yeyeong.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import yeyeong.hellospring.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링이 13번째줄 멤버 서비스를 연결시켜줌
    public MemberController(MemberService memberService) { // 인식못함(순수한 자바 클래스)
        this.memberService = memberService;
    }
}
