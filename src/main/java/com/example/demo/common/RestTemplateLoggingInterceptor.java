package com.example.demo.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger("com.example.demo.common");

    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
    	String requestId = UUID.randomUUID().toString();
        logRequest(requestId, request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(requestId, response);
        return response;
    }

    private void logRequest(String requestId, HttpRequest request, byte[] body) {
        if (log.isInfoEnabled()) {
            log.info("[requestId = {}] Request = [{}:{}], Headers = [{}], Body = [{}]",
            	requestId,
                request.getMethod(),
                request.getURI(),
                request.getHeaders(),
                new String(body)
            );
        }
    }

    private void logResponse(String requestId, ClientHttpResponse response) throws IOException {
        if (log.isInfoEnabled()) {
            log.info("[requestId = {}] Request = [{}:{}], Headers = [{}], Body = [{}]",
            	requestId,
                response.getStatusCode().value(),
                response.getStatusText(),
                response.getHeaders(),
                StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8)
            );
        }
    }

}
