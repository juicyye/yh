package hello.hellojpa.member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public Member join(Member member);

    public List<Member> findAll();

    public Member findById(Long id);
}
