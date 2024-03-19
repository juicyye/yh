package hello.hellojpa.beanfind;

import hello.hellojpa.AppConfig;
import hello.hellojpa.member.MemberRepository;
import hello.hellojpa.member.MemberRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("특정 타입 모두 조회하기")
    void findBeanTypeDuplicate() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("beansOfType = " + beansOfType.get(s));
        }
    }


    @TestConfiguration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1() {
            return new MemberRepositoryImpl();

        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemberRepositoryImpl();

        }
    }
}
