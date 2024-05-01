package com.example.ChocolateShopV2.repositories;

import com.example.ChocolateShopV2.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
