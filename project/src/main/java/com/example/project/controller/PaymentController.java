package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.project.entity.Payment;
import com.example.project.service.PaymentService;

@RestController
@RequestMapping("")
public class PaymentController {
    @Autowired 
    PaymentService service;

    @GetMapping("/payments")
    public Page<Payment> getAll(@RequestParam int page, @RequestParam int size) {
        return service.getAll(page,size);
    }

    @PostMapping("/payments")
    public String post(@RequestBody Payment obj) {
        return service.post(obj);
    }

    @DeleteMapping("/payments/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/payments/{id}")
    public String update(@PathVariable Long id, @RequestBody Payment obj) {
        return service.update(id, obj);
    }
}
