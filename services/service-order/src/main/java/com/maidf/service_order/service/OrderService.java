package com.maidf.service_order.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.uuid.Generators;
import com.maidf.common.entity.order.Order;
import com.maidf.common.entity.product.Product;
import com.maidf.service_order.feigh.ProductClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
    @Autowired
    DiscoveryClient client;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductClient feighClient;

    public Order create(String userId, String productId, Integer num) {
        // Product product = getProductFromRemote(productId);
        Product product = feighClient.getProductById(productId);
        Order order = new Order();
        order.setId(Generators.timeBasedEpochRandomGenerator().generate().toString());
        BigDecimal total = product.getPrice().multiply(new BigDecimal(num));
        order.setTotalPrice(total);
        order.setUserId(userId);
        order.setNickName("fufu");
        order.setAddress("枫丹");
        order.setProductList(Arrays.asList(product));
        return order;
    }

    private Product getProductFromRemote(String productId) {
        List<ServiceInstance> instances = client.getInstances("service-product");
        ServiceInstance instance = instances.get(0);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;

        log.info("远程调用: {}", url);
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}
