package com.example.manageproduct.service.Impl;

import com.example.manageproduct.entity.Product;
import com.example.manageproduct.reponsitory.ProductReponsitory;
import com.example.manageproduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductReponsitory productReponsitory;

    @Override
    public List<Product> getAllProducts() {
        return productReponsitory.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productReponsitory.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productReponsitory.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productReponsitory.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productReponsitory.deleteById(id);
    }
}
