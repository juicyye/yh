package hello.hellojpa;

import hello.hellojpa.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    public void hi(){
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberRepository.getClass() = " + memberRepository.getClass());

    }

}