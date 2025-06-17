package com.maidf.service_order.feigh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.maidf.common.entity.product.Product;

@FeignClient(value = "service-product")
// @FeignClient(value = "service-product", url = "http://xxx")
public interface ProductClient {
    
    @GetMapping("/product/{id}")
    // Product getProductById(@PathVariable("id") String productId, @RequestHeader("Authorization") String token);
    Product getProductById(@PathVariable("id") String productId);

}
