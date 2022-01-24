package yeyeong.hellospring.service;

import yeyeong.hellospring.domain.Member;
import yeyeong.hellospring.repository.MemberRepository;
import yeyeong.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 방지
        // 값이 있으면 꺼내기 Optional
        validateDuplicateMember().findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        memberRepository.save(member);
        return member.getId(); // 아이디 반환
    }

    private MemberRepository validateDuplicateMember() {
        return memberRepository;
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}

