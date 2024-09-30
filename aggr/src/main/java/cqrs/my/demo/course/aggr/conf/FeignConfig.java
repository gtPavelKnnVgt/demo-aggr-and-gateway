package cqrs.my.demo.course.aggr.conf;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {
        "cqrs.my.demo.course.aggr.adapter.demography",
        "cqrs.my.demo.course.aggr.adapter.medicalhistory",
})
public class FeignConfig {
}
