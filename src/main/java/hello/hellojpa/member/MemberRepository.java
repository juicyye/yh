package hello.hellojpa.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);

    public Member findById(Long id);

    public List<Member> findAll();
}
