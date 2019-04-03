package schedule._main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "schedule.*")
@EnableJpaRepositories(basePackages = "schedule.repositories")
@EntityScan(basePackages = "schedule.models.entities")
public class Runner extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(Runner.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Runner.class);
    }
}
