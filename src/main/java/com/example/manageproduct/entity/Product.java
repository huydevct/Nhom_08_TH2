package com.example.manageproduct.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="product_code",nullable = false)
    private String Code;

    @Column(name="product_description",nullable = false)
    private String Description;

    @Column(name="product_price",nullable = false)
    private double Price;

    public Product(String Code, String Description, double Price) {
        this.Code = Code;
        this.Description = Description;
        this.Price = Price;
    }
}
