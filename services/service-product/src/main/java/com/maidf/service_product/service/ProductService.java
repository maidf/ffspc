package com.maidf.service_product.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.maidf.common.entity.product.Product;

@Service
public class ProductService {
    public Product getProduct(String productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal(99));
        product.setName("furina");

        return product;
    }
}
