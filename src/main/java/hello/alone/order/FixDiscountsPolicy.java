package hello.alone.order;

import hello.alone.member.Grades;
import hello.alone.member.Members;

public class FixDiscountsPolicy implements DiscountsPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Members members, int price) {
        if (Grades.VIP == members.getGrade()) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
