package com.example.demo.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import com.example.demo.common.RestTemplateLoggingInterceptor;

@Configuration
public class RestApiConfig {
	
	@Bean
	RestTemplate restTemplate() {
        return new RestTemplateBuilder()
            .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
            .additionalInterceptors(new RestTemplateLoggingInterceptor())
            .build();
    }
}
