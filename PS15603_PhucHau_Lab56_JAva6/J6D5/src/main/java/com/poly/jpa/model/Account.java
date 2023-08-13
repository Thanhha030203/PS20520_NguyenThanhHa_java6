package com.poly.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @Column(name = "Username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", length = 45)
    private String password;

    @Column(name = "fullname", length = 45)
    private String fullname;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "photo", length = 45)
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "username")
    List<Order> orders;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = username;
    }
}