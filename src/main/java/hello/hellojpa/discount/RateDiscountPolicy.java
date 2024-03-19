package hello.hellojpa.discount;

import hello.hellojpa.annotation.MainDiscountPolicy;
import hello.hellojpa.member.Grade;
import hello.hellojpa.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private final int ratePrice = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * ratePrice / 100;
        }
        return 0;
    }
}
