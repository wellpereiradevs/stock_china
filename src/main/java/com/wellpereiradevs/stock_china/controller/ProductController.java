package com.wellpereiradevs.stock_china.controller;

import com.wellpereiradevs.stock_china.model.Products;
import com.wellpereiradevs.stock_china.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Products> createProducts(@RequestBody Products products) {
        Products createdProduct = productRepository.save(products);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
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
