package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.StatusRequest;
import com.example.ChocolateShopV2.dto.product.ProductAddRequest;
import com.example.ChocolateShopV2.dto.product.ProductResponse;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;
import com.example.ChocolateShopV2.service.ProductService;
import com.example.ChocolateShopV2.service.PurveyorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/management/product")
public class ProductController {
    private final ProductService productService;
    private final PurveyorService purveyorService;
    @PostMapping("/add")
    public void add(@RequestBody ProductAddRequest request){
        productService.add(request);
    }
    @PostMapping("/set_purveyor")
    public void set_purveyor(@RequestBody PurveyorSettingRequest request){
        productService.set_purveyor(request);
        purveyorService.set_product(request);
    }
    @GetMapping("/show/{id}")
    public ProductResponse getById(@PathVariable Long id){
        return productService.getById(id);
    }
    @GetMapping("/show_all")
    public List<ProductResponse> show_all(){
        return productService.show_all();
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
    @PostMapping("/setStatus")
    public void setStatus(@RequestBody StatusRequest request){
        productService.set_status(request);
    }
    @PutMapping("/update/{id}")
    public void updateById(@PathVariable Long id, @RequestBody ProductAddRequest request){
        productService.updateById(id, request);
    }
}
