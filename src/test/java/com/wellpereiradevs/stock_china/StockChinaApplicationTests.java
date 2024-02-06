package com.wellpereiradevs.stock_china;

import com.wellpereiradevs.stock_china.controller.ProductController;
import com.wellpereiradevs.stock_china.model.Products;
import com.wellpereiradevs.stock_china.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class StockChinaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        Products product = new Products();
        product.setId(1L);
        product.setName("Product test");
        product.setPrice_purchase(120.59);
        product.setPrice_sale(369.99);

        when(productRepository.findAll()).thenReturn(List.of(product));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
    }
}
