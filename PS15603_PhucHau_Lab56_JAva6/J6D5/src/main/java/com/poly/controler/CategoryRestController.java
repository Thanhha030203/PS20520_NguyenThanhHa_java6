package com.poly.controler;


import com.poly.jpa.dao.CategoryDao;
import com.poly.jpa.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CategoryRestController {
    @Autowired
    CategoryDao categoryDao;

    @GetMapping("/rest/category")
    public ResponseEntity<List<Category>> getALL(){
        return ResponseEntity.ok(categoryDao.findAll());
    }

    @GetMapping("/rest/category/{id}")
    public ResponseEntity<Category> getId(@PathVariable("id") int id){
        if(!categoryDao.existsById(id)) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(categoryDao.findById(id).get());
        }
    }

    @PostMapping("/rest/category")
    public ResponseEntity<Category> post(@RequestBody Category category){
        if(categoryDao.existsById(category.getId())){
            return ResponseEntity.badRequest().build();
        }
        categoryDao.save(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/rest/category")
    public ResponseEntity<Category> put(@RequestBody Category category){
        if(categoryDao.existsById(category.getId())){
            categoryDao.save(category);
            return ResponseEntity.ok(category);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/rest/category/{id}")
    public void delete(@PathVariable("id") int id){
        categoryDao.deleteById(id);
    }
}
