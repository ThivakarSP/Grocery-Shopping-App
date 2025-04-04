package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
