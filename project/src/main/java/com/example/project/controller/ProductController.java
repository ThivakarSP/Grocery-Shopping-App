package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.project.entity.Product;
import com.example.project.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired 
    ProductService service;

    @GetMapping
    public Page<Product> getAll(@RequestParam int page,@RequestParam int size) {
        return service.getAll(page, size);
    }

    @PostMapping
    public String post(@RequestBody Product obj) {
        return service.post(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Product obj) {
        return service.update(id, obj);
    }
}
