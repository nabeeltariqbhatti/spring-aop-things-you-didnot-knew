package springpracticewithjosh.aop.example.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;

import java.util.stream.Stream;

/**
 * @author Nabeel Tariq Bhatti
 * @created on  3/28/23
 */

@Configuration
public class ApplicationConfiguration {


    private final CustomerRepository repository;

    public ApplicationConfiguration(CustomerRepository repository) {
        this.repository = repository;
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener( ) {
        return event -> {
            repository.saveAll(
                    Stream.of("Alpha", "Beta", "Gama").
                            map(name -> new Customer(null, name)).toList()
                    ).forEach(System.out::println);
        };
    }



  public  record Customer(@Id Integer id, String name) {
    }
}
