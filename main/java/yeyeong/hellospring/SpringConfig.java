package yeyeong.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yeyeong.hellospring.domain.Member;
import yeyeong.hellospring.repository.MemberRepository;
import yeyeong.hellospring.repository.MemoryMemberRepository;
import yeyeong.hellospring.service.MemberService;

import java.util.List;
import java.util.Optional;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
