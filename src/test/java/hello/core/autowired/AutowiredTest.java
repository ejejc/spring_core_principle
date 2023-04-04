package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        @Autowired(required = false) // 자동 주입할 대상이 없으면 수정자 자체가 호출이 되지 않는다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired  // 자동 주입할 대상이 없으면 수정자가 호출은 되지만 null을 반환한다.
        public void setNoBean2(@Nullable Member noBean1) {
            System.out.println("noBean2 = " + noBean1);
        }

        @Autowired  // 자동 주입할 대상이 없으면 수정자가 호출은 되지만 Optional.empty를 반환한다.
        public void setNoBean3(Optional<Member> noBean1) {
            System.out.println("noBean3 = " + noBean1);
        }
    }
}
