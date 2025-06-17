package com.maidf.service_order.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "order")
@Data
@Component
public class OrderYaml {
    String timeout;
    String autoConfirm;

}
