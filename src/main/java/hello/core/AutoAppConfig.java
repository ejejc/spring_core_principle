package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // configuration 어노테이션은 제외한다는 뜻, 기존 AppConfig에서 수동으로 빈을 등록해주기 때문에 거기에 자동으로 들어가면 충돌이 난다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
