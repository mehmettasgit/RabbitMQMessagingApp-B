package com.rabbitmqmessagingappB.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.rabbitmqmessagingappB.*"})
@EnableJpaRepositories("com.rabbitmqmessagingappB.*")
@EntityScan("com.rabbitmqmessagingappB.*")
public class Application {
    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }
}
