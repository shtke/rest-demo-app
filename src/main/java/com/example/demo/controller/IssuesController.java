package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.Issue;
import com.example.demo.domain.service.IssuesService;

@RestController
@RequestMapping("issues")
public class IssuesController {
	
	@Autowired
	IssuesService issuesService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Issue> getIssues(@RequestParam(required = false, defaultValue = "1" ) int page,
									@RequestParam(required = false, defaultValue = "10" ) int per_page){
		List<Issue> issues = new ArrayList<Issue>();

		issues = issuesService.getAndFormatIssues(page, per_page);

		return issues;
	}
}
