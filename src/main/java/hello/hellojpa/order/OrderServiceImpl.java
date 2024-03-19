package hello.hellojpa.order;

import hello.hellojpa.annotation.MainDiscountPolicy;
import hello.hellojpa.discount.DiscountPolicy;
import hello.hellojpa.member.Member;
import hello.hellojpa.member.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(findMember, itemPrice);
        return new Order(memberId, itemName, itemPrice, discount);

    }
}
