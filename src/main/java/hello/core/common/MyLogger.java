package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String msg) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + msg);
    }

    @PostConstruct
    public void init() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }

    public void destroy() {
        System.out.println("request scope bean destroy: " + uuid + "[" + this + "]");
        UUID uuid2 = UUID.randomUUID();
        String stringUUID = uuid2.toString();

        if (stringUUID.equals("containsUUid")) {

        }
    }

    public void closeDestroy() {
        int length = requestURL.length();
    }
}
