package com.example.ChocolateShopV2.mappers.impl;

import com.example.ChocolateShopV2.dto.product.ProductResponse;
import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Purveyor;
import com.example.ChocolateShopV2.mappers.ProductMapper;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setType(product.getType());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());
        List<String>purveyors = new ArrayList<>();
        Set<Purveyor>purveyors2 = product.getPurveyors();
        for(Purveyor e : purveyors2){
            purveyors.add(e.getId().toString());
        }
        productResponse.setPurveyors(purveyors);
        return productResponse;
    }
    @Override
    public List<ProductResponse> toDtoS(List<Product> allProducts) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product : allProducts) {
            productResponses.add(toDto(product));
        }
        return productResponses;
    }
}
