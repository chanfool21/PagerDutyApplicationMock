package pagerdutymock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "dao", "service"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class PagerDutyApplication {
    public static void main(String[] args) {
        SpringApplication.run(PagerDutyApplication.class, args);
    }
}
