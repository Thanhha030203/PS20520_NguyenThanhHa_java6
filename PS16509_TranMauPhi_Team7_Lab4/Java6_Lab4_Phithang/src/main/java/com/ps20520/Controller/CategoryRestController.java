package com.ps20520.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps20520.Responsitory.CategoryDao;
import com.ps20520.bean.Category;

//@CrossOrigin("*")
@RestController
public class CategoryRestController {

//		@Autowired
//		CategoryDao categorydao;
//		
//		@GetMapping("/rest/categories")
//		public ResponseEntity<List<Category>> getAll(Model model){ 
//			return ResponseEntity.ok(categorydao.findAll());
//		}
//		@GetMapping("/rest/categories/{id}")
//		public ResponseEntity<Category> getOne(Model model, @PathVariable("id") String id){ 
//			if(!categorydao.existsById(id)) { 
//			return	ResponseEntity.notFound().build();
//			}
//			return ResponseEntity.ok(categorydao.findById(id).get());
//		}
//		
//		@PostMapping("/rest/categories")
//		public ResponseEntity<Category> post(@RequestBody Category category){ 
//			if(categorydao.existsById(category.getId())) { 
//				return	ResponseEntity.badRequest().build();
//				}
//			categorydao.save(category);
//				return ResponseEntity.ok(category);
//		}
//		
//		@PutMapping("/rest/categories/{id}")
//		public ResponseEntity<Category> put(Model model, @PathVariable("id") String id, @RequestBody Category category){ 
//			if(!categorydao.existsById(id)) { 
//			return	ResponseEntity.notFound().build();
//			}
//			categorydao.save(category);
//			return ResponseEntity.ok(category);
//		}
//		@DeleteMapping("/rest/categories/{id}")
//		public ResponseEntity<Void> delete(@PathVariable("id") String id){ 
//			if(!categorydao.existsById(id)) { 
//				return	ResponseEntity.notFound().build();
//				}
//			categorydao.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//		
}
