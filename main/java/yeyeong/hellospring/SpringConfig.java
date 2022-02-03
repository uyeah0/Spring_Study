package yeyeong.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yeyeong.hellospring.domain.Member;
import yeyeong.hellospring.repository.JdbcMemberRepository;
import yeyeong.hellospring.repository.MemberRepository;
import yeyeong.hellospring.repository.MemoryMemberRepository;
import yeyeong.hellospring.service.MemberService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
