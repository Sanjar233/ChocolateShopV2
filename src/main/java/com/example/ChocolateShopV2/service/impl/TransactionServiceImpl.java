package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.dto.transaction.TransactionAddRequest;
import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Transaction;
import com.example.ChocolateShopV2.repositories.ProductRepository;
import com.example.ChocolateShopV2.repositories.TransactionRepository;
import com.example.ChocolateShopV2.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    @Override
    public void add(TransactionAddRequest request) {
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
        transactionRepository.save(transaction);
    }
}
