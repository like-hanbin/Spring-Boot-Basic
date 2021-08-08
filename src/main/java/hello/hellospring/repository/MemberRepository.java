package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
//    저장 기능
    Member save(Member member);
//  Optional : NULL 처리 시 사용
    Optional<Member> findById(Long id); //아이디로 회원찾기
    Optional<Member> findByName(String name); //이름으로 회원찾기
//    findall로 모든 회원 리스트 반환
    List<Member> findAll();
}
