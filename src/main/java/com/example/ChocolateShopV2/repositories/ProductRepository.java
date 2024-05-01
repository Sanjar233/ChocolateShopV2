package com.example.ChocolateShopV2.repositories;

import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
}
