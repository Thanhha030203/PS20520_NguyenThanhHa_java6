package com.poly.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "`order`", indexes = {
        @Index(name = "username_idx", columnList = "username")
})
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username")
    private Account username;

    @Column(name = "CreateDate", length = 45)
    private String createDate;

    @Column(name = "Address", length = 45)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "orderID")
    List<Orderdetail> orderdetails;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}