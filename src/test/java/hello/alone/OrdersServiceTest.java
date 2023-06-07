package hello.alone;

import hello.alone.member.Grades;
import hello.alone.member.Members;
import hello.alone.member.MembersService;
import hello.alone.member.MembersServiceImpl;
import hello.alone.order.Orders;
import hello.alone.order.OrdersService;
import hello.alone.order.OrdersServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrdersServiceTest {

    MembersService membersService = new MembersServiceImpl();
    OrdersService ordersService = new OrdersServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Members member = new Members(memberId, "memberA", Grades.VIP);
        membersService.join(member);

        Orders order = ordersService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
