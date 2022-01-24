package yeyeong.hellospring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yeyeong.hellospring.domain.Member;
import yeyeong.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryRepository;

    @BeforeEach
    public void beforeEach(){
        memoryRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryRepository);
    }

    @AfterEach
    public void afterEach(){ // save가 끝나고 삭제하기
        memoryRepository.clearStore();
    }

    @Test
    void join() {
        // given 데이터
        Member member = new Member();
        member.setName("spring");

        // when 어떤것을 검증하는 지
        Long saveId = memberService.join(member);

        // then 검증 부분
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException error){
            assertThat(error.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        // then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}