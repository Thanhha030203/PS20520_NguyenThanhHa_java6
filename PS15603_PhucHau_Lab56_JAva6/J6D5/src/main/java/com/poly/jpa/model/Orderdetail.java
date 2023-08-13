package com.poly.jpa.model;

import javax.persistence.*;

@Table(name = "orderdetails", indexes = {
        @Index(name = "ProductID_idx", columnList = "ProductID"),
        @Index(name = "OrderID_idx", columnList = "OrderID")
})
@Entity
public class Orderdetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order orderID;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product productID;

    @Column(name = "Price", length = 45)
    private String price;

    @Column(name = "Quantity", length = 45)
    private String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}