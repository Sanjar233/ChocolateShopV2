package com.example.ChocolateShopV2.mappers;

import com.example.ChocolateShopV2.dto.transaction.TransactionResponse;
import com.example.ChocolateShopV2.entities.Transaction;

import java.util.List;

public interface TransactionMapper {
    TransactionResponse toDto(Transaction transaction);
    List<TransactionResponse> toDtoS(List<Transaction> allTransactions);
}
