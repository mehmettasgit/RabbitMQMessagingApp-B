package com.rabbitmqmessagingappB.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigs {
    @Bean
    public CachingConnectionFactory connectionFactory(){
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public DirectExchange CoreListenerExchange() {
        return new DirectExchange("ListenerExchange");
    }

    @Bean
    public Queue queueB() {
        return new Queue("ListenerQueue");
    }
    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(CoreListenerExchange()).with("routingKeyListener");
    }
}
