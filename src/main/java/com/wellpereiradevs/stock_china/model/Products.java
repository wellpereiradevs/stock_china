package com.wellpereiradevs.stock_china.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_sale")
    private Double price_sale;

    @Column(name = "price_purchase")
    private Double price_purchase;

    @Column(name = "minimum_stock")
    private Integer minimum_stock;

    @Column(name = "stock_quant")
    private Integer stock_quant;

}
