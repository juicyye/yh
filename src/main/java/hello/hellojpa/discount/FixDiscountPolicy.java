package hello.hellojpa.discount;

import hello.hellojpa.member.Grade;
import hello.hellojpa.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private final int fixPrice= 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return fixPrice;
        }else return 0;
    }
}
