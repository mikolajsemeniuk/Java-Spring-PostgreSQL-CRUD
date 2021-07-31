package com.example.app.configuration;

import com.example.app.repositories.CustomerRepository;
import com.example.app.entities.CustomerEntity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CustomerConfiguration {
    
    @Bean
    CommandLineRunner runner(CustomerRepository repository) {
        return args -> {
            CustomerEntity customer1 = new CustomerEntity(
                "John",
                "Doe"
            );
            CustomerEntity customer2 = new CustomerEntity(
                "Mike",
                "Mock"
            );
            repository.saveAll(Arrays.asList(customer1, customer2));
        };
    }
}
