/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpoly.api.StudentAPI;
import com.fpoly.bean.StudentMap;
import com.fpoly.bean.Student;

/**
 *
 * @author HP
 */
public class StudentDAO {
    ObjectMapper mapper = new ObjectMapper();
    
    public StudentMap findAll(){
        JsonNode resp = StudentAPI.get("/students");
        System.out.println(resp);
        return mapper.convertValue(resp, StudentMap.class);
    }
    
    public Student findByKey(String key){
        JsonNode resp = StudentAPI.get("/students/" + key);
        return mapper.convertValue(resp, Student.class);
    }
    
    public String create(Student data){
        JsonNode resp = StudentAPI.post("/students",data);
        return resp.get("name").asText();
    }
    
    
    public Student update(Student data,String key){
        JsonNode resp = StudentAPI.put("/students/" + key,data);
        return mapper.convertValue(resp, Student.class);
    }
    
    public void delete(String key){
        StudentAPI.delete("/students/" + key);
    }
    
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        StudentMap list = dao.findAll();
        list.forEach((key,value) -> {
            System.out.println(value.getArray());
        });
        
    }
}
