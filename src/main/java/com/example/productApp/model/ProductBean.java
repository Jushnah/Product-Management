package com.example.productApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Product")
public class ProductBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String productName;
    String category;
    String brand;
    int price;

}
