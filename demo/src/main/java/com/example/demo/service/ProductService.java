package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public List<Product> getAll() {
        return iProductRepo.getAll();
    }
}
