package hello.alone.order;

import hello.alone.member.Members;
import hello.alone.member.MembersRepository;
import hello.alone.member.MemoryMembersRepository;

public class OrdersServiceImpl implements OrdersService {

    private final MembersRepository membersRepository = new MemoryMembersRepository();

    private final DiscountsPolicy discountsPolicy = new FixDiscountsPolicy();

    @Override
    public Orders createOrder(Long memberId, String itemName, int itemPrice) {
        Members member = membersRepository.findById(memberId);
        int discountPrice = discountsPolicy.discount(member, itemPrice);

        return new Orders(memberId, itemName, itemPrice, discountPrice);
    }
}
