package com.example.demo.domain.repository;

import java.util.List;

import com.example.demo.domain.model.Issue;

public interface IssuesRepository {
	List<Issue> getIssues(int page, int perPage);
}
