package com.example.manageproduct.reponsitory;

import com.example.manageproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReponsitory extends JpaRepository<Product, Long> {
}
