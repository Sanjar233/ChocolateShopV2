package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.user.UserRegisterResponse;
import  com.example.ChocolateShopV2.dto.user.AuthLoginRequest;
import  com.example.ChocolateShopV2.dto.user.AuthLoginResponse;
import  com.example.ChocolateShopV2.dto.user.UserRegisterRequest;
import  com.example.ChocolateShopV2.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }


}