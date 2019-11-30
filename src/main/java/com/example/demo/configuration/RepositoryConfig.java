package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.repository.IssuesRepository;
import com.example.demo.domain.repository.impl.IssuesRestRepositoryImpl;

@Configuration
public class RepositoryConfig {
	@Bean
	IssuesRepository issueRepository() {
		String baseUrl = "https://api.github.com/repos/spring-projects/spring-boo/issues";
        return new IssuesRestRepositoryImpl(baseUrl);
    }
}
