package com.example.ChocolateShopV2.dto.product;

import com.example.ChocolateShopV2.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProductResponse {
    private Long id;
    private boolean isActive;
    private String name;
    private ProductType type;
    private int price;
    private int quantity;
    private List<String> purveyors;
}
