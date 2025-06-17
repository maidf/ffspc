package com.maidf.service_product;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootTest
class ServiceProductApplicationTests {
    @Autowired
    DiscoveryClient client;

    @Test
    void contextLoads() {
    }

    @Test
    void discoveryTest() {
        client.getServices().forEach(e -> {
            System.out.println(String.format("discoveryTest -> %s", e));
            List<ServiceInstance> instances = client.getInstances(e);
            instances.forEach(i -> {
                System.out.println("discoveryTest -> ip: " + i.getHost() + " port: " + i.getPort());
            });
        });

    }

}
