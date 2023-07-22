package com.ps20520.rest;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.ps20520.bean.Student;
import com.ps20520.bean.StudentMap;


@Repository
public class StudentRepo {
	private RestTemplate rest = new RestTemplate();
	private String url = "https://ps20520-lab4-java6-default-rtdb.firebaseio.com/students.json";
	
	public String getUrl(String key) {
		return url.replace(".json","/" + key + ".json");
	}
	
	public StudentMap findAll() {
		return rest.getForObject(url, StudentMap.class);
	}
	
	public Student findByKey(String key) {
		return rest.getForObject(getUrl(key), Student.class);
	}
	
	public String create(Student data) {
		HttpEntity<Student> entity = new HttpEntity<>(data);
		JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
		return resp.get("name").asText();
	}
	
	public Student update(String key,Student data) {
		HttpEntity<Student> entity = new HttpEntity<>(data);
		rest.put(getUrl(key),data);
		return data;
	}
	
	public void delete(String key) {
		rest.delete(getUrl(key));
	}
	
	public static void main(String[] args) {
		StudentRepo dao = new StudentRepo();
		StudentMap list = dao.findAll();
		System.out.println(list);
	}
	
}
