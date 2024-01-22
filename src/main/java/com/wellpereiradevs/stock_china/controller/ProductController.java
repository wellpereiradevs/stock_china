package com.wellpereiradevs.stock_china.controller;

import com.wellpereiradevs.stock_china.model.Products;
import com.wellpereiradevs.stock_china.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Products createProducts(@RequestBody Products products) {
        return productRepository.save(products);
    }
}
