package hello.hellojpa;

import hello.hellojpa.aop.TimeTraceAop;
import hello.hellojpa.repository.MemberRepository;
import hello.hellojpa.repository.MemberRepositoryImpl;
import hello.hellojpa.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

}
