package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
   

}
