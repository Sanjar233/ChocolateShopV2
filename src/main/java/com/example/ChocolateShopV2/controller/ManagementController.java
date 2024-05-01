package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.service.ManagementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/management")
public class ManagementController {
    private final ManagementService managementService;
    @PostMapping("/add_purveyor")
    public void add_purveyor(@RequestBody PurveyorAddRequest request){
        managementService.add_purveyor(request);}
}
