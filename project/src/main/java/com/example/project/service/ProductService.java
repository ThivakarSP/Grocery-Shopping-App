package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.entity.Product;
import com.example.project.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired  ProductRepository repo;

    @Autowired EmailService emailService;

    public Page<Product> getAll(int page, int size) {
        PageRequest obj = PageRequest.of(page, size);
        return repo.findAll(obj);
    }

    public String post(Product obj) {
        repo.save(obj);
        emailService.sendMail("727723euit262@skcet.ac.in", "New Product Added", 
                "A new product has been added.");
        return "Product added successfully.";
    }

    public String delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            emailService.sendMail("727723euit262@skcet.ac.in", "Product Deleted", 
                    "Product with ID " + id + " has been deleted.");
            return "Product ID " + id + " deleted successfully.";
        }
        return "Product ID " + id + " not found!";
    }

    public String update(Long id, Product newProduct) {
        if (repo.existsById(id)) {
            newProduct.setId(id); 
            repo.save(newProduct);
            emailService.sendMail("727723euit262@skcet.ac.in", "Product Updated", 
                    "Product with ID " + id + " has been updated.");
            return "Product ID " + id + " updated successfully.";
        }
        return "Product ID " + id + " not found!";
    }
}
