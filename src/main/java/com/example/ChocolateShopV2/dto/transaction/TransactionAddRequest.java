package com.example.ChocolateShopV2.dto.transaction;

import com.example.ChocolateShopV2.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class TransactionAddRequest {
    private TransactionType type;
    private List<Long> products;
    private List<Integer> amount;
    private Long purveyorId;
}
