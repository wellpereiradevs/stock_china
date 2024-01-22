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

    @PutMapping("/{id}")
    public Products updateProducts(@PathVariable Long id, @RequestBody Products products) {
        products.setId(id);
        return productRepository.save(products);
    }

    @DeleteMapping("/{id}")
    public void deleteProducts(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
