package com.example.wiremockdemo.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.HandlerAdapter;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(@Value("${externalBaseUrl}") String baseUrl, WebClient.Builder webClientBuilder)
    {

       return  webClientBuilder
               .baseUrl(baseUrl)
               .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                         .build();
    }
}
