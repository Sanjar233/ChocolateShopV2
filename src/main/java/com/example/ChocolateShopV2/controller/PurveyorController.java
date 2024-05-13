package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.dto.StatusRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorResponse;
import com.example.ChocolateShopV2.service.PurveyorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/show/{id}")
    public PurveyorResponse getById(@PathVariable Long id){
        return purveyorService.getById(id);
    }
    @GetMapping("/show_all")
    public List<PurveyorResponse> show_all(){
        return purveyorService.show_all();
    }
    @PutMapping("/update/{id}")
    public void updateById(@PathVariable Long id,@RequestBody PurveyorAddRequest request){
        purveyorService.updateById(id,request);
    }

}
