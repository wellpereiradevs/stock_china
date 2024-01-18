package com.wellpereiradevs.stock_china.repository;

import com.wellpereiradevs.stock_china.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
