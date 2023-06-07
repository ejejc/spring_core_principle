package hello.alone.order;

import hello.alone.member.Members;

public interface DiscountsPolicy {
    int discount(Members members, int price);
}
