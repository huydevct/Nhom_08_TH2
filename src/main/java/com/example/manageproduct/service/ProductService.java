package com.example.manageproduct.service;

import com.example.manageproduct.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product saveProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Product student);

    void deleteProductById(Long id);
}
