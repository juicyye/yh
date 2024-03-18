package hello.hellojpa;

import hello.hellojpa.discount.DiscountPolicy;
import hello.hellojpa.discount.FixDiscountPolicy;
import hello.hellojpa.member.MemberRepository;
import hello.hellojpa.member.MemberRepositoryImpl;
import hello.hellojpa.member.MemberService;
import hello.hellojpa.member.MemberServiceImpl;
import hello.hellojpa.order.OrderService;
import hello.hellojpa.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    private MemberRepository memberRepository(){
        return new MemberRepositoryImpl();
    }

    @Bean
    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
}
