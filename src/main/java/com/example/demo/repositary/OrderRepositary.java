package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Order;

public interface OrderRepositary extends JpaRepository<Order, Integer> {

}
