package com.ps20520.app;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ps20520.bean.Contact;
import com.ps20520.bean.Student2;

public class jackson2 {
	
	public static void main(String[] args) throws Exception {
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();
		demo7();
		
		
		
	}

	private static void demo7() throws Exception {
		// TODO Auto-generated method stub
		Contact contact = new Contact("anv@gmail.com", "013453544", null);
		List<String> subject = Arrays.asList("WEB205","MOB108");
		Student2 st = new Student2("Nguyễn Văn A", true, 8.0, contact, subject);
		ObjectMapper obj = new ObjectMapper();
		//Chuyển nó sáng dạng chuỗi không lưu 
		String json = obj.writeValueAsString(st);
		
		//Viết đối tượng node nó ra màn hình 
		obj.writerWithDefaultPrettyPrinter().writeValue(System.out, st);
		
		//Hoặc lưu vào 1 file nào đó
		obj.writeValue(new File("src\\main\\resources\\students5.json"), st);
	}

	private static void demo6() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> contact = new HashMap<String, Object>();
		contact.put("email", "anv@gmail.com");
		contact.put("phone", "-123456789");
		List<String> subjects = Arrays.asList("WEB203","MOB108");
		Map<String,Object> st = new HashMap<String, Object>();
		st.put("name", "Nguyễn Văn A");
		st.put("gender", true);
		st.put("marks", 7.5);
		st.put("contact",contact);
		st.put("subjects",subjects);
		
		ObjectMapper obj = new ObjectMapper();
		//Chuyển nó sáng dạng chuỗi không lưu 
		String json = obj.writeValueAsString(st);
		
		//Viết đối tượng node nó ra màn hình 
		obj.writeValue(System.out, st);
		
		//Hoặc lưu vào 1 file nào đó
		obj.writeValue(new File("src\\main\\resources\\students5.json"), st);
	}

	private static void demo5() throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper objmapper = new ObjectMapper();
		ObjectNode st = objmapper.createObjectNode();
		st.put("name", "Nguyễn Văn A");
		st.put("gender", true);
		st.put("marks", 7.5);
		ObjectNode contact = st.putObject("contact");
		contact.put("email", "anv@gmail.com");
		contact.put("phone", "0123456789");
		ArrayNode subjects = st.putArray("subjects");
		subjects.add("WEB205");
		subjects.add("MOB103");
		
		//Chuyển nó sáng dạng chuỗi không lưu 
		String json = objmapper.writeValueAsString(st);
		
		//Viết đối tượng node nó ra màn hình 
		objmapper.writeValue(System.out, st);
		
		//Hoặc lưu vào 1 file nào đó
		objmapper.writeValue(new File("src\\main\\resources\\students5.json"), st);
	}

	private static void demo4() throws Exception, Exception, Exception {
		// TODO Auto-generated method stub
		String json = "src\\main\\resources\\students.json";
		ObjectMapper objmapper = new ObjectMapper();
		
		List<Student2> s = objmapper.readValue(new File(json),  new TypeReference<List<Student2>>() {});
		
		s.forEach(st ->{ 
			System.out.println(">>Name : "+ st.getName());
		});
		
		
	}

	private static void demo3() throws Exception, Exception, Exception {
		// TODO Auto-generated method stub
		String json = "src\\main\\resources\\student.json";
		ObjectMapper objmapper = new ObjectMapper();
		Student2 s2 = objmapper.readValue(new File(json),Student2.class);
		System.out.println(">>Name : " + s2.getName());
		System.out.println(">>Gender : " + s2.getGender());
		System.out.println(">>Marks : " + s2.getMarks());
		Contact c = s2.getContact();
		
		System.out.println(">>Email : " + c.getEmail());
		System.out.println(">>Phone : " + c.getPhone());
		List<String> sb = s2.getSubject();
		sb.forEach(sbj ->{ 
			System.out.println(">>>Subject : "+ sbj);
		});
	}

	private static void demo2() throws Exception, Exception, Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String json = "src\\main\\resources\\students.json";
		ObjectMapper objmapper = new ObjectMapper();
		List<Map<String, Object>> js = objmapper.readValue(new File(json),List.class);
		
		js.forEach(s ->
		{ 
			System.out.println(">> Name : "+s.get("name"));
		}
				);
	}

	private static void demo1() throws Exception, Exception, Exception {
		// TODO Auto-generated method stub
		String json = "src\\main\\resources\\student.json";
		ObjectMapper objmapper = new ObjectMapper();
		
		Map<String, Object> js = objmapper.readValue(new File(json),Map.class);
		System.out.println(">>Name : " + js.get("name"));
		System.out.println(">>Gender : " + js.get("gender"));
		System.out.println(">>Marks : " + js.get("marks"));
		Map<String,Object> contact = (Map<String, Object>) js.get("contact");
		System.out.println(">>Email : " + contact.get("email"));
		System.out.println(">>Phone : " + contact.get("phone"));
		List<String> subject = (List<String>) js.get("subject");
		subject.stream().forEach(System.out::println);
	}
}
