package com.ps20520.app;

import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson1 {

	public static void main(String[] args) throws Exception {
		//demo1();
		demo2();

	}


	private static void demo1() throws Exception, Exception {
		// TODO Auto-generated method stub
		String json = "src\\main\\resources\\student.json";
		ObjectMapper objmapper = new ObjectMapper();
		JsonNode js = objmapper.readTree(new File(json));
		System.out.println(">>Name : " + js.get("name").asText());
		System.out.println(">>Gender : " + js.get("gender").asBoolean());
		System.out.println(">>Marks : " + js.get("marks").asText());
		System.out.println(">>Email : " + js.get("contact").get("email").asText());
		System.out.println(">>Phone : " + js.get("contact").get("phone").asText());
		js.get("subject").iterator().forEachRemaining(s -> {
			System.out.println(">>>Subject : " + s.asText());
		});
	}
	private static void demo2() throws Exception, Exception {
		// TODO Auto-generated method stub
		String json = "src\\main\\resources\\students.json";
		ObjectMapper objmapper = new ObjectMapper();
		JsonNode js = objmapper.readTree(new File(json));
		
		js.iterator().forEachRemaining(s -> {
			System.out.println(">>>Name : " + s.get("name").asText());
		});
	}
}
