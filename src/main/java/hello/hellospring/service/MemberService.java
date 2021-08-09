package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
//    interface를 변수 선언 시 타입으로 선언하는 형태, MemberRepository를 만족하는 MemoryMemberRepository이면 된다
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

//    외부에서 넣어주도록
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    회원가입
    public Long join(Member member) {
//        같은 이름이 있는 중복 회원은 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

//        result.orElseGet() 있으면 꺼내고 없으면 다른 거 실행해~
//        null이 아니고 뭔가 값이 있다면 오류 처리하라
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //Optional 타입
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

//    전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
            return memberRepository.findById(memberId);
    }
}
