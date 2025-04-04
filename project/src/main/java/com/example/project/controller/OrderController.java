package com.example.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.project.entity.Order;
import com.example.project.service.OrderService;


@RestController
public class OrderController {
    @Autowired 
    OrderService service;

    @GetMapping("/orders")
    public Page<Order> getAll(@RequestParam int page, @RequestParam int size) {
        return service.getAll(page, size);
    }


    @GetMapping("/orders/{id}")
    public Order getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @PostMapping("/orders")
    public String post(@RequestBody Order obj) {
        return service.post(obj);
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/orders/{id}")
    public String update(@PathVariable Long id, @RequestBody Order obj) {
        return service.update(id, obj);
    }
}
