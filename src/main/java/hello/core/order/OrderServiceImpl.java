package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); 할인 정책이 변경됨에 따라 client(OrderServiceImpl)를 고쳐야 되는 문제점 발생.
    /**
     * 역활과 구현을 충실하게 분리 -> OK
     * 다형성 및 인터페이스와 구현 객체 분리 -> OK
     * OCP, DIP를 준수했나 -> NO
     * client는 DiscountPolicy (추상) 클래스에만 의존하는 게 아니라 FixDiscountPolicy (구현) 클래스에도 의존하고 있다. -> DIP 위반 !!!
     * DIP를 위반하지 않도록 의존하도록 변경.
     */

    // @Autowired  private MemberRepository memberRepository;
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy; // 인터페이스만 의존하도록 변경

    @Autowired // @Autowired를 사용하면 생성자에서 의존관계를 자동으로 주입 받을 수 있다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 일반 메서드 주입
    /*@Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    // 수정자 주입
    /*@Autowired// (required = false) - 의존관계를 선택적으로 넣어줄 수 있다.
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인 정책에 member을 넘겨서 일을 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
