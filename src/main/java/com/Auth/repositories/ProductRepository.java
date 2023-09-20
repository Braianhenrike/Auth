package com.Auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Auth.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}