package com.example.demo.domain.model;

import java.io.Serializable;

public class Issue implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String body;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
