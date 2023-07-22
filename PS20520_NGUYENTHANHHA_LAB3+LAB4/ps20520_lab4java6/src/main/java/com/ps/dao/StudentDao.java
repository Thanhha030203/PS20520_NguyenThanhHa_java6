/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ps.dao;
import com.ps.bean.*;
import com.ps.rest.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *
 * @author Admin
 */
public class StudentDao {
          ObjectMapper mapper = new ObjectMapper();
    
     public StudentMap findAll(){
        JsonNode resp = Rest.get("/students");
        System.out.println(resp);
        return mapper.convertValue(resp, StudentMap.class);
    }
    
    public Student findByKey(String key){
        JsonNode resp = Rest.get("/students/" + key);
        return mapper.convertValue(resp, Student.class);
    }
    
    public String create(Student data){
        JsonNode resp = Rest.post("/students",data);
        return resp.get("name").asText();
    }
    
    
    public Student update(Student data,String key){
        JsonNode resp = Rest.put("/students/" + key,data);
        return mapper.convertValue(resp, Student.class);
    }
    
    public void delete(String key){
        Rest.delete("/students/" + key);
    }
    
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        StudentMap list = dao.findAll();
        list.forEach((key,value) -> {
            System.out.println(value.getArray());
        });
        
    }
}
