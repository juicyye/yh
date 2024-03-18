package hello.hellojpa.service;

import hello.hellojpa.domain.Member;
import hello.hellojpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member join(Member member) {
        // 같은 이름이 있는 중복 회원 x
        validated(member);
        return memberRepository.save(member);
    }


    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    private void validated(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


}
