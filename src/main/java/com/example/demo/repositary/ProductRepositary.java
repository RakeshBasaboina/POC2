package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Product;

public interface ProductRepositary extends JpaRepository<Product, Integer> {

}
