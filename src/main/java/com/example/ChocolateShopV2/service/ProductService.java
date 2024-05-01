package com.example.ChocolateShopV2.service;

import com.example.ChocolateShopV2.dto.product.ProductAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;

public interface ProductService {
    void add(ProductAddRequest request);
    void set_purveyor(PurveyorSettingRequest request);
}
