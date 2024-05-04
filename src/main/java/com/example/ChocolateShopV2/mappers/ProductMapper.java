package com.example.ChocolateShopV2.mappers;

import com.example.ChocolateShopV2.dto.product.ProductResponse;
import com.example.ChocolateShopV2.entities.Product;

import java.util.List;

public interface ProductMapper {
    ProductResponse toDto(Product product);
    List<ProductResponse> toDtoS(List<Product> allProducts);
}
