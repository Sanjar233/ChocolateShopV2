package com.example.ChocolateShopV2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "purveyor_table")
public class Purveyor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isActive;
    private String name;
    private String address;
    private String phone_number;
    @ManyToMany(mappedBy = "purveyors")
    Set<Product> products;
    @OneToMany(mappedBy = "purveyor")
    private List<Transaction> transactions;
}