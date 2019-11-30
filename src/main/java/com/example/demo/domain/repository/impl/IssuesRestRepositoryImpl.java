package com.example.demo.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.model.Issue;
import com.example.demo.domain.repository.IssuesRepository;

public class IssuesRestRepositoryImpl implements IssuesRepository {
	private String baseUrl;
	
	public IssuesRestRepositoryImpl(String baseUrl) {
		super();
		this.baseUrl= baseUrl;
	}

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Issue> getIssues(int page, int perPage) {
		List<Issue> issues = new ArrayList<Issue>();
		String url = this.baseUrl + "?page=" + page + "&per_page=" + perPage;
		ResponseEntity<List<Issue>> response = 
				restTemplate.exchange(
						url, 
						HttpMethod.GET,
						null, 
						new ParameterizedTypeReference<List<Issue>>(){});
		issues = response.getBody();
		return issues;
	}

}
