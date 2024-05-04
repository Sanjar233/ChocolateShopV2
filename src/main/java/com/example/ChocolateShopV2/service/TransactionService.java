package com.example.ChocolateShopV2.service;

import com.example.ChocolateShopV2.dto.transaction.TransactionAddRequest;
import com.example.ChocolateShopV2.dto.transaction.TransactionResponse;

import java.util.List;

public interface TransactionService {
    void add(TransactionAddRequest request);

    List<TransactionResponse> show_all();
}
