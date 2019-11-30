package com.example.demo.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Issue;
import com.example.demo.domain.repository.IssuesRepository;
import com.example.demo.domain.service.IssuesService;

@Service
public class IssuesServiceImpl implements IssuesService {
	
	@Autowired
	IssuesRepository issuesRepository;

	@Override
	public List<Issue> getAndFormatIssues(int page, int perPage) {
		List<Issue> issues = new ArrayList<Issue>();

		issues = issuesRepository.getIssues(page, perPage);
		
		for(Issue i : issues) {
			if(i.getTitle().length() > 10) {
				i.setTitle(i.getTitle().substring(0, 10));				
			}
			if(i.getBody().length() > 30) {
				i.setBody(i.getBody().substring(0, 30));
			}
		}

		return issues;
	}

}
