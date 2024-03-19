package hello.hellojpa.scan.allbean;

import hello.hellojpa.AutoAppConfig;
import hello.hellojpa.discount.DiscountPolicy;
import hello.hellojpa.member.Grade;
import hello.hellojpa.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member("userA", Grade.VIP);
        int discountPrice= discountService.discount(member, 10000, "fixDiscountPolicy");
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;
        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
        }

        public int discount(Member member, int i, String discountPolicy) {
            DiscountPolicy discountPolicy1 = policyMap.get("discountPolicy");
            return discountPolicy1.discount(member,i);
        }
    }
}
