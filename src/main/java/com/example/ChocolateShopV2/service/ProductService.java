package com.example.ChocolateShopV2.service;

import com.example.ChocolateShopV2.dto.StatusRequest;
import com.example.ChocolateShopV2.dto.product.ProductAddRequest;
import com.example.ChocolateShopV2.dto.product.ProductResponse;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;

public interface ProductService {
    void add(ProductAddRequest request);
    void set_purveyor(PurveyorSettingRequest request);
    ProductResponse getById(Long id);
    void deleteById(Long id);

    void set_status(StatusRequest request);
}
