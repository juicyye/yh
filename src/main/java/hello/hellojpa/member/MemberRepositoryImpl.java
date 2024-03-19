package hello.hellojpa.member;

import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class MemberRepositoryImpl implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Member findById(Long id) {
        return store.get(id);
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
