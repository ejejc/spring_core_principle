package hello.alone.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString
public class Orders {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }
}
