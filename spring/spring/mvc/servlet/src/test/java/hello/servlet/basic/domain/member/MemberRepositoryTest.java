package hello.servlet.basic.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);
        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedMember.getId());

        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

}