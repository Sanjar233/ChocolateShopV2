package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;
import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Purveyor;
import com.example.ChocolateShopV2.repositories.ProductRepository;
import com.example.ChocolateShopV2.repositories.PurveyorRepository;
import com.example.ChocolateShopV2.service.PurveyorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class PurveyorServiceImpl implements PurveyorService {
    private final PurveyorRepository purveyorRepository;
    private final ProductRepository productRepository;
    @Override
    public void add_purveyor(PurveyorAddRequest request){
        Purveyor purveyor = new Purveyor();
        purveyor.setName(request.getName());
        purveyor.setAddress(request.getAddress());
        purveyor.setPhone_number(request.getPhone_number());
        purveyorRepository.save(purveyor);
    }

    @Override
    public void set_product(PurveyorSettingRequest request) {
        Purveyor purveyor = purveyorRepository.findById(request.getProductId()).orElseThrow();
        Set<Product> s = purveyor.getProducts();
        s.add(productRepository.findById(request.getProductId()).get());
        purveyor.setProducts(s);
        purveyorRepository.save(purveyor);
    }
}
