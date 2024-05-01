package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.service.PurveyorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/management/purveyor")
public class PurveyorController {
    private final PurveyorService productService;
    @PostMapping("/add")
    public void add(@RequestBody PurveyorAddRequest request){
        productService.add_purveyor(request);}

}
