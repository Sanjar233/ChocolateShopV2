package com.example.ChocolateShopV2.service;

import com.example.ChocolateShopV2.dto.transaction.TransactionAddRequest;

public interface TransactionService {
    void add(TransactionAddRequest request);
}
