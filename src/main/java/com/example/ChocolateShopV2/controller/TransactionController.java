package com.example.ChocolateShopV2.controller;


import com.example.ChocolateShopV2.dto.transaction.TransactionAddRequest;
import com.example.ChocolateShopV2.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/management/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/add")
    public void add(@RequestBody TransactionAddRequest request){
        transactionService.add(request);}
}
