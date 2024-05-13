package com.example.ChocolateShopV2.controller;


import com.example.ChocolateShopV2.dto.transaction.TransactionAddRequest;
import com.example.ChocolateShopV2.dto.transaction.TransactionResponse;
import com.example.ChocolateShopV2.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/management/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/add")
    public void add(@RequestBody TransactionAddRequest request){
        transactionService.add(request);}
    @GetMapping("/show_all")
    public List<TransactionResponse> show_all(){
        return transactionService.show_all();
    }
    @GetMapping("/show/{id}")
    public TransactionResponse getById(@PathVariable Long id){
        return transactionService.getById(id);
    }
}
