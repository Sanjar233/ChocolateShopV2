package com.example.ChocolateShopV2.dto.transaction;

import com.example.ChocolateShopV2.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TransactionResponse {
    private Long id;
    private LocalDateTime date;
    private TransactionType type;
    private List<Long> products;
    private List <Integer> amount;
    private int sum;
    private Long purveyorId;
}
