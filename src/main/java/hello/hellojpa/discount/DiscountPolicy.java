package hello.hellojpa.discount;

import hello.hellojpa.member.Member;

public interface DiscountPolicy {
    public int discount(Member member, int price);
}
