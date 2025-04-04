package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.project.entity.Category;
import com.example.project.repository.CategoryRepository;


@Service
public class CategoryService {
    @Autowired  CategoryRepository repo;
    
    @Autowired EmailService emailService;

    public Page<Category> getAll(int page, int size) {
        PageRequest obj = PageRequest.of(page, size);
        return repo.findAll(obj);
    }

    public String post(Category obj) {
        repo.save(obj);
        emailService.sendMail("727723euit262@skcet.ac.in", "New Category Added",
                "Category " + obj.getName() + " has been added.");
        return "Category added successfully!";
    }

    public String delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            emailService.sendMail("727723euit262@skcet.ac.in", "Category Deleted",
                    "Category with ID " + id + " has been deleted.");
            return "Category ID " + id + " deleted successfully.";
        }
        return "Category ID " + id + " not found!";
    }

    public String update(Long id, Category obj) {
        if (repo.existsById(id)) {
            obj.setId(id); 
            repo.save(obj);
            emailService.sendMail("727723euit262@skcet.ac.in", "Category Updated",
                    "Category ID " + id + " has been updated.");
            return "Category ID " + id + " updated successfully.";
        }
        return "Category ID " + id + " not found!";
    }

   

	
}
