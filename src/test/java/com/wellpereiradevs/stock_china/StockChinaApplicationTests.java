package com.wellpereiradevs.stock_china;

import com.wellpereiradevs.stock_china.controller.ProductController;
import com.wellpereiradevs.stock_china.model.Products;
import com.wellpereiradevs.stock_china.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
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
        Products product1 = new Products();
        product1.setId(1L);
        product1.setName("Product test");
        product1.setPrice_purchase(120.59);
        product1.setPrice_sale(369.99);

        Products product2 = new Products();
        product2.setId(1L);
        product2.setName("Product 2");
        product2.setPrice_purchase(189.69);
        product2.setPrice_sale(299.99);

        List<Products> productsList = Arrays.asList(product1,product2);
        when(productRepository.findAll()).thenReturn(productsList);
    }

    @Test
    void getAllProducts() throws Exception{
        List<Products> productsList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productsList);

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("R$[0].name").value(productsList.get(0).getName()))
                .andExpect((ResultMatcher) jsonPath("R$[0].price").value(120.59));
    }
}
