package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // thread a : a 사용자가 만원을 주문
        statefulService1.order("userA", 10000);
        // thread b : b 사용자가 2만원을 주문
        statefulService2.order("userB", 20000);

        // thread a : 사용자 a가 주문 금액을 조회
        /*int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);*/
    }

    @Test
    void statelessServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // thread a : a 사용자가 만원을 주문
        int price = statefulService1.order("userA", 10000);
        // thread b : b 사용자가 2만원을 주문
        int price2 = statefulService2.order("userB", 20000);

        // thread a : 사용자 a가 주문 금액을 조
        System.out.println("price = " + price);

        Assertions.assertThat(price).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}