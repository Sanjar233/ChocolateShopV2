package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.dto.StatusRequest;
import com.example.ChocolateShopV2.service.PurveyorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/management/purveyor")
public class PurveyorController {
    private final PurveyorService purveyorService;
    @PostMapping("/add")
    public void add(@RequestBody PurveyorAddRequest request){
        purveyorService.add_purveyor(request);}
    @PostMapping("/setStatus")
    public void setStatus(@RequestBody StatusRequest request){
        purveyorService.set_status(request);
    }
}
