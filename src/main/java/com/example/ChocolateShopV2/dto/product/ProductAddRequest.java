package com.example.ChocolateShopV2.dto.product;

import com.example.ChocolateShopV2.enums.ProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAddRequest {
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    private int price;
}
