package com.maidf.common.entity.product;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Product {
    private String id;
    private BigDecimal price;
    private String name;
}
