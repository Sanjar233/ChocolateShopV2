package com.example.ChocolateShopV2.mappers.impl;

import com.example.ChocolateShopV2.dto.transaction.TransactionResponse;
import com.example.ChocolateShopV2.entities.Transaction;
import com.example.ChocolateShopV2.mappers.TransactionMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TransactionMapperImpl implements TransactionMapper {
    @Override
    public TransactionResponse toDto(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setId(transaction.getId());
        response.setDate(transaction.getDate());
        response.setType(transaction.getType());
        response.setSum(transaction.getSum());
        response.setAmount(transaction.getAmount());
        response.setProducts(transaction.getProducts());
        response.setPurveyorId(transaction.getPurveyor().getId());
        return response;
    }

    @Override
    public List<TransactionResponse> toDtoS(List<Transaction> allTransactions) {
        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for(Transaction transaction : allTransactions) {
            transactionResponses.add(toDto(transaction));
        }
        return transactionResponses;

    }
}
