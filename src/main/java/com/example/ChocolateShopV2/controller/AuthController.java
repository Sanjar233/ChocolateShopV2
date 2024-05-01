package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.user.UserRegisterResponse;
import  com.example.ChocolateShopV2.dto.user.AuthLoginRequest;
import  com.example.ChocolateShopV2.dto.user.AuthLoginResponse;
import  com.example.ChocolateShopV2.dto.user.UserRegisterRequest;
import  com.example.ChocolateShopV2.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }


}