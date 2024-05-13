package com.example.ChocolateShopV2.service;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorResponse;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;
import com.example.ChocolateShopV2.dto.StatusRequest;

import java.util.List;

public interface PurveyorService {
    void add_purveyor(PurveyorAddRequest request);
    void set_product(PurveyorSettingRequest request);
    void set_status(StatusRequest request);
    PurveyorResponse getById(Long id);
    List<PurveyorResponse> show_all();
    void updateById(Long id,PurveyorAddRequest request);
}
