package com.example.ChocolateShopV2.service;


import com.example.ChocolateShopV2.dto.user.AuthLoginRequest;
import com.example.ChocolateShopV2.dto.user.AuthLoginResponse;



public interface AuthService {

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);
}