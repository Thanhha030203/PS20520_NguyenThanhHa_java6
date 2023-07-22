/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ps.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Admin
 */
public class Student {
           private String fullname;
    private String email;
    private Double marks;
    private Boolean gender;
    private String phone;
    private String subjects;

    public Student() {
    }

    public Student(String name, String email, Double marks, Boolean gender, String phone, String subjects) {
        this.fullname = name;
        this.email = email;
        this.marks = marks;
        this.gender = gender;
        this.phone = phone;
        this.subjects = subjects;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String name) {
        this.fullname = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
    
    @JsonIgnore
    public Object[] getArray(){
        return new Object[]{
            getFullname(),getGender(),getEmail(),getMarks(),getPhone(),getSubjects()
        };
    }
}
