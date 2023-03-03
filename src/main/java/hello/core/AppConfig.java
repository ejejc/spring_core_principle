package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 실제 동작에 필요한 구현 객체를 각 client가 아닌 AppConfig에서 생성한다.
 */
public class AppConfig {

    public MemberService memberService() {
        // 생성자 주입 - 구현체를 client가 아닌 별도 클래스에서 넣어준다.
        /**
         * 클라이언트(MemberServiceImpl) 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것과 같다고 해서 DI(Dependency Injection)로, 의존관계 주입이라고 한다.
         */
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        // 생성자 주입
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
