package hello.hellojpa.discount;

import hello.hellojpa.member.Grade;
import hello.hellojpa.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{
    private final int fixPrice= 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return fixPrice;
        }else return 0;
    }
}
