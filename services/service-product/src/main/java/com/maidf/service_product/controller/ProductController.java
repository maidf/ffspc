package com.maidf.service_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.maidf.common.entity.product.Product;
import com.maidf.service_product.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable("id") String productId) {
        Product product = productService.getProduct(productId);
        return product;
    }

}
