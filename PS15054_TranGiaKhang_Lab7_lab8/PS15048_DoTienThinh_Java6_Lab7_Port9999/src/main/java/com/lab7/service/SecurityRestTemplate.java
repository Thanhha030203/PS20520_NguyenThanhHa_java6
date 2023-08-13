package com.lab7.service;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class SecurityRestTemplate {
	private RestTemplate client = new RestTemplate();
	
	public JsonNode get(String url) {
		return request(url, HttpMethod.GET, null);
	}
	
	public JsonNode post(String url, Object data) {
		return request(url, HttpMethod.POST, data);
	}
	
	public JsonNode put(String url, Object data) {
		return request(url, HttpMethod.PUT, data);
	}
	
	public JsonNode delete(String url) {
		return request(url, HttpMethod.DELETE, null);
	}
	
	private JsonNode request(String url, HttpMethod method, Object data) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic dXNlcjE6MTIz");
		
		HttpEntity<Object> httpEntity = new HttpEntity<>(data, headers);
		
		ResponseEntity<JsonNode> response = client.exchange(url, method, httpEntity	, JsonNode.class);
		
		return response.getBody();
	}
}
