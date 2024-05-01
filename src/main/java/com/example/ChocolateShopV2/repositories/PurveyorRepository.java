package com.example.ChocolateShopV2.repositories;

import com.example.ChocolateShopV2.entities.Product;
import com.example.ChocolateShopV2.entities.Purveyor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurveyorRepository extends JpaRepository<Purveyor,Long> {
    Optional<Purveyor> findById(Long id);
}
