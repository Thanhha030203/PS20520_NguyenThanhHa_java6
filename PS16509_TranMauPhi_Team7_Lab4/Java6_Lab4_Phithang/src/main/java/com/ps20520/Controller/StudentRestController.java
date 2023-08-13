package com.ps20520.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps20520.Responsitory.StudentDao;
import com.ps20520.bean.Student;

@CrossOrigin("*")
@RestController
public class StudentRestController {

		@Autowired
		StudentDao studentdao;
		
		@GetMapping("/rest/students")
		public List<Student> getAll(Model model){ 
			return studentdao.findAll();
		}
		@GetMapping("/rest/students/{email}")
		public Student getOne(@PathVariable("email") String email){ 
			return studentdao.findById(email).get();
		}
		@PostMapping("/rest/students")
		public Student create(@RequestBody Student student){ 
			studentdao.save(student);
			return student;
		}
		@PutMapping("/rest/students/{email}")
		public Student update(@PathVariable("email") String email, @RequestBody Student student){ 
			studentdao.save(student);
			return student;
		}
		@DeleteMapping("/rest/students/{email}")
		public void delete(@PathVariable("email") String email) { 
			studentdao.deleteById(email);
		}
}
