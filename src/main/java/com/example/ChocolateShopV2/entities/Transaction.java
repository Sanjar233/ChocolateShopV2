package com.example.ChocolateShopV2.entities;

import com.example.ChocolateShopV2.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "transaction_table")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @ElementCollection
    private List<Long> commodityId = new ArrayList<>();
    @ElementCollection
    private List<Integer> amount = new ArrayList<>();
    private int sum;
}