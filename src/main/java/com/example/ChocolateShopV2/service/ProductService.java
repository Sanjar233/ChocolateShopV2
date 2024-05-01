package com.example.ChocolateShopV2.service;

import com.example.ChocolateShopV2.dto.product.ProductAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;

public interface ProductService {
    void add(ProductAddRequest request);
}
