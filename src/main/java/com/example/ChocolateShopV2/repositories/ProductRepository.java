package com.example.ChocolateShopV2.repositories;

import com.example.ChocolateShopV2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
