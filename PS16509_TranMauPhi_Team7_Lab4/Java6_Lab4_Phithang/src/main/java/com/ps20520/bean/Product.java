package com.ps20520.bean;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product {
   @Id
   int id;
   String name;
   double price;
   @Temporal(TemporalType.DATE)
   @Column(name = "createDate")
   Date createDate = new Date();
   Boolean available ;
  @ManyToOne
  @JoinColumn(name = "categoryid")
   Category category;
  @JsonIgnore
  @OneToMany(mappedBy = "productId")
  List<OrderDetail> details;
   
}
