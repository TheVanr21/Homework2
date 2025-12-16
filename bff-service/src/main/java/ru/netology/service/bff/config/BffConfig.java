package ru.netology.service.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BffConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }
}