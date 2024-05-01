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
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @ElementCollection
    private List<Long> products;
    @ElementCollection
    private List<Integer> amount;
}
