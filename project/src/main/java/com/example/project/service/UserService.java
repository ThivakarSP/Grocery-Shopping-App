package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.entity.User;
import com.example.project.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired UserRepository repo;

    @Autowired EmailService emailService;
    
    public Page<User> getAll(int page, int size) {
        PageRequest obj = PageRequest.of(page, size);
        return repo.findAll(obj);
    }

    public List<User> getByNameContains(String name) {
        return repo.findByNameContains(name);
    }

    public List<User> getByNameStartsWith(String name) {
        return repo.findByNameStartingWith(name);
    }

    public List<User> getByNameEndsWith(String name) {
        return repo.findByNameEndingWith(name);
    }

    public List<User> getByNameNotContains(String name) {
        return repo.findByNameNotContaining(name);
    }

    public String post(User obj) {
        repo.save(obj);
        emailService.sendMail("727723euit262@skcet.ac.in", "New User Registered", 
                "A new user has been registered.");
        return "User registered successfully.";
    }

    public String delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            emailService.sendMail("727723euit262@skcet.ac.in", "User Deleted", 
                    "User with ID " + id + " has been deleted.");
            return "User ID " + id + " deleted successfully.";
        }
        return "User ID " + id + " not found!";
    }

    public String update(Long id, User newUser) {
        if (repo.existsById(id)) {
            newUser.setId(id); 
            repo.save(newUser);
            emailService.sendMail("727723euit262@skcet.ac.in", "User Updated", 
                    "User with ID " + id + "'s details have been updated.");
            return "User ID " + id + " updated successfully.";
        }
        return "User ID " + id + " not found!";
    }

    public User getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
