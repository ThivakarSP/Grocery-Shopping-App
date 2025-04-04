package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.entity.Order;
import com.example.project.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired  OrderRepository repo;

    @Autowired EmailService emailService;

    public Page<Order> getAll(int page, int size) {
        PageRequest obj = PageRequest.of(page, size);
        return repo.findAll(obj);
    }

    public String post(Order obj) {
        repo.save(obj);
        emailService.sendMail("727723euit262@skcet.ac.in", "New Order Placed", "A new order has been placed.");
        return "Order placed successfully.";
    }

    public String delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            emailService.sendMail("727723euit262@skcet.ac.in", "Order Deleted", 
                    "Order with ID " + id + " has been deleted.");
            return "Order ID " + id + " deleted successfully.";
        }
        return "Order ID " + id + " not found!";
    }

    public String update(Long id, Order newOrder) {
        if (repo.existsById(id)) {
            newOrder.setId(id);
            repo.save(newOrder);
            emailService.sendMail("727723euit262@skcet.ac.in", "Order Updated", 
                    "Order with ID " + id + " has been updated.");
            return "Order ID " + id + " updated successfully.";
        }
        return "Order ID " + id + " not found!";
    }

    public Order getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
