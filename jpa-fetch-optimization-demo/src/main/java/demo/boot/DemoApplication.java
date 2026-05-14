package demo.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.boot.service.DemoService;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                DemoApplication.class,
                args
        );
    }

    @Bean
    CommandLineRunner runner(DemoService service) {

        return args -> {

            service.demonstrateNPlusOne();

            service.optimizedFetchJoin();

            service.dtoProjection();

            service.entityGraphDemo();

            service.batchFetchingDemo();
        };
    }
}