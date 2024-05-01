package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.dto.product.ProductAddRequest;
import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.repositories.ProductRepository;
import com.example.ChocolateShopV2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public void add(ProductAddRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setPrice(request.getPrice());
        product.setQuantity(0);
        productRepository.save(product);
    }
}
