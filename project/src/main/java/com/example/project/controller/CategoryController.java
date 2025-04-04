package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.project.entity.Category;
import com.example.project.service.CategoryService;


@RestController
public class CategoryController {
    @Autowired CategoryService service;

    @GetMapping("/categories/showall")
    public Page<Category> getAll(@RequestParam int page, @RequestParam int size) {
        return service.getAll(page, size);
    }

    @PostMapping("/categories")
    public String post(@RequestBody Category obj) {
        return service.post(obj);
    }

    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
    
    @PutMapping("/categories/{id}")
    public String update(@PathVariable Long id, @RequestBody Category obj) {
        return service.update(id, obj);
    }
}


