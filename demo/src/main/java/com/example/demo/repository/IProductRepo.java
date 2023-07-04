package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * from product",nativeQuery = true)
    List<Product> getAll();
}
