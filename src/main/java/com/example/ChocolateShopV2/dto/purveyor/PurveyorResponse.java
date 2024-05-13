package com.example.ChocolateShopV2.dto.purveyor;

import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PurveyorResponse {
    private Long id;
    private boolean isActive;
    private String name;
    private String address;
    private String phone_number;
    Set<Product> products;
    private List<Transaction> transactions;
}
