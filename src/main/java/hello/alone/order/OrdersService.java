package hello.alone.order;

public interface OrdersService {

    Orders createOrder(Long memberId, String itemName, int itemPrice);
}
