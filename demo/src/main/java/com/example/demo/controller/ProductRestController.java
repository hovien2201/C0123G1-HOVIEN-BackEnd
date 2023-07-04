package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepo;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product")
@CrossOrigin("*")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(iProductService.getAll(), HttpStatus.OK);
    }
}
