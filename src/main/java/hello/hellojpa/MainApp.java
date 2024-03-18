package hello.hellojpa;

import hello.hellojpa.member.Grade;
import hello.hellojpa.member.Member;
import hello.hellojpa.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Member member1 = new Member("member1", Grade.VIP);
        memberService.join(member1);
    }
}
