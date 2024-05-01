package com.example.ChocolateShopV2.repositories;

import com.example.ChocolateShopV2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
