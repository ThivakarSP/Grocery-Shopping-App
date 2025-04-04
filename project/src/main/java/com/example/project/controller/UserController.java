package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.project.entity.User;
import com.example.project.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired 
    UserService service;

    @GetMapping
    public Page<User> getAll(@RequestParam int page, @RequestParam int size) {
        return service.getAll(page, size);
    }

    @GetMapping("/contains")
    public List<User> getByNameContains(@RequestParam String name) {
        return service.getByNameContains(name);
    }

    @GetMapping("/startswith")
    public List<User> getByNameStartsWith(@RequestParam String name) {
        return service.getByNameStartsWith(name);
    }

    @GetMapping("/endswith")
    public List<User> getByNameEndsWith(@RequestParam String name) {
        return service.getByNameEndsWith(name);
    }

    @GetMapping("/notcontains")
    public List<User> getByNameNotContains(@RequestParam String name) {
        return service.getByNameNotContains(name);
    }

   

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public String post(@RequestBody User obj) {
        return service.post(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody User obj) {
        return service.update(id, obj);
    }
}
