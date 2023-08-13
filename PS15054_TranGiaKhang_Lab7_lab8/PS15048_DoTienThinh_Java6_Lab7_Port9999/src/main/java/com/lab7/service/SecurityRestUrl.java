package com.lab7.service;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SecurityRestUrl {
private static ObjectMapper mapper = new ObjectMapper();
	
	public static JsonNode get(String path) {
		return request("GET", path, null);
	}
	
	public static JsonNode post(String path, Object data) {
		return request("POST", path, data);
	}
	
	public static JsonNode put(String path, Object data) {
		return request("PUT", path, data);
	}
	
	public static void delete(String path) {
		request("DELETE", path, null);
	}
	
	private static JsonNode request(String method, String path, Object data) {
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(path).openConnection();
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestMethod(method);
			connection.setRequestProperty("Authorization", "Basic dXNlcjE6MTIz");
			if(data != null) {
				connection.setDoOutput(true);
				mapper.writeValue(connection.getOutputStream(), data);
			}
			int responseCode = connection.getResponseCode();
			if(responseCode == 200) {
				return mapper.readTree(connection.getInputStream());
			}
			connection.disconnect();
			return null;
		}
		catch(Exception ex) {
			throw new RuntimeException();
		}
	}
}
