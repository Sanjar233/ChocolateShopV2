package com.example.ChocolateShopV2.service;

import com.example.ChocolateShopV2.dto.user.UserRegisterRequest;
import com.example.ChocolateShopV2.dto.user.UserRegisterResponse;

public interface AdminService {
    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);

    void deleteUser(Long id);
}
