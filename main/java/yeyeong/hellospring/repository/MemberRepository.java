package yeyeong.hellospring.repository;

import yeyeong.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 멤버 저장
    Optional<Member> findById(Long id); // null이면
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
