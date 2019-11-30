package com.example.demo.domain.service;

import java.util.List;

import com.example.demo.domain.model.Issue;

public interface IssuesService {
	List<Issue> getAndFormatIssues(int page, int perPage);
}
