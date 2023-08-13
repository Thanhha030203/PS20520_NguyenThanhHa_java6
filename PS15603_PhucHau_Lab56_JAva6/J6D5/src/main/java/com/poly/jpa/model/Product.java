package com.poly.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "products", indexes = {
        @Index(name = "Categoryid_idx", columnList = "Categoryid")
})
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 45)
    private String name;

    @Column(name = "image", length = 45)
    private String image;

    @Column(name = "price", length = 45)
    private String price;

    @Column(name = "createDate", length = 45)
    private String createDate;

    @Column(name = "Available", length = 45)
    private String available;

    @ManyToOne
    @JoinColumn(name = "Categoryid")
    private Category categoryid;

    @JsonIgnore
    @OneToMany(mappedBy = "productID")
    List<Orderdetail> orderdetails;

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}