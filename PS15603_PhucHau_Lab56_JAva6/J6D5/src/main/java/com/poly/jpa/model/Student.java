package com.poly.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "student", indexes = {
        @Index(name = "email_UNIQUE", columnList = "email", unique = true)
})
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fullname", length = 45)
    private String fullname;

    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "marks")
    private Double marks;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "country", length = 45)
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}