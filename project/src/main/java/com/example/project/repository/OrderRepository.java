package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entity.Order;



public interface OrderRepository extends JpaRepository<Order , Long> {


}
