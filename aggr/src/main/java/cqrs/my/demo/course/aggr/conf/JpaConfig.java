package cqrs.my.demo.course.aggr.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "cqrs.my.demo.course.aggr.domain")
@EnableJpaRepositories(basePackages = {
        "cqrs.my.demo.course.aggr.adapter.persistence"
})
public class JpaConfig {
}
