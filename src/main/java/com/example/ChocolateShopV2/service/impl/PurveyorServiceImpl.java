package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorResponse;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;
import com.example.ChocolateShopV2.dto.StatusRequest;
import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Purveyor;
import com.example.ChocolateShopV2.exception.BadCredentialsException;
import com.example.ChocolateShopV2.mappers.PurveyorMapper;
import com.example.ChocolateShopV2.repositories.ProductRepository;
import com.example.ChocolateShopV2.repositories.PurveyorRepository;
import com.example.ChocolateShopV2.service.PurveyorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class PurveyorServiceImpl implements PurveyorService {
    private final PurveyorRepository purveyorRepository;
    private final ProductRepository productRepository;
    private final PurveyorMapper purveyorMapper;
    @Override
    public void add_purveyor(PurveyorAddRequest request){
        Purveyor purveyor = new Purveyor();
        purveyor.setActive(true);
        purveyor.setName(request.getName());
        purveyor.setAddress(request.getAddress());
        purveyor.setPhone_number(request.getPhone_number());
        purveyorRepository.save(purveyor);
    }
//    if(!product.isActive())throw new BadCredentialsException("Product is not active");
//    if(!purveyor.isActive())throw new BadCredentialsException("Purveyor is not active");
    @Override
    public void set_product(PurveyorSettingRequest request) {
        Purveyor purveyor = purveyorRepository.findById(request.getProductId()).orElseThrow();
        if(!purveyor.isActive())throw new BadCredentialsException("Purveyor is not active");
        Set<Product> s = purveyor.getProducts();
        Product product = productRepository.findById(request.getProductId()).get();
        if(!product.isActive())throw new BadCredentialsException("Product is not active");
        s.add(product);
        purveyor.setProducts(s);
        purveyorRepository.save(purveyor);
    }

    @Override
    public void set_status(StatusRequest request) {
        Purveyor purveyor = purveyorRepository.findById(request.getId()).orElseThrow();
        Set<Product> products =  purveyor.getProducts();
        for(Product e : products){
            Set<Purveyor> purveyors = e.getPurveyors();
            purveyors.remove(purveyor);
            e.setPurveyors(purveyors);
            productRepository.save(e);
        }
        purveyor.setActive(request.isStatus());
        purveyorRepository.save(purveyor);
    }

    @Override
    public PurveyorResponse getById(Long id) {
        return purveyorMapper.toDto(purveyorRepository.findById(id).get());
    }

    @Override
    public List<PurveyorResponse> show_all() {
        return purveyorMapper.toDtoS(purveyorRepository.findAll());
    }

    @Override
    public void updateById(Long id, PurveyorAddRequest request) {
        Purveyor purveyor = purveyorRepository.findById(id).orElseThrow();
        if(!purveyor.isActive())throw new BadCredentialsException("Purveyor is not active");
        purveyor.setName(request.getName());
        purveyor.setAddress(request.getAddress());
        purveyor.setPhone_number(request.getPhone_number());
        purveyorRepository.save(purveyor);
    }
}
