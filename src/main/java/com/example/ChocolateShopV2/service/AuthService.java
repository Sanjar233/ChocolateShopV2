package com.example.ChocolateShopV2.service;


import com.example.ChocolateShopV2.dto.user.AuthLoginRequest;
import com.example.ChocolateShopV2.dto.user.AuthLoginResponse;
import com.example.ChocolateShopV2.dto.user.UserRegisterRequest;
import com.example.ChocolateShopV2.dto.user.UserRegisterResponse;



public interface AuthService {
    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);
}