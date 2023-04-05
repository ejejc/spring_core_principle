package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 실제 동작에 필요한 구현 객체를 각 client가 아닌 AppConfig에서 생성한다.
 * DIP : 추상화에는 의존하고 구체화에는 의존하지 않는다. > 만족
 * OCP : 변경에는 닫혀있고 확장에는 열려 있다 > 만족 : 정책이 변경된다고 해도 client는 변경되지 않고 확장할 수 있다.
 * SRP : 한 클래스는 하나의 책임만 가지고 있어야 한다. > 기존에는 직접 구현 객체를 생성하고 실행하는 다양한 책임을 가지고 있었지만 AppConfig의 등장으로 단순히 실행만 하는 역활만 담당 > 만족
 */
@Configuration
public class AppConfig {

    @Bean // 빈 이름은 메소드 이름으로 등록된다. - 빈이름은 다른 이름으로 부여해야 한다.
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        // 생성자 주입 - 구현체를 client가 아닌 별도 클래스에서 넣어준다.
        /**
         * 클라이언트(MemberServiceImpl) 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것과 같다고 해서 DI(Dependency Injection)로, 의존관계 주입이라고 한다.
         */
        return new MemberServiceImpl(memberRepository());
    }

    // 생성해주는 역활을 분리하자. - 중복도 제거됨 + 역활과 구현이 한눈에 보여짐!
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println(" call AppConfig.orderService");
        // 생성자 주입
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 생성해주는 역활을 분리하자.
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
