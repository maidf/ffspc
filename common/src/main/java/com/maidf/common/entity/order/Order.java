package com.maidf.common.entity.order;

import java.math.BigDecimal;
import java.util.List;

import com.maidf.common.entity.product.Product;

import lombok.Data;

@Data
public class Order {

    private String id;
    private BigDecimal totalPrice;
    private String userId;
    private String nickName;
    private String address;
    private List<Product> productList;
}
