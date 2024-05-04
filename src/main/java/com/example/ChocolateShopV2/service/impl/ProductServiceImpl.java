package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.dto.StatusRequest;
import com.example.ChocolateShopV2.dto.product.ProductAddRequest;
import com.example.ChocolateShopV2.dto.product.ProductResponse;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;
import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Purveyor;
import com.example.ChocolateShopV2.exception.BadCredentialsException;
import com.example.ChocolateShopV2.mappers.ProductMapper;
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
    private final ProductMapper productMapper;
    //if(!product.isActive())throw new BadCredentialsException("Product is not active");
    //    if(!purveyor.isActive())throw new BadCredentialsException("Purveyor is not active");
    @Override
    public void add(ProductAddRequest request){
        Product product = new Product();
        product.setActive(true);
        product.setName(request.getName());
        product.setType(request.getType());
        product.setPrice(request.getPrice());
        product.setQuantity(0);
        productRepository.save(product);
    }

    @Override
    public void set_purveyor(PurveyorSettingRequest request) {
        Product product = productRepository.findById(request.getProductId()).orElseThrow();
        if(!product.isActive())throw new BadCredentialsException("Product is not active");
        Set<Purveyor> s = product.getPurveyors();
        Purveyor purveyor = purveyorRepository.findById(request.getPurveyorId()).get();
        if(!purveyor.isActive())throw new BadCredentialsException("Purveyor is not active");
        s.add(purveyor);
        product.setPurveyors(s);
        productRepository.save(product);
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return productMapper.toDto(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void set_status(StatusRequest request) {
        Product product = productRepository.findById(request.getId()).orElseThrow();
        Set<Purveyor> purveyors=  product.getPurveyors();
        for(Purveyor e : purveyors){
            Set<Product> products = e.getProducts();
            products.remove(product);
            e.setProducts(products);
            purveyorRepository.save(e);
        }
        product.setActive(request.isStatus());
        productRepository.save(product);
    }

}
