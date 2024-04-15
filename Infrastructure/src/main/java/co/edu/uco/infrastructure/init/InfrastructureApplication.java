package co.edu.uco.infrastructure.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"co.edu.uco"})
@EntityScan(basePackages = {"co.edu.uco"})
@EnableJpaRepositories(basePackages = {"co.edu.uco"})
@SpringBootApplication
public class InfrastructureApplication {
    public static void main(String[] args) {SpringApplication.run(InfrastructureApplication.class, args);}
}
