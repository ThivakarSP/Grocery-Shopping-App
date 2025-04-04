package com.example.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContains(String name);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameNotContaining(String name);


}
