package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.dto.product.ProductAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;
import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Purveyor;
import com.example.ChocolateShopV2.repositories.ProductRepository;
import com.example.ChocolateShopV2.repositories.PurveyorRepository;
import com.example.ChocolateShopV2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final PurveyorRepository purveyorRepository;
    @Override
    public void add(ProductAddRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setPrice(request.getPrice());
        product.setQuantity(0);
        productRepository.save(product);
    }

    @Override
    public void set_purveyor(PurveyorSettingRequest request) {
        Product product = productRepository.findById(request.getProductId()).orElseThrow();
        Set<Purveyor> s = product.getPurveyors();
        s.add(purveyorRepository.findById(request.getPurveyorId()).get());
        product.setPurveyors(s);
        productRepository.save(product);
    }

}
