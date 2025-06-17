package com.maidf.service_order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.maidf.common.entity.order.Order;
import com.maidf.service_order.config.OrderYaml;
import com.maidf.service_order.service.OrderService;

// @RefreshScope
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderYaml orderYaml;

    /*
     * @Value("${order.timeout}")
     * String timeout;
     * 
     * @Value("${order.auto-confirm}")
     * String autoConfirm;
     */
    @GetMapping("config")
    public String getConfig() {
        // return new String("timeout: " + timeout + " auto-confirm: " + autoConfirm);
        return new String("timeout: " + orderYaml.getTimeout() + " auto-confirm: " + orderYaml.getAutoConfirm());
    }

    @GetMapping("create/{num}")
    public Order createOrder(@PathVariable Integer num) {
        Order order = orderService.create("1", "1", num);
        return order;
    }

}
