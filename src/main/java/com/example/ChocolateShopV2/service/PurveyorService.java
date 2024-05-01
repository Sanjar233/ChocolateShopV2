package com.example.ChocolateShopV2.service;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;

public interface PurveyorService {
    void add_purveyor(PurveyorAddRequest request);
    void set_product(PurveyorSettingRequest request);
}
