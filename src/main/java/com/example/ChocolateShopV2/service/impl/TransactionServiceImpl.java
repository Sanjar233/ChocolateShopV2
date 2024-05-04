package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.dto.transaction.TransactionAddRequest;
import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Purveyor;
import com.example.ChocolateShopV2.entities.Transaction;
import com.example.ChocolateShopV2.exception.BadRequestException;
import com.example.ChocolateShopV2.repositories.ProductRepository;
import com.example.ChocolateShopV2.repositories.PurveyorRepository;
import com.example.ChocolateShopV2.repositories.TransactionRepository;
import com.example.ChocolateShopV2.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    private final PurveyorRepository purveyorRepository;
    @Override
    public void add(TransactionAddRequest request) {
        for(int j = 0 ; j < request.getProducts().size();j++){
            Product product = productRepository.findById(request.getProducts().get(j)).orElseThrow();
            int q = product.getQuantity() - request.getAmount().get(j);
            if(q < 0)throw new BadRequestException("Not enough amount of products");
            product.setQuantity(q);
        }
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDateTime.now());
        transaction.setType(request.getType());
        transaction.setProducts(request.getProducts());
        int sum = 0;
        for(int i = 0 ; i < request.getProducts().size();i++){
            Product product = productRepository.findById(request.getProducts().get(i)).orElseThrow();
            sum += product.getPrice() * request.getAmount().get(i);
        }
        transaction.setSum(sum);
        transaction.setPurveyor(purveyorRepository.getById(request.getPurveyorId()));
        transactionRepository.save(transaction);
    }
}
