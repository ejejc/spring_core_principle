package hello.alone;

import hello.alone.member.Grades;
import hello.alone.member.Members;
import hello.alone.member.MembersService;
import hello.alone.member.MembersServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static hello.alone.member.Grades.VIP;
import static org.assertj.core.api.Assertions.assertThat;

public class MembersServiceTest {
    MembersService membersService = new MembersServiceImpl();

    @Test
    void join() {
        // given
        Members member = new Members(1L, "memberA", VIP);

        // when
        membersService.join(member);
        Members findMember = membersService.findMember(1L);

        // then
        assertThat(member).isEqualTo(findMember);
    }
}
